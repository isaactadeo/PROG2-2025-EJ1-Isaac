package org.example.dto.cuenta;

public interface IGestionSaldo {
    boolean agregarSaldo(double monto);
    boolean quitarSaldo(double monto);
    double getSaldo();
    int getOperaciones();
}
