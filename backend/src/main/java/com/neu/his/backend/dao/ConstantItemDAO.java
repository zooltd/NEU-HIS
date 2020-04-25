package com.neu.his.backend.dao;

import com.neu.his.backend.pojo.ConstantItemEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConstantItemDAO extends JpaRepository<ConstantItemEntity,Integer> {
  List<ConstantItemEntity> findByConstanttypeid(int constanttypeid);


}
