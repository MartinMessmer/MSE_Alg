package algorithm;

import gifts.Coordinate;
import gifts.Gift;

import java.util.LinkedList;
import java.util.List;

public class FindCentroidAlgorithm {
    private final int iterations;

    /**
     *
     * @param iterations How many times we should iterate to find the optimum
     */
    public FindCentroidAlgorithm(int iterations){
        this.iterations = iterations;
    }

    /**
     * Calculate 2 centroids with gifts associated
     * @param gifts
     * @return Array with two centroids
     */
    public Centroid[] calculateTwoCentroids(List<Gift> gifts){
        Centroid c1 = new Centroid(gifts.get(0).coordinate);
        Centroid c2 = new Centroid(gifts.get(1).coordinate);

        for (int i = 0; i < iterations; i++){
            c1.gifts.clear();
            c2.gifts.clear();

            gifts.forEach(g -> {
                getNearestCentroid(c1, c2, g).gifts.add(g);
            });

            c1.recalculateCentroid();
            c2.recalculateCentroid();
        }

        return new Centroid[] {c1, c2};
    }

    private Centroid getNearestCentroid(Centroid c1, Centroid c2, Gift gift){
        double d1 = gift.coordinate.getSquaredEuclidianDistanceTo(c1.coordinate);
        double d2 = gift.coordinate.getSquaredEuclidianDistanceTo(c2.coordinate);
        if (d1 < d2) {
            return c1;
        } else {
            return c2;
        }
    }

    public class Centroid {
        public Coordinate coordinate;
        public final List<Gift> gifts = new LinkedList<Gift>();

        public Centroid(Coordinate c){
            this.coordinate = c;
        }

        public void recalculateCentroid() {
            double lat = gifts.stream().mapToDouble(g -> g.coordinate.latitude).average().getAsDouble();
            double longitude = gifts.stream().mapToDouble(g -> g.coordinate.longitude).average().getAsDouble();
            coordinate = new Coordinate(lat, longitude);
        }
    }
}
