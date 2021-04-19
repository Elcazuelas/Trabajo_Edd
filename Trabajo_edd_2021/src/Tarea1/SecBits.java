package Tarea1;

/**
 * 
 * @author Julio Monroy - Camilo Vazques
 */
public class SecBits {
    
    private short[] sec;

    public SecBits(int n) {
        sec=new short[n/16];
    }

    public void On(int i, int j){
        for(int a=0;a<sec.length;a++){
            if(i<=a || j>=a){
                sec[a]=1;
            }
        }
    }
    
    public void Off(int i, int j){
        for(int a=0;a<sec.length;a++){
            if(i<=a || j>=a){
                sec[a]=0;
            }
        }
    }
}
