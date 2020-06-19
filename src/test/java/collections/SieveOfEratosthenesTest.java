package collections;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

class SieveOfEratosthenesTest {
    private SieveOfEratosthenes sieveTest;

    @BeforeEach
    void setUp() {
        sieveTest = new SieveOfEratosthenes(120);
    }

    @Test
    void ifSieveIsFilledWithBoundaryPrimes() {
        assertThat(sieveTest.getSieve().size(), equalTo(30));
        assertThat(sieveTest.getSieve().contains(113),is(true));
        assertThat(sieveTest.getSieve().contains(2),is(true));
        assertThat(sieveTest.getSieve().contains(1), is(false));
        assertThat(sieveTest.getSieve().contains(120), is(false));
    }
}