package Actividad_final;

import java.util.Scanner;

// Clase principal para interactuar con el sistema bancario
public class Principal_Main {
    public static void main(String[] args) {
        Banco banco = new Banco();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nSistema de Gestión Bancaria");
            System.out.println("1. Crear Cuenta");
            System.out.println("2. Consultar Saldo");
            System.out.println("3. Depositar");
            System.out.println("4. Retirar");
            System.out.println("5. Transferir");
            System.out.println("6. Procesar Transacciones");
            System.out.println("7. Mostrar Cuentas Ordenadas por Saldo");
            System.out.println("8. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();

            try {
                switch (opcion) {
                    case 1:
                        System.out.print("ID de Cuenta: ");
                        int id = scanner.nextInt();
                        scanner.nextLine(); // Consumir nueva línea
                        System.out.print("Nombre del Titular: ");
                        String nombre = scanner.nextLine();
                        System.out.print("Saldo Inicial: ");
                        double saldo = scanner.nextDouble();
                        banco.crearCuenta(id, nombre, saldo);
                        System.out.println("Cuenta creada exitosamente.");
                        break;
                    case 2:
                        System.out.print("ID de Cuenta: ");
                        id = scanner.nextInt();
                        System.out.println("Saldo: $" + banco.obtenerSaldo(id));
                        break;
                    case 3:
                        System.out.print("ID de Cuenta: ");
                        id = scanner.nextInt();
                        System.out.print("Monto a Depositar: ");
                        double monto = scanner.nextDouble();
                        banco.agregarTransaccion(new Transaccion("deposito", id, monto));
                        System.out.println("Depósito agregado a la cola.");
                        break;
                    case 4:
                        System.out.print("ID de Cuenta: ");
                        id = scanner.nextInt();
                        System.out.print("Monto a Retirar: ");
                        monto = scanner.nextDouble();
                        banco.agregarTransaccion(new Transaccion("retiro", id, monto));
                        System.out.println("Retiro agregado a la cola.");
                        break;
                    case 5:
                        System.out.print("ID de Cuenta Origen: ");
                        int idOrigen = scanner.nextInt();
                        System.out.print("ID de Cuenta Destino: ");
                        int idDestino = scanner.nextInt();
                        System.out.print("Monto a Transferir: ");
                        monto = scanner.nextDouble();
                        banco.agregarTransaccion(new Transaccion("transferencia", idOrigen, idDestino, monto));
                        System.out.println("Transferencia agregada a la cola.");
                        break;
                    case 6:
                        banco.procesarTransacciones();
                        System.out.println("Transacciones procesadas.");
                        break;
                    case 7:
                        banco.ordenarCuentasPorSaldo();
                        banco.mostrarCuentas();
                        break;
                    case 8:
                        System.out.println("Saliendo...");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Opción inválida.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}