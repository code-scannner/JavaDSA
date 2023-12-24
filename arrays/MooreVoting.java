package arrays;

public class MooreVoting {
    public static int majorityElement(int []v) {
        int elem = v[0], c = 1;
        for(int i = 1; i<v.length; i++){
            if(elem != v[i]) c--;
            else c++;
            
            if(c == 0){
                elem = v[i];
                c = 1;
            }
        }
 
        return elem;
     }
    public static void main(String[] args) {
        int arr[] = {7,7,5,5,4,3,5,7,7,7,5,4,6,7,7,7,7};
        System.out.println(majorityElement(arr));
    }
}
