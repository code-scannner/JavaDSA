package dp;

public class OptimalBinarySearchTree {

    public static void main(String[] args) {
        int keys[] = {10,12,20};
        int values[] = {34, 8, 50};

        System.out.println(usingRecursion(0, keys.length - 1, keys, values));

    }

    public static int sum(int freq[], int i, int j){
        int s = 0;
        for(int r = i; r<=j; r++){
            s += freq[r];
        }
        return s;
    }

    public static int usingRecursion(int i, int j, int keys[], int values[]){
        if(i > j) return 0;
        int currsum = sum(values, i, j);
        int min = Integer.MAX_VALUE;
        for(int k = i; k<=j; k++){
            min = Math.min(min, 
                    usingRecursion(i, k - 1, keys, values) + 
                    usingRecursion(k + 1, j, keys, values)
                );
        }

        return min + currsum;
    }
}
