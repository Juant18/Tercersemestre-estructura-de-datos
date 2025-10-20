   public Tarea eliminar() {
    Tarea eliminar = null;

    if (!pila.isEmpty()) {
        eliminar = pila.pop(); 
        
    
        
        System.out.println("Tarea deshecha de la PILA: " + eliminar.getId());
    } else {
        System.out.println("No hay tareas en la PILA para deshacer.");
    }

    return eliminar;
}