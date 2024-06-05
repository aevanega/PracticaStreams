package org.example;

import org.example.interfaces.ServicioCuentas;

import java.util.ArrayList;
import java.util.List;

public class Cliente extends Banco implements ServicioCuentas, Comparable<Cliente> {

    private Integer numero;
    private String nombre;
    private Domicilio domicilio;
    private String rfc;
    private String telefono;
    private List<Cuenta> cuentas;
    private String fechaDeNacimiento;

    public Cliente(Integer numero, String nombre, Domicilio domicilio, String rfc, String telefono, String fechaDeNacimiento) {
        super(nombre, domicilio, rfc, telefono);
        this.numero = numero;
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.rfc = rfc;
        this.telefono = telefono;
        this.fechaDeNacimiento = fechaDeNacimiento;
        this.cuentas = new ArrayList<>();
    }


    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Domicilio getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(Domicilio domicilio) {
        this.domicilio = domicilio;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public List<Cuenta> getCuentas() {
        return cuentas;
    }

    public void setCuentas(List<Cuenta> cuentas) {
        this.cuentas = cuentas;
    }

    public String getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public void setFechaDeNacimiento(String fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "numero=" + numero +
                ", nombre='" + nombre + '\'' +
                ", domicilio=" + domicilio +
                ", rfc='" + rfc + '\'' +
                ", telefono='" + telefono + '\'' +
                ", cuentas=" + cuentas +
                ", fechaDeNacimiento='" + fechaDeNacimiento + '\'' +
                '}';
    }

    @Override
    public Boolean agregarCuenta(Cuenta cuenta) {
        return cuentas.add(cuenta);
    }

    @Override
    public Boolean cancelarCuenta(Integer numero) {
        return cuentas.removeIf(cuenta -> cuenta.getNumero().equals(numero));
    }

    @Override
    public void abonarCuenta(Integer numero, Double abono) {
        cuentas.stream()
                .filter(cuenta -> cuenta.getNumero().equals(numero))
                .findFirst()
                .ifPresentOrElse(
                        cuenta -> cuenta.setSaldo(cuenta.getSaldo() + abono),
                        () -> System.out.println("No se encontró la cuenta con número " + numero)
                );
    }

    @Override
    public void retirar(Integer numero, Double retiro) {
        cuentas.stream()
                .filter(cuenta -> cuenta.getNumero().equals(numero))
                .findFirst()
                .ifPresentOrElse(
                        cuenta -> cuenta.setSaldo(cuenta.getSaldo() - retiro),
                        () -> System.out.println("No se encontró la cuenta con número " + numero)
                );
    }

    @Override
    public Cuenta[] obtenerCuentas() {
        return cuentas.toArray(new Cuenta[0]);
    }

    @Override
    public int compareTo(Cliente o) {
        return this.numero.compareTo(o.numero);
    }
}
