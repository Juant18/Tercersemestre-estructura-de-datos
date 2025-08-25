
public class EjecutarLibro {

    public static void main(String[] args) {

        Libro[] L = new Libro[3];

        L[0] = new Libro("La piscologia", "cervantes", 20000);
        L[1] = new Libro("La muerte de hernesto", "henesto", 50000);
        L[2] = new Libro("El principito", "Antoine de saint-exuperi", 15000);

        System.out.println(L[0].iterarlibros(L));

        System.out.println(" El total de precios es " +  L [0].sumartotal(L));
    }
}