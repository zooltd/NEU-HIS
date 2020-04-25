package com.neu.his.backend.pojo;

import java.sql.Timestamp;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "evaluationrec", schema = "his", catalog = "")
public class EvaluationRecEntity {

  private int id;
  private Integer patientno;
  private Integer regisid;
  private Integer diseaseid;
  private Integer diagnosiscategory;
  private Timestamp onsettime;
  private Integer diagnosistype;

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
  @Column(name = "regisid")
  public Integer getRegisid() {
    return regisid;
  }

  public void setRegisid(Integer regisid) {
    this.regisid = regisid;
  }

  @Basic
  @Column(name = "diseaseid")
  public Integer getDiseaseid() {
    return diseaseid;
  }

  public void setDiseaseid(Integer diseaseid) {
    this.diseaseid = diseaseid;
  }

  @Basic
  @Column(name = "diagnosiscategory")
  public Integer getDiagnosiscategory() {
    return diagnosiscategory;
  }

  public void setDiagnosiscategory(Integer diagnosiscategory) {
    this.diagnosiscategory = diagnosiscategory;
  }

  @Basic
  @Column(name = "onsettime")
  public Timestamp getOnsettime() {
    return onsettime;
  }

  public void setOnsettime(Timestamp onsettime) {
    this.onsettime = onsettime;
  }

  @Basic
  @Column(name = "diagnosistype")
  public Integer getDiagnosistype() {
    return diagnosistype;
  }

  public void setDiagnosistype(Integer diagnosistype) {
    this.diagnosistype = diagnosistype;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EvaluationRecEntity that = (EvaluationRecEntity) o;
    return id == that.id &&
        Objects.equals(patientno, that.patientno) &&
        Objects.equals(regisid, that.regisid) &&
        Objects.equals(diseaseid, that.diseaseid) &&
        Objects.equals(diagnosiscategory, that.diagnosiscategory) &&
        Objects.equals(onsettime, that.onsettime) &&
        Objects.equals(diagnosistype, that.diagnosistype);
  }

  @Override
  public int hashCode() {
    return Objects
        .hash(id, patientno, regisid, diseaseid, diagnosiscategory, onsettime, diagnosistype);
  }
}
