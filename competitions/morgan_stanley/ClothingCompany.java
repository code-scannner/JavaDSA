package competitions.morgan_stanley;

import java.util.*;

public class ClothingCompany {
    static List<Integer> ans = new ArrayList<>();

    static boolean isEqual(char[] char1, char[] char2) {
        for (int i = 0; i < char1.length; i++) {
            if (char1[i] != char2[i])
                return false;
        }
        return true;
    }

    static boolean solve(char[] pat, char[] word, boolean[] visited, int n, char curr[]) {
        if (isEqual(word, curr))
            return true;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                // mark visited
                visited[i] = true;
                // add to sequence
                ans.add(i);

                // attach patch
                char[] prevPatch = new char[pat.length];
                for (int j = i, k = 0; k < pat.length; k++,j++) {
                    prevPatch[k] = curr[j];
                    curr[j] = pat[k];
                }

                // recursion
                if (solve(pat, word, visited, n, curr))
                    return true;

                // remove patch
                for (int j = i, k = 0; k < pat.length; k++,j++) {
                    curr[j] = prevPatch[k];
                }

                // remove from sequence
                ans.remove(ans.size() - 1);
                // mark unvisited
                visited[i] = false;
            }
        }

        return false;

    }

    static void findPatchSequence(String patch, String designerWord) {
        int m = patch.length(), n = designerWord.length();
        if (m > n) {
            ans.add(-1);
            return;
        }
        int nm = n - m + 1;
        boolean visited[] = new boolean[nm];
        char curr[] = new char[n];
        Arrays.fill(curr, '*');
        if (!solve(patch.toCharArray(), designerWord.toCharArray(), visited, nm, curr)) {
            ans.add(-1);
            return;
        }
        return;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String patch = scanner.next();
        String designerWord = scanner.next();
        scanner.close();

        findPatchSequence(patch, designerWord);
        for(int num : ans){
            System.out.print(num + " ");
        }
    }
}
