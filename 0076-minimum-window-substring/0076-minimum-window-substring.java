class Solution {
    public String minWindow(String s, String t) {
        int[] arr = new int[128];

        for (int i = 0; i < t.length(); i++) {
            arr[t.charAt(i)]++;
        }

        int left = 0, count = t.length();
        int min = Integer.MAX_VALUE;
        int start = 0;

        for (int right = 0; right < s.length(); right++) {

            char ch = s.charAt(right);

            if (arr[ch] > 0) {
                count--;
            }
            arr[ch]--;

            while (count == 0) {

                if (right - left + 1 < min) {
                    min = right - left + 1;
                    start = left;
                }

                arr[s.charAt(left)]++;

                if (arr[s.charAt(left)] > 0) {
                    count++;
                }

                left++;
            }
        }

        if (min == Integer.MAX_VALUE) return "";

        return s.substring(start, start + min);
    }
}