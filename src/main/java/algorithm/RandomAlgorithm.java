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

        while (gifts.size() > 1){
            Gift actualGift = gifts.get(random.nextInt(gifts.size() - 1));

            if (actualTrip.getTripInfo().Weight + actualGift.weight > Constraints.SleighsTotalWeightLimit){
                trips.add(actualTrip);
                actualTrip = new Trip(trips.size());
            }
            actualTrip.add(actualGift);
            gifts.remove(actualGift);
        }

        // Insert last Gift
        actualTrip.add(gifts.get(0));
        trips.add(actualTrip);

        System.out.println("******************* End Random Algorithm ******************");
    }
}
