package com.neu.his.backend.service;

import com.neu.his.backend.dao.RegistrationRecDAO;
import com.neu.his.backend.pojo.RegistrationRecEntity;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationRecService {

  @Autowired
  RegistrationRecDAO registrationRecDAO;

  public int getUsed(int id) {
    return registrationRecDAO.getCount(id);
  }

  public RegistrationRecEntity getLast() {
    return registrationRecDAO.findFirstByOrderByIdDesc();
  }

  public RegistrationRecEntity tryGetOne(int patientNo) {
    return registrationRecDAO.findFirstByPatientnoOrderByRegisreationtimeDesc(patientNo);
  }

  public List<RegistrationRecEntity> tryGetList(int patientNo) {
    return registrationRecDAO.findByPatientno(patientNo);
  }

  public RegistrationRecEntity getById(int id) {
    Optional<RegistrationRecEntity> item = registrationRecDAO.findById(id);
    return item.orElse(null);
  }

  public void add(RegistrationRecEntity rec) {
    registrationRecDAO.save(rec);
  }

  public void modifyStatus(int id, int status) {
    registrationRecDAO.modifyStatus(id, status);
  }

  public List<RegistrationRecEntity> getUnchecked(int userid) {
    return registrationRecDAO.getUnchecked(userid);
  }

  public List<RegistrationRecEntity> getChecked(int userid) {
    return registrationRecDAO.getChecked(userid);
  }

  public List<RegistrationRecEntity> getOpened(int userid) {
    return registrationRecDAO.getOpened(userid);
  }

  public List<Integer> getRegisIdListByPatientNo(int patientNo) {
    List<Integer> idList = new ArrayList<>();
    List<RegistrationRecEntity> records = tryGetList(patientNo);
    for (RegistrationRecEntity rec : records) {
      idList.add(rec.getId());
    }
    return idList;
  }

  public int getNewPatientNo() {
    return registrationRecDAO.getMaxPatientNo() + 1;
  }

  public int getNewId() {
    return registrationRecDAO.getMaxId() + 1;
  }


}
