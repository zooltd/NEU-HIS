package com.neu.his.backend.dao;

import com.neu.his.backend.pojo.EvaluationRecEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface EvaluationRecDAO extends JpaRepository<EvaluationRecEntity,Integer> {

  List<EvaluationRecEntity> findByRegisid(int regisId);

  @Query(nativeQuery = true,value = "SELECT MAX(id) FROM evaluationrec")
  int getMaxId();

  @Transactional
  void deleteAllByRegisid(int regisId);

}
