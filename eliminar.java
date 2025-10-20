
public boolean eliminarTarea(String idTarea) {
 
    if (estaEnPila(idTarea)) {
   
        boolean removidaDePila = pila.removeIf(t -> t.getId().equals(idTarea));
        
        if (removidaDePila) {
            System.out.println(" Tarea eliminada de la Pila (Alta Prioridad): " + idTarea);
            return true;
        }
    }

    if (estaEnCola(idTarea)) {
     
        boolean removidaDeCola = cola.removeIf(t -> t.getId().equals(idTarea));
        
        if (removidaDeCola) {
            System.out.println(" Tarea eliminada de la Cola (Prioridad Normal): " + idTarea);
            return true;
        }
    }
    


}