package org.example.dto.builder;

import org.example.dto.cuenta.CajaDeAhorro;

public class CajaDeAhorroBuilder {

    private double saldoInicial = 0.0;

    public CajaDeAhorroBuilder conSaldoInicial(double saldo) {
        this.saldoInicial = saldo;
        return this;
    }

    public CajaDeAhorro build() {
        CajaDeAhorro cuenta = new CajaDeAhorro();
        cuenta.agregarSaldo(saldoInicial);
        return cuenta;
    }
}
