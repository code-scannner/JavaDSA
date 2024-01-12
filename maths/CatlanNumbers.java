package maths;
import java.util.*;

public class CatlanNumbers {
    public static int[] formCatlannumbers(int n){
        int [] catlanNums = new int[n];
        catlanNums[1] = 1;
        catlanNums[2] = 1;
        for (int i = 3; i < catlanNums.length; i++) {
            int left = 1;
            int right = i - 1;
            int num = 0;
            while(left <= right){
                num += catlanNums[left++] * catlanNums[right--];
            }
            num*=2;
            if(i%2 == 0) num-= catlanNums[i/2] * catlanNums[i/2];
            catlanNums[i] = num;
        }

        return catlanNums;

    }
    public static void main(String[] args) {
        
        System.out.println(Arrays.toString(formCatlannumbers(10)));
    }
}
