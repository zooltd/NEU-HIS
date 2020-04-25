package com.neu.his.backend.pojo;

import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "department", schema = "his", catalog = "")
public class DeptEntity {

  private int id;
  private String deptcode;
  private String deptname;
  private Integer deptcategoryid;
  private Integer depttype;

  @Id
  @Column(name = "id")
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  @Basic
  @Column(name = "deptcode")
  public String getDeptcode() {
    return deptcode;
  }

  public void setDeptcode(String deptcode) {
    this.deptcode = deptcode;
  }

  @Basic
  @Column(name = "deptname")
  public String getDeptname() {
    return deptname;
  }

  public void setDeptname(String deptname) {
    this.deptname = deptname;
  }

  @Basic
  @Column(name = "deptcategoryid")
  public Integer getDeptcategoryid() {
    return deptcategoryid;
  }

  public void setDeptcategoryid(Integer deptcategoryid) {
    this.deptcategoryid = deptcategoryid;
  }

  @Basic
  @Column(name = "depttype")
  public Integer getDepttype() {
    return depttype;
  }

  public void setDepttype(Integer depttype) {
    this.depttype = depttype;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DeptEntity that = (DeptEntity) o;
    return id == that.id &&
        Objects.equals(deptcode, that.deptcode) &&
        Objects.equals(deptname, that.deptname) &&
        Objects.equals(deptcategoryid, that.deptcategoryid) &&
        Objects.equals(depttype, that.depttype);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, deptcode, deptname, deptcategoryid, depttype);
  }
}
