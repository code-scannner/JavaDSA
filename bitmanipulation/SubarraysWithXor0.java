package bitmanipulation;

public class SubarraysWithXor0 {
    public static int countTriplets(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            int xor = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                xor ^= arr[j];
                if (xor == 0){
                    count += j - i;
                }

            }
        }

        return count;
    }

    public static void main(String[] args) {
        int arr[] = { 2, 3, 1, 6, 7 };
        System.out.println(countTriplets(arr));
    }
}
