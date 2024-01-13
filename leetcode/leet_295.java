package leetcode;

import java.util.*;

class MedianFinder {
    PriorityQueue<Integer> max;
    PriorityQueue<Integer> min;

    public MedianFinder() {
        max = new PriorityQueue<>(Collections.reverseOrder());
        min = new PriorityQueue<>();
    }

    public void addNum(int num) {
        
        max.add(num);

        while (max.size() > min.size()) {
            min.add(max.poll());
        }
    }

    public double findMedian() {
        System.out.println(max);
        System.out.println(min);
        if((max.size() + min.size())%2 != 0){
            return (double)max.peek();
        }
        else{
            return (max.peek() + min.peek())/2.0;
        }
    }
}

public class leet_295 {

    public static void main(String[] args) {
        MedianFinder median = new MedianFinder();
        median.addNum(2);
        median.addNum(1);
        System.out.println(median.findMedian());
        median.addNum(4);
        median.addNum(3);
        median.addNum(5);
        median.addNum(6);
        System.out.println(median.findMedian());
    }
}
