package Tarea1;

/**
 *
 * @author Julio Monroy - Camilo Vazques - Diego Williams
 */
public class SecBits {

    public int[] sec;// 

    public SecBits(int n) {
        sec = new int[n / 32];
    }

    public void on(int i, int j) {
        int msk;

        if (i % 32 == 0 && (j + 1) % 32 == 0 && j > i) {
            msk = 0xffffffff;
            for (int k = i / 32; k < ((j + 1) / 32); k++) {
                sec[k] = sec[k] | msk;
            }
        } else if (j >= i) {
            msk = 0xffffffff;
            msk = msk >>> i % 32;
            sec[i / 32] = msk | sec[i / 32];
            //para j
            msk = 0xffffffff;
            msk = (msk << 32 - ((j + 1) % 32));
            if (j / 32 == i / 32) {
                sec[j / 32] = msk & sec[j / 32];
            } else {
                sec[j / 32] = msk | sec[j / 32];
                i = ((i / 32) + 1) * 32;
                j = j - (j % 32) - 1;
                if (j > i) {
                    on(i, j);
                }
            }
        }
    }

    public void off(int i, int j) {
        int msk;

        if (i % 32 == 0 && (j + 1) % 32 == 0) {
            msk = 0x00000000;
            for (int k = i / 32; k < ((j + 1) / 32); k++) {
                sec[k] = sec[k] & msk;
            }
        } else {
            msk = 0xffffffff;
            if (i % 32 == 0) {
                sec[i / 32] = 0 & sec[i / 32];
            } else {
                msk = (msk << (32 - (i % 32)));
                sec[i / 32] = msk & sec[i / 32];
            }
            //para j
            msk = 0xffffffff;
            msk = (msk >>> (j + 1) % 32);
            
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
            for (int i = 0; i <= j % 32; i++) {
                if ((sec[j / 32] & msk) != 0) {
                    cont++;
                }
                msk = (msk >>> 1);
            }
            cont += BitsOn((j - (j % 32)) - 1);
        }
        return cont;
    }

    public int SelPos(int l) {
        int msk, cont = 0;

        for (int i = 0; i < sec.length; i++) {
            msk = 0x80000000;
            for (int j = 0; j < 32; j++) {
                if ((msk & sec[i]) != 0) {
                    cont++;
                    if (cont == l) {
                        return (i * 32) + j;
                    }
                }
                msk = msk >>> 1;
            }
        }
        return -1;
    }

    public boolean SubsecuenciaSimilares(SecBits s, int i, int j) {
        int msk;
        int pos = i / 32;
        msk = 0x80000000;
        msk = msk >>> i % 32;
        if (j > (s.sec.length * 32) - 1 || j > (this.sec.length * 32) - 1) {
            return false;
        } else {
            for (int k = i; k <= j; k++) {
                if (k % 32 == 0 && k != 0) {
                    msk = 0x80000000;
                    pos++;
                }
                if ((msk & this.sec[pos]) != (msk & s.sec[pos])) {
                    return false;
                }
                msk = msk >>> 1;
            }
            return true;
        }

    }

    public void Print(int i, int j) {
        int msk;
        int pos = i / 32;
        msk = 0x80000000;
        msk = msk >>> i % 32;
        for (int k = i % 32 + (i / 32) * 32; k <= (j % 32) + (j / 32) * 32; k++) {
            if (k % 32 == 0 && k != 0) {
                msk = 0x80000000;
                pos++;
            }
            if ((msk & sec[pos]) == 0) {
                System.out.print("0");
            } else {
                System.out.print("1");
            }
            msk = msk >>> 1;
        }
        System.out.println("");
    }

    /*public void intTobit() {
        int msk; // m´ascara (en hexadecimal)
        for (int i = 0; i < sec.length; i++) {
            msk = 0x80000000;
            for (short j = 0; j < 32; j++) {
                if ((sec[i] & msk) == 0) {
                    System.out.print("0");
                } else {
                    System.out.print("1");
                }
                msk = (msk >>> 1);
            }
            System.out.print("----\n");
        }
    }*/
}
