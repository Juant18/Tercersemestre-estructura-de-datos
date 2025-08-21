import java.util.Arrays;

public class EjecutarEstudiante {
    
    public static void main(String[] args){

        // Forma 1
        // Creación de los objetos
        Estudiante objEst1 = new Estudiante(909876, "juan", "Triviño", "Ingeniería");
        Estudiante objEst2 = new Estudiante(456098, "Andres", "Cano", "Ingeniería");
        Estudiante objEst3 = new Estudiante(235621, "Mercedes", "Flores", "Ingeniería");

        System.out.println(objEst1);
        System.out.println(objEst2);
        System.out.println(objEst3);

        System.out.println("--------------------------");
        // Crear arreglo de objetos
        Estudiante[] est = new Estudiante[5];
        
        est[0] = objEst1;
        est[1] = objEst2;
        est[2] = objEst3;

        // Forma 2
        est[3] = new Estudiante(506070, "Byron", "Beltran", "Psicología");
        est[4] = new Estudiante(304050, "Antonio", "Buitrago", "Derecho");

        System.out.println(Arrays.toString(est));

        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXx");

        for(Estudiante e: est){
            System.out.println(e);
        }

        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXx");

        for(int i = 0; i < est.length; i++){
            System.out.println(est[i]);
        }

        System.out.println(" Cursos matriculados ---");
    
        contarEstudiantesPorFacultad(est);

        est[0].matricularCursos(new String[]{"Matemáticas", "Programación"});
        est[1].matricularCursos(new String[]{"Matemáticas", "Física"});
        est[2].matricularCursos(new String[]{"Programación", "Química"});
        contarEstudiantesPorCurso(est);
    }
    

    public static void contarEstudiantesPorFacultad(Estudiante[] estudiantes) {
        String[] facultades = {"Ingeniería", "Psicología", "Derecho"};
        int[] contadores = new int[facultades.length];

        for (int i = 0; i < estudiantes.length; i++) {
            if (estudiantes[i] != null) {
                String facultadEstudiante = estudiantes[i].getFacultad();
                
                for (int j = 0; j < facultades.length; j++) {
                    if (facultadEstudiante.equals(facultades[j])) {
                        contadores[j]++;
                        break;
                    }
                }
            }
        }

        System.out.println("--- Conteo de Estudiantes por Facultad ---");
        for (int i = 0; i < facultades.length; i++) {
            System.out.println("Facultad: " + facultades[i] + " -> Estudiantes: " + contadores[i]);
        }
    }


    public static void contarEstudiantesPorCurso(Estudiante[] estudiantes) {
        String[] cursos = {"Matemáticas", "Programación", "Física", "Química"};
        int[] contadores = new int[cursos.length];

        for (int i = 0; i < estudiantes.length; i++) {
            if (estudiantes[i] != null && estudiantes[i].getCursosMatriculados() != null) {
                String[] cursosDelEstudiante = estudiantes[i].getCursosMatriculados();
                for (int j = 0; j < cursosDelEstudiante.length; j++) {
                    for (int k = 0; k < cursos.length; k++) {
                        if (cursosDelEstudiante[j].equals(cursos[k])) {
                            contadores[k]++;
                            break;
                        }
                    }
                }
            }
        }

        System.out.println("--- Conteo de Estudiantes por Curso ---");
        for (int i = 0; i < cursos.length; i++) {
            System.out.println("Curso: " + cursos[i] + " -> Estudiantes: " + contadores[i]);
        }
    }
}