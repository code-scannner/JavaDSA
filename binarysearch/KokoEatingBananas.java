package binarysearch;

public class KokoEatingBananas {
    public static int timeTaken(int bananas[], int speed) {

        int time = 0;
        for (int b : bananas) {
            time += (b + speed - 1) / speed;
        }

        return time;
    }

    public static int minSpeedtoEat(int bananas[], int timeReq) {

        int max = Integer.MIN_VALUE;
        for (int banana : bananas) {
            if (banana > max)
                max = banana;
        }

        int left = 1;
        int right = max;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int timeTook = timeTaken(bananas, mid);
            if (timeTook > timeReq) {
                left = mid + 1;
            } else
                right = mid - 1;
        }

        return left;
    }

    public static void main(String[] args) {
        int bananas[] = { 3, 6, 7, 11 };
        // speed = 2, time = 2 + 3 + 4 + 6 = 15
        // speed = 3, time = 1 + 2 + 3 + 4 = 10
        // speed = 4, time = 1 + 2 + 2 + 3 = 8
        System.out.println(minSpeedtoEat(bananas, 15));
    }
}
