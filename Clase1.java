
import java.util.Arrays;

public class Clase1 {
    public static void main(String[] args) {

        System.out.println("Estructura de Datos");

        // Arreglos ó Arrays ó Vectores

        // Declaración del arreglo. Forma 1
        // int[] numeros;
        // numeros = new int[5];

        // Declaración del arreglo. Forma 2
        // int[] numeros = new int[5];

        // Declaración e inicialización
        // int[] numeros = {10, 20, 30, 40, 50};

        OperacionesArreglos objArreglo = new OperacionesArreglos();

        int[] numeros = objArreglo.llenarArregloEnteros(3);

        System.out.println(Arrays.toString(numeros));

        int sumaTotal = OperacionesArreglos.sumarArreglo(numeros);
        System.out.println("Suma de los elementos: " + sumaTotal);

        int menor = OperacionesArreglos.Menornumero(numeros);
        System.out.println("El menor numero es: " + menor);

        int mayor = OperacionesArreglos.Mayornnumero(numeros);
        System.out.println("El mayor es: " + mayor);

        int promedio = OperacionesArreglos.promedio(numeros);
        System.out.println("El promedio es: " + promedio);
        
     

      }
  
}
    
