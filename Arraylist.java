import java.util.ArrayList;
import java.util.Scanner;

public class GestionEstudiantes {
    public static void main(String[] args) {
        // Crear un ArrayList para almacenar los nombres de los estudiantes
        ArrayList<String> estudiantes = new ArrayList<String>();
        Scanner scanner = new Scanner(System.in);

        // Menú para interactuar con el usuario
        while (true) {
            System.out.println("\nMenú:");
            System.out.println("1. Agregar estudiante");
            System.out.println("2. Eliminar estudiante");
            System.out.println("3. Mostrar estudiantes");
            System.out.println("4. Salir");
            System.out.print("Selecciona una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();  // Limpiar el buffer

            switch (opcion) {
                case 1:
                    // Agregar estudiante
                    System.out.print("Ingresa el nombre del estudiante: ");
                    String nombre = scanner.nextLine();
                    estudiantes.add(nombre);
                    System.out.println("Estudiante agregado.");
                    break;

                case 2:
                    // Eliminar estudiante
                    System.out.print("Ingresa el nombre del estudiante a eliminar: ");
                    String estudianteEliminar = scanner.nextLine();
                    if (estudiantes.remove(estudianteEliminar)) {
                        System.out.println("Estudiante eliminado.");
                    } else {
                        System.out.println("No se encontró al estudiante.");
                    }
                    break;

                case 3:
                    // Mostrar estudiantes
                    if (estudiantes.isEmpty()) {
                        System.out.println("No hay estudiantes en la lista.");
                    } else {
                        System.out.println("Lista de estudiantes:");
                        for (String estudiante : estudiantes) {
                            System.out.println(estudiante);
                        }
                    }
                    break;

                case 4:
                    // Salir
                    System.out.println("Saliendo del programa.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opción no válida, por favor intenta de nuevo.");
            }
        }
    }
}
