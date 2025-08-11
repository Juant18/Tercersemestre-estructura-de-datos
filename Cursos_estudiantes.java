import java.util.Arrays;

public class Cursos_estudiantes {
    public static void main(String[] args) {

        estudiante est1 = new estudiante(1234, "juan", "triviño", "ing");
        estudiante est2 = new estudiante(4321, "Stiven", "goku", "Sayayin");
        estudiante est3 = new estudiante(456, "Andres", "Escobar", "marihuano");

        System.out.println("Estudiante numero 1 " + est1);
         System.out.println("Estudiante numero 2 " + est2);
         System.out.println("Estudiante numero 3 "+ est3);


         System.out.println("-----------------------------------------------------------");
        estudiante[] est = new estudiante[5];
        est[0] = est1;
        est[1] = est2;
        est[2] = est3;

       

       //Forma 2

 est[3] = new estudiante(507080,"alex","andres","derecho");

 est[4] = new estudiante(203010,"vegetta777","veguetitta","youtuber");

System.out.println(Arrays.toString(est)); 

for (estudiante estudiante : est) {
    System.out.println(estudiante);
}

}

}
