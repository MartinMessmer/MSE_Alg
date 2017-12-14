package sample;

import data.CompetitionData;
import Gift.Gift;
import trips.TripSolutionCalculator;
import trips.TripSolutionCounter;

import java.util.*;

public class CalculateSampleTourApp {
    public static void main(String[] args){
        List<Gift> gifts = CompetitionData.getGifts();
        TripSolutionCounter counter = new TripSolutionCalculator(gifts).calculate(CompetitionData.sampleSolution());

        System.out.println("weariness: " + counter.weariness);
        System.out.println("distance: " + counter.distance);
        System.out.println("#tours: " + counter.countTours);
    }
}
