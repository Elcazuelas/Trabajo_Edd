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

        //metodo creado para imprimir la informacion del objeto en las pruebas
        /*public void info() {
            System.out.println( this.coef +"|" + this.ex);
        }*/
    }
    //atributo clase Polinomio
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
                if (n.coef == coef && n.ex == ex) {
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
    
    public Polinomio Suma(Polinomio p) {
        Nodo n = cabeza;
        Nodo a = p.cabeza;
        Polinomio nuevo= new Polinomio();
        
        while (n != null && a != null) {
            if (n.ex==a.ex){
                nuevo.AgregarTermino((n.coef+a.coef), n.ex);
                n = n.next;
                a = a.next;
            }else if(n.ex>a.ex){
                nuevo.AgregarTermino((a.coef), a.ex);
                a = a.next;
            }else if(n.ex<a.ex){
                nuevo.AgregarTermino((n.coef), n.ex);
                n = n.next;
            }
        }
        while(n!=null){
            nuevo.AgregarTermino((n.coef), n.ex);
            n = n.next;
        }
        while(a!=null){
            nuevo.AgregarTermino((a.coef), a.ex);
            a = a.next;
        }
        return nuevo;
    }
    
    public boolean Iguales(Polinomio q){
            Nodo nodoQ = q.cabeza;
            Nodo nodoA = this.cabeza;
        while(nodoA != null || nodoQ != null){
            if (nodoQ == null || nodoA == null || nodoA.coef != nodoQ.coef || nodoA.ex != nodoQ.ex)
                return false;
            nodoA = nodoA.next;
            nodoQ = nodoQ.next;
        }
        return true;
    }
    
    //metodo creado para imprimir un Polinomio en la fase de pruebas
    /*public void imprimir(){
        Nodo n = cabeza;
        while (n != null) {            
            n.info();
            n = n.next;
        }
    }*/
}
