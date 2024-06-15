package strings;

public class RabinKarp {
    
    public static int match(char[] word, char[] patt) {
        int MAX = 127;
        long pattHash = 0;
        for(char c : patt) pattHash = pattHash*127 + c;
        long mod = (long)Math.pow(MAX, patt.length - 1);
        long currHash = 0;
        for(int i = 0; i<word.length; i++){
            if(pattHash == currHash) return i - patt.length;
            if(i >= patt.length){
                currHash = currHash%mod;
            }
            currHash = currHash*MAX + word[i];
        }

        return -1;
    }

    public static void main(String[] args) {
        String str = "Welcome to the jungle hello world";
        String patt = " to the ";
        System.out.println(match(str.toCharArray(), patt.toCharArray()));
    }
}
