package arrays;
import java.util.*;

public class CountOverlappingIntervals {
    public static void main(String[] args) {
        int result = count(
            Arrays.asList(1,2,3,4), Arrays.asList(2,3,4,5));
        System.out.println(result);

    }
    static class Interval{
        int x; 
        int y;
        Interval(int _x, int _y){
            x = _x;
            y = _y;
        }
    }
    public static int count(List<Integer> starting, List<Integer> ending) {
        List<Interval> intervals = new ArrayList<>();
        for(int i = 0; i<starting.size(); i++){
            intervals.add(new Interval(starting.get(i),ending.get(i)));
        }
        Collections.sort(intervals, (a, b)->a.x - b.x);
        int n = 0;
        if (intervals.get(0).y <= intervals.get(1).x)
            n++;
        for (int i = 1; i < starting.size() - 1; i++) {
            if (intervals.get(i).x >= intervals.get(i - 1).y && intervals.get(i).y <= intervals.get(i + 1).x) {
                n++;
            }
        }
        if ( intervals.get(intervals.size() - 1).x >= intervals.get(intervals.size() - 2).y)
            n++;
        return n;
    }
}
