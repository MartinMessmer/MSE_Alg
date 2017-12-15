package solutionChangers;

import gifts.Gift;
import trips.Trip;

import java.util.Collections;
import java.util.List;
import java.util.Random;

public class GiftSwapSameTripSolutionChanger implements SolutionChanger{
    private Random random = new Random();

    @Override
    public List<Trip> change(List<Trip> solution) {
        // select one Random Trip and remove from Solution
        Trip trip = solution.get(random.nextInt(solution.size()));
        solution.remove(trip);

        // swap two random gifts
        int size = trip.getAll().size();
        List<Gift> gifts = trip.getAll();
        Collections.swap(gifts,random.nextInt(size), random.nextInt(size));

        // Make new Trip and insert into Solution
        trip = new Trip(trip.id, gifts);
        solution.add(trip);
        return solution;
    }
}
