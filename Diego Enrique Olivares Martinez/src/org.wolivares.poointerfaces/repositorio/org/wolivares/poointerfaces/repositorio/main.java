package org.wolivares.poointerfaces.repositorio;
import java.util.List;
import org.wolivares.poointerfaces.modelo.*;

/* Diego Enrique Olivares Martinez OM23008 */

public class main {
    public static void main(String[] args) {
        ClienteListRepositorio clienteRepo = new ClienteListRepositorio();

        Cliente cliente1 = new Cliente(1, "Diego", "Olivares");
        Cliente cliente2 = new Cliente(2, "Carolina", "Rivera");
        Cliente cliente3 = new Cliente(3, "Sebastian", "Rivera");

        clienteRepo.crear(cliente1);
        clienteRepo.crear(cliente2);
        clienteRepo.crear(cliente3);

        System.out.println("\nListado de clientes:");
        List<Cliente> clientes = clienteRepo.listar();
        for (Cliente cliente : clientes) {
            System.out.println("\nNombre: "+cliente.getNombre()+" \nApellido: "+cliente.getApellido());
        }

        System.out.println("\nListado de clientes ordenados por nombre de forma ascendente:");
        List<Cliente> clientesOrdenadosAsc = ((OrdenableRepositorio) clienteRepo).listar("nombre", Direccion.ASC);
        for (Cliente cliente : clientesOrdenadosAsc) {
            System.out.println("\nNombre: "+cliente.getNombre()+" \nApellido: "+cliente.getApellido());
        }

        System.out.println("\nListado de clientes paginados:");
        List<Cliente> clientesPaginados = ((PaginableRepositorio) clienteRepo).listar(0, 1);
        for (Cliente cliente : clientesPaginados) {
            System.out.println("\nNombre: "+cliente.getNombre()+" \nApellido: "+cliente.getApellido());
        }

        clienteRepo.eliminar(3);
        Cliente cliente4 = new Cliente(4, "Yari", "Olivares");
        clienteRepo.crear(cliente4);
        clienteRepo.editar(cliente4);
        System.out.println("\nListado de clientes:");
        List<Cliente> clientes1 = clienteRepo.listar();
        for (Cliente cliente : clientes1) {
            System.out.println("\nNombre: "+cliente.getNombre()+" \nApellido: "+cliente.getApellido());
        }
    }
}
