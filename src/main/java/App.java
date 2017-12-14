import algorithm.Algorithm;
import algorithm.RandomAlgorithm;
import trips.Trip;
import trips.TripSolutionCounter;
import trips.TripSolutionMetricCalculator;

import java.util.List;

public class App {
    public static void main(String[] args) {
        // demo: reading gifts -> see demo/ShowGiftsApp
        System.out.println("Hello!");

        Algorithm algorithm;
        algorithm = new RandomAlgorithm();
        algorithm.Run();

        List<Trip> trips = algorithm.GetSolution();
        TripSolutionCounter counter = new TripSolutionMetricCalculator().calculateFromTrip(trips);
        System.out.println("weariness: " + counter.weariness);
        System.out.println("distance: " + counter.distance);
        System.out.println("#tours: " + counter.countTours);
    }
}
