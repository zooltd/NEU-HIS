package com.neu.his.backend.dao;

import com.neu.his.backend.pojo.PrescriptionDetailEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface PrescriptionDetailDAO extends JpaRepository<PrescriptionDetailEntity, Integer> {

  @Query(nativeQuery = true, value = "SELECT MAX(id) FROM prescriptiondetail")
  int getMaxId();

  List<PrescriptionDetailEntity> findByRegisid(int regisId);

  @Transactional
  void deleteAllByRegisid(int regisId);

  @Transactional
  @Modifying
  @Query(value = "UPDATE PrescriptionDetailEntity detail SET detail.state = ?2 WHERE detail.id= ?1")
  void modifyStatus(int id,int status);

}
