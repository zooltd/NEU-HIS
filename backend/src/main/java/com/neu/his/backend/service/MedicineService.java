package com.neu.his.backend.service;

import com.neu.his.backend.dao.MedicineDAO;
import com.neu.his.backend.pojo.MedicineEntity;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicineService {

  @Autowired
  MedicineDAO medicineDAO;

  public MedicineEntity get(int id) {
    Optional<MedicineEntity> item = medicineDAO.findById(id);
    return item.orElse(null);
  }

  public List<MedicineEntity> getAll() {
    return medicineDAO.findAll();
  }

  public List<MedicineEntity> tryGet(int typeId,int CategoryId){
    return medicineDAO.findByMeditypeAndMedicatagory(typeId, CategoryId);
  }

  public List<Integer> getTypes(){
    return medicineDAO.getTypes();
  }

}
