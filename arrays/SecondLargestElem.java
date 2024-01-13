package arrays;

public class SecondLargestElem {
    public static int secondLargest(int arr[]) {
        if (arr.length == 1)
            return arr[0];
        int largest = arr[0];
        int secondLargest = Integer.MIN_VALUE;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > largest) {
                secondLargest = largest;
                largest = arr[i];
            } else if (arr[i] > secondLargest) {
                secondLargest = arr[i];
            }
        }
        if (secondLargest == Integer.MIN_VALUE) {
            return -1;
        }
        return secondLargest;
    }

    public static void main(String[] args) {
        int arr[] = { 2, 1, 3, 4, 5,6 };

        System.out.println(secondLargest(arr));

    }
}