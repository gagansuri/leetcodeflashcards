public class RobotReturnToOrigin_LeetCode657 {

    public boolean judgeCircle(String moves) {
        int upDownCounter=0,leftRightCounter=0;
        for(int i=0;i<moves.length();i++) {
            if(moves.charAt(i)=='U') {
                upDownCounter++;
            } else if(moves.charAt(i)=='D') {
                upDownCounter--;
            } else             if(moves.charAt(i)=='L') {
                leftRightCounter++;
            } else             if(moves.charAt(i)=='R') {
                leftRightCounter--;
            }
        }
        return upDownCounter==0 && leftRightCounter==0;
    }

    public static void main(String[] args) {
        System.out.println("UD :"+new RobotReturnToOrigin_LeetCode657().judgeCircle("UD"));
        System.out.println("LL :"+new RobotReturnToOrigin_LeetCode657().judgeCircle("LL"));
        System.out.println("LR :"+new RobotReturnToOrigin_LeetCode657().judgeCircle("LR"));

    }
}
