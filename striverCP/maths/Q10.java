package striverCP.maths;
import java.util.*;

// Magical Sticks

public class Q10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- >0){
            System.out.println((sc.nextInt() - 1)/2 + 1);
        }
        sc.close();
    }
}