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
            System.out.println("-" + this.coef +"|" + this.ex);
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
    
    public Polinomio Suma(Polinomio p) {
        Nodo n = cabeza;
        Nodo a = p.cabeza;
        Polinomio nuevo= new Polinomio();
        while (((this.Size() > p.Size()) && (n != null)) || ((this.Size() < p.Size()) && (a != null)) || ((this.Size()==p.Size()) && ((a!=null) || (n != null)))) {
            System.out.println("entra");
            if (n.ex==a.ex){
                System.out.println("es igual");
                nuevo.AgregarTermino((n.coef+a.coef), n.ex);
                n = n.next;
                a = a.next;
            }else if((n.ex>a.ex)||((a.ex>0)&& n==null)){
                System.out.println("n es mayor a");
                nuevo.AgregarTermino((a.coef), a.ex);
                a = a.next;
            }else if((n.ex<a.ex)||((n.ex>0)&& a==null)){
                System.out.println("a es mayor n");
                nuevo.AgregarTermino((n.coef), n.ex);
                n = n.next;
            }
        }
        return nuevo;
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
    
    public void imprimir(){
        Nodo n = cabeza;
        while (n != null) {            
            n.info();
            n = n.next;
        }
    }
}
