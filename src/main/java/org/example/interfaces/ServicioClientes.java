package org.example.interfaces;

import org.example.Cliente;

import java.util.TreeSet;

public interface ServicioClientes   {
    Boolean agregarCliente(Cliente cliente);
    Boolean eliminarCliente(Integer numero);
    Cliente consultarCliente(Integer numero);
    TreeSet<Cliente> obtenerClientes();
    Cliente buscarClientePorRFC(String rfc);
}
