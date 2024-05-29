package competitions.amazon_hackathon_season_6;

import java.util.*;

public class Wajid2 {
    public static String sol(int n, String str) {
        StringBuilder res = new StringBuilder();
        for(char c : str.toCharArray()){
            if(c == 'X') res.append("YY");
            else res.append(c);
        }
        StringBuilder finalres = new StringBuilder();
        for(int i = 0; i<res.length(); i++){
            if(i != res.length() - 1 && res.charAt(i) == 'Y' && res.charAt(i + 1) == 'Y'){
                finalres.append('X');
                i++;
            }else{
                finalres.append(res.charAt(i));
            }
        }
        return finalres.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String N = sc.next();
        System.out.println(sol(n,N));
        sc.close();
    }
}
