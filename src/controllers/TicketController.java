package controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import models.TicketSoporte;

public class TicketController {
  public Set<TicketSoporte> filtrarYOrdenarTickets(List<TicketSoporte> tickets, int prioridadMinima){
    Set<TicketSoporte> tTSet = new TreeSet<>(new ComparadorTicket());
    for (TicketSoporte ticketSoporte : tickets) {
      if(ticketSoporte.getPrioridad()>= prioridadMinima){
        tTSet.add(ticketSoporte);
      }
    }
    return tTSet;
  }

  public Map<String, List<String>> agruparCodigosPorPrioridad(List<TicketSoporte> tickets){
    Map<String, List<String>> grupos = new TreeMap<>();
    grupos.put("ALTA", new ArrayList<>());
    grupos.put("MEDIA", new ArrayList<>());
    grupos.put("BAJA", new ArrayList<>());

    for (TicketSoporte ticketSoporte : tickets) {
      String rango;
      if(ticketSoporte.getPrioridad()>=4){
        rango = "ALTA";
      }else if(ticketSoporte.getPrioridad()>=2){
        rango = "MEDIA";
      }else{
        rango = "BAJA";
      }
      String numero = ticketSoporte.getCodigo().split("-")[1];
      List<String> listaGrupos = grupos.get(rango);
      if(!listaGrupos.contains(numero)){
        listaGrupos.add(numero);
      }
    }
    return grupos;
  }

}
