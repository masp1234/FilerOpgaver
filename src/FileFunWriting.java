import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

public class FileFunWriting {
    public static void main(String[] args) throws FileNotFoundException {
        FileFunWriting app = new FileFunWriting();
        app.run();
    }
    public void run() throws FileNotFoundException {
        File file = new File("C:/Users/masp9/OneDrive/Skrivebord/text.txt");
        PrintStream output = new PrintStream(file);
        output.println("fsdfsdfsdfsdf");
        output.close();

    }
}
