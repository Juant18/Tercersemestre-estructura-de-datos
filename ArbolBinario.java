public class ArbolBinario {
    Nodo raiz;

    // Constructor: crea un árbol vacío
    public ArbolBinario() {
        raiz = null;
    }

    // Método para insertar un nuevo valor en el árbol
    public void insertar(int valor) {
        raiz = insertarRec(raiz, valor);
    }

    // Método recursivo para insertar un nuevo valor
    private Nodo insertarRec(Nodo raiz, int valor) {
        if (raiz == null) {
            raiz = new Nodo(valor);
            return raiz;
        }

        if (valor < raiz.valor)
            raiz.izquierda = insertarRec(raiz.izquierda, valor);
        else if (valor > raiz.valor)
            raiz.derecha = insertarRec(raiz.derecha, valor);

        return raiz;
    }

    // Recorrido inorden (izquierda - raíz - derecha)
    public void inOrden() {
        System.out.print("Recorrido Inorden: ");
        inOrdenRec(raiz);
        System.out.println();
    }

    private void inOrdenRec(Nodo raiz) {
        if (raiz != null) {
            inOrdenRec(raiz.izquierda);
            System.out.print(raiz.valor + " ");
            inOrdenRec(raiz.derecha);
        }
    }

    // Recorrido preorden (raíz - izquierda - derecha)
    public void preOrden() {
        System.out.print("Recorrido Preorden: ");
        preOrdenRec(raiz);
        System.out.println();
    }

    private void preOrdenRec(Nodo raiz) {
        if (raiz != null) {
            System.out.print(raiz.valor + " ");
            preOrdenRec(raiz.izquierda);
            preOrdenRec(raiz.derecha);
        }
    }

    // Recorrido postorden (izquierda - derecha - raíz)
    public void postOrden() {
        System.out.print("Recorrido Postorden: ");
        postOrdenRec(raiz);
        System.out.println();
    }

    private void postOrdenRec(Nodo raiz) {
        if (raiz != null) {
            postOrdenRec(raiz.izquierda);
            postOrdenRec(raiz.derecha);
            System.out.print(raiz.valor + " ");
        }
    }

    // Buscar un valor en el árbol
    public boolean buscar(int valor) {
        return buscarRec(raiz, valor);
    }

    private boolean buscarRec(Nodo raiz, int valor) {
        if (raiz == null)
            return false;
        if (raiz.valor == valor)
            return true;
        return valor < raiz.valor
                ? buscarRec(raiz.izquierda, valor)
                : buscarRec(raiz.derecha, valor);
    }

    // Método principal para probar el árbol
    public static void main(String[] args) {
        ArbolBinario arbol = new ArbolBinario();

        // Insertar elementos
        arbol.insertar(50);
        arbol.insertar(30);
        arbol.insertar(70);
        arbol.insertar(20);
        arbol.insertar(40);
        arbol.insertar(60);
        arbol.insertar(80);

        // Mostrar recorridos
        arbol.inOrden();
        arbol.preOrden();
        arbol.postOrden();

        // Buscar valores
        System.out.println("¿Existe 40? " + arbol.buscar(40));
        System.out.println("¿Existe 90? " + arbol.buscar(90));
    }
}
