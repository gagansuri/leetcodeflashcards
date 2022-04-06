public class IsSubSequence_LeetCode392 {



        public static boolean isSubsequence(String s, String t) {
            int j=0;
            for(int i=0;i<s.length();) {
                while(j<t.length() && s.charAt(i)!=t.charAt(j)) {
                    j++;
                }
                if(j>=t.length()) return false;
                i++;j++;
            }
            return true;
        }

    public static void main(String[] args) {
        String s="axc", t="ahbgdc";

        String[] s1={"gagan"};

        System.out.println(isSubsequence(s,t));
    }
}
