package collections;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MakeStringArrayListUpperCaseTest {
    private MakeStringArrayListUpperCase myTest;

    @BeforeEach
    void setUp() {
        myTest = new MakeStringArrayListUpperCase();
        myTest.add("First text line.");
        myTest.add("SECOND line TEXT!");
        myTest.add("65 *(094)%# text");
        System.out.println("Version before modifications");
        myTest.showArrayList();
    }

    @Test
    void testIteratorUpperCase(){
        myTest.makeUpperCaseByIterator();
        System.out.println("\nVersion after modifications");
        myTest.showArrayList();
    }

    @Test
    void testLoopUpperCase(){
        myTest.makeUpperCaseByLoop();
        System.out.println("\nVersion after modifications");
        myTest.showArrayList();
    }

    @Test
    void testReplaceAllUpperCase(){
        myTest.makeUpperCaseByReplaceAll();
        System.out.println("\nVersion after modifications");
        myTest.showArrayList();
    }

}