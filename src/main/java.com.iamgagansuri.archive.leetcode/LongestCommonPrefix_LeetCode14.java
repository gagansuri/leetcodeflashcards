public class LongestCommonPrefix_LeetCode14 {


        public String longestCommonPrefix(String[] strs) {
            StringBuilder sb=new StringBuilder();
            int i =0;
            while(true) {
                for(int j =0;j<strs.length-1;j++) {
                    if(i>strs[0].length() || strs[j].charAt(i)!=strs[j+1].charAt(i)) {
                        return sb.toString();
                    }
                }
                System.out.println("i->"+i +" strs[0] "+strs[0]);
                sb.append(strs[0].charAt(i++));
            }

        }


    public static void main(String[] args) {
        String[] s= {"flower","flow","flight"};
        new LongestCommonPrefix_LeetCode14().longestCommonPrefix(s);
    }
}
