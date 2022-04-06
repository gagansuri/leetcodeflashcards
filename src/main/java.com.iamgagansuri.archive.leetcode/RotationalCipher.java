// Add any extra import statements you may need here


class RotationalCipher {

    // Add any helper functions you may need here


    String rotationalCipher1(String input, int rotationFactor) {
        // Write your code here
        StringBuilder sb=new StringBuilder();
        System.out.println("Input : "+input + " Rotation : "+rotationFactor);
        for(int i=0;i<input.length();i++) {
            int c = input.charAt(i);
            if(c>=65 && c<= 90) {
                //capital A to Z
                c=(c+rotationFactor)%90;
                c=c==0?90:c;
            } else if (c>=97 && c<=122) {
                //small A to Z
                c=(c+rotationFactor)%122;
                c=(c==0?122:c);
            }  else if(c>=48 && c<=57) {
                //digits
                c=(c+rotationFactor)%57;
                c=c==0?57:c;
            }
            char d = (char) c;
            sb.append(d);
            System.out.println(c+" d: "+d);
        }

        return sb.toString();
    }





    String rotationalCipher(String input, int rotationFactor) {
        StringBuilder sb=new StringBuilder();
        for(char c: input.toCharArray()) {
            char out;
            if(c>='A' && c<='Z') {
                System.out.println("input "+c+" c-'A' : "+(c-'A')+ " (c-'A'+rotationFactor)%26 : " +((c-'A'+rotationFactor)%26) + " (char) ((c-'A'+rotationFactor)%26+65): "+(char) ((c-'A'+rotationFactor)%26+65)) ;
                out= (char) ((c-'A'+rotationFactor)%26+'A');

            } else if(c>='a' && c<='z') {
                System.out.println("input "+c+" c-'a' : "+(c-'a')+ " (c-'a'+rotationFactor)%26 : " +((c-'a'+rotationFactor)%26) + " (char) ((c-'a'+rotationFactor)%26+97): "+(char) ((c-'a'+rotationFactor)%26+97));
                out= (char) ((c-'a'+rotationFactor)%26+'a');

            } else if (c>='0' && c<='9') {
                System.out.println("input "+c+" c-'0' : "+(c-'0')+ " (c-'0'+rotationFactor)%10 : " +((c-'0'+rotationFactor)%10) + " (char) ((c-'0'+rotationFactor)%10+57): "+(char) ((c-'0'+rotationFactor)%10+57));
                out= (char) ((c-'0'+rotationFactor)%10+'0');

            } else {
                out=c;
            }
            sb.append(out);

        }
    return sb.toString();
    }





    // These are the tests we use to determine if the solution is correct.
    // You can add your own at the bottom, but they are otherwise not editable!
    int test_case_number = 1;
    void check(String expected, String output) {
        boolean result = (expected.equals(output));
        char rightTick = '\u2713';
        char wrongTick = '\u2717';
        if (result) {
            System.out.println(rightTick + " Test #" + test_case_number);
        }
        else {
            System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
            printString(expected);
            System.out.print(" Your output: ");
            printString(output);
            System.out.println();
        }
        test_case_number++;
    }
    void printString(String str) {
        System.out.print("[\"" + str + "\"]");
    }

    public void run() {
        String input_1 = "All-convoYs-9-be:Alert1.";
        int rotationFactor_1 = 4;
        String expected_1 = "Epp-gsrzsCw-3-fi:Epivx5.";
        String output_1 = rotationalCipher(input_1, rotationFactor_1);
        check(expected_1, output_1);

        String input_2 = "abcdZXYzxy-999.@";
        int rotationFactor_2 = 200;
        String expected_2 = "stuvRPQrpq-999.@";
        String output_2 = rotationalCipher(input_2, rotationFactor_2);
        check(expected_2, output_2);

        // Add your own test cases here

    }

    public static void main(String[] args) {
        new RotationalCipher().run();
    }
}