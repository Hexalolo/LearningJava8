package genericProgramming;

import java.util.ArrayList;
import java.util.Optional;

public class Table <K, V> {
    private ArrayList<Entry> myList;

    public Table() {
        myList = new ArrayList<>();
    }

    public void add(Entry newElement) {
        if (verifyTypeOfEntryInTable(newElement)) {
            boolean ifKeyInTable = false;
            for (Entry element : myList) {
                if (element.getKey().equals(newElement.getKey()))
                    ifKeyInTable = true;
            }
            if (ifKeyInTable == false)
                myList.add(newElement);
        }
    }

    public void add(K key, V value) {
        if (verifyTypeOfEntryInTable(new Entry(key, value))) {
            boolean ifKeyInTable = false;
            for (Entry element : myList) {
                if (element.getKey().equals(key))
                    ifKeyInTable = true;
            }
            if (ifKeyInTable == false)
                myList.add(new Entry(key, value));
        }
    }

    public int getSize(){
        return myList.size();
    }

    public Optional<V> getValue(K key){
        for(Entry element : myList){
            if(element.getKey().equals(key))
                return Optional.of((V) element.getValue());
        }
        return Optional.empty();
    }

    public boolean ifKeyExists(K key){
        for(Entry element : myList){
            if(element.getKey().equals(key))
                return true;
        }
        return false;
    }

    public void setValue(K key, V newValue){
        if(newValue.getClass().getName().equals("java.lang.Integer")) {
            for (int i = 0; i < myList.size(); i++) {
                if (myList.get(i).getKey().equals(key)) {
                    myList.get(i).setValue(newValue);
                    break;
                }
            }
        }
    }

    private boolean verifyTypeOfEntryInTable(Entry newEntry){
        if(myList.isEmpty()) return true;
        if(myList.get(0).getKey().getClass().equals(newEntry.getKey().getClass())) return true;
        if(myList.get(0).getValue().getClass().equals(newEntry.getValue().getClass())) return true;
        return false;
    }
}
