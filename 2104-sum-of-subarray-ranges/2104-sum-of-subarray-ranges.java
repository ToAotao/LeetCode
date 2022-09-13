class Solution {
    public long subArrayRanges(int[] nums) {
        return findMaxSum(nums) - findMinSum(nums);
        
    }
    public long findMinSum(int[] nums) {
        long res = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i <= nums.length; i++) {
            
            while (!stack.isEmpty() && (i == nums.length || nums[i] < nums[stack.peek()])) {
                int right = stack.pop();
                int left = stack.isEmpty()? -1 : stack.peek();
                res += nums[right] * (long)(right - left) * (i - right);
            }
            stack.push(i);
        }
        return res;
    }
    public long findMaxSum(int[] nums) {
        long res = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i <= nums.length; i++) {
            while (!stack.isEmpty() && (i == nums.length || nums[i] > nums[stack.peek()])) {
                int right = stack.pop();
                int left = stack.isEmpty()? -1 : stack.peek();
                res += nums[right] * (long)(right - left) * (i - right);
            }
            stack.push(i);
        }
        return res;
    }
}