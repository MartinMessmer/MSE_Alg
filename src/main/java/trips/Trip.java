package trips;

import com.sun.xml.internal.bind.v2.runtime.reflect.opt.Const;
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
        this.gifts = new LinkedList<>();
        //this.gifts = gifts;
        this.id = id;
        this.weight = Constraints.SleighsWeight;
        for( int i = 0 ; i < gifts.size(); i++){
            if (!tryAdd(gifts.get(i))){
                throw new RuntimeException("Can not insert in group!!");
            }
        }
    }

    public boolean tryAdd(Gift g) {
        if (this.weight + g.weight > Constraints.SleighsTotalWeightLimit){
            return false;
        } else {
            gifts.add(g);
            g.setTourId(this.id);
            this.weight += g.weight;
            return true;
        }
    }

    public void remove(Gift g){
        gifts.remove(g);
        this.weight -= g.weight;
    }

    public List<Gift> getAll() {
        return new ArrayList<>(gifts);
    }

    public TripInfo getTripInfo() {
        final double totalWeight = this.weight;
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
