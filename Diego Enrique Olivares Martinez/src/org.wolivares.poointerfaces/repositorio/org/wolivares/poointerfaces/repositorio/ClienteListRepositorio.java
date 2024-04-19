package org.wolivares.poointerfaces.repositorio;
import org.wolivares.poointerfaces.modelo.Cliente;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ClienteListRepositorio implements CrudRepositorio,OrdenableRepositorio, PaginableRepositorio {
    private List<Cliente> dataSource;

    public ClienteListRepositorio() {
        this.dataSource = new ArrayList<>();
    }

    @Override
    public List<Cliente> listar(){
        return new ArrayList<>(dataSource);
    }

    @Override
    public Cliente porId(Integer id) {
        for (Cliente cliente : dataSource) {
            if (cliente.getId().equals(id)) {
                return cliente;
            }
        }
        return null; 
    }

    @Override
    public void crear(Cliente cliente) {
        dataSource.add(cliente);
    }

    @Override
    public void editar(Cliente cliente) {
        for (int i = 0; i < dataSource.size(); i++) {
            if (dataSource.get(i).getId().equals(cliente.getId())) {
                dataSource.set(i, cliente);
                return;
            }
        }
        throw new IllegalArgumentException("No se encontró el cliente con ID " + cliente.getId());
    }

    @Override
    public void eliminar(Integer id) {
        Cliente clienteAEliminar = null;
    for (Cliente cliente : dataSource) {
        if (cliente.getId().equals(id)) {
            clienteAEliminar = cliente;
            break;
        }
    }
    if (clienteAEliminar != null) {
        dataSource.remove(clienteAEliminar);
    } else {
        throw new IllegalArgumentException("No se encontró ningún cliente con el ID " + id);
    }
    }
    @Override
    public List<Cliente> listar(String campo, Direccion dir) {
        if (!campo.equals("nombre") && !campo.equals("apellido")) {
            throw new IllegalArgumentException("El campo de ordenación debe ser 'nombre' o 'apellido'");
        }

        Comparator<Cliente> comparador;
        if (campo.equals("nombre")) {
            comparador = Comparator.comparing(Cliente::getNombre);
        } else { 
            comparador = Comparator.comparing(Cliente::getApellido);
        }

        if (dir == Direccion.DESC) {
            comparador = comparador.reversed();
        }

        Collections.sort(dataSource, comparador);

        return dataSource;
    }

    @Override
    public List<Cliente> listar(int desde, int hasta) {
        if (desde < 0 || hasta > dataSource.size() || desde > hasta) {
            throw new IllegalArgumentException("Rango de paginación inválido");
        }

        return new ArrayList<>(dataSource.subList(desde, hasta));
    }
}
