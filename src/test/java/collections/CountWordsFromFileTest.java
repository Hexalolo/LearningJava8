package collections;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

class CountWordsFromFileTest {
    private CountWordsFromFile testObject;

    @BeforeEach
    void setUp(){
        testObject = new CountWordsFromFile("wordsForCounting.txt");
    }

    @Test
    void ifWordsAreReadFromFile(){
        assertThat(testObject.getSize(), is(greaterThan(0)));
        assertThat(testObject.ifContains("single"), is(true));
        assertThat(testObject.getCounts("single"), equalTo(1));

    }

    @Test
    void showTreeMap(){
        testObject.showWordsAndCounts();
    }

}