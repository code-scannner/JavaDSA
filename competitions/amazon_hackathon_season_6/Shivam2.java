package competitions.amazon_hackathon_season_6;

import java.util.*;

public class Shivam2 {
    public static int solve(int arr[]) {
        boolean visited[] = new boolean[arr.length];
        int cnt = 0;
        for (int i = 0; i < arr.length; i++) {
            if (!visited[i]) {
                cnt++;
                visited[i] = true;
                int max = arr[i];
                for (int j = i + 1; j < arr.length; j++) {
                    if (arr[j] >= max) {
                        max = arr[j];
                        visited[j] = true;
                    }
                }
            }
        }
        return cnt - 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int j = 0; j < n; j++) {
            arr[j] = sc.nextInt();
        }
        System.out.println(solve(arr));
        sc.close();
    }
}
