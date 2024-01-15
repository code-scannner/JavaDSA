package strings;
import java.util.*;

public class KMP{
    public static List<Integer> kmp(String txt, String pat) {
        List<Integer> indices = new ArrayList<>();

        int pattn = pat.length();
        int txtn = txt.length();

        int [] lps = new int[pattn];
        int len = 0, i = 1;
        // lps[i] = the longest proper prefix of pat[0..i] which is also a suffix of pat[0..i]. 
        while(i < pattn) {
            if(pat.charAt(len) == pat.charAt(i)){
                lps[i++] = ++len;
            }
            else{
                if(len == 0){
                    lps[i++] = 0;
                }
                else{
                    len = lps[len - 1];
                }
            }
        }

        int j = 0;
        i = 0;
        while (i < txtn) {
            if(txt.charAt(i) == pat.charAt(j)){
                i++;
                j++;
            }
            else{
                if(j == 0) i++;
                else{
                    j = lps[j - 1];
                }
            }
            if(j == pattn) {
                indices.add(i - pattn);
                j = 0;
                i = i - pattn + 1;
            }
        }

        return indices;
    }
    public static void main(String[] args) {
        System.out.println(kmp("aececececececdececececbbecec","ecec"));
    }
}