package competitions.amazon_hackathon_season_6;

import java.util.*;

public class Wajid1 {
    public static int sol(int idx, int N, int A, int B, int x, int y, int arr[][]) {
        if (idx == N) {
            if(x == 0 && A == 0 && B != 0){
                return 0;
            }
            else if(y == 0 && B == 0 && A != 0){
                return 0;
            }
            else if (x != 0 && y != 0 && A != 0 && B != 0 && A * y == B * x)
                return 0;
            else
                return (int) 1e8;
        }
        int take = arr[idx][2] + sol(idx + 1, N, A + arr[idx][0], B + arr[idx][1], x, y, arr);
        int discard = sol(idx + 1, N, A, B, x, y, arr);
        return Math.min(take, discard);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();
        int arr[][] = new int[N][3];
        for (int j = 0; j < N; j++) {
            arr[j][0] = sc.nextInt();
            arr[j][1] = sc.nextInt();
            arr[j][2] = sc.nextInt();
        }
        if (x == 0 && y == 0)
            System.out.println(0);
        else {
            int result = sol(0, N, 0, 0, x, y, arr);
            if (result >= (int) 1e8)
                System.out.println(-1);
            else
                System.out.println(result);
        }
        sc.close();
    }
}
