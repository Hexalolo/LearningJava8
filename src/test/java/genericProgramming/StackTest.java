package genericProgramming;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {

    @Test
    void ifIsEmpty(){
        Stack<String> myTestList = new Stack<>();
        assertTrue(myTestList.isEmpty());
    }

    @Test
    void ifStringPushed() {
        Stack<String> myTestList = new Stack<>();
        String text = "My new text";
        myTestList.push(text);
        assertEquals("My new text", myTestList.getItem(0));
    }

    @Test
    void ifIntegerPushed(){
        Stack<Integer> myTestList = new Stack<>();
        myTestList.push(-1255);
        assertEquals(-1255, myTestList.getItem(0));
    }

    @Test
    void ifPushedItemIsFirst(){
        Stack<Integer> myTestList = new Stack<>();
        myTestList.push(-1255);
        myTestList.push(-125512);
        myTestList.push(78);
        assertEquals(78, myTestList.getItem(0));
    }

    @Test
    void ifPushIncreaseSize(){
        Stack<Integer> myTestList = new Stack<>();
        myTestList.push(-1255);
        myTestList.push(-125512);
        assertEquals(2, myTestList.getSize());
    }

    @Test
    void ifISNotEmpty(){
        Stack<Integer> myTestList = new Stack<>();
        myTestList.push(-1255);
        assertFalse(myTestList.isEmpty());
    }

    @Test
    void ifReturnSizeWhenEmpty(){
        Stack<Integer> myTestList = new Stack<>();
        assertEquals(0, myTestList.getSize());
    }

    @Test
    void ifPopWhenManyElement(){
        Stack<Integer> myTestList = new Stack<>();
        myTestList.push(-1255);
        myTestList.push(-125512);
        myTestList.push(78);
        assertEquals(3, myTestList.getSize());
        myTestList.pop(78);
        assertEquals(2, myTestList.getSize());
        assertEquals(-1255, myTestList.getItem(1));
        assertEquals(-125512, myTestList.getItem(0));
    }

    @Test
    void ifPopWhenLastElement(){
        Stack<Integer> myTestList = new Stack<>();
        myTestList.push(-1255);
        myTestList.pop(-1255);
        assertTrue(myTestList.isEmpty());
    }

    @Test
    void ifPopWhenNoParameter(){
        Stack<Integer> myTestList = new Stack<>();
        myTestList.push(-1255);
        myTestList.push(-125512);
        myTestList.push(78);
        assertEquals(3, myTestList.getSize());
        myTestList.pop();
        assertEquals(2, myTestList.getSize());
        assertEquals(78, myTestList.getItem(0));
        assertEquals(-125512, myTestList.getItem(1));
    }

    @Test
    void ifPopWhenEmpty(){
        Stack<String> myTestList = new Stack<>();
        myTestList.pop();
        assertTrue(myTestList.isEmpty());
    }

    @Test
    void ifPopWhenElementNotExist(){
        Stack<String> myTestList = new Stack<>();
        myTestList.push("New text");
        myTestList.pop("new");
        assertEquals(1, myTestList.getSize());
    }
}