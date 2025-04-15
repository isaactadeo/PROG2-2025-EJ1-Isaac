package org.example.dto.cuenta;

    public abstract class Cuenta {
        protected double saldo;
        protected int operaciones;

        public Cuenta() {
            this.saldo = 0.0;
            this.operaciones = 0;
        }

        protected synchronized void registrarOperacion() {
            operaciones++;
        }

    }
