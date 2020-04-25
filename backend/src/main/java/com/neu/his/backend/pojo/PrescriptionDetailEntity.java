package com.neu.his.backend.pojo;

import java.sql.Timestamp;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "prescriptiondetail", schema = "his", catalog = "")
public class PrescriptionDetailEntity {

  private int id;
  private Integer regisid;
  private Integer prescriptionid;
  private Integer mediid;
  private String instruction;
  private String dosage;
  private String frequency;
  private Integer number;
  private Integer state;
  private Timestamp time;

  @Id
  @Column(name = "id")
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  @Basic
  @Column(name = "regisid")
  public Integer getRegisid() {
    return regisid;
  }

  public void setRegisid(Integer regisid) {
    this.regisid = regisid;
  }

  @Basic
  @Column(name = "prescriptionid")
  public Integer getPrescriptionid() {
    return prescriptionid;
  }

  public void setPrescriptionid(Integer prescriptionid) {
    this.prescriptionid = prescriptionid;
  }

  @Basic
  @Column(name = "mediid")
  public Integer getMediid() {
    return mediid;
  }

  public void setMediid(Integer mediid) {
    this.mediid = mediid;
  }

  @Basic
  @Column(name = "instruction")
  public String getInstruction() {
    return instruction;
  }

  public void setInstruction(String instruction) {
    this.instruction = instruction;
  }

  @Basic
  @Column(name = "dosage")
  public String getDosage() {
    return dosage;
  }

  public void setDosage(String dosage) {
    this.dosage = dosage;
  }

  @Basic
  @Column(name = "frequency")
  public String getFrequency() {
    return frequency;
  }

  public void setFrequency(String frequency) {
    this.frequency = frequency;
  }

  @Basic
  @Column(name = "number")
  public Integer getNumber() {
    return number;
  }

  public void setNumber(Integer number) {
    this.number = number;
  }

  @Basic
  @Column(name = "state")
  public Integer getState() {
    return state;
  }

  public void setState(Integer state) {
    this.state = state;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PrescriptionDetailEntity that = (PrescriptionDetailEntity) o;
    return id == that.id &&
        Objects.equals(regisid, that.regisid) &&
        Objects.equals(prescriptionid, that.prescriptionid) &&
        Objects.equals(mediid, that.mediid) &&
        Objects.equals(instruction, that.instruction) &&
        Objects.equals(dosage, that.dosage) &&
        Objects.equals(frequency, that.frequency) &&
        Objects.equals(number, that.number) &&
        Objects.equals(state, that.state);
  }

  @Override
  public int hashCode() {
    return Objects
        .hash(id, regisid, prescriptionid, mediid, instruction, dosage, frequency, number, state);
  }

  @Basic
  @Column(name = "time")
  public Timestamp getTime() {
    return time;
  }

  public void setTime(Timestamp time) {
    this.time = time;
  }
}
