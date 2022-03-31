class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int[][] memo = new int[dungeon.length][dungeon[0].length];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return dp(0, 0, dungeon, memo);
        
    }
    public int dp(int i, int j, int[][] dungeon, int[][] memo){
        int m = dungeon.length;
        int n = dungeon[0].length;
        if (i == m || j == n) return Integer.MAX_VALUE;
        if(i == m - 1 && j == n - 1) {
            return dungeon[i][j] >= 0? 1 : -dungeon[i][j] + 1;
        }
        if (memo[i][j] != -1) return memo[i][j];
        int res = Math.min(
            dp(i + 1, j, dungeon, memo),
            dp(i, j + 1, dungeon, memo)
        ) - dungeon[i][j];
        memo[i][j] = res <=0 ? 1 : res;
        return memo[i][j];
    }
}