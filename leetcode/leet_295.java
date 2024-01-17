package leetcode;

import java.util.*;

class MedianFinder {
    PriorityQueue<Integer> max;
    PriorityQueue<Integer> min;

    public MedianFinder() {
        max = new PriorityQueue<>(Collections.reverseOrder());
        min = new PriorityQueue<>();
        // Numbers from 1 to 100
        max.add(Integer.MIN_VALUE);
        min.add(Integer.MAX_VALUE);
    }

    public void addNum(int num) {
        
        if(num > min.peek())
            min.add(num);
        else
            max.add(num);

        if(max.size() < min.size()){
            max.add(min.poll());
        }
        else if(max.size() - min.size() > 1){
            min.add(max.poll());
        }

    }

    public double findMedian() {
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
        System.out.println(median.findMedian());
    }
}
