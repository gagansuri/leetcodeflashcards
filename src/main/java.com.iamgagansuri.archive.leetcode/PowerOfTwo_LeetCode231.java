public class PowerOfTwo_LeetCode231 {


    public boolean isPowerOfTwo(int n) {
        return (n&(n-1))==0;
    }


    public static void main(String[] args) {
        int n = -2147483648;
        System.out.println("n   :"+(n) );
        System.out.println("n-1 : "+(n-1) );
        System.out.println("&   : "+(n&(n-1)) );

    }
}
