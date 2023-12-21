public class Lexco {
    public static boolean lcs (String str, String subseq){
            int m = str.length();
            int n = subseq.length();
    
            int [] prev = new int[n + 1];
            int [] curr = new int[n + 1];
            for(int i = 1; i<=m; i++){
                for(int j = 1; j<=n; j++){
                    if(str.charAt(i - 1) == subseq.charAt(j - 1)){
                        curr[j] = prev[j - 1] + 1;
                    }
                    else{
                        curr[j] = Math.max(curr[j - 1] , prev[j]);
                    }
                }

                for(int j = 1; j<=n; j++){
                    prev[j] = curr[j];
                }
            }
    
            return curr[n] == n;
    }
    public static String getValidWord(String s, String dict[]){
        String curr = "z";
        for(int i = 0; i<dict.length; i++){
            if(lcs(s, dict[i]) && curr.compareTo(dict[i]) > 0){
                curr = dict[i];
            }
        }
        return curr;
    } 
    public static void main(String[] args) {
        String str = "hgferyjkllkop";
        String dict [] = new String[] { "coffee", "coding", "happy", "hello", "hop" };

        System.out.println(getValidWord(str, dict));
    }
}
