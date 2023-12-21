import java.util.*;

public class BoyerMoore {

    static int CHARS = 128;
    
    static List<Integer> search(char txt[], char pat[]) {
        List<Integer> indices = new ArrayList<Integer>();
        int m = pat.length;
        int n = txt.length;

        // making badcharTable
        int badchar[] = new int[CHARS];

        Arrays.fill(badchar, m);
        for (int i = 0; i < m; i++)
            badchar[(int) pat[i]] = m - i - 1;
        
        badchar[(int)pat[m - 1]] = m;

        // booyer moore algo 
        int s = 0;
        while (s <= (n - m)) {
            int j = m - 1;

            while (j >= 0 && pat[j] == txt[s + j])
                j--;

            if (j < 0) {
                indices.add(s);
                s++;
            }
            else s += badchar[(int)txt[s + j]];
        }

        return indices;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Text - ");
        char txt[] = sc.nextLine().toCharArray();

        System.out.print("Enter Pattern - ");
        char pat[] = sc.nextLine().toCharArray();

        System.out.println("Found at indices - " + search(txt, pat));

        sc.close();
    }
}
