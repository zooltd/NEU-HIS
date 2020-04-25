package com.neu.his.backend.service;

import com.neu.his.backend.dao.DiseaseDAO;
import com.neu.his.backend.pojo.DiseaseEntity;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DiseaseService {

  @Autowired
  DiseaseDAO diseaseDAO;

  public List<DiseaseEntity> getAll() {
    return diseaseDAO.findAll();
  }

  public DiseaseEntity getById(int id) {
    Optional<DiseaseEntity> item = diseaseDAO.findById(id);

    return item.orElse(null);
  }
}
