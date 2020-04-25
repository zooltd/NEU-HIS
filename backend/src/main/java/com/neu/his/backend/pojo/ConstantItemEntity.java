package com.neu.his.backend.pojo;

import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "constantitem", schema = "his", catalog = "")
public class ConstantItemEntity {

  private int id;
  private int constanttypeid;
  private String constantcode;
  private String constantname;

  @Id
  @Column(name = "id")
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  @Basic
  @Column(name = "constanttypeid")
  public int getConstanttypeid() {
    return constanttypeid;
  }

  public void setConstanttypeid(int constanttypeid) {
    this.constanttypeid = constanttypeid;
  }

  @Basic
  @Column(name = "constantcode")
  public String getConstantcode() {
    return constantcode;
  }

  public void setConstantcode(String constantcode) {
    this.constantcode = constantcode;
  }

  @Basic
  @Column(name = "constantname")
  public String getConstantname() {
    return constantname;
  }

  public void setConstantname(String constantname) {
    this.constantname = constantname;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ConstantItemEntity that = (ConstantItemEntity) o;
    return id == that.id &&
        Objects.equals(constanttypeid, that.constanttypeid) &&
        Objects.equals(constantcode, that.constantcode) &&
        Objects.equals(constantname, that.constantname);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, constanttypeid, constantcode, constantname);
  }
}
