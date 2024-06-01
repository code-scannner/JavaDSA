package striverCP.maths;
import java.util.*;

public class Q11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- >0){
            int a  = sc.nextInt(), b= sc.nextInt();
            int side = Math.min(Math.max(a, 2*b), Math.max(2*a, b));
            System.out.println(side * side);
        }
        sc.close();
    }
}