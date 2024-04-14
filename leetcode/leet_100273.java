package leetcode;
import java.util.*;

public class leet_100273 {
    public static int sol(int arr[]) {
        Stack<Integer> stk = new Stack<>();
        int count = 0;
        int n = arr.length;
        for(int i = 0; i<=n; i++){
            while(!stk.isEmpty() && (i == n || stk.peek() < arr[i])){
                int cnt = 1;
                int currElem = stk.pop();
                while(!stk.isEmpty() && stk.peek() == currElem){
                    cnt++;
                    stk.pop();
                }
                count += cnt == 1 ? 1 : 3*(cnt - 1);
            }
            if(i < n)
                stk.push(arr[i]);
        }

        return count;
    }
    public static void main(String[] args) {
        int arr[] = {3,3,3,2,2,3,1,4};
        System.out.println(sol(arr));
    }
}
