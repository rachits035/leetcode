class Solution {
    public int minOperations(int[][] grid, int x) {

        List<Integer> temp = new ArrayList<>();
        int base = grid[0][0];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {

                
                if ((grid[i][j] - base) % x != 0) {
                    return -1;
                }

                temp.add(grid[i][j]);
            }
        }

        Collections.sort(temp);

        int median = temp.get(temp.size() / 2);

        int total = 0;
        for (int val : temp) {
            total += Math.abs(val - median) / x;
        }

        return total;
    }
}