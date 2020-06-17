package exceptions;

import java.io.*;
import java.util.ArrayList;
import java.util.Objects;


public class DealWithFiles {

    public ArrayList<Double> readValues(String filename) throws IOException, NumberFormatException {
        Objects.requireNonNull(filename, "empty file name");
        String line = "";
        ArrayList<Double> myList = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(new File(filename)));

        line = br.readLine();
        while (line != null){
            myList.add(Double.parseDouble(line));
            line = br.readLine();
        }

        br.close();
        return myList;
    }

    public double sumOfValues(String filename) throws IOException {
        Objects.requireNonNull(filename, "empty file name");
        BufferedWriter bw = new BufferedWriter(new FileWriter(new File(filename)));
        ArrayList<Double> myList;
        Double sum = 0.0;

        myList = readValues("doubleNumbers.txt");
        for(Double value : myList){
            sum = sum + value;
        }

        bw.write(sum.toString());

        bw.close();
        return sum;
    }
}
