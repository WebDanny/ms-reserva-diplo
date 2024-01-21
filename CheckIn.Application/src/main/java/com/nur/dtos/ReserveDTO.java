package com.nur.dtos;

import com.nur.model.Propiedad;
import java.util.Date;

public class ReserveDTO {
  public String id;
  public Date dateIn;
  public Date dateOut;
  public String details;

  public Propiedad propiedad;

  public ReserveDTO() {}

  public ReserveDTO(String id, Date dateIn, Date dateOut, String details, Propiedad propiedad) {
    this.id = id;
    this.dateIn = dateIn;
    this.dateOut = dateOut;
    this.details = details;
    this.propiedad = propiedad;
  }

  public String getId() {
    return id;
  }

  public Date getDateIn() {
    return dateIn;
  }

  public Date getDateOut() {
    return dateOut;
  }

  public String getDetails() {
    return details;
  }

  public Propiedad getPropiedad() {
    return propiedad;
  }
}
