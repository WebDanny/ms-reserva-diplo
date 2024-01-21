package com.nur.event;

import com.nur.core.DomainEvent;
import com.nur.model.CheckIn;
import java.time.LocalDate;

public class PropiedadAssigned extends DomainEvent {

  private CheckIn checkIn;

  public PropiedadAssigned(CheckIn checkIn) {
    super(LocalDate.now());
    this.checkIn = checkIn;
  }

  public CheckIn getCheckIn() {
    return checkIn;
  }
}
