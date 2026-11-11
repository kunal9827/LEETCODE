class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        if (s.charAt(0) == '0') return 0;
        int[] d = new int[n + 1];
        d[0] = 1;
        d[1] = 1;
        for (int i = 2; i <= n; i++) {
            int one = s.charAt(i - 1) - '0';
            int two = (s.charAt(i - 2) - '0') * 10 + (s.charAt(i - 1) - '0');
            if (one >= 1 && one <= 9) {
                d[i] += d[i - 1];
            }
            if (two >= 10 && two <= 26) {
                d[i] += d[i - 2];
            }
        }
        return d[n];
    }
}