class Solution {
    public int maxPathScore(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;

        Integer[][][] dp = new Integer[m][n][k + 1];

        int ans = helper(0, 0, grid, k, dp);
        return ans == Integer.MIN_VALUE ? -1 : ans;
    }

    static int helper(int i, int j, int[][] grid, int k, Integer[][][] dp) {

      
        if (i >= grid.length || j >= grid[0].length) {
            return Integer.MIN_VALUE;
        }

    
        int cost = (grid[i][j] == 0) ? 0 : 1;

        if (k - cost < 0) return Integer.MIN_VALUE;


        if (i == grid.length - 1 && j == grid[0].length - 1) {
            return grid[i][j];
        }

 
        if (dp[i][j][k] != null) {
            return dp[i][j][k];
        }

        int right = helper(i, j + 1, grid, k - cost, dp);
        int down  = helper(i + 1, j, grid, k - cost, dp);

        int best = Integer.MIN_VALUE;

        if (right != Integer.MIN_VALUE) {
            best = Math.max(best, grid[i][j] + right);
        }

        if (down != Integer.MIN_VALUE) {
            best = Math.max(best, grid[i][j] + down);
        }

        return dp[i][j][k] = best;
    }
}