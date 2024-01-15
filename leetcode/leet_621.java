package leetcode;

public class leet_621 {
    public static int leastInterval(char[] tasks, int n) {
        if (n == 0)
            return tasks.length;
        int map[] = new int[26];
        for (char c : tasks) {
            map[c - 'A']++;
        }

        int max = Integer.MIN_VALUE, freq = 1, sum = 0;
        for (int f : map) {
            if (f > max) {
                max = f;
                freq = 1;
            } else if (max == f)
                freq++;
            sum += f;
        }

        sum -= freq;
        sum -= max - 1;
        if (sum >= (max - 1) * n) {
            return tasks.length;
        }

        
        return tasks.length + Math.max(0, (max - 1) * n - sum);

    }

    public static void main(String[] args) {
        // char tasks[] = {
        // 'A','A','A','A','A','A','B','C','D','E','F','G'
        // };
        // char tasks[] = {
        // 'A','A','A','B','B','B'
        // };
        char tasks[] = {
                'A', 'A', 'A', 'B', 'B', 'C', 'C', 'C', 'D', 'E', 'F', 'F', 'F'
        };
        System.out.println(leastInterval(tasks, 2));
    }
}
