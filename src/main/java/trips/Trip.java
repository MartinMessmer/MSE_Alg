package trips;

import data.Constraints;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import Gift.Coordinate;
import Gift.Gift;
import others.HaversineDistanceCalculator;

// untested!
public class Trip {
    private final List<Gift> gifts;
    public final int id;
    private double weight;

    public Trip(int id) {
        this(id, new LinkedList<>());
    }

    public Trip(int id, List<Gift> gifts) {
        this.gifts = gifts;
        this.id = id;
    }

    public void add(Gift g) {
        gifts.add(g);
        g.setTourId(this.id);
    }

    public void remove(Gift g){
        gifts.remove(g);
    }

    public List<Gift> getAll() {
        return new ArrayList<>(gifts);
    }

    public TripInfo getTripInfo() {
        final double totalWeight = gifts.stream().mapToDouble(g -> g.weight).sum() + Constraints.SleighsWeight;
        double currentWeight = totalWeight;

        double distance = 0;
        int weariness = 0;
        double lastHopDistance = 0;


        Coordinate previousStation = Constraints.HeadquarterCoordinate;
        Iterator<Gift> giftIterator = gifts.iterator();
        while(giftIterator.hasNext()) {
            Gift gift = giftIterator.next();
            lastHopDistance  = HaversineDistanceCalculator.HaversineDistance(previousStation, gift.coordinate);
            distance += lastHopDistance;
            weariness += currentWeight * lastHopDistance;

            currentWeight -= gift.weight;
            previousStation = gift.coordinate;
        }

        distance += HaversineDistanceCalculator.HaversineDistance(previousStation, Constraints.HeadquarterCoordinate);
        weariness += currentWeight * lastHopDistance;

        return new TripInfo(
                distance,
                weariness,
                totalWeight
        );

    }
}
