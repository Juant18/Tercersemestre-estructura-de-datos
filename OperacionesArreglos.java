
import java.util.Random;

public class OperacionesArreglos {

    // Método para llenar un arreglo de enteros
    public int[] llenarArregloEnteros(int tam) {

        Random rand = new Random();

        int[] numeros = new int[tam];

        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = rand.nextInt(100 - 1) + 1; // Números del 1 al 100
        }

        return numeros;
    }

    public static int sumarArreglo(int[] arreglo) {
        int suma = 0;
        for (int numero : arreglo) {
            suma += numero;
        }
        return suma;
    }

    public static int Mayornnumero(int[] arreglo) {
        int mayor = arreglo[0];
        for (int i = 1; i < arreglo.length; i++) {

            if (arreglo[i] > mayor) {
                mayor = arreglo[i];
            }
        }
        return mayor;
    } 

    public static int Menornumero(int[] arreglo) {
        int menor = arreglo[0];
        for (int i = 1; i < arreglo.length; i++) {

            if (arreglo[i] < menor) {
                menor = arreglo[i];
            }
        }
        return menor;
    } 

    public static int promedio(int[] numeros) {
        int promedio = 0;

        for (int numero : numeros) {
            promedio += numero;

        }
        return (int) promedio / numeros.length;
    }


        }
    


      
        





    
    

        
 
