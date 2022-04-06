import java.util.*;
public class BackSpaceStringCompare {
    public static void main(String[] args) {
        String s = "ab#c",t = "ad#c";
        s="ab##"; t = "c#d#";
        s="y#fo##f";
        t="y#f#o##f";
        System.out.println(backspaceCompare(s,t));
    }

    public static boolean backspaceCompare(String S, String T) {
        //use two stacks
        // when you encounter a character push to the stack and when u encounter a # pop from the stack
        // at the end compare the two stacks

        Stack<Character> sStack=new Stack<>();
        Stack<Character> s1Stack=new Stack<>();
        Stack<Character> tStack=new Stack<>();
        Stack<Character> t1Stack=new Stack<>();
        for(Character x:S.toCharArray()) {
            if(x!='#') {
                sStack.push(x);
            } else if(!sStack.isEmpty()){
                sStack.pop();
            }
        }

        for(Character x:S.toCharArray()) {
            if(x=='#' && s1Stack.isEmpty()==false) {
                s1Stack.pop();
            } else {
                s1Stack.push(x);
            }
        }

        System.out.println(sStack);
        for(Character x:T.toCharArray()) {
            if(x!='#') {
                tStack.push(x);
            } else if(!tStack.isEmpty()){
                tStack.pop();
            }
        }


        for(Character x:T.toCharArray()) {
            if(x=='#' && t1Stack.isEmpty()==false) {
                t1Stack.pop();
            } else if(x!='#'){
                t1Stack.push(x);
            }
        }
        System.out.println(tStack);

        while(!sStack.isEmpty()) {
            char c=sStack.pop();
            if(tStack.isEmpty() || tStack.pop()!=c) {
                return false;
            }
        }

        return sStack.isEmpty() && tStack.isEmpty();



    }

}
