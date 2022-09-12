class Solution {
    public int sumSubarrayMins(int[] arr) {
          long res = 0;
        int len = arr.length;
        int mod = (int)1e9 + 7;
        //cc
        if (arr == null || len == 0) return (int)res;
        
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i <= len; i++) {
            int curr = i < len ? arr[i] : -1;
            
            while (!stack.isEmpty() && arr[stack.peek()] > curr) {
                int right = stack.pop();
                int left = stack.isEmpty() == true ? -1 : stack.peek();
                res += (long)(right - left) * (i - right) * arr[right];
            }
            stack.push(i);
        }
        res = res % mod;
        return (int)res;
    }
}