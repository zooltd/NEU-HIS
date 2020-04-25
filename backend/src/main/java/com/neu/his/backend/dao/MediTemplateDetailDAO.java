package com.neu.his.backend.dao;

import com.neu.his.backend.pojo.MediTemplateDetailEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MediTemplateDetailDAO extends JpaRepository<MediTemplateDetailEntity,Integer> {

  List<MediTemplateDetailEntity> findByMeditemplateid(int id);

}
