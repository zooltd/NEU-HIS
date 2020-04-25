package com.neu.his.backend.pojo;

import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "meditemplatedetail", schema = "his", catalog = "")
public class MediTemplateDetailEntity {

  private int id;
  private Integer meditemplateid;
  private Integer mediid;
  private String usage;
  private String dosage;
  private String frequency;

  @Id
  @Column(name = "id")
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  @Basic
  @Column(name = "meditemplateid")
  public Integer getMeditemplateid() {
    return meditemplateid;
  }

  public void setMeditemplateid(Integer meditemplateid) {
    this.meditemplateid = meditemplateid;
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
  @Column(name = "usage")
  public String getUsage() {
    return usage;
  }

  public void setUsage(String usage) {
    this.usage = usage;
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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MediTemplateDetailEntity that = (MediTemplateDetailEntity) o;
    return id == that.id &&
        Objects.equals(meditemplateid, that.meditemplateid) &&
        Objects.equals(mediid, that.mediid) &&
        Objects.equals(usage, that.usage) &&
        Objects.equals(dosage, that.dosage) &&
        Objects.equals(frequency, that.frequency);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, meditemplateid, mediid, usage, dosage, frequency);
  }
}
