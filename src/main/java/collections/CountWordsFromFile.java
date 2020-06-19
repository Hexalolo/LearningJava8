package collections;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class CountWordsFromFile {
    private Map<String, Integer> countingWords;

    public CountWordsFromFile(String fileName){
        countingWords = new TreeMap<>();
        try {
            readFile(fileName);
        }
        catch(IOException e){
            System.out.println("Problem with file reading");
            e.printStackTrace();
        }

    }

    private void readFile(String fileName) throws IOException {
        Objects.requireNonNull(fileName, "empty file name");
        String line = "";
        BufferedReader br = new BufferedReader(new FileReader(new File(fileName)));

        line = br.readLine();
        while (line != null){
            countWordsFromLine(line);
            line = br.readLine();
        }
        br.close();
    }

    private void countWordsFromLine(String line){
        String[] wordsFromLine = line.split(" ");
        for(int i = 0; i < wordsFromLine.length; i++){
            if(countingWords.containsKey(wordsFromLine[i])){
                int valueBefore = countingWords.get(wordsFromLine[i]);
                countingWords.put(wordsFromLine[i], valueBefore + 1);
            }
            else {
                countingWords.put(wordsFromLine[i], 1);
            }
        }
    }

    public void showWordsAndCounts(){
        countingWords.forEach((word, count) -> System.out.println(word + " "+count));
    }

    public int getSize(){
        return countingWords.size();
    }

    public int getCounts(String word){
        return countingWords.get(word);
    }

    public boolean ifContains(String word){
        return countingWords.containsKey(word);
    }
}
