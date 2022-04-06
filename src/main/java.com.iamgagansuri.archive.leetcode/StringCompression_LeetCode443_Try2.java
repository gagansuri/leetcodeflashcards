import java.util.Arrays;

public class StringCompression_LeetCode443_Try2
{

    public static int compress(char[] chars) {
        int i=0,j=0,index=0;

        while(i<chars.length) {
            j=i;
            while(j<chars.length && chars[i]==chars[j]) {
                j++;
            }

            // now its different

            //check length = 1 and length >9

            int count = j-i;

            String countDigits=count+"";

            if(count==1) {
                chars[index++]=chars[i];
            }
            else
            {
                chars[index++]=chars[i];
                for(int k=0;k<countDigits.length();k++) {
                    chars[index++]=countDigits.charAt(k);
                }

            }
            i=j;


        }

        return index;
    }

    public static void main(String[] args)
    {
        char[] chars = {'a','a','b','b','c','c','c'};
        System.out.println(compress(chars));
        Arrays.asList(chars).forEach(System.out::println);
    }
}
