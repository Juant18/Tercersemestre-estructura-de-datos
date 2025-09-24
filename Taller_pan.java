import java.util.Stack;


public class Taller_pan {
    public static void main(String[] args) {




        Stack<String> p = new Stack<>();

        
p.push("Sandwich con pan Blanco");
p.push("Sandwich con pan integral");

if (p.size() >= 2) {
            // Extraer y almacenar el primer texto (último en entrar)
            String texto1 = p.pop();

            // Extraer y almacenar el segundo texto
            String texto2 = p.pop();

            // Comparar los textos
            if (texto1.equals(texto2)) {
                System.out.println("Los panes tienen el mismo pan " + texto1);
            } else {
                System.out.println("Los sandwiches son diferentes " + texto1 + ", Pan 2 " + texto2);
            }
        } else {
            System.out.println("No hay suficientes elementos en la pila para comparar.");
        }
    }
}
 
