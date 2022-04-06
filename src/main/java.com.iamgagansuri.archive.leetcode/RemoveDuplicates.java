import java.sql.SQLOutput;

public class RemoveDuplicates {


    public int removeDuplicates(int[] nums) {
        int length = nums.length;
        int unique = 0;
        for (int runningIndex = 1; runningIndex < nums.length ; ) {
            if (nums[unique] != nums[runningIndex]) {
                unique++;
                nums[unique]=nums[runningIndex];
            } runningIndex++;

        }
        return unique+1;
    }

    public static void main(String[] args) {
        System.out.println(new RemoveDuplicates().removeDuplicates(new int[]{1, 1, 2}));
    }
}
