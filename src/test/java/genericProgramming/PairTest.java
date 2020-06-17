package genericProgramming;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class PairTest {
    private Pair<Integer> myIntegerPair;
    private Pair<Double> myDoublePair;
    private Pair<String> myStringPair;
    private Pair<Integer> myEqualPair;
    private Pair<String> myEmptyPair;

    @BeforeEach
    void setUp() {
        myIntegerPair = new Pair<>(12, -15);
        myDoublePair = new Pair<>(-4.53, 6.322);
        myStringPair = new Pair<>("ala", "aa");
        myEqualPair = new Pair<>(4, 4);
        myEmptyPair = new Pair<>("", "");
    }

    @Test
    void testGetMax() {
        assertEquals(Optional.of(12), myIntegerPair.getMax());
        assertEquals(Optional.of(6.322), myDoublePair.getMax());
        assertEquals(Optional.of("ala"), myStringPair.getMax());
        assertEquals(Optional.of(4), myEqualPair.getMax());
        assertEquals(Optional.of(""), myEmptyPair.getMax());
    }

    @Test
    void testGetMin() {
        assertEquals(Optional.of(-15), myIntegerPair.getMin());
        assertEquals(Optional.of(-4.53), myDoublePair.getMin());
        assertEquals(Optional.of("aa"), myStringPair.getMin());
        assertEquals(Optional.of(4), myEqualPair.getMin());
        assertEquals(Optional.of(""), myEmptyPair.getMin());
    }
}