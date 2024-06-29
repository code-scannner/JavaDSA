package strings;

public class StringHash {
    public static void main(String[] args) {
        String str = "abcccaabbac";
        System.out.println(hash(str, 'a', 3));
        System.out.println(hash("abcccaabbca", 'a', 3));
    }

    public static long hash(String str, char firstChar, int size) {
        long ans = 0;
        for (char c : str.toCharArray()) {
            ans = ans * size + (c - firstChar + 1);
        }
        return ans;
    }
}
