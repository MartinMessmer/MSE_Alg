package demo;

import data.CompetitionData;
import Gift.Gift;
import trips.TripSolutionMetricCalculator;
import trips.TripSolutionCounter;

import java.util.*;

public class CalculateSampleTourApp {
    public static void main(String[] args){
        List<Gift> gifts = CompetitionData.getGifts();
        TripSolutionCounter counter =
                new TripSolutionMetricCalculator()
                        .calculateFromGift(CompetitionData.sampleSolution(), gifts);

        System.out.println("weariness: " + counter.weariness);
        System.out.println("distance: " + counter.distance);
        System.out.println("#tours: " + counter.countTours);
    }
}
