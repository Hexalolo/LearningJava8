package interfaces;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public interface IntSequence {
    boolean hasNext();
    int next();

    static void of (int n1, int n2, int n3, int n4, int n5){
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(n1, n2, n3, n4, n5));
        Comparator<Integer> integerComparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        };
        list.sort(integerComparator);
        for(Object item : list){
            System.out.print(item +", ");
        }
        System.out.println();
    }

    static int[] constant(int n) {
        return new int[]{n, n, n, n, n};
    }
}
