package maths;

public class Power {
    public static int pow(int n , int x) {
        int result = 1;
        while (x > 0) {
            if((x&1) == 1){
                result*=n;
            }
            n*=n;
            x>>=1;
        }

        return result;
    }
    public static int pow(int n , int x, int range) {
        long result = 1L;
        while (x > 0) {
            if((x&1) == 1){
                result = (result * n)%range;
            }
            n = (int)(((long)n*n)%range);
            x>>=1;
        }

        return (int)result;
    }
    public static void main(String[] args) {
        int n = 2, x = 9;
        System.out.println(pow(n, x));
        
    }
    
}
