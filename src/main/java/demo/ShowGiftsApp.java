package demo;

import Gift.Gift;
import data.CompetitionData;

import java.util.List;

public class ShowGiftsApp {
    public static void main(String[] args) {
        List<Gift> gifts = CompetitionData.getGifts();

        gifts.stream().limit(5).forEach(g -> {
            System.out.format("Id: %d, Weight: %f, (lat: %f, long: %f)%n", g.id, g.weight, g.coordinate.latitude, g.coordinate.longitude);
        });
    }
}
