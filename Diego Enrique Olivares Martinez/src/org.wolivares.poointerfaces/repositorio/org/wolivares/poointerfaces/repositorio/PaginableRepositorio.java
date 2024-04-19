package org.wolivares.poointerfaces.repositorio;
import org.wolivares.poointerfaces.modelo.Cliente;
import java.util.List;


public interface PaginableRepositorio {
    List<Cliente> listar(int desde, int hasta);
}

