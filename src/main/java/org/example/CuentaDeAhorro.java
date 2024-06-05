package org.example;

public class CuentaDeAhorro extends Cuenta{
    private Double tasaDeInteresMensual;


    public CuentaDeAhorro(Integer numero, Double saldo, Double tasaDeInteresMensual) {

        super(numero, saldo);
        this.tasaDeInteresMensual = tasaDeInteresMensual;
    }

    public Double calcularInteres(Integer dias){
        return this.tasaDeInteresMensual * dias;
    }

    @Override
    public String toString() {
        return "CuentaDeAhorro{" +
                "tasaDeInteresMensual=" + tasaDeInteresMensual +
                '}';
    }
}
