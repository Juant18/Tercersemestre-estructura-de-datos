package Actividad_final;
// Clase que representa una cuenta bancaria
// Clase que representa una cuenta bancaria
public class Cuenta {
    private int idCuenta;
    private String nombreTitular;
    private double saldo;

    public Cuenta(int idCuenta, String nombreTitular, double saldoInicial) {
        this.idCuenta = idCuenta;
        this.nombreTitular = nombreTitular;
        this.saldo = saldoInicial;
    }

    public int getIdCuenta() {
        return idCuenta;
    }

    public String getNombreTitular() {
        return nombreTitular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double monto) {
        if (monto > 0) {
            saldo += monto;
        } else {
            throw new IllegalArgumentException("El monto del depósito debe ser positivo.");
        }
    }

    public void retirar(double monto) {
        if (monto > 0 && monto <= saldo) {
            saldo -= monto;
        } else {
            throw new IllegalArgumentException("Monto inválido o saldo insuficiente.");
        }
    }

    public void transferir(Cuenta cuentaDestino, double monto) {
        if (monto > 0 && monto <= saldo) {
            this.retirar(monto);
            cuentaDestino.depositar(monto);
        } else {
            throw new IllegalArgumentException("Monto inválido o saldo insuficiente para transferencia.");
        }
    }

    @Override
    public String toString() {
        return "Cuenta ID: " + idCuenta + ", Titular: " + nombreTitular + ", Saldo: " + saldo;
    }
}