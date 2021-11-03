import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class FileFunReading {
    public static void main(String[] args) throws IOException {
        FileFunReading app = new FileFunReading();
        app.run();
    }
    public void run() throws IOException {
        File file = new File("C:/Users/masp9/OneDrive/Skrivebord/text.txt");
        Scanner input = new Scanner(file);

        while(input.hasNextLine()) {
            String next = input.nextLine();
            System.out.println(next);
        }

    }
}
