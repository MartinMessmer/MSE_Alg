package pathOptimizer;

import data.Constraints;
import gifts.Coordinate;
import gifts.Gift;
import trips.Trip;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

// not sure whether this impl. is correct ...
public class GreedyShortestPathOptimizer implements PathOptimizer {
    @Override
    public List<Gift> reorder(List<Gift> gifts) {
        List<Gift> result = new LinkedList<>();
        Coordinate location = Constraints.HeadquarterCoordinate;

        while (gifts.size() > 0) {
            Gift nextGift = gifts.stream().min(new NearestGiftComperator(location)).get();
            result.add(nextGift);
            location = nextGift.coordinate;
            gifts.remove(nextGift);
        }

        return result;
    }

    class NearestGiftComperator implements Comparator<Gift> {
        private final Coordinate location;

        NearestGiftComperator(Coordinate location) {
            this.location = location;
        }

        @Override
        public int compare(Gift o1, Gift o2) {
            double d1 = o1.coordinate.getSquaredEuclidianDistanceTo(location);
            double d2 = o2.coordinate.getSquaredEuclidianDistanceTo(location);

            if (d1 == d2) {
                return 0;
            }

            return d1 < d2 ? -1 : 1;
        }
    }
}
