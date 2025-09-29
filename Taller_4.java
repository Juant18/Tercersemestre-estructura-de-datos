import java.util.Stack;

public class Taller_4 {

    public static String Taller_4 (int[] numbers) {
        if (numbers == null || numbers.length != 10) {
            throw new IllegalArgumentException("El arreglo debe contener exactamente 10 números.");
        }

        Stack<Integer> stack = new Stack<>();

        // Apilar todos los números
        for (int num : numbers) {
            if (num < 0 || num > 9) {
                throw new IllegalArgumentException("Los números deben estar entre 0 y 9.");
            }
            stack.push(num);
        }

        // Extraer los últimos 4 dígitos para el sufijo
        
        for (int i = 0; i < 4; i++) {
            suffix.insert(0, stack.pop());
        }

        // Extraer los siguientes 3 dígitos para el medio
        StringBuilder middle = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            middle.insert(0, stack.pop());
        }

        // Extraer los primeros 3 dígitos para el código de área
        StringBuilder area = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            area.insert(0, stack.pop());
        }

        // Formatear el número telefónico
        return "(" + area.toString() + ") " + middle.toString() + "-" + suffix.toString();
    }

    public static void main(String[] args) {
        int[] example1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        int[] example2 = {5, 1, 9, 5, 5, 5, 4, 4, 6, 8};
        int[] example3 = {3, 4, 5, 5, 0, 1, 2, 5, 2, 7};

        System.out.println(formatPhoneNumber(example1)); // (123) 456-7890
        System.out.println(formatPhoneNumber(example2)); // (519) 555-4468
        System.out.println(formatPhoneNumber(example3)); // (345) 501-2527
    }
}