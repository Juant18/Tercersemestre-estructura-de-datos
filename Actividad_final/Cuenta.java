package Actividad_final;

public class Cuenta {
    //clase de la cuenta bancaria
    private int idCuenta;
    private String Nombreusuario;
    private double Dinero;

    public Cuenta(int idCuenta, String Nombreusuario, double saldoInicial) {
        this.idCuenta = idCuenta;
        this.Nombreusuario = Nombreusuario;
        this.Dinero = saldoInicial;
    }
//metodos
    public int getIdCuenta() {
        return idCuenta;
    }

    public String getNombreTitular() {
        return Nombreusuario;
    }

    public double getSaldo() {
        return Dinero;
    }
//creo como deposita la persona
    public void depositar(double monto) {
        if (monto > 0) {
            Dinero += monto;
        } else {
            throw new IllegalArgumentException("El monto del depósito debe ser positivo.");
        }
    }
//creo si la persona retira dinero

    public void retirar(double monto) {
        if (monto > 0 && monto <= Dinero) {
            Dinero -= monto;
        } else {
            throw new IllegalArgumentException("Monto inválido o saldo insuficiente.");
        }
    }
//creo si la persona necesita transferir el dinero
    public void transferir(Cuenta cuentaDestino, double monto) {
        if (monto > 0 && monto <= Dinero) {
            this.retirar(monto);
            cuentaDestino.depositar(monto);
        } else {
            throw new IllegalArgumentException("Monto inválido o saldo insuficiente para transferencia.");
        }
    }

    @Override
    public String toString() {
        return "Cuenta ID: " + idCuenta + ", Titular: " + Nombreusuario + ", Saldo: " + Dinero;
    }
}