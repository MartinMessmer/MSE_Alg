package strategies;

import Gift.Gift;
import trips.Trip;

import java.util.List;

public interface Strategy {
    List<Trip> calculateSolution(List<Gift> gifts);
}
