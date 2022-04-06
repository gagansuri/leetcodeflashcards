public class FindTheCelebrity {


    public int findCelebrity(int n) {
        int celebrity=0;

        for(int i =1;i<n;i++) {
            //if celebrity knows person i, then celebrity cannot be a celebrity but i can be
            if(knows(celebrity,i)) {
                celebrity=i;
            }
        }

        for(int i=0;i<n;i++) {
            if(i!=celebrity && knows(celebrity,i) || !knows(i,celebrity)) {
                return -1;
            }
        }
        return celebrity;
    }

    public boolean knows(int i,int j ) {
        return true;
    }
}
