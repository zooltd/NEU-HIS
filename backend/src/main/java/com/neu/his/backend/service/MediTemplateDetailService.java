package com.neu.his.backend.service;

import com.neu.his.backend.dao.MediTemplateDetailDAO;
import com.neu.his.backend.pojo.MediTemplateDetailEntity;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MediTemplateDetailService {

  @Autowired
  MediTemplateDetailDAO mediTemplateDetailDAO;

  public List<MediTemplateDetailEntity> getDetails(int id){
    return mediTemplateDetailDAO.findByMeditemplateid(id);
  }

}
