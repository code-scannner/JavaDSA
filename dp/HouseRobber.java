package dp;

public class HouseRobber {
    public static int maximumSumNonAdjacentElem(int arr[]) {
        int n = arr.length;
        if (n == 1)
            return arr[0];
        int far = arr[0], adj = Math.max(arr[0], arr[1]);
        for (int i = 2; i < n; i++) {
            int maximum = Math.max(arr[i] + far, adj);
            far = adj;
            adj = maximum;
        }

        return Math.max(far, adj);

    }

    public static int maximum(int arr[], int l, int r) {
        int n = r - l + 1;
        if (n < 1)
            return 0;
        else if (n == 1)
            return arr[l];
        int far = arr[l], adj = Math.max(arr[l], arr[l + 1]);
        for (int i = l + 2; i <= r; i++) {
            int maximum = Math.max(arr[i] + far, adj);
            far = adj;
            adj = maximum;
        }

        return Math.max(far, adj);
    }

    // array is circular
    public static int HouseRobberII(int arr[]) {
        int n = arr.length;
        return Math.max(maximum(arr, 0, n - 2), maximum(arr, 1, n - 1));
    }

    public static void main(String[] args) {
        int arr[] = { 2, 1, 4, 9 };

        System.out.println(HouseRobberII(arr));

    }

}