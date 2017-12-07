import data.FileService;
import models.Gift;
import data.GiftsLoader;
import others.HaversineDistanceCalculator;

import java.util.List;

public class App {
    public static void main(String[] args) {
        System.out.println("Hello!");
        testFileServiceAndGiftLoader();
    }

    private static void testFileServiceAndGiftLoader() {
        List<String> lines = new FileService().readFileFromResourceFolder("gifts.csv");
        System.out.println(lines.get(0));
        System.out.println(lines.get(1));
        List<Gift> gifts = new GiftsLoader().extract(lines);

        System.out.println(gifts.get(1).id);
        System.out.println(gifts.get(1));
        System.out.println(gifts.get(2));
    }
}
