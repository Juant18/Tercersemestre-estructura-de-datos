import java.util.Random;

public class Operaciones {
    public  int[] Arreglo(int tam) {

        Random rand = new Random();
        
        int[] numeros = new int[tam];
        for (int i = 0; 1 < numeros.length; i++){
            
        numeros[i] = rand.nextInt(100 - 1) + 1;
    }
        return numeros;

    }

}
