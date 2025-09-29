import java.util.Stack;

public class Taller_5 {

    public static int secondLargest(int[] numbers) {
        if (numbers == null || numbers.length < 2) {
            throw new IllegalArgumentException("El arreglo debe contener al menos dos números.");
        }

        Stack<Integer> stack = new Stack<>();

        // Apilar todos los números
        for (int num : numbers) {
            stack.push(num);
        }

        // Encontrar el máximo
        int max = Integer.MIN_VALUE;
        Stack<Integer> tempStack = new Stack<>();
        while (!stack.isEmpty()) {
            int current = stack.pop();
            if (current > max) {
                max = current;
            }
            tempStack.push(current);
        }

        // Volver a apilar todos excepto el máximo
        while (!tempStack.isEmpty()) {
            int val = tempStack.pop();
            if (val != max) {
                stack.push(val);
            }
        }

        if (stack.isEmpty()) {
            throw new IllegalArgumentException("No hay un segundo número más grande distinto.");
        }

        // Encontrar el segundo máximo
        int secondMax = Integer.MIN_VALUE;
        while (!stack.isEmpty()) {
            int current = stack.pop();
            if (current > secondMax) {
                secondMax = current;
            }
        }

        if (secondMax == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("No hay un segundo número más grande distinto.");
        }

        return secondMax;
    }

    public static void main(String[] args) {
        System.out.println(secondLargest(new int[]{10, 40, 30, 20, 50})); // 40
        System.out.println(secondLargest(new int[]{25, 143, 89, 13, 105})); // 105
        System.out.println(secondLargest(new int[]{54, 23, 11, 17, 10})); // 23
    }
}