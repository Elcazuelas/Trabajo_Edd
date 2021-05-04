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
    }
}
