package streams;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Iterator;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class StreamOfWordsTest {
    private StreamOfWords myObject;
    private Stream<String> myStream;

    @BeforeEach
    void setUp(){
        myObject = new StreamOfWords();

        try {
            myStream = myObject.readFile("wordsForCounting.txt", "array");
        }
        catch (IOException e) {
            System.out.println("Problem with reading a file");
            e.printStackTrace();
        }

    }

    @Test
    void ifStreamIsCreated(){

        Iterator iterator = myStream.iterator();
        assertEquals(true, iterator.hasNext());
        //myObject.displayStream(myStream);
    }

    @Test
    void findLongestWord(){
        String result = myObject.getLongestWord(myStream);
        System.out.println(result);
        assertEquals("thelongestword", result);
    }

    @Test
    void findLongestWords(){
        String[] longestWords = myObject.getLongestWords(myStream);
        for(String item : longestWords)
            System.out.println(item);
        assertEquals(1, longestWords.length);
    }

    @Test
    void findShortestWord(){
        String result = myObject.getShortestWord(myStream);
        System.out.println(result);
        assertEquals("me", result);
    }

    @Test
    void findShortestWords(){
        String[] shortestWords = myObject.getShortestWords(myStream);
        for(String item : shortestWords)
            System.out.println(item);
        assertEquals(5, shortestWords.length);
    }

    @Test
    void ifSorted(){
        String[] sortedWords = myObject.sortByLetters(myStream);
        for(String item : sortedWords)
            System.out.println(item);
        assertEquals("class", sortedWords[0]);
    }

    @Test
    void testCountingWords(){
        long result = myObject.countWords(myStream);
        System.out.println(result);
        assertEquals(26, result);
    }

    @Test
    void testAverageWordLength(){
        double result = myObject.getAverageWordLength(myStream);
        System.out.println(result);
        assertTrue(result > 0);
    }

    @Test
    void testCountingLetters(){
        int result = myObject.countLetters(myStream);
        System.out.println(result);
        assertEquals(121, result);
    }

    @Test
    void testNoDuplication(){
        Stream<String> streamNoDuplication;
        streamNoDuplication = myObject.deleteDuplicates(myStream);
        myObject.displayStream(streamNoDuplication);
    }
}