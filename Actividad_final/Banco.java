package Actividad_final;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

// Creacion de clase que tiene el crear cuenta, actualizar etc.
public class Banco {
    private ArrayList<Cuenta> cuentas; // Lista para QuickSort y Mostrar
    private Queue<Transaccion> colaTransacciones; // Cola para procesar transacciones pendientes 
    private NodoCuenta raizBST; // NUEVO: Raíz del Árbol de Búsqueda Binaria

    public Banco() {
        cuentas = new ArrayList<>();
        colaTransacciones = new LinkedList<>();
        raizBST = null; // Inicializa el BST vacío
    }

    // **********************************************
    // *** IMPLEMENTACIÓN DE ÁRBOL DE BÚSQUEDA BINARIA (BST) ***
    // **********************************************

    // Método principal para insertar una cuenta en el BST
    private void insertarEnBST(Cuenta nuevaCuenta) {
        raizBST = insertarRec(raizBST, nuevaCuenta);
    }

    // Método recursivo para insertar en el BST
    private NodoCuenta insertarRec(NodoCuenta raiz, Cuenta nuevaCuenta) {
        if (raiz == null) {
            return new NodoCuenta(nuevaCuenta);
        }
        // Las cuentas se ordenan por su ID (criterio de búsqueda)
        if (nuevaCuenta.getIdCuenta() < raiz.cuenta.getIdCuenta()) {
            raiz.izquierda = insertarRec(raiz.izquierda, nuevaCuenta);
        } else if (nuevaCuenta.getIdCuenta() > raiz.cuenta.getIdCuenta()) {
            raiz.derecha = insertarRec(raiz.derecha, nuevaCuenta);
        }
        return raiz;
    }

    // **********************************************
    // *** IMPLEMENTACIÓN DE BÚSQUEDA BINARIA (BST) ***
    // **********************************************
    
    // REEMPLAZO COMPLETO: Ahora utiliza la Búsqueda Binaria sobre el BST
    // Buscar cuenta (Implementación con Búsqueda Binaria BST)
    public Cuenta buscarCuenta(int idCuenta) {
        return busquedaBinariaRec(raizBST, idCuenta);
    }

    // Método auxiliar recursivo para la Búsqueda Binaria
    private Cuenta busquedaBinariaRec(NodoCuenta raiz, int idCuenta) {
        if (raiz == null) {
            return null; // Cuenta no encontrada
        }
        
        // El ID es el mismo, se encontró la cuenta
        if (idCuenta == raiz.cuenta.getIdCuenta()) {
            return raiz.cuenta;
        } 
        
        // Si el ID es menor, buscamos en el subárbol izquierdo
        else if (idCuenta < raiz.cuenta.getIdCuenta()) {
            return busquedaBinariaRec(raiz.izquierda, idCuenta);
        } 
        
        // Si el ID es mayor, buscamos en el subárbol derecho
        else {
            return busquedaBinariaRec(raiz.derecha, idCuenta);
        }
    }
    
    // ********************************************
    // *** MÉTODOS NUCLEARES  ****
    // ********************************************

    public void crearCuenta(int idCuenta, String nombre, double saldoInicial) {
        if (buscarCuenta(idCuenta) == null) { // buscarCuenta ya usa el BST
            Cuenta nuevaCuenta = new Cuenta(idCuenta, nombre, saldoInicial);
            cuentas.add(nuevaCuenta); // Se mantiene la lista para QuickSort
            insertarEnBST(nuevaCuenta); // Se inserta en el Árbol
        } else {
            throw new IllegalArgumentException("La cuenta ya existe.");
        }
    }

    // Actualizar cuenta 
    public void actualizarCuenta(int idCuenta, String nuevoNombre) {
     
        Cuenta cuenta = buscarCuenta(idCuenta); 
        if (cuenta != null) {
      
            cuentas.removeIf(c -> c.getIdCuenta() == idCuenta);
            cuentas.add(new Cuenta(idCuenta, nuevoNombre, cuenta.getSaldo())); 
            
            // Actualización directa al objeto en el BST (asumiendo objeto mutable)
            cuenta.Nombreusuario = nuevoNombre; 
            
        } else {
            throw new IllegalArgumentException("Cuenta no encontrada.");
        }
    }

    // Eliminar cuenta (Solo eliminamos de la lista 'cuentas' por simplicidad,
    // La eliminación de un nodo de un BST es más compleja y se omite para enfocarse en la inserción/búsqueda).
    public void eliminarCuenta(int idCuenta) {
        Cuenta cuenta = buscarCuenta(idCuenta);
        if (cuenta != null && cuenta.getSaldo() == 0) {
            // Solo se elimina del ArrayList usado para informes. 
            // La eliminación eficiente del BST requiere un algoritmo de eliminación de nodos.
            cuentas.removeIf(c -> c.getIdCuenta() == idCuenta);
            
            // Idealmente, se llamaría a eliminarNodoBST(idCuenta)
            
        } else {
            throw new IllegalArgumentException("Cuenta no encontrada o tiene saldo.");
        }
    }
    
    // Consulta de saldo
    public double obtenerSaldo(int idCuenta) {
        // Usa el método buscarCuenta con Búsqueda Binaria
        Cuenta cuenta = buscarCuenta(idCuenta);
        if (cuenta != null) {
            return cuenta.getSaldo();
        }
        throw new IllegalArgumentException("Cuenta no encontrada.");
    }

    // Agregar transacción a la cola
    public void agregarTransaccion(Transaccion transaccion) {
        if ("retiro".equals(transaccion.getTipo()) || "transferencia".equals(transaccion.getTipo())) {
            // Usa el método buscarCuenta con Búsqueda Binaria
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
                    // Usa el método buscarCuenta con Búsqueda Binaria
                    Cuenta cuenta = buscarCuenta(transaccion.getIdCuentaOrigen());
                    if (cuenta != null) {
                        cuenta.depositar(transaccion.getMonto());
                    }
                } else if ("retiro".equals(transaccion.getTipo())) {
                    // Usa el método buscarCuenta con Búsqueda Binaria
                    Cuenta cuenta = buscarCuenta(transaccion.getIdCuentaOrigen());
                    if (cuenta != null) {
                        cuenta.retirar(transaccion.getMonto());
                    }
                } else if ("transferencia".equals(transaccion.getTipo())) {
                    // Usa el método buscarCuenta con Búsqueda Binaria
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

    // Ordenar cuentas por saldo (USA QUICK SORT)
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