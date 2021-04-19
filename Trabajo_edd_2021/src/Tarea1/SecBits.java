package Tarea1;

/**
 *
 * @author Julio Monroy - Camilo Vazques
 */
public class SecBits {

    private short[] sec;// 010000000000 0000000000000000 [0 ,0 ]

    public SecBits(int n) { //
        sec = new short[n / 16];
    }

    public void On(int i, int j) {
        int msk = 0x80000000;//1000000..
        int aux=0;
        int ms = 0x80000000; // m´ascara (en hexadecimal)
        for (short k = 0; k < sec.length*16; k++) { //recorre 1 por 1 los bits
            if (i <= k && j >= k) {   //busca la posicion de enmedio de los dos datos dados
                sec[aux]=(short) (sec[aux] | msk);
            }
            msk=(short) (msk>>>1);
            
            
            for (short l = 0; l < 16; l++) {
            if ((ms & msk) == 0){ 
                System.out.print("0");
            }else {System.out.print("1");}
        ms = (short) (ms >>> 1);
        
        }
            System.out.println("");
            ms = (short) 0x8000;
        }
    }

    public void Off(int i, int j) {
        for (int a = 0; a < sec.length; a++) {
            if (i <= a || j >= a) {
                sec[a] = 0;
            }
        }
    }

    public int BitsOn(int j) {
        int cont = 0;
        for (int a = 0; a < sec.length; a++) {
            if (sec[a] == 1) {
                cont++;
            }
        }
        return cont;
    }

    public int SelPos(int l) {
        int cont = 0;
        for (int a = 0; a < sec.length; a++) {
            if (sec[a] == 1) {
                cont++;
                if (l == cont) {
                    return a;
                }
            }
        }
        return -1;
    }

    public boolean SubsecuenciaSimilares(SecBits s, int i, int j) {
        for (int a = 0; a < sec.length; a++) {
            if (i <= a || j >= a) {
                if (!(s.sec[a] == this.sec[a])) {
                    return false;
                }
            }
        }
        return true;
    }
    /*
    public void Print(int i, int j) {
        for (int a = 0; a < sec.length; a++) {
            if (i <= a || j >= a) {
                System.out.print(a + " ");
            }
        }
    }*/
    public void intTobit() {
        short msk = (short) 0x8000; // m´ascara (en hexadecimal)
        int aux=0;
        for (short i = 0; i < 16; i++) {
            if ((sec[aux] & msk) == 0){ 
                System.out.print("0");
            }else {System.out.print("1");}
        msk = (short) (msk >>> 1);
        
        }
    }
}
