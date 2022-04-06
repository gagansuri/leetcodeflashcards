import java.util.Arrays;

public class MaximumUnitsOnATruck {


    public static int maximumUnits(int[][] boxTypes, int truckSize) {
        //sort descending by number of units per box
        Arrays.sort(boxTypes,(a, b)->b[1]-a[1]);

        int maximumNumberOfUnits=0;

        for(int[] boxType:boxTypes) {
            System.out.println("boxType[0] :"+boxType[0] +" boxType[1]: "+boxType[1]);
            if(boxType[0]<=truckSize) {
                //put this box in the truck and reduce the trucksize
                maximumNumberOfUnits+=boxType[1]*boxType[0];
                truckSize-=boxType[0];
            } else {
                // if the remaining trucksize is smaller than the number of box, use lesser number of boxes equal to truck size from that boxType
                maximumNumberOfUnits+=truckSize*boxType[1];
                return maximumNumberOfUnits;


            }

        }

        return maximumNumberOfUnits;

    }

    public static void main(String[] args) {
        int[][] boxes={{1,3},{2,2},{3,1}};
        int truckSize=4;
        maximumUnits(boxes,truckSize);
    }
}