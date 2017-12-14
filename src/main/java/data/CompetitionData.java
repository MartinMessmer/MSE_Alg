package data;

import Gift.Gift;
import trips.GiftWithTrip;

import java.util.List;
import java.util.stream.Collectors;

public class CompetitionData {
    public static List<Gift> getGifts(){
        List<String> lines = new FileService().readFileFromResourceFolder("gifts.csv");
        return new GiftsLoader().extract(lines);
    }

    public static List<GiftWithTrip> sampleSolution(){
        List<String> lines = new FileService().readFileFromResourceFolder("sample_submission.csv");
        return lines
                .stream()
                .skip(1)
                .map(s -> {
                    String[] values = s.split(",");
                    int giftId = Integer.parseInt(values[0]);
                    int tripId = Integer.parseInt(values[1]);
                    return new GiftWithTrip(tripId, giftId);
                })
                .collect(Collectors.toList());

    }
}
