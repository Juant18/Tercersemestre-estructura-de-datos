import java.util.Scanner;

class Paquete {
    String destinatario;
    String fechaIngreso;

    public Paquete(String destinatario, String fechaIngreso) {
        this.destinatario = destinatario;
        this.fechaIngreso = fechaIngreso;
    }
}

public class SistemaCasilleros {
    static Paquete[] casilleros = new Paquete[36];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- Menú Principal ---");
            System.out.println("1. Registrar paquete en casillero");
            System.out.println("2. Consultar casilleros disponibles");
            System.out.println("3. Información de paquete en casillero");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1:
                    registrarPaquete(sc);
                    break;
                case 2:
                    mostrarCasillerosDisponibles();
                    break;
                case 3:
                    mostrarInfoPaquete(sc);
                    break;
                case 4:
                    System.out.println("Cerrando aplicación...");
                    break;
                default:
                    System.out.println("Opción inválida, intente de nuevo.");
            }
        } while (opcion != 4);

        sc.close();
    }

    // Método para obtener el tamaño del casillero según su número
    public static String obtenerTamanioCasillero(int numero) {
        if (numero >= 1 && numero <= 8) {
            return "Mediano";
        } else if (numero >= 9 && numero <= 22) {
            return "Pequeño";
        } else if (numero >= 23 && numero <= 36) {
            return "Grande";
        } else {
            return "Desconocido";
        }
    }

    public static void registrarPaquete(Scanner sc) {
        // Mostrar casilleros disponibles con tamaño
        System.out.println("Casilleros disponibles:");
        boolean hayDisponibles = false;
        for (int i = 0; i < casilleros.length; i++) {
            if (casilleros[i] == null) {
                System.out.println("Casillero #" + (i + 1) + " - " + obtenerTamanioCasillero(i + 1));
                hayDisponibles = true;
            }
        }
        if (!hayDisponibles) {
            System.out.println("No hay casilleros disponibles.");
            return;
        }

        System.out.print("Ingrese número de casillero para asignar (1-36): ");
        int casilleroElegido = sc.nextInt();
        sc.nextLine(); // limpiar buffer

        if (casilleroElegido < 1 || casilleroElegido > 36) {
            System.out.println("Número de casillero inválido.");
            return;
        }

        if (casilleros[casilleroElegido - 1] != null) {
            System.out.println("El casillero #" + casilleroElegido + " ya está ocupado.");
            return;
        }

        System.out.print("Ingrese nombre del destinatario: ");
        String destinatario = sc.nextLine();
        System.out.print("Ingrese fecha de ingreso (dd/mm/aaaa): ");
        String fechaIngreso = sc.nextLine();

        casilleros[casilleroElegido - 1] = new Paquete(destinatario, fechaIngreso);
        System.out.println("Paquete registrado en casillero #" + casilleroElegido + " (" + obtenerTamanioCasillero(casilleroElegido) + ")");
    }

    public static void mostrarCasillerosDisponibles() {
        System.out.println("Casilleros disponibles:");
        boolean hayDisponibles = false;
        for (int i = 0; i < casilleros.length; i++) {
            if (casilleros[i] == null) {
                System.out.println("Casillero #" + (i + 1) + " - " + obtenerTamanioCasillero(i + 1));
                hayDisponibles = true;
            }
        }
        if (!hayDisponibles) {
            System.out.println("No hay casilleros disponibles.");
        }
    }

    public static void mostrarInfoPaquete(Scanner sc) {
        System.out.print("Ingrese número de casillero (1-36): ");
        int num = sc.nextInt();
        sc.nextLine(); // limpiar buffer

        if (num < 1 || num > 36) {
            System.out.println("Número de casillero inválido.");
            return;
        }

        Paquete p = casilleros[num - 1];
        if (p == null) {
            System.out.println("El casillero #" + num + " está vacío.");
        } else {
            System.out.println("Información del paquete en casillero #" + num + " (" + obtenerTamanioCasillero(num) + "):");
            System.out.println("Destinatario: " + p.destinatario);
            System.out.println("Fecha de ingreso: " + p.fechaIngreso);
        }
    }
}