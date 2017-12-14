package strategies;

import Gift.Gift;
import algorithm.FindCentroidAlgorithm;
import data.Constraints;
import trips.Trip;

import java.util.LinkedList;
import java.util.List;

public class HalfingWithCentroidsStrategy implements Strategy {
    private final FindCentroidAlgorithm centroidFinder = new FindCentroidAlgorithm(50);

    @Override
    public List<Trip> calculateSolution(List<Gift> gifts) {
        List<Trip> trips = new LinkedList<>();
        halfingGroup(gifts, trips);
        return trips;
    }

    private void halfingGroup(List<Gift> gifts, List<Trip> trips){
        double weight = gifts.stream().mapToDouble(g -> g.weight).sum();
        if (weight <= Constraints.SleighsMaxLoad){
            trips.add(new Trip(trips.size(), gifts));
        } else {
            FindCentroidAlgorithm.Centroid[] centroids = centroidFinder.calculateTwoCentroids(gifts);
            halfingGroup(centroids[0].gifts, trips);
            halfingGroup(centroids[1].gifts, trips);
        }
    }
}
