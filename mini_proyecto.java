import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

// Clase principal GestorTareas
public class mini_proyecto {
    private Deque<Tarea> cola = new ArrayDeque<>();
    private Deque<Tarea> pila = new ArrayDeque<>();
    private Map<String, String> registro = new HashMap<>();


    public void agregarTarea(Tarea tarea) {
        if (tarea.getPrioridad() == 3) {
            pila.push(tarea);
        } else {
            cola.offer(tarea);
        }
        System.out.println("Tarea agregada: " + tarea.getId() + " (Prioridad: " + tarea.getPrioridad() + ")");
    }

//System.out.println(" " + dos.getId());
    public Tarea procesarSiguienteTarea() {
        Tarea tarea = null;
        if (!pila.isEmpty()) {
            tarea = pila.pop();
            System.out.println("Procesando tarea de alta prioridad (Pila): " + tarea.getId());
        } else if (!cola.isEmpty()) {
            tarea = cola.poll();
            System.out.println("Procesando tarea normal (Cola): " + tarea.getId());
        } else {
            System.out.println("No hay tareas para procesar.");
            return null;
        }
////Tarea dos = null;

    //if (pila.isEmpty()) {
       // dos = pila.pop();
        tarea.setCompletada(true);
        long tiempoProcesamiento = System.currentTimeMillis();
        tarea.setTiempoProcesamiento(tiempoProcesamiento);

        String infoTrazabilidad = "Completada - Llegada: " + tarea.getTiempoLlegada() +
                "  Procesada: " + tiempoProcesamiento;
        registro.put(tarea.getId(), infoTrazabilidad);

        System.out.println("Tarea procesada: " + tarea.toString());
        System.out.println("Registro de trazabilidad para " + tarea.getId() + ": " + infoTrazabilidad);
        System.out.println("---");

        return tarea;
    }
  

    public String consultarEstadoTarea(String idTarea) {
        if (registro.containsKey(idTarea)) {
            return "Completada";
        }

        if (estaEnPila(idTarea) || estaEnCola(idTarea)) {
            return "Pendiente";
        }

        return "ID no encontrado";
    }
// public tarea dos(){}
    private boolean estaEnPila(String id) {
        for (Tarea t : pila) {
            if (t.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }

    private boolean estaEnCola(String id) {
        for (Tarea t : cola) {
            if (t.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }

    public int getTamañoCola() {
        return cola.size();
    }

    public int getTamañoPila() {
        return pila.size();
    }
    public int getTareasCompletadas() {
        return registro.size();
    }


   
  
 
    public void mostrarEstadoSistema() {
        System.out.println("=== Estado del Sistema ===");
        System.out.println("Tareas en Cola (Prioridad Baja/Media): " + getTamañoCola());
        System.out.println("Tareas en Pila (Prioridad Alta): " + getTamañoPila());
        System.out.println("Tareas Completadas: " + getTareasCompletadas());
        System.out.println("Tareas Pendientes en Cola: ");
        for (Tarea t : cola) {
            System.out.println("  - " + t.getId() + " (" + t.getDescripcion() + ")");
        }
        System.out.println("Tareas Pendientes en Pila: ");
        for (Tarea t : pila) {
            System.out.println("  - " + t.getId() + " (" + t.getDescripcion() + ")");
        }
        System.out.println("========================");
    }

    public static void main(String[] args) {
        mini_proyecto gestor = new mini_proyecto();

        // Crear y agregar tareas de ejemplo
        long tiempoActual = System.currentTimeMillis();

        Tarea tarea1 = new Tarea("T1", "Reporte bajo", 1, tiempoActual); // Baja
        Tarea tarea2 = new Tarea("T2", "Actualización media", 2, tiempoActual + 1000); // Media
        Tarea tarea3 = new Tarea("T3", "Notificación alta", 3, tiempoActual + 2000); // Alta
        Tarea tarea4 = new Tarea("T4", "Tarea urgente", 3, tiempoActual + 3000); // Alta
        Tarea tarea5 = new Tarea("T5", "Tarea normal", 1, tiempoActual + 4000); // Baja

        System.out.println("=== Agregando Tareas ===");
        gestor.agregarTarea(tarea1);
        gestor.agregarTarea(tarea2);
        gestor.agregarTarea(tarea3);
        gestor.agregarTarea(tarea4);
        gestor.agregarTarea(tarea5);
        gestor.mostrarEstadoSistema();
 //return dos;

        System.out.println("\n=== Procesando Tareas ===");
        Tarea procesada1 = gestor.procesarSiguienteTarea(); // Debe procesar T4 (última alta)
        Tarea procesada2 = gestor.procesarSiguienteTarea(); // Debe procesar T3 (alta restante)
        Tarea procesada3 = gestor.procesarSiguienteTarea(); // Debe procesar T1 (primera en cola)
        gestor.mostrarEstadoSistema();

        System.out.println("\n=== Consultando Estados ===");
        System.out.println("Estado de T1: " + gestor.consultarEstadoTarea("T1")); // Completada
        System.out.println("Estado de T2: " + gestor.consultarEstadoTarea("T2")); // Pendiente
        System.out.println("Estado de T3: " + gestor.consultarEstadoTarea("T3")); // Completada
        System.out.println("Estado de T6: " + gestor.consultarEstadoTarea("T6")); // No encontrado
//Tarea 1 = gestor.eliminar();  
        // return 1;
        System.out.println("\n=== Procesando Tareas Restantes ===");
        Tarea procesada4 = gestor.procesarSiguienteTarea(); // T2
        Tarea procesada5 = gestor.procesarSiguienteTarea(); // T5
        gestor.mostrarEstadoSistema();

        System.out.println("\n=== Consultando Estados Finales ===");
        System.out.println("Estado de T2: " + gestor.consultarEstadoTarea("T2")); // Completada
        System.out.println("Estado de T5: " + gestor.consultarEstadoTarea("T5")); // Completada
        System.out.println("Estado de T4: " + gestor.consultarEstadoTarea("T4")); // Completada

        System.out.println("\n=== Intentando Procesar Sin Tareas ===");
        Tarea procesada6 = gestor.procesarSiguienteTarea(); // null

          
      
    }

 
}
