package com.neu.his.backend.pojo;

import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "disease", schema = "his", catalog = "")
public class DiseaseEntity {

  private int id;
  private String diseaseabbr;
  private String diseasename;
  private String icdcode;
  private Integer diseasetype;

  @Id
  @Column(name = "id")
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  @Basic
  @Column(name = "diseaseabbr")
  public String getDiseaseabbr() {
    return diseaseabbr;
  }

  public void setDiseaseabbr(String diseaseabbr) {
    this.diseaseabbr = diseaseabbr;
  }

  @Basic
  @Column(name = "diseasename")
  public String getDiseasename() {
    return diseasename;
  }

  public void setDiseasename(String diseasename) {
    this.diseasename = diseasename;
  }

  @Basic
  @Column(name = "icdcode")
  public String getIcdcode() {
    return icdcode;
  }

  public void setIcdcode(String icdcode) {
    this.icdcode = icdcode;
  }

  @Basic
  @Column(name = "diseasetype")
  public Integer getDiseasetype() {
    return diseasetype;
  }

  public void setDiseasetype(Integer diseasetype) {
    this.diseasetype = diseasetype;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DiseaseEntity that = (DiseaseEntity) o;
    return id == that.id &&
        Objects.equals(diseaseabbr, that.diseaseabbr) &&
        Objects.equals(diseasename, that.diseasename) &&
        Objects.equals(icdcode, that.icdcode) &&
        Objects.equals(diseasetype, that.diseasetype);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, diseaseabbr, diseasename, icdcode, diseasetype);
  }
}
