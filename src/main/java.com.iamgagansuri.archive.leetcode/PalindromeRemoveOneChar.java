public class PalindromeRemoveOneChar {


    public static void main(String[] args) {
        String s = "abbca";
        PalindromeRemoveOneChar palindromeRemoveOneChar=new PalindromeRemoveOneChar();
        System.out.println(s +" is : "+palindromeRemoveOneChar.isPalindrome(s));


    }

    boolean isPalindrome(String s) {
        if(s==null || s.length()==0) return false;
        int start=0,end=s.length()-1;
        while (start<end) {
            if(s.charAt(start)!=s.charAt(end)) {
                  if(isPalindromeRemoved(s,start+1,end) || isPalindromeRemoved(s,start,end+1)) {
                      return true;
                }  else {
                      return false;
                  }
            }
            start++;
            end--;
        }
        return true;
    }

    boolean isPalindromeRemoved(String s1,int start,int end) {
        while(start<end) {
            if(s1.charAt(start++)!=s1.charAt(end--)) {
                return false;
            }

        }
    return true;
    }

}
