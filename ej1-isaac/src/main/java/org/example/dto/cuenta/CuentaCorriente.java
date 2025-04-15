package org.example.dto.cuenta;

public class CuentaCorriente extends Cuenta implements IGestionSaldo {
    public double giroDescubierto;

    public CuentaCorriente() {
        super();
    }
    public CuentaCorriente(double giroDescubierto) {
        super();
        this.giroDescubierto = giroDescubierto;
    }

    @Override
    public synchronized boolean agregarSaldo(double monto) {
        if (monto <= 0) return false;
        saldo += monto;
        registrarOperacion();
        return true;
    }

    @Override
    public synchronized boolean quitarSaldo(double monto) {
        if (monto <= 0) return false;
        if ((saldo - monto) >= -giroDescubierto) {
            saldo -= monto;
            registrarOperacion();
            return true;
        }
        return false;
    }

    @Override
    public synchronized double getSaldo() {
        return saldo;
    }

    @Override
    public synchronized int getOperaciones() {
        return operaciones;
    }
}
