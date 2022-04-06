public class LongPressedName_LeetCode925 {


        public static  boolean isLongPressedName(String name, String typed) {
            StringBuffer sb =new StringBuffer(typed);
            if(name.equals(typed)) return true;
int len=sb.length();
            for(int i=0;i<len-1;i++) {
                if(sb.charAt(i)==sb.charAt(i+1)) {
                    sb.deleteCharAt(i);
                    if(sb.toString().equals(name)) return true;
                }
            }
            System.out.println(sb);
            return false;
        }


    public static void main(String[] args) {
        String name="a";
        String type="aaaaaaaaaaaaaaaaa";
        isLongPressedName(name,type);
    }
}
