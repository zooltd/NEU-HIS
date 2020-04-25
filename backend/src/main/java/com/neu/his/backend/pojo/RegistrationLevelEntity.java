package com.neu.his.backend.pojo;

import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "registrationlevel", schema = "his", catalog = "")
public class RegistrationLevelEntity {

  private int registrationlevelid;
  private String registrationlevelcode;
  private String registrationlevelname;
  private Integer sequencenumber;
  private Double registrationfee;
  private Integer registrationlimit;
  private Integer deletetag;

  @Id
  @Column(name = "registrationlevelid")
  public int getRegistrationlevelid() {
    return registrationlevelid;
  }

  public void setRegistrationlevelid(int registrationlevelid) {
    this.registrationlevelid = registrationlevelid;
  }

  @Basic
  @Column(name = "registrationlevelcode")
  public String getRegistrationlevelcode() {
    return registrationlevelcode;
  }

  public void setRegistrationlevelcode(String registrationlevelcode) {
    this.registrationlevelcode = registrationlevelcode;
  }

  @Basic
  @Column(name = "registrationlevelname")
  public String getRegistrationlevelname() {
    return registrationlevelname;
  }

  public void setRegistrationlevelname(String registrationlevelname) {
    this.registrationlevelname = registrationlevelname;
  }

  @Basic
  @Column(name = "sequencenumber")
  public Integer getSequencenumber() {
    return sequencenumber;
  }

  public void setSequencenumber(Integer sequencenumber) {
    this.sequencenumber = sequencenumber;
  }

  @Basic
  @Column(name = "registrationfee")
  public Double getRegistrationfee() {
    return registrationfee;
  }

  public void setRegistrationfee(Double registrationfee) {
    this.registrationfee = registrationfee;
  }

  @Basic
  @Column(name = "registrationlimit")
  public Integer getRegistrationlimit() {
    return registrationlimit;
  }

  public void setRegistrationlimit(Integer registrationlimit) {
    this.registrationlimit = registrationlimit;
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
    RegistrationLevelEntity that = (RegistrationLevelEntity) o;
    return registrationlevelid == that.registrationlevelid &&
        Objects.equals(registrationlevelcode, that.registrationlevelcode) &&
        Objects.equals(registrationlevelname, that.registrationlevelname) &&
        Objects.equals(sequencenumber, that.sequencenumber) &&
        Objects.equals(registrationfee, that.registrationfee) &&
        Objects.equals(registrationlimit, that.registrationlimit) &&
        Objects.equals(deletetag, that.deletetag);
  }

  @Override
  public int hashCode() {
    return Objects
        .hash(registrationlevelid, registrationlevelcode, registrationlevelname, sequencenumber,
            registrationfee, registrationlimit, deletetag);
  }
}
