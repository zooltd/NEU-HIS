package com.neu.his.backend.service;

import com.neu.his.backend.dao.InvoiceDAO;
import com.neu.his.backend.pojo.InvoiceEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InvoiceService {

  @Autowired
  InvoiceDAO invoiceDAO;

  public InvoiceEntity getLast() {
    return invoiceDAO.findFirstByOrderByIdDesc();
  }

  public void add(InvoiceEntity invoice) {
    invoiceDAO.save(invoice);
  }

  public int getNewNo() {
    return invoiceDAO.getMaxNo() + 1;
  }
}
