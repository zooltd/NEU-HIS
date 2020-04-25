package com.neu.his.backend.service;

import com.neu.his.backend.dao.PrescriptionDetailDAO;
import com.neu.his.backend.pojo.PrescriptionDetailEntity;
import java.util.List;
import java.util.Vector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PrescriptionDetailService {

  @Autowired
  PrescriptionDetailDAO prescriptionDetailDAO;

  public void deleteByRegisId(int regisId) {
    prescriptionDetailDAO.deleteAllByRegisid(regisId);
  }

  public int getNewId() {
    return prescriptionDetailDAO.getMaxId() + 1;
  }

  public void saveAll(List<PrescriptionDetailEntity> list) {
    prescriptionDetailDAO.saveAll(list);
  }

  public List<PrescriptionDetailEntity> getByRegisId(int id) {
    return prescriptionDetailDAO.findByRegisid(id);
  }

  public Vector<PrescriptionDetailEntity> getByRegisId(Iterable<Integer> regisIdList) {
    Vector<PrescriptionDetailEntity> vec = new Vector<>();
    for (int id : regisIdList) {
      List<PrescriptionDetailEntity> list = prescriptionDetailDAO.findByRegisid(id);
      if (list.size() != 0) {
        vec.addAll(list);
      }
    }
    return vec;
  }

  public void modifyStatus(int id, int status) {
    prescriptionDetailDAO.modifyStatus(id, status);
  }


}
