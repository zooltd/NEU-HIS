package com.neu.his.backend.dao;

import com.neu.his.backend.pojo.UserEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserDAO extends JpaRepository<UserEntity, Integer> {

  UserEntity findByUsername(String username);

  UserEntity getByUsernameAndPassword(String username, String password);

  List<UserEntity> findByDeptidAndRegistrationlevelidAndUsertype(int deptid, int registrationlevelid,int usertype);


}
