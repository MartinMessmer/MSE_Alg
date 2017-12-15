package solutionChangers;

import gifts.Gift;
import trips.Trip;

import java.util.List;
import java.util.Random;

public class GiftSwapDiffrentTripSolutionChanger implements SolutionChanger {
    private Random random = new Random();

    @Override
    public List<Trip> change(List<Trip> solution) {
        // select two Random Trips
        Trip t1 = solution.get(random.nextInt(solution.size()));
        Trip t2 = solution.get(random.nextInt(solution.size()));

        // select two Random Gifts
        Gift g1 = t1.getAll().get(random.nextInt(t1.getAll().size()));
        Gift g2 = t2.getAll().get(random.nextInt(t2.getAll().size()));

        // Try to Exchange the gifts
        if (t1.tryAdd(g2)){
            t2.remove(g2);
            if (t2.tryAdd(g1)){
                t1.remove(g1);
            }
        }

        return solution;
    }
}
