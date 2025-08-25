public class Libro {

    private String titulo;
    private String autor;
    private int precio;

    public Libro(String titulo, String autor, int precio) {
        this.titulo = titulo;
        this.autor = autor;
        this.precio = precio;

    }
    public String toString(){
        return "Libro { Titulo: " + titulo + " Autor: " + autor + " Precio: " + precio + " }";
    }

public int sumartotal(Libro [] L){
    int suma=0;
    for(int i = 0; i < L.length; i++){
          suma+=L[i].precio;
}

return suma;


}

    public String iterarlibros(Libro[] L) {
        String cad = "";
        for (int i = 0; i < L.length; i++) {
            cad += L[i].toString() + "/n";

        }
        return cad;
}
}