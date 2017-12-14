package strategies;

import Gift.Gift;
import trips.Trip;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class RandomStrategy implements Strategy {
    @Override
    public List<Trip> calculateSolution(List<Gift> gifts) {
        List<Trip> trips = new LinkedList<>();
        Trip actualTrip = new Trip(trips.size());
        Random random = new Random();

        Gift actualGift;
        while (gifts.size() > 1){
            actualGift = gifts.get(random.nextInt(gifts.size() - 1));
            if (!actualTrip.tryAdd(actualGift)){
                trips.add(actualTrip);
                actualTrip = new Trip(trips.size());
                actualTrip.tryAdd(actualGift); // should always work because its a new trip
            }
            gifts.remove(actualGift);
        }

        // todo: hm... why we need this here?
        // insert last Gift
        actualGift = gifts.get(0);
        if (!actualTrip.tryAdd(actualGift)){
            trips.add(actualTrip);
            actualTrip = new Trip(trips.size());
        }
        trips.add(actualTrip);

        return trips;
    }
}
