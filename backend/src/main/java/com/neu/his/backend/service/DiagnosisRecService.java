package com.neu.his.backend.service;

import com.neu.his.backend.dao.DiagnosisRecDAO;
import com.neu.his.backend.pojo.DiagnosisRecEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DiagnosisRecService {

  @Autowired
  DiagnosisRecDAO diagnosisRecDAO;

  public DiagnosisRecEntity getByRegisId(int regisId){
    return diagnosisRecDAO.findByRegistrationrecid(regisId);
  }

  public void save(DiagnosisRecEntity diagnosisRec){
    diagnosisRecDAO.save(diagnosisRec);
  }

  public int getNewId(){
    return diagnosisRecDAO.getMaxId()+1;
  }

  public void modifyStatus(int regisId,int status){
    diagnosisRecDAO.modifyStatus(regisId,status);
  }

  public void deleteByRegisId(int regisId){
      diagnosisRecDAO.deleteAllByRegistrationrecid(regisId);
  }



}
