package dp;

public class LongestBitonicSubsequence {
    public static int longestSequence(int arr[]) {
        int n = arr.length;
        int incDp[] = new int[n];
        incDp[0] = 1;
        for (int i = 1; i < n; i++) {
            incDp[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] < arr[i]) {
                    incDp[i] = Math.max(incDp[i], 1 + incDp[j]);
                }
            }
        }
        
        int decDep[] = new int[n];
        decDep[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            decDep[i] = 1;
            for (int j = i + 1; j <n; j++) {
                if (arr[j] < arr[i]) {
                    decDep[i] = Math.max(decDep[i], 1 + decDep[j]);
                }
            }
        }

        int maxL = 0;
        for(int i = 0; i<n; i++){
            maxL = Math.max(maxL, incDp[i] + decDep[i] - 1);
        }

        return maxL;
    }
    public static void main(String[] args) {
        int arr[] = { 1, 11, 2, 10, 4, 5, 2, 1 };

        System.out.println(longestSequence(arr));


    }
}
