import java.util.*;

class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
        boolean[][] visited = new boolean[n][n];
        
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        pq.offer(new int[]{grid[0][0], 0, 0});
        
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int time = cur[0], i = cur[1], j = cur[2];
            
          
            if (visited[i][j]) continue;
            visited[i][j] = true;
            
            if (i == n - 1 && j == n - 1) return time;
            
            for (int[] d : directions) {
                int ni = i + d[0], nj = j + d[1];
                if (ni >= 0 && nj >= 0 && ni < n && nj < n && !visited[ni][nj]) {
                    int newTime = Math.max(time, grid[ni][nj]);  
                    pq.offer(new int[]{newTime, ni, nj});
                }
            }
        }
        
        return -1; 
    }
}
