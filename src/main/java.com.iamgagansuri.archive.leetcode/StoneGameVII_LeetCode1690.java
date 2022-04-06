public class StoneGameVII_LeetCode1690  {
    public static void main(String[] args) {
        int[] nums={5,3,1,4,2};
        stoneGameVII(nums);
    }
    public static int stoneGameVII(int[] stones) {
        int total=0;
        for(int i=0;i<stones.length;i++) {
            total+=stones[i];
        }
        int aliceSum=0,bobSum=0;
        int i=0,j=stones.length-1;
        boolean aliceTurn=true;
        while(i<j) {

            //alice turn
            if(aliceTurn) {


                if(total-stones[i] > total-stones[j])  {
                    total=total-stones[i];
                    aliceSum+=total;
                    i++;
                }  else {
                    total=total-stones[j];
                    aliceSum+=total;
                    j--;
                }
                aliceTurn=false;
            } else {
                if(total-stones[i] < total-stones[j])  {
                    total=total-stones[i];
                    bobSum+=total;
                    i++;
                }  else  {
                    total=total-stones[j];
                    bobSum+=total;
                    j--;
                }
                aliceTurn=true;


            }
        }


        return aliceSum-bobSum;
    }
}