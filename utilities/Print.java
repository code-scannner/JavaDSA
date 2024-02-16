package utilities;
import java.util.*;

public class Print {
    public static void array(int arr[]){
        System.out.println(Arrays.toString(arr));
    }
    public static void array(boolean arr[]){
        System.out.println(Arrays.toString(arr));
    }
    public static void matrix(int matrix[][]) {
        for(int is[] : matrix){
            array(is);
        }
    }
    public static void matrix(boolean matrix[][]) {
        for(boolean is[] : matrix){
            array(is);
        }
    }
}
