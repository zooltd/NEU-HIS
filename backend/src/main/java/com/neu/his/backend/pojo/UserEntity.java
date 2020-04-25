package com.neu.his.backend.pojo;

import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users", schema = "his", catalog = "")
public class UserEntity {

  private int id;
  private String username;
  private String password;
  private String realname;
  private Integer usertype;
  private Integer deptid;
  private Integer registrationlevelid;
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
  @Column(name = "username")
  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  @Basic
  @Column(name = "password")
  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  @Basic
  @Column(name = "realname")
  public String getRealname() {
    return realname;
  }

  public void setRealname(String realname) {
    this.realname = realname;
  }

  @Basic
  @Column(name = "usertype")
  public Integer getUsertype() {
    return usertype;
  }

  public void setUsertype(Integer usertype) {
    this.usertype = usertype;
  }

  @Basic
  @Column(name = "deptid")
  public Integer getDeptid() {
    return deptid;
  }

  public void setDeptid(Integer deptid) {
    this.deptid = deptid;
  }

  @Basic
  @Column(name = "registrationlevelid")
  public Integer getRegistrationlevelid() {
    return registrationlevelid;
  }

  public void setRegistrationlevelid(Integer registrationlevelid) {
    this.registrationlevelid = registrationlevelid;
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
    UserEntity that = (UserEntity) o;
    return id == that.id &&
        Objects.equals(username, that.username) &&
        Objects.equals(password, that.password) &&
        Objects.equals(realname, that.realname) &&
        Objects.equals(usertype, that.usertype) &&
        Objects.equals(deptid, that.deptid) &&
        Objects.equals(registrationlevelid, that.registrationlevelid) &&
        Objects.equals(deletetag, that.deletetag);
  }

  @Override
  public int hashCode() {
    return Objects
        .hash(id, username, password, realname, usertype, deptid, registrationlevelid, deletetag);
  }
}
