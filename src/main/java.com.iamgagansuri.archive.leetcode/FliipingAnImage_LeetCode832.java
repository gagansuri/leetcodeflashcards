public class FliipingAnImage_LeetCode832 {

    public static int[][] flipAndInvertImage(int[][] image) {
        System.out.println(1^1);
        System.out.println(0^1);

        for(int i=0;i<image.length;i++) {
            for(int j =0;j<image[i].length;j++) {
                image[i][j]=image[i][j]^1;
            }
        }
        return image;
    }


    public static void main(String[] args) {
        int[][]image = {{1,1,0},{1,0,1},{0,0,0}};
        flipAndInvertImage(image);
    }
}
