package com.neu.his.backend.service;

import com.neu.his.backend.dao.MediTemplateDAO;
import com.neu.his.backend.pojo.MediTemplateEntity;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MediTemplateService {

  @Autowired
  MediTemplateDAO mediTemplateDAO;

  public List<MediTemplateEntity> getall() {
    return mediTemplateDAO.findAll();
  }

  public MediTemplateEntity getById(int id) {
    Optional<MediTemplateEntity> item = mediTemplateDAO.findById(id);
    return item.orElse(null);
  }

}
