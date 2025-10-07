import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;




// Clase principal GestorTareas
public class mini_proyecto_Pilas_Colas {
    private Deque<Tarea> cola = new ArrayDeque<>();  // Cola FIFO para prioridades baja y media
    private Deque<Tarea> pila = new ArrayDeque<>();  // Pila LIFO para prioridad alta
    private Map<String, String> registro = new HashMap<>();  // Mapa para trazabilidad de tareas completadas

    /**
     * Agrega una tarea al sistema según su prioridad.
     * Prioridad 3 (Alta): va a la pila.
     * Prioridad 1 o 2: va a la cola.
     */
    public void agregarTarea(Tarea tarea) {
        if (tarea.getPrioridad() == 3) {
            pila.push(tarea);
        } else {
            cola.offer(tarea);
        }
    }

    /**
     * Procesa la siguiente tarea según la prioridad.
     * 1. Si hay tareas en la pila (alta prioridad), extrae de allí (LIFO).
     * 2. Si no, extrae de la cola (FIFO).
     * Marca la tarea como completada, registra en el mapa y retorna la tarea.
     * Si no hay tareas, retorna null.
     */
    public Tarea procesarSiguienteTarea() {
        Tarea tarea = null;
        if (!pila.isEmpty()) {
            tarea = pila.pop();
        } else if (!cola.isEmpty()) {
            tarea = cola.poll();
        } else {
            return null;  // No hay tareas
        }

        // Marcar como completada
        tarea.setCompletada(true);
        long tiempoProcesamiento = System.currentTimeMillis();
        tarea.setTiempoProcesamiento(tiempoProcesamiento);

        // Registrar en el mapa de trazabilidad
        String infoTrazabilidad = "Completada - Llegada: " + tarea.getTiempoLlegada() +
                                  " - Procesada: " + tiempoProcesamiento;
        registro.put(tarea.getId(), infoTrazabilidad);

        return tarea;
    }

    /**
     * Consulta el estado de una tarea por ID.
     * - Si está en el registro: "Completada"
     * - Si está pendiente en cola o pila: "Pendiente"
     * - Si no se encuentra: "ID no encontrado"
     */
    public String consultarEstadoTarea(String idTarea) {
        if (registro.containsKey(idTarea)) {
            return "Completada";
        }

        // Verificar si está pendiente en pila o cola
        if (estaEnPila(idTarea) || estaEnCola(idTarea)) {
            return "Pendiente";
        }

        return "ID no encontrado";
    }

    // Método auxiliar para verificar si una tarea está en la pila por ID
    private boolean estaEnPila(String id) {
        for (Tarea t : pila) {
            if (t.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }

    // Método auxiliar para verificar si una tarea está en la cola por ID
    private boolean estaEnCola(String id) {
        for (Tarea t : cola) {
            if (t.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }

    // Métodos adicionales para inspección (opcionales, para testing)
    public int getTamanoCola() {
        return cola.size();
    }

    public int getTamanoPila() {
        return pila.size();
    }

    public int getTareasCompletadas() {
        return registro.size();
    }
}