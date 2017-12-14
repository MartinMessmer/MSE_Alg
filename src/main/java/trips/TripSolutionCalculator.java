package trips;

import Gift.Gift;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TripSolutionCalculator {
    private final Map<Integer, Gift> giftsById;

    public TripSolutionCalculator(List<Gift> gifts){
        this.giftsById = gifts.stream()
                .collect(Collectors.toMap(Gift::GiftId, Function.identity()));
    }

    public TripSolutionCounter calculate(List<GiftWithTrip> solution){
        List<Trip> trips = solution
                .stream()
                .collect(Collectors.groupingBy(GiftWithTrip::TripId))
                .values()
                .stream()
                .map(giftsAndTour -> {
                    List<Gift> giftsInTrip = giftsAndTour
                            .stream()
                            .map(t -> giftsById.get(t.giftId))
                            .collect(Collectors.toList());
                    return new Trip(giftsAndTour.get(0).tripId, giftsInTrip);
                })
                .collect(Collectors.toList());

        final TripSolutionCounter counter = new TripSolutionCounter();
        trips.forEach(trip -> {
            counter.countTours++;
            TripInfo info = trip.getTripInfo();
            counter.weariness += info.Weariness;
            counter.distance += info.Distance;
        });
        return counter;
    }
}
