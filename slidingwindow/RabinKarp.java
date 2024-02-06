package slidingwindow;

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
}
