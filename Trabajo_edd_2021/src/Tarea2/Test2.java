package Tarea2;
/**
 *
 * @author Diego
 */
public class Test2 {
    public static void main(String[] args) {
        //creo polinomio q
        Polinomio q = new Polinomio();
        q.AgregarTermino(10, 0);
        q.AgregarTermino((float) 3.5, 2);
        q.AgregarTermino(6, 3);
        //al evaluar q en 2 deberua dar 72
        System.out.println("al evaluar q con x=2 da: " + q.Evaluar(2));
        
        //creo un nuevo polinomio para probar los metodos suma e iguales
        Polinomio r = new Polinomio();
        r.AgregarTermino(5, 0);
        r.AgregarTermino(2, 1);
        r.AgregarTermino(3, 2);
        
        //verifico si el metodo iguales funciona, deberia dar falso en este caso...
        if (r.Iguales(q)) {
            System.out.println("son iguales");
        }else{
            System.out.println("no son iguales");
        }
        
        //pruebo si la suma se hizo bien con el metodo Imprimir de polinomio
        //q.Suma(r).imprimir();
        
        Polinomio s = r.Suma(q);
        
        //creo un polinomio con lo que deberia dar la suma para luego comparar si son iguales
        Polinomio b = new Polinomio();
        b.AgregarTermino(15, 0);
        b.AgregarTermino(2, 1);
        b.AgregarTermino((float)6.5, 2);
        b.AgregarTermino(6, 3);
        
        if (s.Iguales(b)) {
            System.out.println("son iguales");
        }else{
            System.out.println("no son iguales");
        }
        
        
        //implementacion de un arreglo de polinomios y buscar el que da el mayor valor de x
        Polinomio[] arrPoli = new Polinomio[3];
        for (int i = 0; i < arrPoli.length; i++) {
            arrPoli[i] = new Polinomio();
        }
        
        arrPoli[0].AgregarTermino(1, 0);
        arrPoli[0].AgregarTermino(1, 1);
        arrPoli[0].AgregarTermino(1, 2);
        
        arrPoli[1].AgregarTermino(-1, 0);
        arrPoli[1].AgregarTermino(-1, 1);
        arrPoli[1].AgregarTermino(-1, 2);
        arrPoli[1].AgregarTermino(-100, 3);
        
        arrPoli[2].AgregarTermino(-1, 0);
        arrPoli[2].AgregarTermino(-1, 1);
        arrPoli[2].AgregarTermino(-1, 2);
        arrPoli[2].AgregarTermino(-1, 3);
        arrPoli[2].AgregarTermino(-1, 4);
        
        int pos = posMayorEv(arrPoli, 2);
        if (pos == -1) {
            System.out.println("Ingrese un arreglo valido");
        }else{
            System.out.println("La poscion del arreglo con el mayor resultado al reemplazar x, es: "+ pos);
            //arrPoli[pos].imprimir();
        }
    }
    
    public static int posMayorEv(Polinomio[] arr, float x){
        float resultado=-1;
        boolean entra = true;
        int pos = -1;
        float evaluar;
        for (int i = 0; i < arr.length ; i++) {
            if (arr[i] != null && entra) {
                resultado = arr[i].Evaluar(x);
                entra= false;
                pos=i;
            }else if(arr[i] != null){
                evaluar=arr[i].Evaluar(x);
                if ( evaluar > resultado) {
                resultado = evaluar;
                pos=i;
                }
            }
        }
        return pos;
    }
}
