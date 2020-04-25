package com.neu.his.backend.service;

import com.neu.his.backend.dao.DeptDAO;
import com.neu.his.backend.pojo.DeptEntity;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeptService {

  @Autowired
  DeptDAO deptDAO;

  public List<DeptEntity> get() {
    return deptDAO.findAll();
  }

  public List<DeptEntity> getByCatagoryId(int id) {
    return deptDAO.findByDeptcategoryid(id);
  }

  public String getDeptName(int id) {
    return deptDAO.findById(id).getDeptname();
  }

}
