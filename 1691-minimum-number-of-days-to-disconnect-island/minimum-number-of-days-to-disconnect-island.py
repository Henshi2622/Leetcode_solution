class Solution(object):
    def minDays(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        def is_connected(grid):
            # Helper function to check if the grid is connected (i.e., only one island exists).
            def dfs(x, y):
                if x < 0 or x >= len(grid) or y < 0 or y >= len(grid[0]) or grid[x][y] == 0:
                    return
                grid[x][y] = 0
                for dx, dy in [(-1, 0), (1, 0), (0, -1), (0, 1)]:
                    dfs(x + dx, y + dy)

            found = False
            for i in range(len(grid)):
                for j in range(len(grid[0])):
                    if grid[i][j] == 1:
                        if found:
                            return False  # Found another island, grid is disconnected
                        found = True
                        dfs(i, j)
            return found

        def count_islands():
            # Counts the number of islands in the grid.
            temp_grid = [row[:] for row in grid]
            islands = 0
            for i in range(len(temp_grid)):
                for j in range(len(temp_grid[0])):
                    if temp_grid[i][j] == 1:
                        islands += 1
                        dfs(i, j)
            return islands

        # If the grid is already disconnected
        if not is_connected([row[:] for row in grid]):
            return 0

        # Check if disconnecting the grid is possible in one day
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == 1:
                    grid[i][j] = 0
                    if not is_connected([row[:] for row in grid]):
                        return 1
                    grid[i][j] = 1

        # If not possible in one day, it will take 2 days
        return 2

# Example usage:
solution = Solution()
grid1 = [[0,1,1,0],[0,1,1,0],[0,0,0,0]]
grid2 = [[1,1]]
print(solution.minDays(grid1))  # Output: 2
print(solution.minDays(grid2))  # Output: 2

        