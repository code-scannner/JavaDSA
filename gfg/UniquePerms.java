package gfg;
import java.util.*;

public class UniquePerms {
    static ArrayList<ArrayList<Integer>> ans;
    static void solve(ArrayList<Integer> arr,int i, ArrayList<Integer> list ){
        if(i < 0){
            ans.add(new ArrayList<>(list));
            return;
        }

        // take 
        list.add(arr.get(i));
        solve(arr, i - 1, list);
        list.remove(list.size() - 1);

        // don't take
        i--;
        while(i >= 0 && arr.get(i) == arr.get(i + 1)) i--;
        solve(arr, i, list);
    }
    static ArrayList<ArrayList<Integer>> uniquePerms(ArrayList<Integer> arr , int n) {
        // code here
        ans = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        Collections.sort(arr);
        solve(arr, arr.size() - 1, list);
        return ans;
    }
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(1);
        arr.add(2);
        arr.add(2);
        arr.add(3);
        System.out.println(uniquePerms(arr, arr.size()));

    }
}
