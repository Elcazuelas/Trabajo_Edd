/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tarea2;

/**
 *
 * @author ignac
 */
public class Polinomio {

    private class Nodo {

        //creo nodos;
        public Nodo next;
        public float coef;
        public int ex;

        //definir metodo constructor de la clase nodo
        public Nodo(float coef, int ex, Nodo next) {
            this.coef = coef;
            this.ex = ex;
            this.next = next;
        }

        //Impirmir la informacion del objeto
        public void info() {

        }
    }

    public Nodo cabeza;

    //al iniciar se crea un polinomio vacio
    public Polinomio() {
        this.cabeza = null;
    }

    public void AgregarTermino(float coef, int ex) {
        if (this.cabeza == null) {
            Nodo nuevo = new Nodo(coef, ex, null);
            this.cabeza = nuevo;
        } else {
            Nodo n = cabeza;
            while (n.next != null) {
                if (n.coef == coef || n.ex == ex) {
                    System.out.println("Ya existe un termino igual");
                    return;
                }
                n = n.next;
            }
            Nodo nuevo = new Nodo(coef, ex, null);
            n.next = nuevo;
        }
    }

    public float Evaluar(float x) {
        Nodo n = cabeza;
        float resultado = 0;
        while (n != null) {
            resultado = (float) (resultado + (n.coef * (Math.pow(x, n.ex))));
            n = n.next;
        }
        return resultado;
    }
    
    public int Size(){
        int i = 0;
        Nodo n = cabeza;
        while (n != null) {
            i++;
            n = n.next;
        }
        return i;
    }
}
