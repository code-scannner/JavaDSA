package utilities;
import java.util.*;

public class arrayComparator {
    public static void main(String[] args) {
        int twodArray[][] = new int[][]{
            {74,1},
            {65,1},
            {70,2}
        };
        Arrays.sort(twodArray, (a,b)->a[0] - b[0]);
        for(int i[] : twodArray) System.out.println(Arrays.toString(i));
    }
}
