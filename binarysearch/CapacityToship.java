package binarysearch;

public class CapacityToship {
    public static int canShip(int[] weights, int capacity) {
        int currCap = 0, days = 1;
        for (int weight : weights) {
            if (weight + currCap > capacity) {
                days++;
                currCap = 0;
            }
            currCap += weight;
        }
        return days;
    }

    public static int shipWithinDays(int[] weights, int days) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int weight : weights) {
            if(weight > max) max = weight;
            sum+=weight;
        }
        int left = max;
        int right = sum;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int daysRequired = canShip(weights, mid);
            if (daysRequired > days) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left;

    }

    public static void main(String[] args) {
        int weights[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        System.out.println(shipWithinDays(weights, 5));
    }
}
