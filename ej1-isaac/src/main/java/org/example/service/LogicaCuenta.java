package org.example.service;

import org.example.dto.cuenta.Cuenta;
import org.example.dto.cuenta.IGestionSaldo;

import java.util.ArrayList;
import java.util.List;

public class LogicaCuenta {

    private static LogicaCuenta instancia;
    private static final Object lock = new Object();

    private final List<Cuenta> cuentas;

    private LogicaCuenta() {
        this.cuentas = new ArrayList<>();
    }

    public static LogicaCuenta getInstancia() {
        if (instancia == null) {
            synchronized (lock) {
                if (instancia == null) {
                    instancia = new LogicaCuenta();
                }
            }
        }
        return instancia;
    }

    public int agregarCuenta(Cuenta cuenta) {
        synchronized (cuentas) {
            cuentas.add(cuenta);
            return cuentas.size() - 1;
        }
    }

    public boolean agregarSaldo(int cuentaId, double monto) {
        Cuenta cuenta = obtenerCuenta(cuentaId);
        if (cuenta instanceof IGestionSaldo) {
            return ((IGestionSaldo) cuenta).agregarSaldo(monto);
        }
        return false;
    }

    public boolean quitarSaldo(int cuentaId, double monto) {
        Cuenta cuenta = obtenerCuenta(cuentaId);
        if (cuenta instanceof IGestionSaldo) {
            return ((IGestionSaldo) cuenta).quitarSaldo(monto);
        }
        return false;
    }

    public double consultarSaldo(int cuentaId) {
        Cuenta cuenta = obtenerCuenta(cuentaId);
        if (cuenta instanceof IGestionSaldo) {
            return ((IGestionSaldo) cuenta).getSaldo();
        }
        return -1;
    }

    private Cuenta obtenerCuenta(int cuentaId) {
        synchronized (cuentas) {
            if (cuentaId >= 0 && cuentaId < cuentas.size()) {
                return cuentas.get(cuentaId);
            }
            return null;
        }
    }
}
