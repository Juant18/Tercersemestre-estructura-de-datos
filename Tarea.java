
// Clase Tarea
class Tarea {
    private String id;
    private String descripcion;
    private int prioridad;
    private long tiempoLlegada;
    private boolean completada = false;
    private long tiempoProcesamiento = -1L;

    public Tarea(String id, String descripcion, int prioridad, long tiempoLlegada) {
        this.id = id;
        this.descripcion = descripcion;
        this.prioridad = prioridad;
        this.tiempoLlegada = tiempoLlegada;
    }

    // Getters
    public String getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public long getTiempoLlegada() {
        return tiempoLlegada;
    }

    public boolean isCompletada() {
        return completada;
    }

    public long getTiempoProcesamiento() {
        return tiempoProcesamiento;
    }

    // Setters para marcar como completada
    public void setCompletada(boolean completada) {
        this.completada = completada;
    }

    public void setTiempoProcesamiento(long tiempoProcesamiento) {
        this.tiempoProcesamiento = tiempoProcesamiento;
    }

    @Override
    public String toString() {
        return "Tarea{id='" + id + "', descripcion='" + descripcion + "', prioridad=" + prioridad +
               ", tiempoLlegada=" + tiempoLlegada + ", completada=" + completada +
               ", tiempoProcesamiento=" + tiempoProcesamiento + "}";
    }
}
