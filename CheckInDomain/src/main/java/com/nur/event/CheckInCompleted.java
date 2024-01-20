package com.nur.event;

import com.nur.core.DomainEvent;
import com.nur.model.CheckIn;

import java.time.LocalDate;

public class CheckInCompleted extends DomainEvent {

  private CheckIn checkIn;

  public CheckInCompleted(CheckIn checkIn) {
    super(LocalDate.now());
    this.checkIn = checkIn;
  }

  public CheckIn getCheckIn() {
    return checkIn;
  }
}
