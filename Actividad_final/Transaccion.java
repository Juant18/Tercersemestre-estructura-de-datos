package Actividad_final;

// Clase que representa una transacción bancaria
public class Transaccion {
    private String tipo; // "deposito", "retiro", "transferencia"
    private int idCuentaOrigen;
    private int idCuentaDestino; // Solo para transferencias
    private double monto;

    public Transaccion(String tipo, int idCuentaOrigen, double monto) {
        this.tipo = tipo;
        this.idCuentaOrigen = idCuentaOrigen;
        this.monto = monto;
        this.idCuentaDestino = -1; // Se usa para transacciones que no requieren una cuenta destino
    }

    public Transaccion(String tipo, int idCuentaOrigen, int idCuentaDestino, double monto) {
        this.tipo = tipo;
        this.idCuentaOrigen = idCuentaOrigen;
        this.idCuentaDestino = idCuentaDestino;//Se usa para transacciones que sí requieren una cuenta destino
        this.monto = monto;
    }

    public String getTipo() {
        return tipo;
    }

    public int getIdCuentaOrigen() {
        return idCuentaOrigen;
    }

    public int getIdCuentaDestino() {
        return idCuentaDestino;
    }

    public double getMonto() {
        return monto;
    }

    @Override
    public String toString() {
        if ("transferencia".equals(tipo)) {
            return "Transferencia de " + idCuentaOrigen + " a " + idCuentaDestino + " por $" + monto;
        } else {
            return tipo + " en cuenta " + idCuentaOrigen + " por $" + monto;
        }
    }
}