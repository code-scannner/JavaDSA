package strings;
import java.util.*;

public class KMP{
    
    public static List<Integer> kmp(String txt, String pat) {
        List<Integer> indices = new ArrayList<>();

        int pattn = pat.length();
        int txtn = txt.length();

        int [] lps = LPS.lps(pat);

        int j = 0, i = 0;

        while (i < txtn) {
            if(txt.charAt(i) == pat.charAt(j)){
                i++;
                j++;
            }
            else{
                if(j == 0) i++;
                else j = lps[j - 1];
            }
            if(j == pattn) {
                indices.add(i - pattn);
                j = lps[j - 1];
            }
        }

        return indices;
    }
    public static int firstIndex(String txt, String pat) {
        int pattn = pat.length();
        int txtn = txt.length();

        int [] lps = LPS.lps(pat);

        int j = 0, i = 0;

        while (i < txtn) {
            if(txt.charAt(i) == pat.charAt(j)){
                i++;
                j++;
            }
            else{
                if(j == 0) i++;
                else j = lps[j - 1];
            }
            if(j == pattn) return i - pattn;
        }

        return -1;
    }
    public static void main(String[] args) {
        System.out.println(kmp("aececececececd","ecec"));
        System.out.println(firstIndex("aececececececd","ecec"));
    }
}