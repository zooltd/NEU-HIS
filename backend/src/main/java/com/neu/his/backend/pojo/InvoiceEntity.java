package com.neu.his.backend.pojo;

import java.sql.Timestamp;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "invoicetable", schema = "his", catalog = "")
public class InvoiceEntity {

  private int id;
  private Integer invoiceno;
  private Double invoiceprice;
  private Integer invoicestate;
  private Timestamp chargetime;
  private Integer operatorid;
  private Integer registrationid;
  private Integer paytype;
  private String redinvoiceno;
  private Integer invoicestatus;

  @Id
  @Column(name = "id")
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  @Basic
  @Column(name = "invoiceno")
  public Integer getInvoiceno() {
    return invoiceno;
  }

  public void setInvoiceno(Integer invoiceno) {
    this.invoiceno = invoiceno;
  }

  @Basic
  @Column(name = "invoiceprice")
  public Double getInvoiceprice() {
    return invoiceprice;
  }

  public void setInvoiceprice(Double invoiceprice) {
    this.invoiceprice = invoiceprice;
  }

  @Basic
  @Column(name = "invoicestate")
  public Integer getInvoicestate() {
    return invoicestate;
  }

  public void setInvoicestate(Integer invoicestate) {
    this.invoicestate = invoicestate;
  }

  @Basic
  @Column(name = "chargetime")
  public Timestamp getChargetime() {
    return chargetime;
  }

  public void setChargetime(Timestamp chargetime) {
    this.chargetime = chargetime;
  }

  @Basic
  @Column(name = "operatorid")
  public Integer getOperatorid() {
    return operatorid;
  }

  public void setOperatorid(Integer operatorid) {
    this.operatorid = operatorid;
  }

  @Basic
  @Column(name = "registrationid")
  public Integer getRegistrationid() {
    return registrationid;
  }

  public void setRegistrationid(Integer registrationid) {
    this.registrationid = registrationid;
  }

  @Basic
  @Column(name = "paytype")
  public Integer getPaytype() {
    return paytype;
  }

  public void setPaytype(Integer paytype) {
    this.paytype = paytype;
  }

  @Basic
  @Column(name = "redinvoiceno")
  public String getRedinvoiceno() {
    return redinvoiceno;
  }

  public void setRedinvoiceno(String redinvoiceno) {
    this.redinvoiceno = redinvoiceno;
  }

  @Basic
  @Column(name = "invoicestatus")
  public Integer getInvoicestatus() {
    return invoicestatus;
  }

  public void setInvoicestatus(Integer invoicestatus) {
    this.invoicestatus = invoicestatus;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InvoiceEntity that = (InvoiceEntity) o;
    return id == that.id &&
        Objects.equals(invoiceno, that.invoiceno) &&
        Objects.equals(invoiceprice, that.invoiceprice) &&
        Objects.equals(invoicestate, that.invoicestate) &&
        Objects.equals(chargetime, that.chargetime) &&
        Objects.equals(operatorid, that.operatorid) &&
        Objects.equals(registrationid, that.registrationid) &&
        Objects.equals(paytype, that.paytype) &&
        Objects.equals(redinvoiceno, that.redinvoiceno) &&
        Objects.equals(invoicestatus, that.invoicestatus);
  }

  @Override
  public int hashCode() {
    return Objects
        .hash(id, invoiceno, invoiceprice, invoicestate, chargetime, operatorid, registrationid,
            paytype, redinvoiceno, invoicestatus);
  }
}
