package utilities;
// import java.util.*;

public class stringBuilder {
    public static void main(String[] args) {
        StringBuilder str = new StringBuilder();
        str.append("Dear, Shreyansh Gupta");
        str.deleteCharAt(2);
        char c = 'b';
        str.append((char)(c - ('a' - 'A')));
        // StringBuilder string = "dfdfdf"; // not allowed
        // str.delete(0, 6);
        // str.deleteCharAt(0);
        // final String result = str.substring(0,3);
        // final String result2 = str.substring(3);
        System.out.println(str);
        // str.delete(0, str.length()); // for clearing the string
        System.out.println(str);
    }
}
