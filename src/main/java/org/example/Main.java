package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        // Crear 3 clientes
        Cliente cliente1 = new Cliente(1, "Cliente 1", null, "RFC1", "1234567890", "01-01-1990");
        Cliente cliente2 = new Cliente(2, "Cliente 2", null, "RFC2", "0987654321", "02-02-1991");
        Cliente cliente3 = new Cliente(3, "Cliente 3", null, "RFC3", "1122334455", "03-03-1992");

        List<Cliente> clientes = List.of(cliente1, cliente2, cliente3);

        // Leer el archivo de cuentas y asignar cuentas a clientes
        try {
            List<String> lines = Files.readAllLines(Paths.get("src/cuentas.txt"));
            lines.forEach(line -> {
                Cuenta cuenta = parseCuenta(line);
                if (cuenta != null) {
                    int clienteNumero = obtenerClienteNumero(line);
                    clientes.stream()
                            .filter(cliente -> cliente.getNumero() == clienteNumero)
                            .findFirst()
                            .ifPresent(cliente -> cliente.agregarCuenta(cuenta));
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Validar que cada cliente tenga sus respectivas cuentas
        clientes.forEach(cliente -> {
            System.out.println("Cuentas del " + cliente.getNombre() + ":");
            for (Cuenta cuenta : cliente.obtenerCuentas()) {
                System.out.println(cuenta);
            }
        });
    }

    private static Cuenta parseCuenta(String line) {
        if (line == null || line.trim().isEmpty()) {
            return null;
        }

        // Verificar que la línea tiene al menos la longitud mínima esperada
        if (line.length() < 2) {
            return null;
        }

        String tipoCuenta = line.substring(0, 2);
        String cleanedLine = line.substring(2).replaceAll("[\\[\\]]", "");
        String[] parts = cleanedLine.split(",\\s*");

        // Verificar que hay suficientes partes en la línea
        if (parts.length < 5) {
            return null;
        }

        try {
            Integer numero = Integer.parseInt(parts[0].trim());
            String fechaApertura = parts[1].trim();
            Double saldo = Double.parseDouble(parts[2].trim());
            Double interes = Double.parseDouble(parts[3].trim());
            Integer clienteNumero = Integer.parseInt(parts[4].trim());

            Cuenta cuenta;
            if (tipoCuenta.equals("CA")) {
                cuenta = new CuentaDeAhorro(numero, saldo, interes);
            } else {
                cuenta = new CuentaDeCheque(numero, saldo, interes);
            }
            cuenta.setFechaApertura(fechaApertura);
            cuenta.setNumero(clienteNumero);  // Necesitamos agregar este método en la clase Cuenta
            return cuenta;
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static int obtenerClienteNumero(String line) {
        String[] parts = line.split("\\[|,|\\]");
        return Integer.parseInt(parts[5].trim());
//        // domicilios
//        Domicilio domicilioBanco = new Domicilio("Calle 1", 123, "Colonia 1", "Estado 1", 11111);
//        Domicilio domicilioCliente1 = new Domicilio("Calle 2", 456, "Colonia 2", "Estado 2", 22222);
//        Domicilio domicilioCliente2 = new Domicilio("Calle 3", 789, "Colonia 3", "Estado 3", 33333);
//
//        // banco
//        Banco banco = new Banco("Bancolombia", domicilioBanco, "RFCBANCO", "555-5555");
//
//        // clientes
//        Cliente cliente1 = new Cliente(1, "Juan Perez", domicilioCliente1, "RFC1", "555-1234", "2000-01-01");
//        Cliente cliente2 = new Cliente(2, "Maria Lopez", domicilioCliente2, "RFC2", "555-5678",  "1985-02-02");
//
//        // Agregar clientes al banco
//        banco.agregarCliente(cliente1);
//        banco.agregarCliente(cliente2);
//
//        // Consultar cliente por número
//        Cliente clienteConsultado = banco.consultarCliente(1);
//        System.out.println("Cliente consultado por número:");
//        System.out.println(clienteConsultado);
//
//        // Buscar cliente por RFC
//        Cliente clientePorRFC = banco.buscarClientePorRFC("RFC2");
//        System.out.println("\nCliente encontrado por RFC:");
//        System.out.println(clientePorRFC);
//
//        // Eliminar cliente por número
//        boolean clienteEliminado = banco.eliminarCliente(2);
//        System.out.println("\nCliente eliminado? " + (clienteEliminado ? "Sí" : "No"));
//
//        // Obtener todos los clientes ordenados por TreeSet
//        TreeSet<Cliente> clientesOrdenados = banco.obtenerClientes();
//        System.out.println("\nClientes en el banco (ordenados por TreeSet):");
//        for (Cliente cliente : clientesOrdenados) {
//            System.out.println(cliente);
//        }
//
    }
}