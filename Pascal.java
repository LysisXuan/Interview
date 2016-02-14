import java.io.*;
import java.util.*;

//Question #5
public class Pascal {
    public static void main(String args[] ) throws Exception {
        Scanner in = new Scanner(System.in);
        int _K = in.nextInt();
        pascals_triangle(_K);       
    }
    
    public static void pascals_triangle(int k) {
        if(k<2 ||k>25) throw new IllegalArgumentException("Input K should 2<=K<=25");
        
        for(int line = 1;line<=k; line++) {
            int coef = 1;
            for(int index = 1;index<=line; index++){
                System.out.print(coef+" ");
                coef=coef*(line-index)/index;
            }
            System.out.print("\n");
        }
        
    }
}