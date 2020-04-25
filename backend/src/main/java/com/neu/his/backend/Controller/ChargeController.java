package com.neu.his.backend.Controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.neu.his.backend.pojo.InvoiceEntity;
import com.neu.his.backend.pojo.MedicineEntity;
import com.neu.his.backend.pojo.PrescriptionDetailEntity;
import com.neu.his.backend.pojo.RegistrationRecEntity;
import com.neu.his.backend.result.Result;
import com.neu.his.backend.result.ResultCode;
import com.neu.his.backend.result.ResultFactory;
import com.neu.his.backend.service.ConstantItemService;
import com.neu.his.backend.service.InvoiceService;
import com.neu.his.backend.service.MedicineService;
import com.neu.his.backend.service.PrescriptionDetailService;
import com.neu.his.backend.service.RegistrationRecService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ChargeController {

  @Autowired
  RegistrationRecService registrationRecService;
  @Autowired
  PrescriptionDetailService prescriptionDetailService;
  @Autowired
  MedicineService medicineService;
  @Autowired
  ConstantItemService constantItemService;
  @Autowired
  InvoiceService invoiceService;

  @CrossOrigin
  @RequestMapping(value = "/api/charge/query", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
  @ResponseBody
  public Result query(@RequestBody String jsonString) {
    JSONObject jsonObject = JSON.parseObject(jsonString);
    int patientNo = Integer.parseInt(String.valueOf(jsonObject.get("patientno")));
    RegistrationRecEntity rec = registrationRecService.tryGetOne(patientNo);
    if (rec == null) {
      return ResultFactory.buildFailResult("查无此人");
    }
    String patientname = rec.getName();
    Object data[] = new Object[2];
    data[0] = rec;
    data[1] = getItems(patientNo, patientname);
    return ResultFactory.buildSuccessResult(data);
  }

  public Object[] getItems(int patientNo, String patientname) {
    List<Integer> idList = registrationRecService.getRegisIdListByPatientNo(patientNo);
    List<PrescriptionDetailEntity> list = prescriptionDetailService.getByRegisId(idList);
    JSONArray array = JSON.parseArray(JSON.toJSONString(list));
    Object items[] = new Object[array.size()];
    for (int i = 0; i < list.size(); i++) {
      JSONObject obj = array.getJSONObject(i);
      int mediId = (int) obj.get("mediid");
      MedicineEntity medi = medicineService.get(mediId);
      obj.put("patientno", patientNo);
      obj.put("patientname", patientname);
      obj.put("itemname", medi.getMediname());
      obj.put("price", medi.getPrice());
      String statename = (((int) obj.get("state") == 1) ? "已开立" : "已结算");
      obj.put("statename", statename);
      items[i] = obj;
    }
    return items;
  }

  @CrossOrigin
  @RequestMapping(value = "/api/charge/init", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
  @ResponseBody
  public Result init() {
    return ResultFactory.buildSuccessResult(constantItemService.getByConstantTypeId(5));
  }

  @CrossOrigin
  @RequestMapping(value = "/api/charge/invoice", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
  @ResponseBody
  public Result getInvoice() {
    return ResultFactory.buildSuccessResult(invoiceService.getLast().getInvoiceno() + 1);
  }

  @CrossOrigin
  @RequestMapping(value = "/api/charge/submit", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
  @ResponseBody
  public Result submit(@RequestBody String jsonString) {
    JSONObject obj = JSON.parseObject(jsonString);
    int patientNo = (int) obj.get("patientNo");
    String patientName = registrationRecService.tryGetOne(patientNo).getName();
    List<Integer> modifyIdList = JSON
        .parseArray(JSON.toJSONString(obj.getJSONArray("modifyIdList")), Integer.class);
    InvoiceEntity invoice = JSON
        .parseObject(JSON.toJSONString(obj.get("invoice")), InvoiceEntity.class);
    //添加发票
    invoiceService.add(invoice);
    //修改处方明细状态
    for (int detaiId : modifyIdList) {
      prescriptionDetailService.modifyStatus(detaiId, 2);
    }
    //修改挂号信息状态
    registrationRecService.modifyStatus(invoice.getRegistrationid(), 168);
    return ResultFactory.buidResult(ResultCode.SUCCESS, "缴费成功", getItems(patientNo,patientName));
  }


}
