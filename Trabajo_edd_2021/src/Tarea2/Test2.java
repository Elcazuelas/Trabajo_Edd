package Tarea2;
/**
 *
 * @author Diego
 */
public class Test2 {
    public static void main(String[] args) {
        Polinomio q = new Polinomio();
        q.AgregarTermino(10, 0);
        q.AgregarTermino((float) 3.5, 2);
        q.AgregarTermino(6, 3);
        System.out.println(q.Evaluar(2));
        Polinomio r = new Polinomio();
        r.AgregarTermino(5, 0);
        r.AgregarTermino(2, 1);
        r.AgregarTermino(3, 2);
        q.Suma(r).imprimir();
        
       
    }
}
