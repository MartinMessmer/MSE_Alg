package algorithm;

import Gift.Gift;
import data.Constraints;
import trips.Trip;
import java.util.Random;

public class RandomAlgorithm extends Algorithm{

    public RandomAlgorithm(){
        super();
        System.out.println("************** Starting Random Algorithm *************");
    }

    @Override
    public void Run() {
        Trip actualTrip = new Trip(trips.size());
        Random random = new Random();

        Gift actualGift;
        while (gifts.size() > 1){
            actualGift = gifts.get(random.nextInt(gifts.size() - 1));
            if (!actualTrip.tryAdd(actualGift)){
                trips.add(actualTrip);
                actualTrip = new Trip(trips.size());
            }
            gifts.remove(actualGift);
        }

        // insert last Gift
        actualGift = gifts.get(0);
        if (!actualTrip.tryAdd(actualGift)){
            trips.add(actualTrip);
            actualTrip = new Trip(trips.size());
        }
        trips.add(actualTrip);

        System.out.println("******************* End Random Algorithm ******************");
    }
}
