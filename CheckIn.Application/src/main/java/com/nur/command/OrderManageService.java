package com.nur.command;

import com.nur.model.Reserve;
import com.nur.model.StatusReserve;
import org.springframework.stereotype.Service;

@Service
public class OrderManageService {

  public Reserve confirm(Reserve orderPayment, Reserve orderStock) {
    Reserve o =
        new Reserve(
            orderPayment.getId(),
            orderPayment.getDateIn(),
            orderPayment.getDateOut(),
            orderPayment.getDetails(),
            orderPayment.getPropiedad());

    System.out.println("CONFIRMADA");
    orderStock.setStatus(StatusReserve.FINALIZED);
    /*if (orderPayment.getStatus().equals("ACCEPT") &&
            orderStock.getStatus().equals("ACCEPT")) {
        o.setStatus("CONFIRMED");
    } else if (orderPayment.getStatus().equals("REJECT") &&
            orderStock.getStatus().equals("REJECT")) {
        o.setStatus("REJECTED");
    } else if (orderPayment.getStatus().equals("REJECT") ||
            orderStock.getStatus().equals("REJECT")) {
        String source = orderPayment.getStatus().equals("REJECT")
                ? "PAYMENT" : "STOCK";
        o.setStatus("ROLLBACK");
        o.setSource(source);
    }*/
    return o;
  }
}
