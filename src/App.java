import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import controllers.TicketController;
import models.TicketSoporte;

public class App {
    public static void main(String[] args) throws Exception {
        runTicketSoporte();
    }

    private static void runTicketSoporte() {
        List<TicketSoporte> tickets = new ArrayList<>();
        tickets.add(new TicketSoporte("TK-104", "Ana Torres", 5));
        tickets.add(new TicketSoporte("TK-101", "Luis Mora", 2));
        tickets.add(new TicketSoporte("TK-108", "Carlos Vega", 4));
        tickets.add(new TicketSoporte("tk-104", "Ana Torres", 5));
        tickets.add(new TicketSoporte("TK-103", "Luis Andrade", 3));
        tickets.add(new TicketSoporte("TK-107", "Mateo Rojas", 1));
        tickets.add(new TicketSoporte("TK-102", "Sofia Cordero", 4));
        tickets.add(new TicketSoporte("TK-106", "Carlos Mendez", 5));
        tickets.add(new TicketSoporte("TK-105", "Ana Molina", 2));

        System.out.println("======== Arreglo Original =======");
        for (TicketSoporte ticketSoporte : tickets) {
            System.out.println(ticketSoporte);
        }
        TicketController controller = new TicketController();
        System.out.println("========= Filtrar ==========");
        Set<TicketSoporte> filtrar = controller.filtrarYOrdenarTickets(tickets, 2);
        for (TicketSoporte ticketSoporte : filtrar) {
            System.out.println(ticketSoporte);
        }

        System.out.println("========== Agrupar =======");
        Map<String, List<String>> grupos = controller.agruparCodigosPorPrioridad(tickets);
        for(Map.Entry<String, List<String>> entry : grupos.entrySet()){
            System.out.println(entry.getKey() + "-> " + entry.getValue());
        }
    }
}
