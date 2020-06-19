package collections;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class ShuffleSentencesTest {
    private ShuffleSentences testObject;

    @BeforeEach
    void setUp() {
        testObject = new ShuffleSentences();
    }

    @Test
    void listIsFilled(){
        assertThat(testObject.getNumberOfSentences(), is(greaterThan(0)));

    }

    @Test
    void doTheShuffle(){
        System.out.println("Version before modification");
        testObject.showAllSentences();
        System.out.println("\nVersion after modification");
        testObject.shuffleList();
        testObject.showAllSentences();
    }
}