package com.neu.his.backend.Controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.neu.his.backend.pojo.ConstantItemEntity;
import com.neu.his.backend.pojo.DiagnosisRecEntity;
import com.neu.his.backend.pojo.DiseaseEntity;
import com.neu.his.backend.pojo.EvaluationRecEntity;
import com.neu.his.backend.pojo.MediTemplateDetailEntity;
import com.neu.his.backend.pojo.MediTemplateEntity;
import com.neu.his.backend.pojo.MedicineEntity;
import com.neu.his.backend.pojo.PrescriptionDetailEntity;
import com.neu.his.backend.pojo.RegistrationRecEntity;
import com.neu.his.backend.result.Result;
import com.neu.his.backend.result.ResultCode;
import com.neu.his.backend.result.ResultFactory;
import com.neu.his.backend.service.ConstantItemService;
import com.neu.his.backend.service.DiagnosisRecService;
import com.neu.his.backend.service.DiseaseService;
import com.neu.his.backend.service.EvaluationRecService;
import com.neu.his.backend.service.MediTemplateDetailService;
import com.neu.his.backend.service.MediTemplateService;
import com.neu.his.backend.service.MedicineService;
import com.neu.his.backend.service.PrescriptionDetailService;
import com.neu.his.backend.service.RegistrationRecService;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;
import javax.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DoctorController {

  @Autowired
  RegistrationRecService registrationRecService;
  @Autowired
  DiseaseService diseaseService;
  @Autowired
  MedicineService medicineService;
  @Autowired
  MediTemplateService mediTemplateService;
  @Autowired
  MediTemplateDetailService mediTemplateDetailService;
  @Autowired
  ConstantItemService constantItemService;
  @Autowired
  DiagnosisRecService diagnosisRecService;
  @Autowired
  EvaluationRecService evaluationRecService;
  @Autowired
  PrescriptionDetailService prescriptionDetailService;


  @CrossOrigin
  @RequestMapping(value = "/api/init", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
  @ResponseBody
  public Result init(@RequestBody String jsonString) {
    JSONObject obj = JSON.parseObject(jsonString);
    int userid = Integer.parseInt(String.valueOf(obj.get("userid")));
    List<List> data = new ArrayList<>();
    data.add(registrationRecService.getUnchecked(userid));
    data.add(registrationRecService.getChecked(userid));
    data.add(registrationRecService.getOpened(userid));
    data.add(diseaseService.getAll());
    data.add(getTemplates());
    data.add(getMedi());
//    System.out.println(data.size());
    return ResultFactory.buildSuccessResult(data);
  }

  public Vector getTemplates() {
    Vector data = new Vector();
    for (MediTemplateEntity template : mediTemplateService.getall()) {
      Map map = new HashMap();
      map.put("template", template);
      Vector vec = new Vector();
      List<MediTemplateDetailEntity> details = mediTemplateDetailService
          .getDetails(template.getId());
      for (MediTemplateDetailEntity detail : details) {
        Object objects[] = new Object[3];
        objects[0] = detail;
        objects[1] = medicineService.get(detail.getId());
        objects[2] = 1; //数量
        vec.add(objects);
      }
      map.put("detail", vec);
      data.add(map);
    }
    return data;
  }

  public Vector getMedi() {
    Vector vec = new Vector();
    List<Integer> mediTypeId = medicineService.getTypes();
    List<ConstantItemEntity> mediTypes = new ArrayList<>();
    for (int i : mediTypeId) {
      mediTypes.add(constantItemService.getById(i));
    }
    List<ConstantItemEntity> mediCategories = constantItemService.getByConstantTypeId(10);
    for (ConstantItemEntity mediCatagory : mediCategories) {
      Map firstMap = new HashMap();
      firstMap.put("label", mediCatagory.getConstantname());
      firstMap.put("id", mediCatagory.getId());
      Vector firstChildren = new Vector();
      for (ConstantItemEntity mediType : mediTypes) {
        List<MedicineEntity> medicine = medicineService
            .tryGet(mediType.getId(), mediCatagory.getId());
        if (medicine.size() == 0) {
          continue;
        }
        Map secondMap = new HashMap();
        secondMap.put("label", mediType.getConstantname());
        secondMap.put("id", mediType.getId());
        Vector secondChildren = new Vector();
        for (MedicineEntity medi : medicine) {
          Map thirdMap = new HashMap();
          thirdMap.put("label", medi.getMediname());
          thirdMap.put("id", medi.getId());
          secondChildren.add(thirdMap);
        }
        secondMap.put("children", secondChildren);
        firstChildren.add(secondMap);
      }
      firstMap.put("children", firstChildren);
      vec.add(firstMap);
    }
    return vec;
  }

  @CrossOrigin
  @RequestMapping(value = "/api/getmedi", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
  @ResponseBody
  public Result getMedi(@RequestBody String jsonString) {
    JSONObject obj = JSON.parseObject(jsonString);
    int mediId = (int) obj.get("mediId");
    System.out.println(mediId);
    MedicineEntity medi = medicineService.get(mediId);
    System.out.println(medi.getMediname());
    return ResultFactory.buildSuccessResult(medi);
  }

  @CrossOrigin
  @RequestMapping(value = "/api/doctor/showdiagnosis", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
  @ResponseBody
  public Result showDiagnosis(@RequestBody String jsonString) {
    JSONObject obj = JSON.parseObject(jsonString);
    int regisId = (int) obj.get("registrationId");
    DiagnosisRecEntity diagnosis = diagnosisRecService.getByRegisId(regisId);
    List<EvaluationRecEntity> evaluations = evaluationRecService.getByRegisId(regisId);
    Object data[] = new Object[2];
    data[0] = diagnosis;
    if (evaluations.size() == 0) {
      data[1] = null;
      return ResultFactory.buildSuccessResult(data);
    }
    Object disease[] = new Object[evaluations.size()];
    for (int i = 0; i < evaluations.size(); i++) {
      int id = evaluations.get(i).getDiseaseid();
      DiseaseEntity d = diseaseService.getById(id);
      JSONObject object = JSON.parseObject(JSON.toJSONString(d));
      if (evaluations.get(i).getOnsettime() == null) {
        object.put("time", null);
      } else {
        LocalDateTime time = evaluations.get(i).getOnsettime().toLocalDateTime();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String str = time.format(formatter);
        object.put("time", str);
      }
      disease[i] = object;
    }
    data[1] = disease;
    return ResultFactory.buildSuccessResult(data);
  }

  @CrossOrigin
  @RequestMapping(value = "/api/doctor/savediagnosis", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
  @ResponseBody
  public Result saveDiagnosis(@RequestBody String jsonString) {
    String message = "提交成功";
    JSONObject obj = JSON.parseObject(jsonString);
    int regisId = (int) obj.get("regisId");
    int state = (int) obj.get("state");
    //获取病历信息实体
    DiagnosisRecEntity diagnosis = JSON
        .parseObject(JSON.toJSONString(obj.get("diagnosis")), DiagnosisRecEntity.class);
    //获取诊断疾病实体列表
    List<EvaluationRecEntity> evaluations = JSON
        .parseArray(JSON.toJSONString(obj.getJSONArray("evaluations")), EvaluationRecEntity.class);
    //若状态号为166，则表中已存在记录，修改时删除已有记录
    if (state == 166) {
      message = "修改成功";
      diagnosisRecService.deleteByRegisId(regisId);
      evaluationRecService.deleteByRegisId(regisId);
    }
    //若状态号非166，则更新挂号信息状态为已诊
    else {
      registrationRecService.modifyStatus(regisId, 166);

    }
    diagnosis.setId(diagnosisRecService.getNewId());
    //保存新病历信息
    diagnosisRecService.save(diagnosis);
    int evalId = evaluationRecService.getNewId();
    //保存新诊断疾病
    for (int i = 0; i < evaluations.size(); i++) {
      evaluations.get(i).setId(i + evalId);
      evaluationRecService.save(evaluations.get(i));
    }
    return ResultFactory.buidResult(ResultCode.SUCCESS, message, getPatients(regisId));
  }

  public Object[] getPatients(int regisId) {
    int doctorId = registrationRecService.getById(regisId).getDoctorid();
    List<RegistrationRecEntity> unCheckedList = registrationRecService.getUnchecked(doctorId);
    List<RegistrationRecEntity> checkedList = registrationRecService.getChecked(doctorId);
    List<RegistrationRecEntity> openedList = registrationRecService.getOpened(doctorId);
    Object data[] = new Object[3];
    data[0] = unCheckedList;
    data[1] = checkedList;
    data[2] = openedList;
    return data;
  }

  @CrossOrigin
  @RequestMapping(value = "/api/doctor/modifydiagnosis", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
  @ResponseBody
  public Result modifyDiagnosis(@RequestBody String jsonString) {
    JSONObject obj = JSON.parseObject(jsonString);
    int regisId = (int) obj.get("regisId");
    registrationRecService.modifyStatus(regisId, 165);
    diagnosisRecService.deleteByRegisId(regisId);
    evaluationRecService.deleteByRegisId(regisId);
    return ResultFactory.buidResult(ResultCode.SUCCESS, "已移出至未诊区", getPatients(regisId));
  }

  @CrossOrigin
  @RequestMapping(value = "/api/doctor/submitmedi", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
  @ResponseBody
  public Result submitMedi(@RequestBody String jsonString) {
    String message = "开立成功";
    JSONObject obj = JSON.parseObject(jsonString);
    int regisId = (int) obj.get("regisId");
    int state = (int) obj.get("state");
    if (state == 167) {
      message = "修改成功";
      prescriptionDetailService.deleteByRegisId(regisId);
    }
    List<PrescriptionDetailEntity> details = JSON
        .parseArray(JSON.toJSONString(obj.getJSONArray("details")), PrescriptionDetailEntity.class);
    int firseId = prescriptionDetailService.getNewId();
    for (int i = 0; i < details.size(); i++) {
      details.get(i).setId(i + firseId);
    }
    prescriptionDetailService.saveAll(details);
    if (state != 167) {
      registrationRecService.modifyStatus(regisId, 167);
    }
    return ResultFactory.buidResult(ResultCode.SUCCESS, message, getPatients(regisId));
  }

  @CrossOrigin
  @RequestMapping(value = "/api/doctor/showmedi", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
  @ResponseBody
  public Result showMedi(@RequestBody String jsonString) {
    JSONObject obj = JSON.parseObject(jsonString);
    int regisId = (int) obj.get("regisId");
    List<PrescriptionDetailEntity> details = prescriptionDetailService.getByRegisId(regisId);
    Set<Integer> templateIdList = new HashSet();
    Vector medicine = new Vector();
    for (PrescriptionDetailEntity detail : details) {
      templateIdList.add(detail.getPrescriptionid());
      JSONObject medi = JSON.parseObject(JSON.toJSONString(detail));
      MedicineEntity mediInfo = medicineService.get(detail.getMediid());
      medi.put("mediId", medi.remove("mediid"));
      medi.put("templateId", medi.remove("prescriptionid"));
      medi.put("usage", medi.remove("instruction"));
//      medi.put("status",medi.remove("state"));
      medi.put("num", medi.remove("number"));
      medi.put("mediname", mediInfo.getMediname());
      medi.put("medispecification", mediInfo.getMedispecification());
      medi.put("price", mediInfo.getPrice());
      medicine.add(medi);
    }
    templateIdList.remove(0);
    Vector formwork = new Vector();
    for (int templateId : templateIdList) {
      MediTemplateEntity mediTemplate = mediTemplateService.getById(templateId);
      formwork.add(mediTemplate);
    }
    Object data[] = new Object[2];
    data[0] = medicine;
    data[1] = formwork;
    return ResultFactory.buildSuccessResult(data);
  }

  @CrossOrigin
  @RequestMapping(value = "/api/doctor/cancel", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
  @ResponseBody
  public Result cancel(@RequestBody String jsonString) {
    JSONObject obj = JSON.parseObject(jsonString);
    int regisId = (int) obj.get("regisId");
    prescriptionDetailService.deleteByRegisId(regisId);
    registrationRecService.modifyStatus(regisId, 166);
    return ResultFactory.buidResult(ResultCode.SUCCESS, "已撤销开立", getPatients(regisId));
  }
}