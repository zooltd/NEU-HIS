package com.neu.his.backend.dao;

import com.neu.his.backend.pojo.DiseaseEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiseaseDAO extends JpaRepository<DiseaseEntity,Integer> {


}
