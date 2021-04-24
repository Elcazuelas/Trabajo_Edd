package Tarea1;

/**
 *
 * @author Julio Monroy - Camilo Vazques
 */
public class SecBits {

    private int[] sec;// 

    public SecBits(int n) { //
        sec = new int[n / 32];
    }
//
    public void On(int i, int j) {
        int msk;
        
        if ( j/32 == i/32 ) {
            msk = 0x80000000;
            for (int k = 0; k <= j%32; k++) { //recorre 1 por 1 los bits
                msk= (msk>>>1);
            }
        }else{
            msk = 0xffffffff;
            for (int k = 0; k < i%32; k++) { //recorre 1 por 1 los bits
                msk= (msk>>>1);
            }
            sec[i/32]= msk | sec[i/32];
            //para j
            msk = 0xffffffff;
            for (int k = 0; k < 32-(j%32); k++) { //recorre 1 por 1 los bits
                msk= (msk << 1);
            }
            sec[j/32]= msk | sec[j/32];
        }
            
        i        
        
        if (i%32 == 0 && (j+1)%32==0) {
            msk = 0xffffffff;
            for (int k = i/32; k < ((j+1)/32); k++) {
                sec[k]=sec[k]|msk;
            }
        }
        
        
        /*for (short k = 0; k < 10; k++) { //recorre 1 por 1 los bits
            sec[aux]=(short) (sec[aux] | msk);
            msk=(short) (msk>>>1);
        }*/
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
        int msk; // m´ascara (en hexadecimal)
        for (int i = 0; i < sec.length; i++) {
            msk = 0x80000000;
            for (short j = 0; j < 32; j++) {
                if ((sec[i] & msk) == 0) {
                    System.out.print("0");
                } else {
                    System.out.print("1");
                }
                msk =(msk >>> 1);
            }
            System.out.print("----");
        }
    }
}
