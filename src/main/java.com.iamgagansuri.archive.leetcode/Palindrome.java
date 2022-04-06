public class Palindrome{

    public static void main(String args[]) {

        Palindrome p = new Palindrome();
        System.out.println(p.isPalindrome("abaa"));

    }


    public boolean isPalindrome(String s) {

        if(s==null || s.length()==0) return true;

        int start=0,end=s.length()-1;

        while(start<end) {
            if(s.charAt(start++)!=s.charAt(end--)){
                return false;
            }
        }
        return true;
    }

}
