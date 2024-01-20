package leetcode;

public class leet_2375 {
    public static void main(String[] args) {
        String str = "IIIDIDDD";
        System.out.println(smallestNumber(str));
    }

    public static String smallestNumber(String pattern) {
        StringBuilder str = new StringBuilder();
        int n = pattern.length();
        str.append(1);
        int inc = 1;
        for (int i = 0; i < n; i++) {
            if (pattern.charAt(i) == 'I') {
                str.append(++inc);
            } else {
                int prev = (int) (str.charAt(str.length() - 1) - '0');
                int k = i;
                while (k < n && pattern.charAt(k) == 'D')
                    k++;
                // counting number of consecutive Ds
                int count = k - i;
                inc = prev + count;
                str.setCharAt(str.length() - 1, (char) (inc + '0'));
                for (int j = inc - 1; j >= prev; j--)
                    str.append(j);
                i = k - 1;
            }
        }

        return str.toString();
    }
}
