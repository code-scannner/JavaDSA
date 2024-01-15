package leetcode;

import java.util.*;

class MyCalendar {
    List<int[]> bookings;

    public MyCalendar() {
        bookings = new ArrayList<>();
    }

    public boolean book(int start, int end) {
        int low = 0, high = bookings.size() - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int[] book = bookings.get(mid);
            int books = book[0], booke = book[1];
            if ((books <= start && start < booke) || (books < end && end <= booke)
                    || (start < books && end > booke))
                return false;

            if (end <= books) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        bookings.add(low, new int[]{start, end});

        return true;
    }

    public boolean brute(int start, int end) {
        for (int i = 0; i < bookings.size(); i++) {
            int books = bookings.get(i)[0];
            int booke = bookings.get(i)[1];
            if ((books <= start && start < booke) || (books < end && end <= booke)
                    || (start < books && end > booke)) {
                return false;
            }
        }

        bookings.add(new int[] { start, end });
        return true;
    }

}

public class leet_729 {
    public static void main(String[] args) {
        MyCalendar cal = new MyCalendar();
        System.out.println(cal.book(10, 20));
        System.out.println(cal.book(15, 25));
        System.out.println(cal.book(20, 30));
    }
}
