import java.util.Arrays;

public class EjecutarLibro {
    
    public static void main(String[] args){

Libro [] L= new Libro [5];

        L[0] = 
        L[1] = new Vehiculo("37GHW87DY38", "KIA", 2026,  true);
        L[2] = new Vehiculo("D973Y7792YD", "BMW", 2020,  false);

   

System.out.println(L[0].iterarlibros(L));

        System.out.println("El total de precios es"+ L[0].sumarprecio(L));
    }
}