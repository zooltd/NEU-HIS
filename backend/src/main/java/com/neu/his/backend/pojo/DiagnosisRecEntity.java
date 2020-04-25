package com.neu.his.backend.pojo;

import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "diagnosisrec", schema = "his", catalog = "")
public class DiagnosisRecEntity {

  private int id;
  private Integer patientno;
  private Integer registrationrecid;
  private String selfintro;
  private String presentdiseasehis;
  private String treatment;
  private String pastdiseasehis;
  private String allergy;
  private String examination;
  private String examinationadvice;
  private String note;
  private String examinres;
  private String diagnosisres;
  private String advice;
  private Integer recordstatus;

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
  @Column(name = "registrationrecid")
  public Integer getRegistrationrecid() {
    return registrationrecid;
  }

  public void setRegistrationrecid(Integer registrationrecid) {
    this.registrationrecid = registrationrecid;
  }

  @Basic
  @Column(name = "selfintro")
  public String getSelfintro() {
    return selfintro;
  }

  public void setSelfintro(String selfintro) {
    this.selfintro = selfintro;
  }

  @Basic
  @Column(name = "presentdiseasehis")
  public String getPresentdiseasehis() {
    return presentdiseasehis;
  }

  public void setPresentdiseasehis(String presentdiseasehis) {
    this.presentdiseasehis = presentdiseasehis;
  }

  @Basic
  @Column(name = "treatment")
  public String getTreatment() {
    return treatment;
  }

  public void setTreatment(String treatment) {
    this.treatment = treatment;
  }

  @Basic
  @Column(name = "pastdiseasehis")
  public String getPastdiseasehis() {
    return pastdiseasehis;
  }

  public void setPastdiseasehis(String pastdiseasehis) {
    this.pastdiseasehis = pastdiseasehis;
  }

  @Basic
  @Column(name = "allergy")
  public String getAllergy() {
    return allergy;
  }

  public void setAllergy(String allergy) {
    this.allergy = allergy;
  }

  @Basic
  @Column(name = "examination")
  public String getExamination() {
    return examination;
  }

  public void setExamination(String examination) {
    this.examination = examination;
  }

  @Basic
  @Column(name = "examinationadvice")
  public String getExaminationadvice() {
    return examinationadvice;
  }

  public void setExaminationadvice(String examinationadvice) {
    this.examinationadvice = examinationadvice;
  }

  @Basic
  @Column(name = "note")
  public String getNote() {
    return note;
  }

  public void setNote(String note) {
    this.note = note;
  }

  @Basic
  @Column(name = "examinres")
  public String getExaminres() {
    return examinres;
  }

  public void setExaminres(String examinres) {
    this.examinres = examinres;
  }

  @Basic
  @Column(name = "diagnosisres")
  public String getDiagnosisres() {
    return diagnosisres;
  }

  public void setDiagnosisres(String diagnosisres) {
    this.diagnosisres = diagnosisres;
  }

  @Basic
  @Column(name = "advice")
  public String getAdvice() {
    return advice;
  }

  public void setAdvice(String advice) {
    this.advice = advice;
  }

  @Basic
  @Column(name = "recordstatus")
  public Integer getRecordstatus() {
    return recordstatus;
  }

  public void setRecordstatus(Integer recordstatus) {
    this.recordstatus = recordstatus;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DiagnosisRecEntity that = (DiagnosisRecEntity) o;
    return id == that.id &&
        Objects.equals(patientno, that.patientno) &&
        Objects.equals(registrationrecid, that.registrationrecid) &&
        Objects.equals(selfintro, that.selfintro) &&
        Objects.equals(presentdiseasehis, that.presentdiseasehis) &&
        Objects.equals(treatment, that.treatment) &&
        Objects.equals(pastdiseasehis, that.pastdiseasehis) &&
        Objects.equals(allergy, that.allergy) &&
        Objects.equals(examination, that.examination) &&
        Objects.equals(examinationadvice, that.examinationadvice) &&
        Objects.equals(note, that.note) &&
        Objects.equals(examinres, that.examinres) &&
        Objects.equals(diagnosisres, that.diagnosisres) &&
        Objects.equals(advice, that.advice) &&
        Objects.equals(recordstatus, that.recordstatus);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, patientno, registrationrecid, selfintro, presentdiseasehis, treatment,
        pastdiseasehis, allergy, examination, examinationadvice, note, examinres, diagnosisres,
        advice, recordstatus);
  }
}
