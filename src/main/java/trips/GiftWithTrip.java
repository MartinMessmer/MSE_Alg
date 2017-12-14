package trips;

public class GiftWithTrip {
    public final int tripId;
    public final int giftId;

    public GiftWithTrip(int tourId, int giftId) {
        this.tripId = tourId;
        this.giftId = giftId;
    }

    public int TripId() {
        return tripId;
    }
}