//   73 74 75 71 69 72 76 73

     
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;    
        int[] ans = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = n - 1; i >= 0; i--) {
        
            while (!stack.isEmpty() && temperatures[stack.peek()] <= temperatures[i]) {
                stack.pop();
            }
            ans[i] = stack.isEmpty()? 0 : stack.peek() - i;
            stack.push(i);
        }
        return ans;
    }
}