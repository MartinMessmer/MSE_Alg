import data.FileService;

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
        List<String> lines = new FileService().readFileFromResourceFolder("gifts.csv");
        System.out.println(lines.get(0));
        System.out.println(lines.get(1));
        System.out.println(lines.get(2));
    }
}
