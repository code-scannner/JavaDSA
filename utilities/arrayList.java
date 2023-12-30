package utilities;
import java.util.*;

public class arrayList {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(4);
        list.add(5);

        // list to array for premitive data type
        // int array[] = list.stream().mapToInt(Integer::intValue).toArray();

        // to reverse the list;
        // Collections.reverse(list);


        // array to list 
        List<Integer> listing = Arrays.asList(1,2,3,4);
        System.out.println(listing);

        // creating a 2dlist 
        List<int []> twodList = new ArrayList<int []>();
        twodList.add(new int[]{1,2});
        twodList.add(new int[]{4,5});

        // int toarray[][] = twodList.toArray(new int [0][0]);

        // for (int[] i : toarray) {
            // System.out.println(Arrays.toString(i));
        // }


        // copy a list
        // List<Integer> cloned = new ArrayList<>(listing);
        // cloned.add(5);
        // System.out.println(cloned);

        // remove element
        // System.out.println(list);
        // list.remove(list.size() - 1);
        // System.out.println(list);


    }
}
