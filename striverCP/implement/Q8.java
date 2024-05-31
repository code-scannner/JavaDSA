package striverCP.implement;

import java.util.*;

public class Q8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int count = 0;
        for(int i = 0; i<t;i++){
            char c = sc.next().charAt(0);
            if(c == 'T') count += 4;
            else if(c == 'C') count+= 6;
            else if(c == 'O') count += 8;
            else if(c == 'D') count += 12;
            else  count+= 20;
        }

        System.out.println(count);
        
        sc.close();
    }
}
