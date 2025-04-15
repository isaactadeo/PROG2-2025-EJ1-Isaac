package org.example.dto.cuenta;

public class CajaDeAhorro extends Cuenta implements IGestionSaldo {

    public CajaDeAhorro() {
        super();
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
        saldo -= monto;
        registrarOperacion();
        return true;
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
