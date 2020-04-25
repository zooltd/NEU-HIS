package com.neu.his.backend.service;

import com.neu.his.backend.dao.EvaluationRecDAO;
import com.neu.his.backend.pojo.EvaluationRecEntity;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EvaluationRecService {

  @Autowired
  EvaluationRecDAO evaluationRecDAO;

  public List<EvaluationRecEntity> getByRegisId(int regisId) {
    return evaluationRecDAO.findByRegisid(regisId);
  }

  public void save(EvaluationRecEntity evaluationRec) {
    evaluationRecDAO.save(evaluationRec);
  }
  public void saveAll(List<EvaluationRecEntity> evaluationRec){
    evaluationRecDAO.saveAll(evaluationRec);
  }

  public int getNewId(){
    return evaluationRecDAO.getMaxId()+1;
  }
  public void deleteById(int id){
    evaluationRecDAO.deleteById(id);
  }

  public void deleteAll(List<EvaluationRecEntity> evaluationRecEntityList){
    evaluationRecDAO.deleteAll(evaluationRecEntityList);
  }

  public void deleteByRegisId(int regisId){
    evaluationRecDAO.deleteAllByRegisid(regisId);
  }
}
