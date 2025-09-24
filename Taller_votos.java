import java.util.ArrayDeque;
import java.util.Queue;

public class Taller_votos {
    public static void main(String[] args) {

        Queue<Integer> Cola = new ArrayDeque<>();

        System.out.println(Cola.peek()); // null

        Cola.add(10);
        Cola.add(20);

        System.out.println("los votos afavor y en contra son :" +Cola);
        Integer valor1 = Cola.poll(); // Saca el 10

        // 2. Verificar si la cola no está vacía y extraer el segundo valor
        Integer resultadoResta = null;
        if (valor1 != null) {
            Integer valor2 = Cola.poll(); // Saca el 5
            if (valor2 != null) {
                // 3. Realizar la resta
                resultadoResta = valor1 - valor2; // 10 - 5 = 5

                // 4. Volver a añadir el resultado a la cola
                Cola.offer(resultadoResta);
            } else {
                // Si no hay segundo valor, vuelve a poner el primero si quieres
                if (valor1 != null) {
                    Cola.offer(valor1);
                }
            }
        }

        System.out.println("El resultado de la votacion es " + resultadoResta);

    }
}