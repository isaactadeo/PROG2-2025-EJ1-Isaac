package org.example.dto.builder;

import org.example.dto.cuenta.CuentaCorriente;

public class CuentaCorrienteBuilder {

    private double saldoInicial = 0.0;
    private double giroDescubierto = 0.0;

    public CuentaCorrienteBuilder conSaldoInicial(double saldo) {
        this.saldoInicial = saldo;
        return this;
    }

    public CuentaCorrienteBuilder conGiroDescubierto(double giro) {
        this.giroDescubierto = giro;
        return this;
    }

    public CuentaCorriente build() {
        CuentaCorriente cuenta = new CuentaCorriente(giroDescubierto);
        cuenta.agregarSaldo(saldoInicial);
        return cuenta;
    }
}

