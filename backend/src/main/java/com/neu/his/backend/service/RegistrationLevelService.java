package com.neu.his.backend.service;

import com.neu.his.backend.dao.RegistrationLevelDAO;
import com.neu.his.backend.pojo.RegistrationLevelEntity;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationLevelService {

  @Autowired
  RegistrationLevelDAO registrationLevelDAO;

  public List<RegistrationLevelEntity> getLevels() {
    return registrationLevelDAO.findAll();
  }

  public int getlimit(int id){
    return registrationLevelDAO.findByRegistrationlevelid(id).getRegistrationlimit();
  }

}
