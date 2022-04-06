import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.*;

public class LambdaExpression {

    public static void main(String[] args) {
        List<Integer>names=new ArrayList<>();
        Collections.sort(names, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return 0;
            }
        });
    }
}
