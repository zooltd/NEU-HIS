package com.neu.his.backend.dao;

import com.neu.his.backend.pojo.MedicineEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MedicineDAO extends JpaRepository<MedicineEntity,Integer> {

  List<MedicineEntity> findByMeditypeAndMedicatagory(int typeId,int categoryId);

  @Query(nativeQuery = true,value = "SELECT DISTINCT meditype FROM medicine")
  List<Integer> getTypes();
}
