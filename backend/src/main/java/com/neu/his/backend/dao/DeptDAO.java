package com.neu.his.backend.dao;

import com.neu.his.backend.pojo.DeptEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeptDAO extends JpaRepository<DeptEntity, Integer> {

  List<DeptEntity> findByDeptcategoryid(int deptcategoryid);

  DeptEntity findById(int id);

}
