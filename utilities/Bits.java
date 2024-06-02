package utilities;

public class Bits {
    static public int setAllOnes(int num) {
        int res = 0;
        while (num > 0) {
            res<<=1;
            res|=1;
            num >>=1;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(setAllOnes(256));
    }
}
