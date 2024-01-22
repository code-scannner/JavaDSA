package utilities;
// import java.util.*;

public class stringBuilder {
    public static void main(String[] args) {
        StringBuilder str = new StringBuilder();
        str.append("Dear, Shreyansh Gupta");
        // StringBuilder string = "dfdfdf"; // not allowed
        // str.delete(0, 6);
        // str.deleteCharAt(0);
        // final String result = str.substring(0,3);
        final String result2 = str.substring(3);
        System.out.println(result2);
    }
}
