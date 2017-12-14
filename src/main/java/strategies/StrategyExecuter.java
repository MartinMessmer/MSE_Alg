package strategies;

import gifts.Gift;
import data.CompetitionData;
import trips.Trip;
import trips.TripSolutionCounter;
import trips.TripSolutionMetricCalculator;

import java.util.List;

public class StrategyExecuter {
    private final List<Gift> gifts = CompetitionData.getGifts();

    public void execute(Strategy strategy) {
        System.out.format("execute strategy: %s ... %n", strategy.getClass().getSimpleName());
        long timeStart = System.currentTimeMillis();
        List<Trip> trips = strategy.calculateSolution(gifts);
        TripSolutionCounter counter = new TripSolutionMetricCalculator().calculateFromTrip(trips);
        long timeEnd = System.currentTimeMillis();

        System.out.println(String.format("weariness: %,d", counter.weariness));
        System.out.println(String.format("distance: %,d", counter.distance));
        System.out.println(String.format("#tours: %,d",  counter.countTours));
        System.out.println(String.format("processing time: %,2f sec.",  (timeEnd-timeStart)/1000.0 ));
    }
}
