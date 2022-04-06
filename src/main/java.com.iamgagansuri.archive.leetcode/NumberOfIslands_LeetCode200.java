import java.util.concurrent.atomic.AtomicInteger;

public class NumberOfIslands_LeetCode200 {


    public static void main(String[] args) {
        char[][] grid = new char[][]{{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}};
        numIslands(grid);
    }

    public static int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    count += dfs(i, j, grid);
                }

            }
        }
        return count;
    }

    static int dfs(int i, int j, char[][] grid) {
            if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '1') {
            return 0;
        }
        dfs(i + 1, j, grid);
        dfs(i - 1, j, grid);
        dfs(i, j + 1, grid);
        dfs(i, j - 1, grid);
        return 1;
    }
}

    /*
        public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {

            int oldColor=image[sr][sc];
            dfs(sc,sr,image,newColor,oldColor);
            return image;
        }



        void dfs(int col,int row,int[][]image,int newColor,int oldColor) {
            if(col<0 || row<0 || row>=image.length || col>=image[0].length || image[row][col]!=oldColor || image[row][col]==newColor)
                return;

            image[row][col]=newColor;
            //upper row
            dfs(col,row-1,image,newColor,oldColor);
            //lower row
            dfs(col,row+1,image,newColor,oldColor);
            //left col
            dfs(col-1,row,image,newColor,oldColor);
            //right col
            dfs(col+1,row,image,newColor,oldColor);



        }

*/