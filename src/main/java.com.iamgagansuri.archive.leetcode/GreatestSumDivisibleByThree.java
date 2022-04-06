/*

1262. Greatest Sum Divisible by Three
Medium

735

20

Add to List

Share
Given an array nums of integers, we need to find the maximum possible sum of elements of the array such that it is divisible by three.



Example 1:

Input: nums = [3,6,5,1,8]
Output: 18
Explanation: Pick numbers 3, 6, 1 and 8 their sum is 18 (maximum sum divisible by 3).
Example 2:

Input: nums = [4]
Output: 0
Explanation: Since 4 is not divisible by 3, do not pick any number.
Example 3:

Input: nums = [1,2,3,4,4]
Output: 12
Explanation: Pick numbers 1, 3, 4 and 4 their sum is 12 (maximum sum divisible by 3).


Constraints:

1 <= nums.length <= 4 * 10^4
1 <= nums[i] <= 10^4
Accepted
26,912
Submissions
53,877


 */
public class GreatestSumDivisibleByThree {
    public static void main(String[] args) {
        int[]nums = new int[]{3,6,5,1,8};
        //assert 12==
        System.out.println(maxSumDivThree(nums));
    }
    public static int maxSumDivThree(int[] nums) {
        int maxSum=0;
        int[][] dp=new int[nums.length][3];
        dp[0][0]=0;
        dp[0][1]=Integer.MIN_VALUE;
        dp[0][2]=Integer.MIN_VALUE;

        for(int i=0;i<nums.length;i++) {
            //first element
            if(i==0) {
                //check what is the remainder for the first element in the array
                //if 0 store the number is 0 column and so on
                /// so we have dp[0][0]=3 now
                dp[i][nums[i]%3]=nums[i];

            } else {
                //check other remainders
                // if remainder is 1 then store then max in 1 else in 2
                   if(nums[i]%3==0) {
                       System.out.println("dp[i-1][0] :"+dp[i-1][0]+",nums[i]+dp[i-1][0] :"+(nums[i]+dp[i-1][0]));
                       dp[i][0]=Math.max(dp[i-1][0],nums[i]+dp[i-1][0]);

                       System.out.println("dp[i-1][1] :"+dp[i-1][1]+",nums[i]+dp[i-1][1] :"+(nums[i]+dp[i-1][1]));


                       dp[i][1]=Math.max(dp[i-1][1],nums[i]+dp[i-1][1]);

                       System.out.println("dp[i-1][2] :"+dp[i-1][2]+",nums[i]+dp[i-1][2] :"+(nums[i]+dp[i-1][2]));

                       dp[i][2]=Math.max(dp[i-1][2],nums[i]+dp[i-1][2]);
                       //other 2 as well
                   } else if(nums[i]%3==1) {
                       //this new number leaves a remainder of 1 so it must be added to dp[i-1][2]
                       /*
                       if the remainder of the current number is 1 , it can be added to the sum with remainder 0 to make the remainder 1
                       or it can be added to the number with remainder 2 to make the remainder 0
                       it can be added to the number with remainder 1 to make the remainder 2



                        */
                       System.out.println("dp[i-1][0] :"+dp[i-1][0]+",dp[i-1][2]+nums[i] :"+(dp[i-1][2]+nums[i]));
                       dp[i][0] = Math.max(dp[i-1][0],dp[i-1][2]+nums[i]);

                       System.out.println("dp[i-1][1] :"+dp[i-1][1]+",dp[i-1][0]+nums[i] :"+(dp[i-1][0]+nums[i]));
                       dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0]+nums[i]);

                       System.out.println("dp[i-1][2] :"+dp[i-1][2]+",dp[i-1][1]+nums[i] :"+(dp[i-1][1]+nums[i]));
                       dp[i][2] = Math.max(dp[i-1][2],dp[i-1][1]+nums[i]);
                }  else if(nums[i]%3==2) {
                        //add to the number with remainder 1 to make remainder 0
                       System.out.println("dp[i-1][0] :"+dp[i-1][0]+",dp[i-1][1]+nums[i] :"+(dp[i-1][1]+nums[i]));
                       dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]+nums[i]);

                       System.out.println("dp[i-1][1] :"+dp[i-1][1]+",dp[i-1][2]+nums[i] :"+(dp[i-1][2]+nums[i]));
                       dp[i][1] = Math.max(dp[i-1][1],dp[i-1][2]+nums[i]);

                       System.out.println("dp[i-1][2] :"+dp[i-1][2]+",dp[i-1][0]+nums[i] :"+(dp[i-1][0]+nums[i]));
                       dp[i][2] = Math.max(dp[i-1][2],dp[i-1][0]+nums[i]);

                   }
                }

            }
return dp[nums.length-1][0];


    }
    public static int maxSumDivThree1(int[] a) {
    int n=a.length;
    int dp[][]=new int [n][3];
        for(int i=0;i<n;i++) {
            if (i == 0) {
                dp[i][a[i] % 3] = a[i];
            } else {
                for (int j = 0; j < 3; j++) {
                    int sum = dp[i - 1][j] + a[i];
                    dp[i][sum % 3] = Math.max(dp[i][sum % 3], sum);
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j]);
                }
            }
        }
        return dp[n-1][0];
        }
}
