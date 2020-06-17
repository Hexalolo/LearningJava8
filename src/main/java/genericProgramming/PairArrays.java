package genericProgramming;

import java.util.ArrayList;
import java.util.Comparator;

public class PairArrays {

    public static <E extends Comparable<E>> Pair<E> firstLast(ArrayList<? extends Comparable<E>> a) {
        E first = (E) a.get(0);
        E second = (E) a.get(a.size() - 1);
        Pair<E> newPair = new Pair<>(first, second);
        return new Pair<E>(first, second);
    }

    public static <E extends Comparable<E>> E min(ArrayList<? extends Comparable<E>> a) {
        E minValue = (E) a.get(0);
        for(Comparable<E> element : a){
            if(minValue.compareTo((E) element) > 0)
                minValue = (E) element;
        }
        return minValue;
    }

    public static <E extends Comparable<E>> E max(ArrayList<? extends Comparable<E>> a) {
        E minValue = (E) a.get(0);
        for(Comparable<E> element : a){
            if(minValue.compareTo((E) element) < 0)
                minValue = (E) element;
        }
        return minValue;
    }

    public static <E extends Comparable<E>> Pair<E> minMax(ArrayList<? extends Comparable<E>> a) {
        E minValue = min(a);
        E maxValue = max(a);
        return new Pair<>(minValue, maxValue);
    }
}
