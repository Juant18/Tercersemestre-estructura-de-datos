import java.util.Scanner;

public class CasillerosAmazon {
    static Paquete[] casilleros = new Paquete[36];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opciones;

        do {
            System.out.println("\n--- Menú ---");
            System.out.println("1. Registro de paquete");
            System.out.println("2. Consulta de casilleros disponibles");
            System.out.println("3. Información de paquete en los casilleros");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            opciones = sc.nextInt();
            sc.nextLine(); 

            switch (opciones) {
                case 1:
                    Paqueteregistro(sc);
                    break;
                case 2:
                    Casillerosdisponibles();
                    break;
                case 3:
                    Informacionpaquete(sc);
                    break;
                case 4:
                    System.out.println("Proceso de cerrar App...");
                    break;
                default:
                    System.out.println("Opción inválida, intente de nuevo.");
            }
        } while (opcion != 4);

        sc.close();
    }

    // Método para obtener el tamaño del casillero según su número
    public static String obtenerTamañoCasillero(int numero) {
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

    public static void Paqueteregistro(Scanner sc) {
        // Mostrar casilleros disponibles con tamaño
        System.out.println("Casilleros disponibles:");
        boolean Losdisponibles = false;
        for (int i = 0; i < casilleros.length; i++) {
            if (casilleros[i] == null) {
                System.out.println("Casillero #" + (i + 1) + " - " + obtenerTamañoCasillero(i + 1));
                Losdisponibles = true;
            }
        }
        if (Losdisponibles) {
            System.out.println("No hay casilleros disponibles.");
            return;
        }

        System.out.print("Ingrese número de casillero para ser asginado (1-36): ");
        int casilleroElegido = sc.nextInt();
        sc.nextLine(); 

        if (casilleroElegido < 1 || casilleroElegido > 36) {
            System.out.println("Número de casillero inválido.");
            return;
        }

        if (casilleros[casilleroElegido - 1] != null) {
            System.out.println("El casillero #" + casilleroElegido + " ya está ocupado.");
            return;
        }

        System.out.print("Ingrese nombre del receptor ");
        String destinatario = sc.nextLine();
        System.out.print("Ingrese fecha de ingreso (dd/mm/aaaa): ");
        String fechaIngreso = sc.nextLine();

        casilleros[casilleroElegido - 1] = new Paquete(destinatario, fechaIngreso);
        System.out.println("Paquete registrado en casillero #" + casilleroElegido + " (" + obtenerTamañoCasillero(casilleroElegido) + ")");
    }

    public static void Casillerosdisponibles() {
        System.out.println("Casilleros disponibles:");
        boolean hayDisponibles = false;
        for (int i = 0; i < casilleros.length; i++) {
            if (casilleros[i] == null) {
                System.out.println("Casillero #" + (i + 1) + " - " + obtenerTamañoCasillero(i + 1));
                hayDisponibles = true;
            }
        }
        if (!hayDisponibles) {
            System.out.println("No hay casilleros disponibles.");
        }
    }

    public static void Informacionpaquete(Scanner sc) {
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
            System.out.println("Información del paquete en casillero #" + num + " (" + obtenerTamañoCasillero(num) + "):");
            System.out.println("Destinatario: " + p.receptor);
            System.out.println("Fecha de ingreso: " + p.Fechadeentrada);
        }
    }
}