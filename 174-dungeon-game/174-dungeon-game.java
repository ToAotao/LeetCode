class Solution {
    int[][] memo;
    public int calculateMinimumHP(int[][] dungeon) {
        memo = new int[dungeon.length][dungeon[0].length];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return dp(0,0,dungeon);
        
    }
    public int dp(int i , int j, int[][] dungeon ) {
        int m  = dungeon.length;
        int n = dungeon[0].length;
        if (i == m - 1 && j == n - 1) {
            return dungeon[i][j] >= 0? 1 : -dungeon[i][j] + 1;
        }
        if (i == m || j == n) {
            return Integer.MAX_VALUE;
        }
        

        if (memo[i][j] != -1) return memo[i][j];
        int res = Math.min(dp(i + 1, j, dungeon), dp(i, j+1, dungeon)) - dungeon[i][j];
        memo[i][j] = res <= 0? 1 : res;
        return memo[i][j];
    }

}