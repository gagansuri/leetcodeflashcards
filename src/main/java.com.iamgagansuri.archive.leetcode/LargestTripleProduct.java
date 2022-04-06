

import java.io.*;
        import java.util.*;
// Add any extra import statements you may need here


public class LargestTripleProduct {

    // Add any helper functions you may need here
    static int max(int a ,int b,int c ) {
        int greaterof2=a>=b?a:b;
        return greaterof2>=c?greaterof2:c;
    }

    static int min(int a ,int b,int c ) {
        int lesserof2=a<=b?a:b;
        return lesserof2<=c?lesserof2:c;
    }

    int[] findMaxProduct(int[] arr) {
        int[] out=new int[arr.length];
        int[] firstThree = new int[3];
        firstThree=Arrays.copyOfRange(arr, 0, 3);
        Arrays.sort(firstThree);
        int max1 = firstThree[2], max2 = firstThree[1], max3 = firstThree[0];
        int min1 = firstThree[0], min2 = firstThree[1];


        for (int i = 3; i < arr.length; i++) {
            int n = arr[i];
            if (n > max1) {
                max3=max2;
                max2=max1;
                max1=n;

            } else if (n > max2) {
                max3 = max2;
                max2 = n;
            } else if (n > max3) {
                max3 = n;
            }


            if (n < min1) {
                min2 = min1;
                min1 = n;
            } else if (n < min2) {
                min2 = n;

            }

            out[i] = Math.max(max1 * max2 * max3, max1 * min1 * min2);
        }
        out[0] = -1;
        out[1] = -1;
        out[2] = arr[0] * arr[1] * arr[2];
        return out;
    }
    int[] findMaxProductWorking(int[] arr) {
        // Write your code here
        int[] out=new int[arr.length];
        int highestPof3=arr[0]*arr[1]*arr[2]; //24

        int highestPof2=arr[0]*arr[1];  //6
        int lowestPof2=arr[0]*arr[1];   //6

        int highestNumberTillNow=Math.max(arr[0],arr[1]);  //3
        int lowestNumberTillNow=Math.min(arr[0],arr[1]);   //2

        // 2,3,4,5,-1,-5

        out[0]=-1;out[1]=-1;out[2]=arr[0]*arr[1]*arr[2];
        for(int i=2;i<arr.length;i++) {
            highestPof3=max(highestPof3,arr[i]*highestPof2,arr[i]*lowestPof2);

            highestPof2=max(highestPof2,arr[i]*highestNumberTillNow,arr[i]*lowestNumberTillNow);

            lowestPof2=min(lowestPof2,arr[i]*lowestNumberTillNow,arr[i]*highestNumberTillNow);


            highestNumberTillNow=Math.max(highestNumberTillNow,arr[i]);
            lowestNumberTillNow=Math.min(lowestNumberTillNow,arr[i]);
            out[i]=highestPof3;

        }
        return out;



    }




int findMaxProductAll(int[] arr)  {
        int max1=arr[0],max2=arr[0],max3=arr[0],min1=arr[0],min2=arr[0];




        for(int i=0;i<arr.length;i++) {
            if(arr[i]>=max1) {
              max1=arr[i];
              max2=max1;
              max3=max2;
            } else if(arr[i]>=max2) {
                max2=arr[i];
                max3=max2;
            } else if(arr[i]>=max3) {
                max3=arr[i];
            }


            if(arr[i]<=min1) {
                min1=arr[i];
                min2=min1;

            } else if(arr[i]<=min2) {
                min2=arr[i];
            }
        }

return Math.max(max1*max2*max3,max1*min1*min2);
}







    // These are the tests we use to determine if the solution is correct.
    // You can add your own at the bottom, but they are otherwise not editable!
    int test_case_number = 1;

    void check(int[] expected, int[] output) {
        int expected_size = expected.length;
        int output_size = output.length;
        boolean result = true;
        if (expected_size != output_size) {
            result = false;
        }
        for (int i = 0; i < Math.min(expected_size, output_size); i++) {
            result &= (output[i] == expected[i]);
        }
        char rightTick = '\u2713';
        char wrongTick = '\u2717';
        if (result) {
            System.out.println(rightTick + " Test #" + test_case_number);
        }
        else {
            System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
            printIntegerArray(expected);
            System.out.print(" Your output: ");
            printIntegerArray(output);
            System.out.println();
        }
        test_case_number++;
    }

    void printIntegerArray(int[] arr) {
        int len = arr.length;
        System.out.print("[");
        for(int i = 0; i < len; i++) {
            if (i != 0) {
                System.out.print(", ");
            }
            System.out.print(arr[i]);
        }
        System.out.print("]");
    }

    public void run() {
        int[] arr_1 = {1, 2, 3, 4, 5};
        int[] expected_1 = {-1, -1, 6, 24, 60};
        int[] output_1 = findMaxProduct(arr_1);
        check(expected_1, output_1);

        int[] arr_2 = {2, 4, 7, 1, 5, 3};
        int[] expected_2 = {-1, -1, 56, 56, 140, 140};
        int[] output_2 = findMaxProduct(arr_2);
        check(expected_2, output_2);

        // Add your own test cases here

    }

    public static void main(String[] args) {
        new LargestTripleProduct().run();
    }
}