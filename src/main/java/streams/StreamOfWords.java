package streams;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamOfWords {
    private Stream<String> streamFromText;
    private Stream<String> streamFromArray;
    private String text;
    private List<String> arrayOfWords;
    private BufferedReader br;
    private String line;

    public Stream readFile(String fileName, String fillingMethod) throws IOException {
        Objects.requireNonNull(fileName, "empty file name");
        line = "";
        br = new BufferedReader(new FileReader(new File(fileName)));

        if(fillingMethod.equals("text")) {
            fillStreamFromText();
            br.close();
            return streamFromText;
        }

        if(fillingMethod.equals("array")){
            fillStreamFromArray();
            br.close();
            return streamFromArray;
        }

        else {
            br.close();
            return Stream.empty();
        }

    }

    private void fillStreamFromText() throws IOException {
        text = "";
        line = br.readLine();
        while (line != null){
            text = text.concat(line + "\n");
            line = br.readLine();
        }
        streamFromText = Stream.of(text);
    }

    private void fillStreamFromArray() throws IOException {
        arrayOfWords = new ArrayList<>();
        line = br.readLine();
        while (line != null){
            String[] wordsFromLine = line.split(" ");
            for(String word : wordsFromLine){
                arrayOfWords.add(word);
            }
            line = br.readLine();
        }
        streamFromArray = arrayOfWords.stream();
    }

    public void displayStream(Stream stream){
        stream.forEach(System.out::println);
    }

    public String[] getShortestWords(Stream<String> stream){
        String[] shortestWords = stream.filter(word -> word.length() < 4).toArray(String[]::new);
        return shortestWords;
    }

    public String[] getLongestWords(Stream<String> stream) {
        String[] longestWords = stream.filter(word -> word.length() > 8).toArray(String[]::new);
        return longestWords;
    }

    public String getShortestWord(Stream stream){
        Comparator<String> comparator = Comparator.comparing(String::length);
        Optional<String> shortestWord = stream.min(comparator);
        String result = shortestWord.orElse("");
        return result;
    }

    public String getLongestWord(Stream stream) {
        Comparator<String> comparator = Comparator.comparingInt(String::length);
        Optional<String> longestWord = stream.max(comparator);
        String result = longestWord.orElse("");
        return result;
    }

    public String[] sortByLetters(Stream stream) {
        Object[] sortedWordsObject = stream.sorted().toArray();
        String[] sortedWords = new String[sortedWordsObject.length];
        for(int i = 0; i < sortedWordsObject.length; i++){
            sortedWords[i] = (String) sortedWordsObject[i];
        }
        return sortedWords;
    }

    public long countWords(Stream<String> stream){
        IntSummaryStatistics summary = stream.collect(Collectors.summarizingInt(String::length));
        return summary.getCount();
    }

    public double getAverageWordLength(Stream<String> stream){
        IntSummaryStatistics summary = stream.collect(Collectors.summarizingInt(String::length));
        return summary.getAverage();
    }

    public int countLetters(Stream<String> stream){
        int countLetters = stream.collect(Collectors.summingInt(String::length));
        return countLetters;
    }

    public Stream deleteDuplicates(Stream stream){
        return stream.distinct();
    }

}
