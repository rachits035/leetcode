import java.util.*;

class Solution {
    int n, m;
    int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}}; 

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> ans = new ArrayList<>();
        n = heights.length;
        m = heights[0].length;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                boolean[][] visitedPacific = new boolean[n][m];
                boolean[][] visitedAtlantic = new boolean[n][m];

                boolean pacific = dfsPacific(i, j, heights, heights[i][j], visitedPacific);
                boolean atlantic = dfsAtlantic(i, j, heights, heights[i][j], visitedAtlantic);

                if(pacific && atlantic){
                    ans.add(Arrays.asList(i,j));
                }
            }
        }

        return ans;
    }

    private boolean dfsPacific(int i, int j, int[][] heights, int prev, boolean[][] visited){
        if(i <= 0 || j <= 0) return true; 
        visited[i][j] = true;

        for(int[] d : dirs){
            int ni = i + d[0];
            int nj = j + d[1];

            if(ni < 0 || nj < 0 || ni >= n || nj >= m || visited[ni][nj])
                continue;

            if(heights[ni][nj] <= heights[i][j]){
                if(dfsPacific(ni, nj, heights, heights[ni][nj], visited))
                    return true;
            }
        }

        return false;
    }

    private boolean dfsAtlantic(int i, int j, int[][] heights, int prev, boolean[][] visited){
        if(i >= n-1 || j >= m-1) return true; 

        visited[i][j] = true;

        for(int[] d : dirs){
            int ni = i + d[0];
            int nj = j + d[1];

            if(ni < 0 || nj < 0 || ni >= n || nj >= m || visited[ni][nj])
                continue;

            if(heights[ni][nj] <= heights[i][j]){
                if(dfsAtlantic(ni, nj, heights, heights[ni][nj], visited))
                    return true;
            }
        }

        return false;
    }
}
