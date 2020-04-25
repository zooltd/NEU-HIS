package com.neu.his.backend.pojo;

import java.sql.Timestamp;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "meditemplate", schema = "his", catalog = "")
public class MediTemplateEntity {

  private int id;
  private String name;
  private Integer doctorid;
  private Timestamp creationtime;
  private String range;
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
  @Column(name = "name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
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
  @Column(name = "creationtime")
  public Timestamp getCreationtime() {
    return creationtime;
  }

  public void setCreationtime(Timestamp creationtime) {
    this.creationtime = creationtime;
  }

  @Basic
  @Column(name = "range")
  public String getRange() {
    return range;
  }

  public void setRange(String range) {
    this.range = range;
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
    MediTemplateEntity that = (MediTemplateEntity) o;
    return id == that.id &&
        Objects.equals(name, that.name) &&
        Objects.equals(doctorid, that.doctorid) &&
        Objects.equals(creationtime, that.creationtime) &&
        Objects.equals(range, that.range) &&
        Objects.equals(deletetag, that.deletetag);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, doctorid, creationtime, range, deletetag);
  }
}
