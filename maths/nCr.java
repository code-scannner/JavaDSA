package maths;

import java.util.ArrayList;
import java.util.List;

public class nCr {
    static int mod = (int)1e9 + 7;
    public static int combination(int n , int r, int range){
        double res = 1;
        int ren = r;
        for(int i= 0; i<r; i++){
            res = ((res * (n--)) / (ren--))% mod;
        }
        return (int)Math.round(res);
    }
    public static int combination(int n , int r) {
        
        int res = 1;
        for(int i= 0; i<r; i++){
            res*=(n--);
        }
        while(r > 0) res/=(r--);
        return res;
    }
    public static List<Integer> generate_pascal_row(int n){
        List<Integer> result = new ArrayList<>();
        result.add(1);
        int ncr = 1;
        for(int i = 0; i<n; i++){
            ncr *= (n - i);
            ncr /= i + 1;
            result.add(ncr);
        }

        return result;

    }
    public static void main(String[] args) {
        System.out.println(combination(8,3));
        // System.out.println(generate_pascal_row(10));
    }
}
