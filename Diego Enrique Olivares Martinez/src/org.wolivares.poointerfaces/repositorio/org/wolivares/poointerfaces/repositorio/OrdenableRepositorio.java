package org.wolivares.poointerfaces.repositorio;
import org.wolivares.poointerfaces.modelo.Cliente;
import java.util.List;

public interface OrdenableRepositorio {
    List<Cliente> listar(String campo, Direccion dir);
}

