package com.neu.his.backend.dao;

import com.neu.his.backend.pojo.DiagnosisRecEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface DiagnosisRecDAO extends JpaRepository<DiagnosisRecEntity, Integer> {

  DiagnosisRecEntity findByRegistrationrecid(int registrationId);

  @Query(nativeQuery = true, value = "SELECT MAX(id) FROM diagnosisrec")
  int getMaxId();

  @Transactional
  @Modifying
  @Query(nativeQuery = true, value = "UPDATE diagnosisrec rec SET rec.recordstatus = ?2 WHERE rec.registrationrecid= ?1")
  void modifyStatus(int regisId, int status);

  @Transactional
  void deleteAllByRegistrationrecid(int regisId);

}
