public class Solution {
    
    public int minDays(int[][] grid) {
        // Count the number of islands in the grid
        int islands = countIslands(grid);
        
        // Step 1: Check if already disconnected
        if (islands != 1) {
            return 0;
        }
        
        // Step 2: Check if disconnecting with one move
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    grid[i][j] = 0;  // Temporarily change this land to water
                    if (countIslands(grid) != 1) {
                        return 1;
                    }
                    grid[i][j] = 1;  // Revert the change
                }
            }
        }
        
        // Step 3: If no single cell removal works, return 2
        return 2;
    }

    private int countIslands(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int islandCount = 0;
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    islandCount++;
                    dfs(grid, visited, i, j);
                }
            }
        }
        
        return islandCount;
    }

    private void dfs(int[][] grid, boolean[][] visited, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || visited[i][j] || grid[i][j] == 0) {
            return;
        }
        visited[i][j] = true;
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int[] direction : directions) {
            dfs(grid, visited, i + direction[0], j + direction[1]);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        
        int[][] grid1 = {{0, 1, 1, 0}, {0, 1, 1, 0}, {0, 0, 0, 0}};
        int[][] grid2 = {{1, 1}};
        
        System.out.println(solution.minDays(grid1));  // Output: 2
        System.out.println(solution.minDays(grid2));  // Output: 2
    }
}
