public class StringCompression_LeetCode443  {

    public static void main(String[] args) {
        char[] c= new char[]{'a','a','b','b','c','c','c'};
        c=new char[]{'a'};
        System.out.println(compress(c));
    }
    public static int compress(char[] chars) {
        int index=0;//keep track of index to insert in the original array
        // int i=0
        int i=0;
        while(i<chars.length) {
            char current=chars[i];
            int j=i;
            while(j<chars.length && chars[i]==chars[j])  {
                j++;
            }
            //chars[i]!=chars[j]
            chars[index++]=chars[i];
            if(j-i > 1) {
                String count=(j-i)+"";
                for(char c:count.toCharArray()) {
                    chars[index++]=c;
                }
            }
            i=j;
        }

        return index;
    }


}
