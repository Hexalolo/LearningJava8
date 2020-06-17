package exceptions;

import java.io.FileNotFoundException;
import java.io.IOException;

public class MainExceptions {
    public static void main(String[] args) {
        System.out.println("Hello");
        DealWithFiles dwf = new DealWithFiles();
        try {
            dwf.readValues(null);
            dwf.sumOfValues(null);
        }
        catch (FileNotFoundException ex) {
            System.out.println("File not found");
            ex.printStackTrace();
        }
        catch (IOException ex) {
            System.out.println("General IO problem");
            ex.printStackTrace();
        }
        catch (NumberFormatException ex) {
            System.out.println("Wrong number format");
            ex.printStackTrace();
        }

        System.out.println("End");
    }
}
