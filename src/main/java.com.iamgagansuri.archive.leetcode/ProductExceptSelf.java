import java.util.Arrays;

public class ProductExceptSelf

{
    public int[] productExceptSelf(int[] nums) {
    int temp=1;
        for(int i=0;i<nums.length;i++) {
        temp*=nums[i];
    }
    for(int i=0;i<nums.length;i++) {
        nums[i]=temp/nums[i];
    }
    return nums;
    }

    public static void main(String[] args) {
        int[]nums = {1,2,3,4};
        int[] output={24,12,8,6};
        int[]out=new ProductExceptSelf().productExceptSelf(nums);
        nums = new int[]{5, 4, 2, 6};
        int[]out1=new ProductExceptSelf().productExceptSelfWithouTDivision(nums);
        System.out.println(Arrays.asList(out));
    }


 /*   public int[] productExceptSelfWithouTDivision(int[] nums) {
        int temp=1;
        int[] prod=new int[nums.length];
        for(int i=0;i<nums.length;i++) {
            prod[i]=temp;
            temp*=nums[i];
        }
        temp=1;
        for(int i=nums.length-1;i>=0;i--) {
            prod[i]=prod[i]*temp;
            temp=temp*nums[i];
        }
        return prod;
    }*/





    public int[] productExceptSelfWithouTDivision(int[] nums) {
        int[] product=new int[nums.length];
        int temp=1;
        nums=new int[]{3,4,2,5};
        //calculate the product of all the elements to the left of the element
        //eg. nums {3,4,2,5}
        for(int i=0;i<nums.length;i++) {
            product[i]=temp; //for the first element its 1 since there is nothing to the left of the element
            temp= temp*nums[i]; // multiple the element at i =0 with 1 for i = 0;
        }
        System.out.println(product);
        //product = {1,3,12,24}

        //calculate the product of the all elements to the right of the element
        //now with product of elements to the left and all the elements start from the end of the array and calculate the product except self
        temp =1;
        for(int i=nums.length-1;i>=0;i--) {
            //the last elements already contains the correct value since there is no element to the right of the last element
            product[i]=product[i]*temp;
            temp=temp*nums[i]; //multiply the temp by the last element e.g. 5 so that previous element in product will be multiplied with this number
        }

          // at the end product = {40,30,60,24}
        System.out.println(product);
        return product;

    }































    public int[] productExceptSelfWithouTDivision1(int[] nums) {
        int product[]=new int[nums.length];
        for(int i=0;i<nums.length;i++) {
            product[i]=1;
        }
        //take the multiple of all the elements to the left of the element
        /*
        {3,4,5,1}
        {1,3,12,60} --> 1 , 3 , 3*4=12, 4*5=20
        {
         */
        nums= new int[]{3, 4, 5, 1};
        int temp=1;
        for(int i=0;i<nums.length;i++)
        {
            product[i]=temp;
            temp=temp*nums[i];
        }

        System.out.println(product);

        //take the multiple of all the elemets to the right of the element starting from the end
/*        {3,4,5,1}
step 1        {1,3,12,60} --> 1 , 3 , 3*4=12, 4*5=20

tep 2     {          20,15 ,12,60}
*/
        temp=1;
        for(int i=nums.length-1;i>=0;i--) {
            product[i]=product[i]*temp;
            temp=temp*nums[i];
        }

        return product;

    }










}