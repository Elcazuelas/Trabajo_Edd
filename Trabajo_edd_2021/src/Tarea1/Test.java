package Tarea1;

/**
 * 
 * @author Julio Monroy - Camilo Vazques - Diego Williams
 */
public class Test {
    public static void main(String[] args) {
        //se crea un SecBits y se le prenden algunos bits 
        SecBits td=new SecBits(128);
        td.on(1, 5);
        td.on(30, 33);
        
        //se imprime desde el bits 1 hasta el 33 (la secuencia deberia ser 1111100...01111)
        td.Print(1, 33);
        
        //se apagan algunos bits
        td.off(30, 33);
        
        //se vuelve a imprimir la misma secuencia pero ahora los ultimos 2 bits de la secuencia deberian estar apagados
        td.Print(1, 33);
        
        //se prueba el metodo BitsOn de SecBits en toda la secuencia de bits,para este caso el metodo deberia contar 5 bits encendidos
        System.out.println("Bits encendidos en td: "+ td.BitsOn(63));
        
        //probando SelPos, le pedire la posicion del quinto bits encendido, en este caso deberia der la poscion 5
        System.out.println("La poscion del quinto bit encendido de td es: " + td.SelPos(5));
        
        //se crea un nuevo sec bits 
        SecBits s = new SecBits(64);
        s.on(1,8);
        s.on(9,40);
        
        if (td.SubsecuenciaSimilares(s, 0,5)) {//en este caso es verdadero porque son iguales en esa sub secuencia
            System.out.println("Las secuencias son iguales");
        }else{
            System.out.println("Las secuencias no son iguales");
        }
        
        if (td.SubsecuenciaSimilares(s, 0,63)) {//en este caso es falso porque s tiene mas bits encendidos
            System.out.println("Las secuencias son iguales");
        }else{
            System.out.println("Las secuencias no son iguales");
        }
    }

}
