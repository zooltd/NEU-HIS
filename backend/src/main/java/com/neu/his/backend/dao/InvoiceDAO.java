package com.neu.his.backend.dao;

import com.neu.his.backend.pojo.InvoiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface InvoiceDAO extends JpaRepository<InvoiceEntity,Long> {

  InvoiceEntity findFirstByOrderByIdDesc();

  @Query(nativeQuery = true,value = "SELECT MAX(invoiceno) FROM invoicetable")
  int getMaxNo();

}
