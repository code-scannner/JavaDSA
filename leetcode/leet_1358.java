package leetcode;

public class leet_1358 {

    public static int numberOfSubstrings(String s) {
        int n = s.length(), i = 0, j = -1, result = 0;
        int[] count = new int[3];

        while (j < n) {
            if (count[0] > 0 && count[1] > 0 && count[2] > 0) {
                result += n - j;
                count[s.charAt(i++) - 'a']--;
            } else {
                if(++j < n){
                    count[s.charAt(j) - 'a']++;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        // String str = "aaacb";
        String str = "abcabc";
        System.out.println(numberOfSubstrings(str));

    }
}
