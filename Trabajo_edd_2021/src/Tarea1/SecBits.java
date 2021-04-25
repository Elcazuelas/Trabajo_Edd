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
    public void on(int i, int j) {
        int msk = 0x80000000;

        if (i % 32 == 0 && (j + 1) % 32 == 0) {
            msk = 0xffffffff;
            for (int k = i / 32; k < ((j + 1) / 32); k++) {
                sec[k] = sec[k] | msk;
            }
        } else if (j / 32 == i / 32) {
            for (int k = 0; k <= j % 32; k++) { //recorre 1 por 1 los bits
                if (k >= i % 32) {
                    sec[i / 32] = sec[i / 32] | msk;
                }
                msk = (msk >>> 1);
            }
        } else {
            msk = 0xffffffff;
            for (int k = 0; k < i % 32; k++) { //recorre 1 por 1 los bits
                msk = (msk >>> 1);
            }
            sec[i / 32] = msk | sec[i / 32];
            //para j
            msk = 0xffffffff;
            for (int k = 0; k < 32 - ((j+1) % 32); k++) { //recorre 1 por 1 los bits
                msk = (msk << 1);
            }
            sec[j / 32] = msk | sec[j / 32];

            i = ((i / 32) + 1) * 32;
            j = j - (j % 32) - 1;
            if (j > i) {
                on(i, j);
            }
        }
    }

    public void off(int i, int j) {
        int msk = 0x7fffffff;

        if (i % 32 == 0 && (j + 1) % 32 == 0) {
            msk = 0x00000000;
            for (int k = i / 32; k < ((j + 1) / 32); k++) {
                sec[k] = sec[k] & msk;
            }
        } else if (j / 32 == i / 32) {
            for (int k = 0; k <= j % 32; k++) { //recorre 1 por 1 los bits
                if (k >= i % 32) {
                    sec[i / 32] = sec[i / 32] & msk;
                }
                msk = (msk >>> 1);
            }
        } else {
            msk = 0xffffffff;
            for (int k = 0; k < 32-(i % 32); k++) { //recorre 1 por 1 los bits
                msk = (msk << 1);
            }
            sec[i / 32] = msk & sec[i / 32];
            //para j
            msk = 0xffffffff;
            for (int k = 0; k < (j+1) % 32; k++) { //recorre 1 por 1 los bits
                msk = (msk >>> 1);
            }
            sec[j / 32] = msk & sec[j / 32];

            i = ((i / 32) + 1) * 32;
            j = j - (j % 32) - 1;
            if (j > i) {
                off(i, j);
            }
        }
    }

    public int BitsOn(int j) {
        int msk;
        int cont = 0;

        msk = 0x80000000;
        if (j / 32 == 0) {
                for (short k = 0; k <= j % 32; k++) {
                    if ((sec[0] & msk) != 0) {
                        cont++;
                    }
                    msk = (msk >>> 1);
                }
        } else {
            for (int i = 0; i <= j%32; i++) {
                if ((sec[j/32] & msk) != 0) {
                        cont++;
                    }
                    msk = (msk >>> 1);
            }
            cont+= BitsOn(j - (j % 32) - 1);
        }
        return cont;
    }

    public int SelPos(int l) {
        int cont = 0;
        int msk=0x80000000;
        int aux=0;
        int pos=-1;
        while (cont!=l && aux<sec.length ) {            
            if ((sec[aux] & msk) == 0) {
                System.out.print("0");
            }else{
                System.out.print("akitoy,");
                cont++;
            }
            pos++;
            msk=(msk>>>1);
            if (pos%32==0) {
                msk=0x80000000;
                aux++;
            }
        }
        return pos;
        
        
        /*for (int i = 0; i < sec.length; i++) {
            msk =0x80000000;
            for (int j=0; j < 32 ; j++  ) {
                if ((msk & sec[i])!= 0) {
                    cont++;
                    if (cont==l) {
                        return ((i-1)*32)+j;
                    }
                }
            }
        }*/
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
    
    public void Print(int i, int j) {
        for (int a = 0; a < sec.length; a++) {
            if (i <= a || j >= a) {
                System.out.print(a + " ");
            }
        }
    }
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
