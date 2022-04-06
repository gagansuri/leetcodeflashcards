public class SumInAnArray {


    public static void main(String[] args) {
        int[] arr=new int[]{1,2,3,9,7};
        int target=12;
        int res[]=findSumPositions(arr,target);

        if(res[0]==2 && res[1]==3) System.out.println("worked correctly");
        else System.out.println("wrong answer");
    }


    private static int[] findSumPositions(int[]nums,int target) {
        int result[]=new int[2];
        int size=nums.length;
        if(nums==null || size==0 || size==1) return null;

        for(int i=0;i<size;i++) {
            int toFind=target-nums[i];
            for(int j =i+1;j<size;j++) {
                if(toFind==nums[j]) {
                    result[0]=i;
                    result[1]=j;
                    return result;
                }

            }
        }
        return null;
    }

}
