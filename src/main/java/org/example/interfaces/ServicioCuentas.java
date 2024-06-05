package org.example.interfaces;

import org.example.Cuenta;

public interface ServicioCuentas {
    Boolean agregarCuenta(Cuenta cuenta);
    Boolean cancelarCuenta(Integer numero);
    void abonarCuenta(Integer numero, Double abono);
    void retirar(Integer numero, Double retiro);
    Cuenta[] obtenerCuentas();

}
