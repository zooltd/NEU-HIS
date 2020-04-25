package com.neu.his.backend.service;

import com.neu.his.backend.dao.ConstantItemDAO;
import com.neu.his.backend.pojo.ConstantItemEntity;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConstantItemService {

  @Autowired
  ConstantItemDAO constantItemDao;

  public List<ConstantItemEntity> getByConstantTypeId(int constanttypeid) {
    return constantItemDao.findByConstanttypeid(constanttypeid);
  }

  //TODO
  public String getName(int id) {
    Optional<ConstantItemEntity> item = constantItemDao.findById(id);
    return item.map(ConstantItemEntity::getConstantname).orElse(null);
  }

  public ConstantItemEntity getById(int id){
    Optional<ConstantItemEntity> item = constantItemDao.findById(id);
    return item.orElse(null);
  }


}
