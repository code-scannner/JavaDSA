package slidingwindow;
import java.util.*;

public class RabinKarp {
    public static boolean match(String patt, String text, int s, int m) {
        for (int i = 0; i < m; i++) {
            if (patt.charAt(i) != text.charAt(s + i))
                return false;
        }

        return true;
    }

    public static boolean search(String patt, String text) {
        int m = patt.length(), n = text.length();
        if (n < m)
            return false;
        int hash = 0;
        int curr = 0;
        for (int i = 0; i < m; i++) {
            hash += patt.charAt(i);
            curr += text.charAt(i);
        }
        int j = m;
        while (true) {
            if (hash == curr && match(patt, text, j - m, m))
                return true;

            curr -= text.charAt(j - m);
            if (j == n)
                break;
            curr += text.charAt(j);
            j++;
        }

        return false;
    }

    public static void main(String[] args) {
        String patt = "ab", text = "eidbabooo";
        System.out.println(search(patt, text));
    }


    // rolling hash with positions
    public String longest(String str, int window){
        int n = str.length();
        if(n < window) return null;
        int hash = 0;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            // adding to end of window
            hash += (str.charAt(i) - 'a' + 1);
            
            if (i >= window) {
                // removing from front of window
                hash -= (str.charAt(i - window) - 'a' + 1);
            }
            if (i >= window - 1) {
                // adding to the result
                if(map.containsKey(hash)){
                    List<Integer> indices = map.get(hash);
                    for(int ind : indices){
                        if(matches(str, ind, i - window + 1, window)) {
                            return str.substring(i - window + 1, i + 1);
                        }
                    }
                }
                else{
                    map.put(hash, new ArrayList<>());
                }
                map.get(hash).add(i - window + 1);

            }
        }
        return "";
    }

    public boolean matches(String s, int i, int j, int size){
        for(int k = 0; k < size; k++){
            if(s.charAt(i + k) != s.charAt(j + k)) return false;
        }
        return true;
    }
}
