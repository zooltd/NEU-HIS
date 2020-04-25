package com.neu.his.backend.Controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.neu.his.backend.pojo.ConstantItemEntity;
import com.neu.his.backend.pojo.DeptEntity;
import com.neu.his.backend.pojo.InvoiceEntity;
import com.neu.his.backend.pojo.RegistrationRecEntity;
import com.neu.his.backend.pojo.UserEntity;
import com.neu.his.backend.result.Result;
import com.neu.his.backend.result.ResultFactory;
//import com.neu.his.backend.service.DeptService;
import com.neu.his.backend.service.ConstantItemService;
import com.neu.his.backend.service.DeptService;
import com.neu.his.backend.service.InvoiceService;
import com.neu.his.backend.service.RegistrationLevelService;
import com.neu.his.backend.service.RegistrationRecService;
import com.neu.his.backend.service.UserService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import javax.servlet.Registration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class RegistrationController {

  @Autowired
  ConstantItemService constantItemService;
  @Autowired
  RegistrationLevelService registrationLevelService;
  @Autowired
  DeptService deptService;
  @Autowired
  UserService userService;
  @Autowired
  RegistrationRecService registrationRecService;
  @Autowired
  InvoiceService invoiceService;


  @CrossOrigin
  @RequestMapping(value = "/api/registration", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
  @ResponseBody
  public Result registration(@RequestBody String jsonString) {
    JSONObject obj = JSON.parseObject(jsonString);
    RegistrationRecEntity regisRec = JSON
        .parseObject(JSON.toJSONString(obj.get("regisRec")), RegistrationRecEntity.class);
    InvoiceEntity invoice = JSON
        .parseObject(JSON.toJSONString(obj.get("invoice")), InvoiceEntity.class);
    int regisId = registrationRecService.getNewId();
    regisRec.setId(regisId);
    invoice.setRegistrationid(regisId);
    try {
      registrationRecService.add(regisRec);
      invoiceService.add(invoice);
      return ResultFactory.buildSuccessResult(null);
    } catch (Exception e) {
      return ResultFactory.buildFailResult(e.toString());
    }
  }

  @CrossOrigin
  @RequestMapping(value = "/api/initialize", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
  @ResponseBody
  public Result initialize() {
    Vector data = new Vector();
    data.add(registrationLevelService.getLevels());
    data.add(getDepts());
    data.add(constantItemService.getByConstantTypeId(5));
    data.add(invoiceService.getNewNo());
    return ResultFactory.buildSuccessResult(data);
  }

  public Vector<Map> getDepts() {
    Vector<Map> vec = new Vector<>();
    List<ConstantItemEntity> deptTypes = constantItemService.getByConstantTypeId(1);
    for (ConstantItemEntity deptType : deptTypes) {
      Map map = new HashMap();
      map.put("name", deptType.getConstantname());
      map.put("id", deptType.getId());
      List<DeptEntity> depts = deptService.getByCatagoryId(deptType.getId());
      Vector children = new Vector();
      for (DeptEntity dept : depts) {
        Map temp = new HashMap();
        temp.put("name", dept.getDeptname());
        temp.put("id", dept.getId());
        children.add(temp);
      }
      map.put("child", children);
      vec.add(map);
    }
    return vec;
  }

  @CrossOrigin
  @RequestMapping(value = "/api/getid", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
  @ResponseBody
  public Result getID() {
    return ResultFactory.buildSuccessResult(registrationRecService.getNewPatientNo());
  }

  @CrossOrigin
  @RequestMapping(value = "/api/getinvoiceno", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
  @ResponseBody
  public Result getInoviceId() {
    return ResultFactory.buildSuccessResult(invoiceService.getNewNo());
  }

  @CrossOrigin
  @RequestMapping(value = "/api/tryget", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
  @ResponseBody
  public Result tryget(@RequestBody String jsonString) {
    JSONObject obj = JSON.parseObject(jsonString);
    int patientNo = Integer.valueOf(String.valueOf(obj.get("patientNo")));
    RegistrationRecEntity rec = registrationRecService.tryGetOne(patientNo);
    if (rec == null) {
      System.out.println("null");
      return ResultFactory.buildFailResult("未找到");
    } else {
      return ResultFactory.buildSuccessResult(rec);
    }
  }


  @CrossOrigin
  @RequestMapping(value = "/api/getdoctors", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
  @ResponseBody
  public Result getDoctors(@RequestBody String jsonString) {
    JSONObject obj = JSON.parseObject(jsonString);
    int deptid = (int) obj.get("deptid");
    int registrationlevelid = (int) obj.get("registrationlevelid");
    List<UserEntity> doctors = userService
        .getByDeptidAndRegistrationlevelid(deptid, registrationlevelid, 3);
    return ResultFactory.buildSuccessResult(doctors);
  }


  @CrossOrigin
  @RequestMapping(value = "/api/getused", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
  @ResponseBody
  public Result getUsed(@RequestBody String jsonString) {
    JSONObject obj = JSON.parseObject(jsonString);
    int id = Integer.valueOf(String.valueOf(obj.get("doctorid")));
    int count = registrationRecService.getUsed(id);
    return ResultFactory.buildSuccessResult(count);
  }

  @CrossOrigin
  @RequestMapping(value = "/api/getrec", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
  @ResponseBody
  public Result tryGetList(@RequestBody String jsonString) {
    JSONObject obj = JSON.parseObject(jsonString);
    int patientNo = Integer.valueOf(String.valueOf(obj.get("patientno")));
    List<RegistrationRecEntity> records = registrationRecService.tryGetList(patientNo);
    if (records.isEmpty()) {
      return ResultFactory.buildFailResult("未找到");
    }
    String deptName = deptService.getDeptName(records.get(0).getDeptid());
    String status = null;
    Vector vec = new Vector();
    for (RegistrationRecEntity rec : records) {
      JSONObject jsonObject = JSONObject.parseObject(JSON.toJSONString(rec));
      jsonObject.put("deptname", deptName);
      jsonObject.put("statusname", constantItemService.getName(rec.getPresentstatus()));
      vec.add(jsonObject);
    }
    return ResultFactory.buildSuccessResult(vec);
  }

  @CrossOrigin
  @RequestMapping(value = "/api/update", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
  @ResponseBody
  public Result update(@RequestBody String jsonString) {
    JSONObject obj = JSON.parseObject(jsonString);
    int id = Integer.valueOf(String.valueOf(obj.get("id")));
    registrationRecService.modifyStatus(id, 169);
    return ResultFactory.buildSuccessResult(null);
  }
}
