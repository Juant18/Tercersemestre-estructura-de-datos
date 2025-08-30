public class EjecutarLibro {
    public static void main(String[] args) {
        Libro[] L = new Libro[3];
        L[0] = new Libro("La piscologia", "cervantes", 20000);
        L[1] = new Libro("La muerte de hernesto", "henesto", 50000);
        L[2] = new Libro("El principito", "Antoine de saint-exuperi", 15000);
        // Ordenar libros por precio de menor a mayor
        ordenarPorPrecio(L);
        // Mostrar libros ordenados
        System.out.println("Libros ordenados por precio de menor a mayor:");
        System.out.println(iterarLibros(L));
        // Mostrar suma total de precios
        System.out.println("El total de precios es " + sumarTotal(L));
    }
    public static void ordenarPorPrecio(Libro[] L) {
        int n = L.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (L[j].getPrecio() > L[j + 1].getPrecio()) {
                    // Intercambiar libros
                    Libro temp = L[j];
                    L[j] = L[j + 1];
                    L[j + 1] = temp;
                }
            }
        }
    }
     public static String iterarLibros(Libro[] L) {
        StringBuilder cad = new StringBuilder();
        for (Libro libro : L) {
            cad.append(libro.toString()).append("\n");
        }
        return cad.toString();
    }
    // Método para sumar el total de precios
    public static int sumarTotal(Libro[] L) {
        int suma = 0;
        for (Libro libro : L) {
            suma += libro.getPrecio();
        }
        return suma;
    }
}