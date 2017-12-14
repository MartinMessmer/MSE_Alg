package pathOptimizer;

import gifts.Gift;
import trips.Trip;

import java.util.List;

public interface PathOptimizer {
    List<Gift> reorder(List<Gift> gifts);
}
