public class NonDecreasingArray {


    public static void main(String[] args) {
        int nums[]=new int[]{3,4,2,3};
        NonDecreasingArray nd=new NonDecreasingArray();
        System.out.println(nd.checkPossibility(nums));
    }


        public boolean checkPossibility(int[] nums) {
            int count=0;
            int i=0;
            while(i<nums.length-1) {
                if(nums[i]<=nums[i+1]) {
                    i++;
                } else {
                    i++;
                    count++;
                }

            }

            if(count<=1) return true;

            return false;
        }
    }

