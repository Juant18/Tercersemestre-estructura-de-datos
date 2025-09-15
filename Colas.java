import java.util.LinkedList;
import java.util.Queue;

public class Colas {
    

    public static void main(String[] args) {


Queue<String> miCola = new LinkedList<>();


miCola.add("juan");
miCola.add("andres");
miCola.add("luisa");
miCola.add("felipe");
miCola.add("salome");

System.out.println("¿La cola está vacía? " + miCola.isEmpty());
System.out.println("cola " +miCola);

System.out.println(miCola.peek());
miCola.poll();





    }

}
