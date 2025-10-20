import java.util.Vector;
import java.util.Collections;

public class Implementarmetodos {
    public static void main(String[] args) {

        // 1. Creación de un Vector
        Vector<String> nombres = new Vector<>();
        System.out.println("Vector inicial (vacío): " + nombres);
        System.out.println("Tamaño inicial: " + nombres.size());
        System.out.println("Capacidad inicial (por defecto): " + nombres.capacity());

        // --- Adición de Elementos ---
        System.out.println("\n--- Suma de elementos ---");
        nombres.add("Ana");
        nombres.add("Luis");
        nombres.add("Marta");
        System.out.println("Vector después de 'add()': " + nombres);

        // Agregando otro vector
        Vector<String> otrosNombres = new Vector<>();
        otrosNombres.add("Pedro");
        otrosNombres.add("Sofía");
        nombres.addAll(otrosNombres);
        System.out.println("Vector después de 'addAll()': " + nombres);

        // Insertando en un índice específico
        nombres.insertElementAt("Carlos", 2);
        System.out.println("Vector después de 'insertElementAt()': " + nombres);

        // --- Modificación de Elementos ---
        System.out.println("\n--- Modificación de Elementos ---");
        nombres.set(1, "Daniela");
        System.out.println("Vector después de 'set()': " + nombres);
          //public Tarea eliminar() {
    //Tarea eliminar = null;

    //if (pila.isEmpty()) {
        eliminar = pila.pop(); 
        
    
        
      //  System.out.println("tarea eliminada " + eliminar.getId());
   // } else {
        System.out.println("No hay tareas para eliminar.");
    }

    return eliminar;
}
  Tarea eliminada1 = gestor.eliminar();  
         return eliminada1;

        // --- Acceso y Búsqueda ---
        System.out.println("\n--- Acceso y Búsqueda ---");
        System.out.println("Elemento en el índice 3: " + nombres.get(3));
        System.out.println("Primer elemento: " + nombres.firstElement());
        System.out.println("Último elemento: " + nombres.lastElement());
        System.out.println("¿Contiene 'Marta'? " + nombres.contains("Marta"));
        System.out.println("Índice de 'Pedro': " + nombres.indexOf("Pedro"));

        // --- Eliminación de Elementos ---
        System.out.println("\n--- Eliminación de Elementos ---");
        nombres.remove("Luis"); // Elimina la primera ocurrencia de "Luis"
        System.out.println("Vector después de 'remove(\"Luis\")': " + nombres);
        nombres.remove(0); // Elimina el elemento en el índice 0
        System.out.println("Vector después de 'remove(0)': " + nombres);
        
        // --- Ordenamiento ---
        System.out.println("\n--- Ordenamiento ---");
        Collections.sort(nombres); // Se usa Collections.sort para ordenar el Vector
        System.out.println("Vector ordenado: " + nombres);

        // --- Tamaño y Capacidad ---
        System.out.println("\n--- Tamaño y Capacidad ---");
        System.out.println("Tamaño actual del vector: " + nombres.size());
        System.out.println("Capacidad actual: " + nombres.capacity());
        nombres.trimToSize();
        System.out.println("Capacidad después de 'trimToSize()': " + nombres.capacity());

        // --- Limpieza del Vector ---
        System.out.println("\n--- Limpieza del Vector ---");
        nombres.clear();
        System.out.println("Vector después de 'clear()': " + nombres);
        System.out.println("Tamaño después de 'clear()': " + nombres.size());
        System.out.println("¿El vector está vacío? " + nombres.isEmpty());
    }
}