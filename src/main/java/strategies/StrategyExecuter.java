package strategies;

import gifts.Gift;
import data.CompetitionData;
import pathOptimizer.GreedyShortestPathOptimizer;
import pathOptimizer.PathOptimizer;
import trips.Trip;
import trips.TripSolutionCounter;
import trips.TripSolutionMetricCalculator;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class StrategyExecuter {
    private final List<Gift> gifts = CompetitionData.getGifts();
    private final CustomTimer customTimer = new CustomTimer();

    public void execute(Strategy strategy, Optional<PathOptimizer> pathOptimizer) {
        System.out.format("execute strategy: %s ... %n", strategy.getClass().getSimpleName());
        customTimer.tick();
        List<Trip> trips = strategy.calculateSolution(gifts);
        printTripMetrics(trips, customTimer.tock());


        if (pathOptimizer.isPresent()) {
            System.out.println("");
            System.out.println("");
            runPathOptimization(trips, pathOptimizer.get());
        }
    }

    private void runPathOptimization(List<Trip> trips, PathOptimizer pathOptimizer){
        // path optimization
        System.out.format("running path optimization %s... %n", pathOptimizer.getClass().getSimpleName());
        List<Trip> reorderedTrips = new LinkedList<>();
        customTimer.tick();
        for (Trip trip : trips) {
            Trip reorderedTrip = new Trip(trip.id, pathOptimizer.reorder(trip.getAll()));
            reorderedTrips.add(reorderedTrip);
        }

        printTripMetrics(reorderedTrips, customTimer.tock());
    }

    private void printTripMetrics(List<Trip> trips, long processingTimeMillis) {
        TripSolutionCounter counter = new TripSolutionMetricCalculator().calculateFromTrip(trips);
        System.out.println(String.format("weariness: %,d", counter.weariness));
        System.out.println(String.format("distance: %,d", counter.distance));
        System.out.println(String.format("#tours: %,d",  counter.countTours));
        System.out.println(String.format("processing time: %,2f sec.",  processingTimeMillis/1000.0 ));
    }
}

class CustomTimer{
    private long start;

    public void tick() {
        start = System.currentTimeMillis();
    }

    public long tock() {
        return System.currentTimeMillis() - start;
    }
}