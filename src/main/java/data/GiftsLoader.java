package data;

import Gift.Coordinate;
import Gift.Gift;

import java.util.ArrayList;
import java.util.List;

public class GiftsLoader {
    public List<Gift> extract(List<String> lines) {
        List<Gift> gifts = new ArrayList<>(lines.size()-11);
        for (int i = 1; i < lines.size(); i++) {
            gifts.add(createGifts(lines.get(i)));
        }
        return gifts;
    }

    private Gift createGifts(String text){
        String[] textSplitted = text.split(",");
        Coordinate coordinate = new Coordinate(
                Double.parseDouble(textSplitted[1]), // lat
                Double.parseDouble(textSplitted[2]) // long
        );
        return new Gift(
                Integer.parseInt(textSplitted[0]), // id
                coordinate,
                Double.parseDouble(textSplitted[3]), // weight
                0); // tripId
    }
}
