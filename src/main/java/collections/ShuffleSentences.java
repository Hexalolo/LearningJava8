package collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShuffleSentences {
    private List<String> listOfSentences;

    public ShuffleSentences(){
        listOfSentences = new ArrayList<>();
        String text1 = "The first sentence.";
        String text2 = "Lord is the biggest supporter in the world.";
        String text3 = "Long teeth with long eyes can make long trip";
        String text4 = "Best friends you will meet in fire";
        listOfSentences.add(text1);
        listOfSentences.add(text2);
        listOfSentences.add(text3);
        listOfSentences.add(text4);

    }

    public void showSentence(int i){
        System.out.println(listOfSentences.get(i));
    }

    public void showAllSentences(){
        listOfSentences.forEach(sentence -> System.out.println(sentence));
    }

    public void shuffleList(){
        Collections.shuffle(listOfSentences);
    }

    public int getNumberOfSentences(){
        return listOfSentences.size();
    }
}
