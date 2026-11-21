class Solution {
public int leastInterval(char[] tasks, int n) {
int[] arr = new int[26];

    for (int i = 0; i < tasks.length; i++) {
        arr[tasks[i] - 'A']++;
    }
    Arrays.sort(arr);
    int max = arr[25];
    int count = 0;
    for (int i = 25; i >= 0; i--) {
        if (arr[i] == max) {
            count++;
        }
    }
    int ans = (max - 1) * (n + 1) + count;
    return Math.max(ans, tasks.length);
}

}