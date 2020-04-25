package com.neu.his.backend.dao;

import com.neu.his.backend.pojo.RegistrationRecEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface RegistrationRecDAO extends JpaRepository<RegistrationRecEntity, Integer> {

  @Query(nativeQuery = true, value = "SELECT COUNT(r.patientno) FROM registrationrec AS r WHERE TO_DAYS(r.consultdate) = TO_DAYS(NOW()) AND r.doctorid = ?1 AND presentstatus != 168")
  int getCount(int id);

  RegistrationRecEntity findFirstByOrderByIdDesc();

  RegistrationRecEntity findFirstByPatientnoOrderByRegisreationtimeDesc(int patientno);

  List<RegistrationRecEntity> findByPatientno(int patientno);

  @Transactional
  @Modifying
  @Query(value = "UPDATE RegistrationRecEntity rec SET rec.presentstatus = ?2 WHERE rec.id= ?1")
  void modifyStatus(int id, int status);

  @Query(nativeQuery = true, value = "SELECT * FROM registrationrec WHERE consultdate = CURDATE() AND presentstatus = 165 AND doctorid = ?1")
  List<RegistrationRecEntity> getUnchecked(int userid);

  @Query(nativeQuery = true, value = "SELECT * FROM registrationrec WHERE consultdate = CURDATE() AND presentstatus = 166 AND doctorid = ?1")
  List<RegistrationRecEntity> getChecked(int userid);

  @Query(nativeQuery = true, value = "SELECT * FROM registrationrec WHERE consultdate = CURDATE() AND presentstatus = 167 AND doctorid = ?1")
  List<RegistrationRecEntity> getOpened(int userid);

  @Query(nativeQuery = true, value = "SELECT MAX(patientno) FROM registrationrec")
  int getMaxPatientNo();

  @Query(nativeQuery = true, value = "SELECT MAX(id) FROM registrationrec")
  int getMaxId();

}
