public class Vehiculo {

    private String chasis;
    private String marca;
    private int modelo;
    private boolean matricula;

    public Vehiculo(String chasis, String marca, int modelo, boolean matricula) {
        this.chasis = chasis;
        this.marca = marca;
        this.modelo = modelo;
        this.matricula = matricula;
    }

    public String toString() {
        return "Vehiculo { Chasis: " + chasis + " Marca: " + marca + " modelo: " + modelo + " Matricula " + matricula
                + " }";
    }

    // metodo

    public String iterarvehiculos(Vehiculo[] v) {
        String cad = "";
        for (int i = 0; i < v.length; i++) {
            cad += v[i].toString() + "/n";

        }
        return cad;

    }
}
