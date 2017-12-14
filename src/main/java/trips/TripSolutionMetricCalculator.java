package trips;

import gifts.Gift;
import data.Constraints;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TripSolutionMetricCalculator {
    public final boolean throwExceptionForInvalidData;

    public TripSolutionMetricCalculator() {
        this(true);
    }

    public TripSolutionMetricCalculator(boolean throwExceptionForInvalidData){
        this.throwExceptionForInvalidData = throwExceptionForInvalidData;
    }

    public TripSolutionCounter calculateFromTrip(List<Trip> solution) {
        final TripSolutionCounter counter = new TripSolutionCounter();
        solution.forEach(trip -> {
            counter.countTours++;
            TripInfo info = trip.getTripInfo();
            counter.weariness += info.Weariness;
            counter.distance += info.Distance;

            if (info.Weight > Constraints.SleighsTotalWeightLimit) {
                System.out.format("WARNING!: Trip #%d exceeds weight limit (%f)%n", trip.id, info.Weight);
                if (throwExceptionForInvalidData){
                    throw new RuntimeException("slighs weight exceeded: you have killed one of santas reindeer!");
                }
            }
        });
        return counter;
    }

    public TripSolutionCounter calculateFromGift(List<GiftWithTrip> solution, List<Gift> gifts){
        final Map<Integer, Gift> giftsById = gifts.stream()
                .collect(Collectors.toMap(Gift::GiftId, Function.identity()));

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

        return calculateFromTrip(trips);
    }
}
