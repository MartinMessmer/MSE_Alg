package models;

import data.Constraints;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import others.HaversineDistanceCalculator;

// untested!
public class Trip {
    private final List<Gift> gifts;

    public Trip(List<Gift> gifts) {
        this.gifts = gifts;
    }

    public void add(Gift g) {
        gifts.add(g);
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
        double hopDistance = 0;


        Coordinate previousStation = Constraints.HeadquarterCoordinate;
        Iterator<Gift> giftIterator = gifts.iterator();
        while(giftIterator.hasNext()) {
            Gift gift = giftIterator.next();
            hopDistance  = HaversineDistanceCalculator.HaversineDistance(previousStation, gift.coordinate);
            distance += hopDistance;
            weariness += currentWeight * hopDistance;

            currentWeight -= gift.weight;
            previousStation = gift.coordinate;
        }

        distance += HaversineDistanceCalculator.HaversineDistance(previousStation, Constraints.HeadquarterCoordinate);
        weariness += currentWeight * hopDistance;

        return new TripInfo(
                distance,
                weariness,
                totalWeight
        );

    }


}
