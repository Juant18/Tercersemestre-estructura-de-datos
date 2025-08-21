public class Estudiante {

    //Atributos de la clase
    private int id;
    private String nombre;
    private String apellido;
    private String facultad;
    // Nuevo atributo para guardar los cursos
    private String[] cursosMatriculados;


    //Constructor de la clase
    public Estudiante(int id, String nombre, String apellido, String facultad){
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.facultad = facultad;
    }

    public int getId(){
        return id;
    }

    // El método ahora guarda los cursos en el atributo
    public void matricularCursos(String[] cursos){
        this.cursosMatriculados = cursos;
    }

    // Nuevo método para obtener los cursos
    public String[] getCursosMatriculados(){
        return cursosMatriculados;
    }

    public String getFacultad(){
        return facultad;
    }

    public String toString(){
        return "Estudiante { id: " + id + " Nombre: " + nombre + " Apellido: " + apellido + " Facultad: " + facultad + " }";
    }
}