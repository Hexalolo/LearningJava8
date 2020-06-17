package genericProgramming;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class PairArraysTest {
    private ArrayList<Integer> myList;

    @BeforeEach
    void setUp() {
        myList = new ArrayList<>();
        myList.add(90);
        myList.add(832);
        myList.add(-13);
        myList.add(904);
        myList.add(90);
        myList.add(901);
    }

    @Test
    void testFirstLast() {

        Pair<Integer> myPair = PairArrays.firstLast(myList);
        assertEquals(90, myPair.getFirst());
        assertEquals(901, myPair.getSecond());
    }

    @Test
    void testMin(){
        assertEquals(-13, PairArrays.min(myList));
    }

    @Test
    void testMax(){
        assertEquals(904, PairArrays.max(myList));
    }

    @Test
    void testMinMax(){
        assertEquals(-13, PairArrays.minMax(myList).getFirst());
        assertEquals(904, PairArrays.minMax(myList).getSecond());
    }
}