package utilities;
import java.util.*;

public class arrayList {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(4);
        list.add(5);

        // list to array for premitive data type
        int array[] = list.stream().mapToInt(Integer::intValue).toArray();


        // creating a 2dlist 
        List<int []> twodList = new ArrayList<int []>();
        twodList.add(new int[]{1,2});
        twodList.add(new int[]{4,5});

        int toarray[][] = twodList.toArray(new int [0][0]);

        for (int[] i : toarray) {
            System.out.println(Arrays.toString(i));
        }

    }
}
