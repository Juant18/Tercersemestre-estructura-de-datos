package Actividad_final;

// Clase que representa un Nodo en el Árbol de Búsqueda Binaria 
public class NodoCuenta {
    Cuenta cuenta;
    NodoCuenta izquierda;
    NodoCuenta derecha;

    public NodoCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
        this.izquierda = null;
        this.derecha = null;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }
}