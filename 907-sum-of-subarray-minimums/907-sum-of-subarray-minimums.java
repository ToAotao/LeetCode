class Solution {
    public int sumSubarrayMins(int[] arr) {
        long result = 0;
        int len = arr.length;
        int mod = (int)1e9 + 7;
        if(arr == null || arr.length == 0) return (int)result;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i <= len; i++){
            int cur = (i < len) == true? cur = arr[i] : -1;
        
            while (!stack.isEmpty() && arr[stack.peek()] > cur){
                int right = stack.pop();
                int left = stack.isEmpty()? -1 : stack.peek();
                result += arr[right] * (long)(right - left) * (i - right);
            }
            stack.push(i);
        }
        result = result % mod;
        return (int)(result);
    }
}