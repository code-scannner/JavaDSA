
import java.util.*;
public class Lexco1 {
    public static int[] finalArray(int n , int q, int [][] qry){
        int [] ans = new int[n];
        for(int [] query : qry){
            int i = query[0];
            int x = query[1];
            ans[i] += x;
            i--;
            x--;
            while(i >= 0 && x > 0){
                ans[i] += x;
                i--;
                x--;
            }
            i = query[0] + 1;
            x = query[1] - 1;
            while(i < n && x > 0){
                ans[i] += x;
                i++;
                x--;
            }
        }
        return ans;
    } 
    public static void main(String[] args) {
        int n = 5, q = 3;
        int [][] qry = new int[][]{
            {2,2},
            {1,3},
            {4,1}
        };

        System.out.println(Arrays.toString(finalArray(n, q, qry)));
    }
}
