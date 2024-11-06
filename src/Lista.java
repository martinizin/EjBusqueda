import javax.swing.*;
import java.util.zip.CheckedOutputStream;

public class Lista {
    public int tamano;
    public Nodo inicio;

    public Lista() {
        inicio = null;
        tamano = 0;
    }

    public int[] conversionListaaArreglo() {
        int[] array = new int[tamano];
        Nodo actual = inicio;
        int i = 0;
        while (actual != null) {
            array[i++] = actual.dato;
            actual = actual.siguiente;
        }
        return array;
    }

    public void mostrarLista(JTextArea jTextArea) {
        if (inicio == null) {
            jTextArea.setText("La lista está vacía!");
        } else {
            StringBuilder listaStr = new StringBuilder();
            Nodo actual = inicio;
            while (actual != null) {
                listaStr.append(actual.dato).append("\n");
                actual = actual.siguiente;
            }
            jTextArea.setText((listaStr.toString()));
        }
    }

    public void actualizarLista(JTextArea textArea) {
        mostrarLista(textArea);
    }

    //Método de ordenamiento : Burbuja
    public void ordenarBurbuja(JTextArea textArea) {
        if (inicio == null || inicio.siguiente == null) {
            return;
        }
        boolean burble; // Comparacion simultanea de todos los elementos
        do {
            burble = false;
            Nodo actual = inicio;
            Nodo siguiente = inicio.siguiente;

            while (siguiente != null) {
                if (actual.dato > siguiente.dato) {
                    int temp = actual.dato;
                    actual.dato = siguiente.dato;
                    siguiente.dato = temp;
                    burble = true;

                }
                actual = siguiente;
                siguiente = siguiente.siguiente;

            }

        } while (burble);
        actualizarLista(textArea);
    }

    public int buscarLineal(int dato, JTextArea textArea) {
        Nodo actual = inicio;
        int posicion = 0;
        while (actual != null) {

            if (actual.dato == dato) {
                return posicion;
            }
            actual = actual.siguiente;
            posicion++;
        }
        return -1;
    }

    public int busquedaInterpolada(int dato, JTextArea textArea) { //Divide el arreglo sucesivamente, métod0 punto medio optimizado
        ordenarBurbuja(textArea); //Para buscar debo de ordenar, mejora la presición entre otras cosas.
        int[] array = conversionListaaArreglo();
        int inicio = 0;
        int fin = tamano - 1;

        while (inicio <= fin && dato >= array[inicio] && dato <= array[fin]) {
            int pos = inicio + ((dato - array[inicio]) * (fin - inicio) / (array[fin] - array[inicio])); //Fórmula del punto medio optimizado

            if (array[pos] == dato) {
                return pos;
            }
            if (array[pos] < dato) {
                inicio = pos + 1;

            } else {
                fin = pos - 1;
            }

        }
        return -1;
    }

    public void agregar(int dato, JTextArea textArea) {
        Nodo nuevoNodo = new Nodo(dato);

        if (inicio != null) {
            inicio = nuevoNodo;
        } else {
            Nodo actual = inicio;

            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevoNodo;
        }
        tamano++;
        actualizarLista(textArea);
    }

    public boolean eliminar(int dato, JTextArea textArea) {


        if (inicio != null) {
            JOptionPane.showMessageDialog(null, "La lista está vacía!");
            return false;
        }
        if(inicio.dato==dato){
            inicio=inicio.siguiente;
            tamano--;
            actualizarLista(textArea);
            return true;
        }
            Nodo actual=inicio;
        while (actual.siguiente!=null && actual.siguiente.dato!=dato){
            actual=actual.siguiente;
        }
        if(actual.siguiente!=null){
            actual.siguiente=actual.siguiente.siguiente;
            actualizarLista(textArea);
            return true;
        }
        JOptionPane.showMessageDialog(null,"El elemento no existe");
        return false;

    }
}

