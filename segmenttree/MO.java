package segmenttree;

// range sum for array

public class MO {
    int gap;
    int[] sum;
    int[] arr;

    MO(int a[]) {
        arr = a;
        int n = arr.length;
        gap = (int) Math.sqrt(n);
        sum = new int[n / gap];
        for (int i = 0; i < sum.length; i++) {
            int s = 0, k = i * gap;
            for (int j = 0; j < gap; j++) {
                s += arr[j + k];
            }
            sum[i] = s;
        }
    }

    int query(int l, int r) {

        int leftStart = (l + gap - 1) / gap;
        int rightStart = r / gap;
        int s = 0;

        if (leftStart <= rightStart) {
            for (int i = l; i <= r; i++)
                s += arr[i];
        } else {
            // for l to m * gap - 1;
            for (int i = leftStart * gap - 1; i >= l; i--)
                s += arr[i];
            // for middle values from m * gap to n * gap - 1
            for (int i = leftStart; i < rightStart; i++)
                s += sum[i];
            // last end values from n*gap to r
            for (int i = rightStart * gap; i <= r; i++)
                s += arr[i];
        }

        return s;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 5, 3, 2, 4, 3, 6, 5, 2, 1, 1 };
        MO mo = new MO(arr);
        System.out.println(mo.query(1, 1));
    }

}
