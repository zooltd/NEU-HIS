package com.neu.his.backend.pojo;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "registrationrec", schema = "his", catalog = "")
public class RegistrationRecEntity {

  private int id;
  private Integer patientno;
  private String name;
  private String gender;
  private String identifycard;
  private Date birthdate;
  private Integer age;
  private String agetype;
  private String address;
  private Date consultdate;
  private String amorpm;
  private Integer deptid;
  private Integer doctorid;
  private Integer registerlevelid;
  private Integer paytypeid;
  private Integer needmedirecbook;
  private Timestamp regisreationtime;
  private Integer regisreationid;
  private Integer presentstatus;

  @Id
  @Column(name = "id")
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  @Basic
  @Column(name = "patientno")
  public Integer getPatientno() {
    return patientno;
  }

  public void setPatientno(Integer patientno) {
    this.patientno = patientno;
  }

  @Basic
  @Column(name = "name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Basic
  @Column(name = "gender")
  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  @Basic
  @Column(name = "identifycard")
  public String getIdentifycard() {
    return identifycard;
  }

  public void setIdentifycard(String identifycard) {
    this.identifycard = identifycard;
  }

  @Basic
  @Column(name = "birthdate")
  public Date getBirthdate() {
    return birthdate;
  }

  public void setBirthdate(Date birthdate) {
    this.birthdate = birthdate;
  }

  @Basic
  @Column(name = "age")
  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  @Basic
  @Column(name = "agetype")
  public String getAgetype() {
    return agetype;
  }

  public void setAgetype(String agetype) {
    this.agetype = agetype;
  }

  @Basic
  @Column(name = "address")
  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  @Basic
  @Column(name = "consultdate")
  public Date getConsultdate() {
    return consultdate;
  }

  public void setConsultdate(Date consultdate) {
    this.consultdate = consultdate;
  }

  @Basic
  @Column(name = "amorpm")
  public String getAmorpm() {
    return amorpm;
  }

  public void setAmorpm(String amorpm) {
    this.amorpm = amorpm;
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
  @Column(name = "doctorid")
  public Integer getDoctorid() {
    return doctorid;
  }

  public void setDoctorid(Integer doctorid) {
    this.doctorid = doctorid;
  }

  @Basic
  @Column(name = "registerlevelid")
  public Integer getRegisterlevelid() {
    return registerlevelid;
  }

  public void setRegisterlevelid(Integer registerlevelid) {
    this.registerlevelid = registerlevelid;
  }

  @Basic
  @Column(name = "paytypeid")
  public Integer getPaytypeid() {
    return paytypeid;
  }

  public void setPaytypeid(Integer paytypeid) {
    this.paytypeid = paytypeid;
  }

  @Basic
  @Column(name = "needmedirecbook")
  public Integer getNeedmedirecbook() {
    return needmedirecbook;
  }

  public void setNeedmedirecbook(Integer needmedirecbook) {
    this.needmedirecbook = needmedirecbook;
  }

  @Basic
  @Column(name = "regisreationtime")
  public Timestamp getRegisreationtime() {
    return regisreationtime;
  }

  public void setRegisreationtime(Timestamp regisreationtime) {
    this.regisreationtime = regisreationtime;
  }

  @Basic
  @Column(name = "regisreationid")
  public Integer getRegisreationid() {
    return regisreationid;
  }

  public void setRegisreationid(Integer regisreationid) {
    this.regisreationid = regisreationid;
  }

  @Basic
  @Column(name = "presentstatus")
  public Integer getPresentstatus() {
    return presentstatus;
  }

  public void setPresentstatus(Integer presentstatus) {
    this.presentstatus = presentstatus;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RegistrationRecEntity that = (RegistrationRecEntity) o;
    return id == that.id &&
        Objects.equals(patientno, that.patientno) &&
        Objects.equals(name, that.name) &&
        Objects.equals(gender, that.gender) &&
        Objects.equals(identifycard, that.identifycard) &&
        Objects.equals(birthdate, that.birthdate) &&
        Objects.equals(age, that.age) &&
        Objects.equals(agetype, that.agetype) &&
        Objects.equals(address, that.address) &&
        Objects.equals(consultdate, that.consultdate) &&
        Objects.equals(amorpm, that.amorpm) &&
        Objects.equals(deptid, that.deptid) &&
        Objects.equals(doctorid, that.doctorid) &&
        Objects.equals(registerlevelid, that.registerlevelid) &&
        Objects.equals(paytypeid, that.paytypeid) &&
        Objects.equals(needmedirecbook, that.needmedirecbook) &&
        Objects.equals(regisreationtime, that.regisreationtime) &&
        Objects.equals(regisreationid, that.regisreationid) &&
        Objects.equals(presentstatus, that.presentstatus);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, patientno, name, gender, identifycard, birthdate, age, agetype, address,
        consultdate, amorpm, deptid, doctorid, registerlevelid, paytypeid, needmedirecbook,
        regisreationtime, regisreationid, presentstatus);
  }

  @Override
  public String toString() {
    return "RegistrationRecEntity{" +
        "id=" + id +
        ", patientno=" + patientno +
        ", name='" + name + '\'' +
        ", gender='" + gender + '\'' +
        ", identifycard='" + identifycard + '\'' +
        ", birthdate=" + birthdate +
        ", age=" + age +
        ", agetype='" + agetype + '\'' +
        ", address='" + address + '\'' +
        ", consultdate=" + consultdate +
        ", amorpm='" + amorpm + '\'' +
        ", deptid=" + deptid +
        ", doctorid=" + doctorid +
        ", registerlevelid=" + registerlevelid +
        ", paytypeid=" + paytypeid +
        ", needmedirecbook=" + needmedirecbook +
        ", regisreationtime=" + regisreationtime +
        ", regisreationid=" + regisreationid +
        ", presentstatus=" + presentstatus +
        '}';
  }
}
