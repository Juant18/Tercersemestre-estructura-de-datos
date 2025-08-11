public class estudiante {

    private int id;
    private String nombre;
    private String apellido;
    private String facultad;

    public estudiante(int id, String nombre,  String apellido, String facultad) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.facultad = facultad;

    }
    public int getId() {
        return id;
    }

public void matricularcursos( int id ,String[] cursos){
String cad ="";

for(int i = 0;  i < cursos.length;i++){
 cad+=cursos[i] + "";

    }
 System.out.println("Estudiante {id:" + id + ", Cursos Matriculados:"+cad ); 

 
}
public String toString(){
    return "Cursos {id:" + id + " Nombre : " + nombre + " Apellido :" + apellido + " Facultad :" + facultad + "}";
}
}
