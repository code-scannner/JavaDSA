package leetcode;

public class leet_2075 {
    public static String decodeCiphertext(String s, int rows) {
        int n = s.length();
        int cols = n / rows;
        StringBuilder str = new StringBuilder();
        for (int i = 0; i <= cols - rows + 1; i++) {
            int start = i;
            while (start < n) {
                str.append(s.charAt(start));
                start += cols + 1;
            }
        }
        while (str.length() != 0 && str.charAt(str.length() - 1) == ' ') {
            str.deleteCharAt(str.length() - 1);
        }

        return str.toString();
        
    }

    public static void main(String[] args) {
        System.out.println(decodeCiphertext("iveo    eed   l te   olc", 4));
        System.out.println(decodeCiphertext("ch   ie   pr", 3));
        System.out.println(decodeCiphertext("coding", 1));
    }
}
