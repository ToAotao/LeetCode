class Solution {
    int[] memo;
    public int coinChange(int[] coins, int amount) {
        memo = new int[amount + 1];
        Arrays.fill(memo, -123);
        return dp(coins, amount);
    }
    public int dp(int[] coins, int amount) {
        if (amount == 0) return 0;
        if (amount < 0) return -1;
        int res = Integer.MAX_VALUE;
        for (int coin : coins) {
            
            if(memo[amount] != -123){
                return memo[amount];
            }
            int subProgram = dp(coins, amount - coin);
            if (subProgram == -1) continue;
            res = Math.min(res, subProgram + 1);
             
        }
        memo[amount] = res == Integer.MAX_VALUE? -1 : res;
        return memo[amount];
    }
}