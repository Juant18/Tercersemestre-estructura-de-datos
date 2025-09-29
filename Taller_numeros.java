import java.util.ArrayDeque;
import java.util.Queue;

public class Taller_numeros {

    public static void main(String[] args) {

Queue<Double> Cola = new ArrayDeque<>();

Cola.add(4.0);
Cola.add(8.0);

if (Cola.size() >= 2) {
            // Extraer y almacenar el primer numero (último en entrar)
            Double Numero1 = Cola.poll();

            // Extraer y almacenar el segundo numero
            Double Numero2 = Cola.poll();
            
            Double raiz1 = Math.sqrt(Numero1);
            Double raiz2 = Math.cbrt(Numero2);



 if (raiz1 == raiz2) {

System.out.println("Los valores son iguales ? " + Cola.isEmpty());
            } else {
              System.out.println("Los valores son iguales ?"  + Cola.isEmpty());
            }
   

 }

}

    

}

