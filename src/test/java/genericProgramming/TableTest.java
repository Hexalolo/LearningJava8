package genericProgramming;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class TableTest {
    private Table myTestTable;
    private Entry entry1;
    private Entry entry2;
    private Entry anotherEntry;
    private Entry anotherEntry2;

    @BeforeEach
    void setUp() {
        myTestTable = new Table();
        entry1 = new Entry("Tomek", 25);
        entry2 = new Entry("Ewa", 65);
        anotherEntry = new Entry(12, "Potwór");
        anotherEntry2 = new Entry('g', 12.3F);
    }

    @Test
    void ifAddedEntryStringInteger() {
        myTestTable.add(entry1);
        assertEquals(1, myTestTable.getSize());
        assertEquals(Optional.of(25), myTestTable.getValue("Tomek"));
    }

    @Test
    void ifAddedEntryIntegerString(){
        myTestTable.add(anotherEntry);
        assertEquals(1, myTestTable.getSize());
        assertEquals(Optional.of("Potwór"), myTestTable.getValue(12));
    }

    @Test
    void ifAddedEntryCharDouble(){
        myTestTable.add(anotherEntry2);
        assertEquals(1, myTestTable.getSize());
        assertEquals(Optional.of(12.3F), myTestTable.getValue('g'));
    }

    @Test
    void ifAddedByKeyValue() {
        myTestTable.add("Patryk", 78);
        assertEquals(1, myTestTable.getSize());
        assertEquals(Optional.of(78), myTestTable.getValue("Patryk"));
    }

    @Test
    void ifDetectedMultipleKeysByEntry() {
        myTestTable.add(entry1);
        myTestTable.add(entry1);
        assertEquals(1, myTestTable.getSize());
        assertEquals(Optional.of(25), myTestTable.getValue("Tomek"));
    }

    @Test
    void ifDetectedMultipleKeysByKeyValue(){
        myTestTable.add("Patryk", 78);
        myTestTable.add("Patryk", 5);
        assertEquals(1, myTestTable.getSize());
        assertEquals(Optional.of(78), myTestTable.getValue("Patryk"));
    }

    @Test
    void ifSkippedWrongEntryType(){
        myTestTable.add(entry1);
        myTestTable.add(anotherEntry);
        myTestTable.add(anotherEntry2);
        myTestTable.add(-3, "log");
        myTestTable.add('d', 124.5F);
        assertEquals(1, myTestTable.getSize());
        assertEquals(Optional.of(25), myTestTable.getValue("Tomek"));

    }

    @Test
    void getKeyThatNotExist(){
        myTestTable.add(entry1);
        assertEquals(Optional.empty(), myTestTable.getValue("Patryk"));
    }

    @Test
    void verifyKeyExsists(){
        myTestTable.add(entry1);
        assertTrue(myTestTable.ifKeyExists("Tomek"));
    }

    @Test
    void verifyKeyNotExsists(){
        assertFalse(myTestTable.ifKeyExists("Tomek"));
    }

    @Test
    void setValueForKeyNotExisting(){
        myTestTable.add(entry1);
        myTestTable.setValue("Patryk", 65);
        assertEquals(1, myTestTable.getSize());
        assertEquals(Optional.of(25), myTestTable.getValue("Tomek"));
    }

    @Test
    void ifSetValue(){
        myTestTable.add(entry1);
        myTestTable.add(entry2);
        myTestTable.setValue("Ewa", 12);
        assertEquals(2, myTestTable.getSize());
        assertEquals(Optional.of(12), myTestTable.getValue("Ewa"));
    }

    @Test
    void setImproperValue(){
        myTestTable.add(entry1);
        myTestTable.setValue("Tomek", "Kochanowski");
        assertEquals(1, myTestTable.getSize());
        assertEquals(Optional.of(25), myTestTable.getValue("Tomek"));
    }
}