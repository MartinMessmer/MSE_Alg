package algorithm;

import Gift.Gift;
import data.FileService;
import data.GiftsLoader;
import trips.Trip;

import java.util.LinkedList;
import java.util.List;

public abstract class Algorithm {
    List<Gift> gifts;
    List<Trip> trips;

    public Algorithm(){
        List<String> lines = new FileService().readFileFromResourceFolder("gifts.csv");
        gifts = new GiftsLoader().extract(lines);
        trips = new LinkedList<>();
    }

    public abstract void Run();

    public List<Trip> GetSolution(){
        return trips;
    }
}
