import java.util.Arrays;

public class RotateArray {


    public static void main(String[] args) {
            int nume[] = new int[] {1,2,3,4,5,6,7};
            int k = 3;

        rotateFinal(nume,k);
        System.out.println(nume);
    }
    public static void rotate(int[] nums, int k) {
        k = k % nums.length;
        if(k==0 || k > nums.length) return;
        int[] temp=new int[nums.length];
        int backPointer=nums.length-k;
        for(int i=0;i<nums.length;i++) {
            temp[i]=nums[backPointer];
            backPointer++;
            backPointer=backPointer%nums.length;
        }
        for(int i=0;i<nums.length;i++) {
            nums[i]=temp[i];
        }
        System.out.println(temp);


        /*
        1,2,3,4,5,6,7
        rotate 3 =
        r1:  7 1 2 3 4 5 6
        r2 : 6 7 1 2 3 4 5
        r3 : 5 6 7 1 2 3 4

        *
         */

    }

    public static void rotateInline(int[] nums, int k) {


    }

    public static void rotateWithExtraArray(int[] nums, int k) {
        int copyArray[]= nums.clone();
        for(int i=0;i<nums.length;i++) {
            nums[(i+k)%nums.length]=copyArray[i];
        }
        System.out.println("");
    }


    public static void NotGoodrotateWithReverse(int[] nums, int k) {
        int length=nums.length;
        for(int i=0;i<nums.length/2;i++) {
            int temp=nums[i];
            nums[i]=nums[length-1-i];
            nums[length-1-i]=temp;
        }

        //reverse i = 0 to i<k
        for(int i=0;i<k/2;i++) {
            int temp=nums[i];
            nums[i]=nums[k-1-i];
            nums[k-1-i]=temp;
        }
        // reverse i=k to i < length
        for(int i=0;i<(length-k)/2;i++) {
            int temp=nums[i+k];
            nums[i+k]=nums[length-1-i];
            nums[length-1-i]=temp;
        }

        System.out.println(nums);
    }
    static void rotateFinal(int[] num, int k) {
        rotateArr(num,0,num.length-1);
        rotateArr(num,0,k-1);
        rotateArr(num,k,num.length-1);

    }

    static void rotateArr(int[] num,int start,int end) {
        while(start<end) {
            int temp=num[start];
            num[start]=num[end];
            num[end]=temp;
            start++;
            end--;
        }


    }

    }
