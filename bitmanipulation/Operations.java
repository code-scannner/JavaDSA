package bitmanipulation;

public class Operations {
    public static void main(String[] args) {
        System.out.println(reverseBits(6));
        System.out.println(complementBits(8));
        System.out.println(countBits(31));
    }

    public static int countBits(int num) {
        int count = 0;
        while (num != 0) {
            if ((num & 1) == 1)
                count++;
            num = num >> 1;
        }
        return count;
    }
    // n is positive
    public static int reverseBits(int n) {
        int reversed = 0;
        while (n != 0) {
            reversed <<= 1;
            reversed |= (n & 1);
            n >>= 1;
        }

        return reversed;
    }

    public static int complementBits(int n) {
        int complemented = 0;
        int i = 0;
        while (n != 0) {
            complemented |= (1 - (n & 1)) << i;
            i++;
            n >>= 1;
        }
        return complemented;
    }

    
}
