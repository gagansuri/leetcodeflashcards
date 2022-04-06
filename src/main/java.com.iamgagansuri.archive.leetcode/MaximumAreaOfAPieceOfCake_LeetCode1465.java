import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class MaximumAreaOfAPieceOfCake_LeetCode1465 {
        public static int maxArea(int h, int w, String[] horizontalCuts, String[] verticalCuts) {
            Arrays.sort(horizontalCuts);
            Arrays.sort(verticalCuts);
        /*
        find the maximum size of the intervals both horizontal and vertical
        the first cut horizontal or vertical will have its interval equal to the cut and the last interval will have its interval calculated by subtracting from h or w respectively.
        */
            int previousH=0,maxH=0,previousV=0,maxV=0;
            for(int i =0;i<horizontalCuts.length;i++) {
                int interval = Integer.parseInt(horizontalCuts[i])-previousH;
                previousH=Integer.parseInt(horizontalCuts[i]);
                //System.out.println("hinterval : "+interval);
                maxH=Math.max(maxH,interval);
            }

            maxH=Math.max(maxH,h-Integer.parseInt(horizontalCuts[horizontalCuts.length-1]));

            for(int i =0;i<verticalCuts.length;i++) {
                int interval = Integer.parseInt(verticalCuts[i])-previousV;
                previousV=Integer.parseInt(verticalCuts[i]);
                //System.out.println("vinterval : "+interval);
                maxV=Math.max(maxV,interval);
            }
            maxV=Math.max(maxV,w-Integer.parseInt(verticalCuts[verticalCuts.length-1]));

            return maxH*maxV;
        }

    public static void main(String[] args) throws IOException {
        int h=1000000000;
        int w=1000000000;
        String[]hcuts= Files.readAllBytes(Paths.get("/Users/ga001su/Study/FB_Test/src/main/java/hcuts.txt")).toString().split(",");
        String[]vcuts= Files.readAllBytes(Paths.get("/Users/ga001su/Study/FB_Test/src/main/java/vcuts.txt")).toString().split(",");
        maxArea(h,w,hcuts,vcuts);
    }
}

