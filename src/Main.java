import domain.MaxVisitorsPortBuilder;
import domain.MaxVisitorsPort;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Main class
 * */
public class Main {

    /**
     * It runs program from terminal.
     * @param args args[0] - file name to process
     * */
    public static void main(String[] args) {
        MaxVisitorsPort adapter = MaxVisitorsPortBuilder.buildForFileInputStreamInputAndConsoleOutput();

        try (FileInputStream inputStream = new FileInputStream(args[0])) {
            adapter.execute(inputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
