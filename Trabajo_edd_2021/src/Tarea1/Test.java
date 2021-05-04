package Tarea1;

/**
 * 
 * @author Julio Monroy - Camilo Vazques - Diego Williams
 */
public class Test {
    public static void main(String[] args) {
        SecBits td=new SecBits(128);
        SecBits s = new SecBits(64);
        td.on(1,5);
        s.on(1,6);
        td.on(32,33 );
        s.on(32,33 );
        if (td.SubsecuenciaSimilares(s, 1,6)) {
            System.out.println("sisoy");
        }else{
            System.out.println("nosoy");
        }
        //td.off(0,64);
        System.out.println(td.BitsOn(126));
        System.out.println(td.SelPos(6));
        td.Print(0, 35);
    }

}
