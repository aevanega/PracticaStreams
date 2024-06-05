package org.example;

public abstract class Cuenta implements Comparable<Cuenta> {
    private Cliente cliente;
    private Integer numero;
    private String fechaApertura;
    private Double saldo;
    private String fechaCancelacion;

    public Cuenta(Integer numero, Double saldo) {
        this.numero = numero;
        this.saldo = saldo;
    }

    @Override
    public int compareTo(Cuenta otraCuenta) {
        return this.saldo.compareTo(otraCuenta.saldo);
    }
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getFechaApertura() {
        return fechaApertura;
    }

    public void setFechaApertura(String fechaApertura) {
        this.fechaApertura = fechaApertura;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public String getFechaCancelacion() {
        return fechaCancelacion;
    }

    public void setFechaCancelacion(String fechaCancelacion) {
        this.fechaCancelacion = fechaCancelacion;
    }

    @Override
    public String toString() {
        return "Cuenta{" +
                "cliente=" + cliente +
                ", numero=" + numero +
                ", fechaApertura='" + fechaApertura + '\'' +
                ", saldo=" + saldo +
                ", fechaCancelacion='" + fechaCancelacion + '\'' +
                '}';
    }
}
