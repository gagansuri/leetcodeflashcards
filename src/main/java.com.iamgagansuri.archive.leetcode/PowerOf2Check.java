public class PowerOf2Check
{
    public static boolean checkIfPowerOf2(int n)
    {

        int num=1;
        while(num<n) {
            num=num<<1;
            //System.out.println(num);
        }
    return num==n;
    }


    public static void main(String[] args)
    {
        System.out.println(checkIfPowerOf2(2));
        System.out.println(checkIfPowerOf2(5));
        System.out.println(checkIfPowerOf2(8));
        System.out.println(checkIfPowerOf2(15));
        System.out.println(checkIfPowerOf2(16));
        System.out.println(checkIfPowerOf2(31));
        System.out.println(checkIfPowerOf2(32));
    }
}
