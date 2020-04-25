package com.neu.his.backend.dao;

import com.neu.his.backend.pojo.RegistrationLevelEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistrationLevelDAO extends JpaRepository<RegistrationLevelEntity, Integer> {
  RegistrationLevelEntity findByRegistrationlevelid(int id);
}
