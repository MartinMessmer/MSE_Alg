import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        System.out.println("Hello!");
        loadFile();
    }

    private static void loadFile() {
        URI path = null;
        try {
            path = Thread.currentThread().getContextClassLoader().getResource("gifts.csv").toURI();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        List<String> lines = new LinkedList<>();
        try {
            lines = Files.readAllLines(Paths.get(path));
        } catch (IOException e) {
            e.printStackTrace();
        }

       System.out.println(lines.size());
    }
}
