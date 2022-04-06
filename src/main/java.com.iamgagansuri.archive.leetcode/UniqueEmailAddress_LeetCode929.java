import java.util.*;
public class UniqueEmailAddress_LeetCode929 {


        public static  int numUniqueEmails(String[] emails) {
            Set<String> set=new HashSet<>();
            for(String email:emails) {
                String[] parts=email.split("@");

                String left=parts[0];
                String domain=parts[1];

                String[] name=left.split("\\+");
                String actualEmail=name[0];
                actualEmail=actualEmail.replaceAll(".","");
                StringBuilder sb = new StringBuilder();
                sb.append(actualEmail).append(domain);
                set.add(sb.toString());
                System.out.println(sb.toString());
            }

            return set.size();

        }

    public static void main(String[] args) {
        String emails[]= {"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"};
        System.out.println(numUniqueEmails(emails));
    }
}
