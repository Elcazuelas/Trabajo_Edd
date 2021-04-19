package Tarea1;

/**
 *
 * @author Julio Monroy - Camilo Vazques
 */
public class SecBits {

    private short[] sec;

    public SecBits(int n) {
        sec = new short[n / 16];
    }

    public void On(int i, int j) {
        for (int a = 0; a < sec.length; a++) { //recorre 1 por 1 los bits
            if (i <= a || j >= a) {   //busca la posicion de enmedio de los dos datos dados
                sec[a] = 1;       //reeemplaza por 1
            }
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
}
