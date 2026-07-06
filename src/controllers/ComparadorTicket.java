package controllers;

import java.util.Comparator;

import models.TicketSoporte;

public class ComparadorTicket implements Comparator<TicketSoporte>{

  @Override
  public int compare(TicketSoporte t1, TicketSoporte t2) {
    int compPrioridad = Integer.compare(t2.getPrioridad(), t1.getPrioridad());
    if(compPrioridad != 0){
      return compPrioridad;
    }
    int compTecnico = t1.getTecnico().compareToIgnoreCase(t2.getTecnico());
    return compTecnico;
  }
}
