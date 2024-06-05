package org.example;

public class CuentaDeCheque extends Cuenta{
    private Double costoManejoMesual;
    public CuentaDeCheque(Integer numero, Double saldo, Double costoManejoMesual) {

        super(numero, saldo);
        this.costoManejoMesual = costoManejoMesual;
    }

    @Override
    public String toString() {
        return "CuentaDeCheque{" +
                "costoManejoMesual=" + costoManejoMesual +
                '}';
    }
}
