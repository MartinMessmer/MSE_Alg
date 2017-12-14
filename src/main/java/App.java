import algorithm.Algorithm;
import algorithm.FindCentroidAlgorithm;
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
        //algorithm = new RandomAlgorithm();
        algorithm = new FindCentroidAlgorithm(50);
        algorithm.Run();

        List<Trip> trips = algorithm.GetSolution();
        TripSolutionCounter counter = new TripSolutionMetricCalculator().calculateFromTrip(trips);
        System.out.println(String.format("weariness: %,d", counter.weariness));
        System.out.println(String.format("distance: %,d", counter.distance));
        System.out.println(String.format("#tours: %,d",  counter.countTours));
    }
}
