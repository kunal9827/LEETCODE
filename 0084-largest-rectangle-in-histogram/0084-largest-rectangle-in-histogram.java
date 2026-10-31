class Solution {
    public int largestRectangleArea(int[] arr) {
        int n = arr.length;
        int max = 0;
        int left[] = new int[n];
        int right[] = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) 
                st.pop();

            if (st.isEmpty()) left[i] = -1;
            else left[i] = st.peek();
            st.push(i);
        }
        st.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) 
                st.pop();
            
            if (st.isEmpty()) right[i] = n;
            else right[i] = st.peek();
            st.push(i);
        }
        // Calculate Area
        for (int i = 0; i < n; i++) {
            int h = arr[i];
            int w = right[i] - left[i] - 1;
            int area = h * w;
            max = Math.max(max, area);
        }
        return max;
    }
}