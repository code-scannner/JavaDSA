package utilities;
// import java.util.*;

public class string {
    public static void main(String[] args) {

        StringBuffer str = new StringBuffer("Hello how are u?");
        StringBuffer str2 = new StringBuffer("hello");
        StringBuilder str3 = new StringBuilder("given data");
        char c = str.charAt(0);
        str.setCharAt(0, str2.charAt(0));
        str2.setCharAt(0, c);
        System.out.println(str);
        System.out.println(str2);
        System.out.println(str3);

        // String msg = "x+5-3+x=6+x-2";
        // System.out.println(Arrays.toString(msg.split("[=]")));

        // String x = "type";
        // String y = "type";


        // System.out.println(
        //     y.compareTo(x)
        // );

        // System.out.println(x == y);

        // System.out.println("applebanana");



    }
}
