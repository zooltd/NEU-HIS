package com.neu.his.backend.pojo;

import java.sql.Timestamp;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "medicine", schema = "his", catalog = "")
public class MedicineEntity {

  private int id;
  private String code;
  private String mediname;
  private String medispecification;
  private String unit;
  private String manufacturer;
  private Integer meditype;
  private Integer medicatagory;
  private Double price;
  private String abbrcode;
  private Timestamp createtime;
  private Timestamp modifactiontime;
  private Integer deletetag;

  @Id
  @Column(name = "id")
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  @Basic
  @Column(name = "code")
  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  @Basic
  @Column(name = "mediname")
  public String getMediname() {
    return mediname;
  }

  public void setMediname(String mediname) {
    this.mediname = mediname;
  }

  @Basic
  @Column(name = "medispecification")
  public String getMedispecification() {
    return medispecification;
  }

  public void setMedispecification(String medispecification) {
    this.medispecification = medispecification;
  }

  @Basic
  @Column(name = "unit")
  public String getUnit() {
    return unit;
  }

  public void setUnit(String unit) {
    this.unit = unit;
  }

  @Basic
  @Column(name = "manufacturer")
  public String getManufacturer() {
    return manufacturer;
  }

  public void setManufacturer(String manufacturer) {
    this.manufacturer = manufacturer;
  }

  @Basic
  @Column(name = "meditype")
  public Integer getMeditype() {
    return meditype;
  }

  public void setMeditype(Integer meditype) {
    this.meditype = meditype;
  }

  @Basic
  @Column(name = "medicatagory")
  public Integer getMedicatagory() {
    return medicatagory;
  }

  public void setMedicatagory(Integer medicatagory) {
    this.medicatagory = medicatagory;
  }

  @Basic
  @Column(name = "price")
  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  @Basic
  @Column(name = "abbrcode")
  public String getAbbrcode() {
    return abbrcode;
  }

  public void setAbbrcode(String abbrcode) {
    this.abbrcode = abbrcode;
  }

  @Basic
  @Column(name = "createtime")
  public Timestamp getCreatetime() {
    return createtime;
  }

  public void setCreatetime(Timestamp createtime) {
    this.createtime = createtime;
  }

  @Basic
  @Column(name = "modifactiontime")
  public Timestamp getModifactiontime() {
    return modifactiontime;
  }

  public void setModifactiontime(Timestamp modifactiontime) {
    this.modifactiontime = modifactiontime;
  }

  @Basic
  @Column(name = "deletetag")
  public Integer getDeletetag() {
    return deletetag;
  }

  public void setDeletetag(Integer deletetag) {
    this.deletetag = deletetag;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MedicineEntity that = (MedicineEntity) o;
    return id == that.id &&
        Objects.equals(code, that.code) &&
        Objects.equals(mediname, that.mediname) &&
        Objects.equals(medispecification, that.medispecification) &&
        Objects.equals(unit, that.unit) &&
        Objects.equals(manufacturer, that.manufacturer) &&
        Objects.equals(meditype, that.meditype) &&
        Objects.equals(medicatagory, that.medicatagory) &&
        Objects.equals(price, that.price) &&
        Objects.equals(abbrcode, that.abbrcode) &&
        Objects.equals(createtime, that.createtime) &&
        Objects.equals(modifactiontime, that.modifactiontime) &&
        Objects.equals(deletetag, that.deletetag);
  }

  @Override
  public int hashCode() {
    return Objects
        .hash(id, code, mediname, medispecification, unit, manufacturer, meditype, medicatagory,
            price, abbrcode, createtime, modifactiontime, deletetag);
  }
}
