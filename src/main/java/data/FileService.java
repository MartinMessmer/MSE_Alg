package data;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;

public class FileService {
    public List<String> readFileFromResourceFolder(String name) {
        URI path = null;
        try {
            path = Thread.currentThread().getContextClassLoader().getResource(name).toURI();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        List<String> lines = new LinkedList<>();
        try {
            lines = Files.readAllLines(Paths.get(path));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return lines;
    }
}
