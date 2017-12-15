package pathOptimizers;

import gifts.Gift;
import trips.Trip;
import trips.TripSolutionCounter;
import trips.TripSolutionMetricCalculator;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class TourInverterPathOptimizer implements PathOptimizer {
    @Override
    public List<Gift> reorder(List<Gift> gifts) {
        Trip normalTrip = new Trip(gifts.get(0).tourId, gifts);
        List<Trip> normalTrips = new LinkedList<>();
        normalTrips.add(normalTrip);
        TripSolutionCounter counterNormalTrip = new TripSolutionMetricCalculator().calculateFromTrip(normalTrips);

        Collections.reverse(gifts);
        Trip invertedTrip = new Trip(gifts.get(0).tourId, gifts);
        List<Trip> invertedTrips = new LinkedList<>();
        invertedTrips.add(invertedTrip);
        TripSolutionCounter counterInvertedTrip = new TripSolutionMetricCalculator().calculateFromTrip(invertedTrips);

        if (counterNormalTrip.weariness <= counterInvertedTrip.weariness){
            return normalTrip.getAll();
        } else {
            return invertedTrip.getAll();
        }
    }
}
