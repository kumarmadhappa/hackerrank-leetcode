package leetcode;

public class CountServersCommunications {

    public int countServersBruteForce(int[][] grid) {

        int rows =  grid.length;
        int cols = grid[0].length;
        int count = 0;


        for (int r = 0; r<rows; r++){
            for(int c=0; c<cols;c++){
                if(grid[r][c]==1 && checkAdjacent(r, c, grid))
                    count++ ;
            }
        }

        return count;
    }

    private boolean checkAdjacent(int r, int c, int[][] grid) {
        if(checkColumn(r, c, grid))
            return true;

        if(checkRow(r, c, grid))
            return true;

        return false;
    }

    private boolean checkRow(int r, int c, int[][] grid) {
        int i=0;
        while(i<grid[0].length){
            if(i==c){
                i++;
                continue;
            }
            if(grid[r][i] == 1)
                return true;
            i++;
        }
        return false;
    }

    private boolean checkColumn(int r, int c, int[][] grid) {
        int i=0;
        while(i<grid.length){
            if(i==r){
                i++;
                continue;
            }

            if(grid[i][c] == 1)
                return true;
            i++;
        }
        return false;
    }


    public int optimized(int[][] grid) {

        int rows =  grid.length;
        int cols = grid[0].length;
        int count = 0;

        int[] rowServers = new int[rows];
        int[] colServers = new int[cols];

        for (int r = 0; r<rows; r++){
            for(int c=0; c<cols;c++){
                if(grid[r][c]==1){
                    rowServers[r]++;
                    colServers[c]++;
                }

            }

        }

        for (int r = 0; r<rows; r++){
            for(int c=0; c<cols;c++){
                if(grid[r][c]==1 && checkRowCol(r, c, rowServers, colServers))
                    count++ ;
            }
        }
        return count;
    }

    private boolean checkRowCol(int r, int c, int[] rowServers, int[] colServers) {
        return rowServers[r] > 1 || colServers[c] > 1;
    }



    public static void main(String[] args) {
        CountServersCommunications c = new CountServersCommunications();
        System.out.println(c.countServersBruteForce(new int[][]{{1,0},{1,1}}));
        System.out.println(c.countServersBruteForce(new int[][]{{1,1,0,0},{0,0,1,0},{0,0,1,0},{0,0,0,1}}));
        System.out.println(c.countServersBruteForce(new int[][]{{1,0,0,1,0},{0,0,0,0,0},{0,0,0,1,0}}));

        System.out.println("Optimized::");
        System.out.println(c.optimized(new int[][]{{1,0},{1,1}}));
        System.out.println(c.optimized(new int[][]{{1,1,0,0},{0,0,1,0},{0,0,1,0},{0,0,0,1}}));
        System.out.println(c.optimized(new int[][]{{1,0,0,1,0},{0,0,0,0,0},{0,0,0,1,0}}));

    }
}
