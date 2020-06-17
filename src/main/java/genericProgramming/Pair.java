package genericProgramming;

import java.util.ArrayList;
import java.util.Optional;

public class Pair <E extends Comparable<E>> {
    private E first;
    private E second;

    public Pair(E first, E second) {
        this.first = first;
        this.second = second;
    }

    public E getFirst() {
        return first;
    }

    public E getSecond() {
        return second;
    }

    public Optional<E> getMax(){
        if(first.compareTo(second) >= 1)
            return (Optional<E>) Optional.of(first);
        if(first.compareTo(second) < 1)
            return (Optional<E>) Optional.of(second);
        return Optional.empty();
    }

    public Optional<E> getMin(){
        if(first.compareTo(second) < 1)
            return (Optional<E>) Optional.of(first);
        if(first.compareTo(second) >= 1)
            return (Optional<E>) Optional.of(second);
        return Optional.empty();
    }

}
