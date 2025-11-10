import java.util.Scanner;

public class Menu_banco {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opciones;

        do {
            System.out.println("\n--- Menú ---");
            System.out.println("1.Cuenta usuario ");
            System.out.println("2.retiros de capital ");
            System.out.println("3.Abono de capital ");
            System.out.println("4 crear, actualizar, Eliminar cuenta ");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opciones = sc.nextInt();
            sc.nextLine();

            switch (opciones) {
                case 1:
                    Usuario(sc);
                    break;
                case 2:
                    retiros();
                    break;
                case 3:
                    Abono_capital(sc);
                    break;
                case 4:
                    Administrar_cuentas(sc);
                    break;
                case 5:

                    System.out.println("Proceso de cerrar App...");

                default:
                    System.out.println("Opción inválida, intente de nuevo.");
            }
        } while (opciones != 5);

        sc.close();
    }
}
