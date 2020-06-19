package collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MakeStringArrayListUpperCase {
    private List<String> myList;

    public MakeStringArrayListUpperCase(){
        myList = new ArrayList<>();
    }

    public void add(String newText){
        myList.add(newText);
    }

    public void showArrayList(){
        myList.forEach(System.out::println);
    }

    public void makeUpperCaseByIterator() {
        Iterator<String> iterator = myList.iterator();
        List<String> temporaryList = new ArrayList<>();
        while(iterator.hasNext()){
            String textToModify = iterator.next();
            int indexOfText = myList.indexOf(textToModify);
            temporaryList.add(indexOfText,textToModify.toUpperCase());
        }
        myList = temporaryList;
        //without temporaryList it throws ConcurrentModificationException
    }

    public void makeUpperCaseByLoop(){
        List<String> temporaryList = new ArrayList<>();
        for(int i = 0; i < myList.size(); i++){
            String textToModify = myList.get(i);
            temporaryList.add(i,textToModify.toUpperCase());
        }
        myList = temporaryList;
        //without temporaryList it blocks in the loop
    }

    public void makeUpperCaseByReplaceAll(){
        myList.replaceAll( e -> e.toUpperCase());
        //it works fine
    }
}
