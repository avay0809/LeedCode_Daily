class Solution {
    int LEFT = 0;
    int UP = 1;
    int MOD = 1_000_000_007;
    int m, n;

    public int uniquePaths(int[][] grid) {
        m = grid.length;
        n = grid[0].length;

        // t[row][col][LEFT] = ways to reach this cell by entering from the left
        // t[row][col][UP]   = ways to reach this cell by entering from above
        int[][][] t = new int[m][n][2]; // Java initializes to 0

        // Start cell: one way to be here (start is never a mirror, slot is arbitrary)
        t[0][0][LEFT] = 1;

        // Prefill 0th row: one way to reach each cell, until the first mirror
        for (int col = 1; col < n; col++) {
            t[0][col][LEFT] = 1;
            if (grid[0][col] == 1)
                break; // deflected down, cells beyond stay 0
        }

        // Prefill 0th column: one way to reach each cell, until the first mirror
        for (int row = 1; row < m; row++) {
            t[row][0][UP] = 1;
            if (grid[row][0] == 1)
                break; // deflected right, cells below stay 0
        }

        // Fill the rest
        for (int row = 1; row < m; row++) {
            for (int col = 1; col < n; col++) {

                // Entering from the left neighbour (row, col-1)
                if (grid[row][col - 1] == 1)
                    t[row][col][LEFT] = t[row][col - 1][UP]; // mirror: only UP-entrants turn right
                else
                    t[row][col][LEFT] = (t[row][col - 1][LEFT] + t[row][col - 1][UP]) % MOD;

                // Entering from the top neighbour (row-1, col)
                if (grid[row - 1][col] == 1)
                    t[row][col][UP] = t[row - 1][col][LEFT]; // mirror: only LEFT-entrants turn down
                else
                    t[row][col][UP] = (t[row - 1][col][LEFT] + t[row - 1][col][UP]) % MOD;
            }
        }

        // Destination is always empty: every arrival counts, from either side
        return (t[m - 1][n - 1][LEFT] + t[m - 1][n - 1][UP]) % MOD;
    }
}