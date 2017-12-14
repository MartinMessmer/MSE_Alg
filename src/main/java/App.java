import algorithm.Algorithm;
import algorithm.RandomAlgorithm;
import data.FileService;
import Gift.Gift;
import data.GiftsLoader;
import trips.Trip;
import trips.TripSolutionCalculator;
import trips.TripSolutionCounter;

import java.util.List;

public class App {
    public static void main(String[] args) {
        System.out.println("Hello!");
        //testFileServiceAndGiftLoader();

        Algorithm algorithm;
        algorithm = new RandomAlgorithm();
        algorithm.Run();

        List<Trip> trips = algorithm.GetSolution();
        TripSolutionCounter counter = new TripSolutionCalculator(gifts).calculate();
        System.out.println("weariness: " + counter.weariness);
        System.out.println("distance: " + counter.distance);
        System.out.println("#tours: " + counter.countTours);





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
