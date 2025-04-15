package org.example;

import org.example.dto.cuenta.CajaDeAhorro;
import org.example.dto.cuenta.CuentaCorriente;
import org.example.service.LogicaCuenta;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args) {

        LogicaCuenta logicaCuenta = LogicaCuenta.getInstancia();

        for (int i = 0; i < 5; i++) {
            logicaCuenta.agregarCuenta(new CajaDeAhorro());
            logicaCuenta.agregarCuenta(new CuentaCorriente());
        }

        ExecutorService executor = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 10000; i++) {
            executor.submit(() -> {
                int cuentaId = ThreadLocalRandom.current().nextInt(0, 10);
                double monto = ThreadLocalRandom.current().nextDouble(1, 1000);

                if (ThreadLocalRandom.current().nextBoolean()) {
                    logicaCuenta.agregarSaldo(cuentaId, monto);
                } else {
                    logicaCuenta.quitarSaldo(cuentaId, monto);
                }
            });
        }

        executor.shutdown();

        while (!executor.isTerminated()) {

        }

        for (int i = 0; i < 10; i++) {
            double saldo = logicaCuenta.consultarSaldo(i);
            System.out.println("Cuenta ID: " + i + "Saldo: " + saldo);
        }
    }
}
