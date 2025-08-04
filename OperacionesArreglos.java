
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



public static String encontrarRepetidos(int[] arreglo) {
    StringBuilder resultado = new StringBuilder();
    boolean hayRepetidos = false;

    // Bucle exterior: Selecciona un número para comparar
    for (int i = 0; i < arreglo.length; i++) {
        // Ignora el número si ya se ha procesado
        boolean yaContado = false;
        for (int k = 0; k < i; k++) {
            if (arreglo[i] == arreglo[k]) {
                yaContado = true;
                break;
            }
        }
        if (yaContado) {
            continue;
        }

        // Bucle interior: Cuenta las repeticiones del número seleccionado
        int conteo = 1;
        for (int j = i + 1; j < arreglo.length; j++) {
            if (arreglo[i] == arreglo[j]) {
                conteo++;
            }
        }

        // Si hay más de una ocurrencia, añade el resultado al StringBuilder
        if (conteo > 1) {
            resultado.append("El número ").append(arreglo[i]).append(" se repite ").append(conteo).append(" veces.\n");
            hayRepetidos = true;
        }
    }

    if (!hayRepetidos) {
        resultado.append("No se encontraron números repetidos en el arreglo.");
    }

    // Retorna el texto completo
    return resultado.toString();
        }
    }
    


      
        





    
    

        
 
