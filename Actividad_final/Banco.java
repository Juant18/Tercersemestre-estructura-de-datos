package Actividad_final;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

// Creacion de clase que tiene el crear cuenta,actualizar etc..
public class Banco {
    private ArrayList<Cuenta> cuentas; // Lista para almacenar cuentas 
    private Queue<Transaccion> colaTransacciones; // Cola para procesar transacciones pendientes 

    public Banco() {
        cuentas = new ArrayList<>();
        colaTransacciones = new LinkedList<>();
    }

    // Crear cuenta
    public void crearCuenta(int idCuenta, String nombre, double saldoInicial) {
        if (buscarCuenta(idCuenta) == null) {
            cuentas.add(new Cuenta(idCuenta, nombre, saldoInicial));
        } else {
            throw new IllegalArgumentException("La cuenta ya existe.");
        }
    }

    // Actualizar cuenta 
    public void actualizarCuenta(int idCuenta, String nuevoNombre) {
        Cuenta cuenta = buscarCuenta(idCuenta);
        if (cuenta != null) {
            cuentas.remove(cuenta);
            cuentas.add(new Cuenta(idCuenta, nuevoNombre, cuenta.getSaldo()));
        } else {
            throw new IllegalArgumentException("Cuenta no encontrada.");
        }
    }

    // Eliminar cuenta
    public void eliminarCuenta(int idCuenta) {
        Cuenta cuenta = buscarCuenta(idCuenta);
        if (cuenta != null && cuenta.getSaldo() == 0) {
            cuentas.remove(cuenta);
        } else {
            throw new IllegalArgumentException("Cuenta no encontrada o tiene saldo.");
        }
    }

    // Buscar cuenta 
    public Cuenta buscarCuenta(int idCuenta) {
        for (Cuenta cuenta : cuentas) {
            if (cuenta.getIdCuenta() == idCuenta) {
                return cuenta;
            }
        }
        return null;
    }

    // Consulta de saldo
    public double obtenerSaldo(int idCuenta) {
        Cuenta cuenta = buscarCuenta(idCuenta);
        if (cuenta != null) {
            return cuenta.getSaldo();
        }
        throw new IllegalArgumentException("Cuenta no encontrada.");
    }

    // Agregar transacción a la cola
    public void agregarTransaccion(Transaccion transaccion) {
        if ("retiro".equals(transaccion.getTipo()) || "transferencia".equals(transaccion.getTipo())) {
            Cuenta cuentaOrigen = buscarCuenta(transaccion.getIdCuentaOrigen());
            if (cuentaOrigen == null) {
                throw new IllegalArgumentException("Cuenta origen no encontrada.");
            }
            if (cuentaOrigen.getSaldo() < transaccion.getMonto()) {
                throw new IllegalArgumentException("Saldo insuficiente en la cuenta origen para realizar la operación.");
            }
        }
        colaTransacciones.add(transaccion);
    }

    // Procesar transacciones en la cola
    public void procesarTransacciones() {
        while (!colaTransacciones.isEmpty()) {
            Transaccion transaccion = colaTransacciones.poll();
            try {
                if ("deposito".equals(transaccion.getTipo())) {
                    Cuenta cuenta = buscarCuenta(transaccion.getIdCuentaOrigen());
                    if (cuenta != null) {
                        cuenta.depositar(transaccion.getMonto());
                    }
                } else if ("retiro".equals(transaccion.getTipo())) {
                    Cuenta cuenta = buscarCuenta(transaccion.getIdCuentaOrigen());
                    if (cuenta != null) {
                        cuenta.retirar(transaccion.getMonto());
                    }
                } else if ("transferencia".equals(transaccion.getTipo())) {
                    Cuenta cuentaOrigen = buscarCuenta(transaccion.getIdCuentaOrigen());
                    Cuenta cuentaDestino = buscarCuenta(transaccion.getIdCuentaDestino());
                    if (cuentaOrigen != null && cuentaDestino != null) {
                        cuentaOrigen.transferir(cuentaDestino, transaccion.getMonto());
                    }
                }
            } catch (Exception e) {
                System.out.println("Error procesando transacción: " + e.getMessage());
            }
        }
    }

    // Ordenar cuentas por saldo 
    public void ordenarCuentasPorSaldo() {
        quickSort(cuentas, 0, cuentas.size() - 1, Comparator.comparingDouble(Cuenta::getSaldo));
    }

    private void quickSort(ArrayList<Cuenta> lista, int bajo, int alto, Comparator<Cuenta> comparador) {
        if (bajo < alto) {
            int pi = particion(lista, bajo, alto, comparador);
            quickSort(lista, bajo, pi - 1, comparador);
            quickSort(lista, pi + 1, alto, comparador);
        }
    }

    private int particion(ArrayList<Cuenta> lista, int bajo, int alto, Comparator<Cuenta> comparador) {
        Cuenta pivote = lista.get(alto);
        int i = (bajo - 1);
        for (int j = bajo; j < alto; j++) {
            if (comparador.compare(lista.get(j), pivote) <= 0) {
                i++;
                Collections.swap(lista, i, j);
            }
        }
        Collections.swap(lista, i + 1, alto);
        return i + 1;
    }

    // Mostrar todas las cuentas 
    public void mostrarCuentas() {
        for (Cuenta cuenta : cuentas) {
            System.out.println(cuenta);
        }
    }
}