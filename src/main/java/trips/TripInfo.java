package trips;

public class TripInfo {
    public TripInfo(double distance, double weariness, double weight) {
        Distance = distance;
        Weariness = weariness;
        Weight = weight;
    }

    public final double Distance;
    public final double Weariness;
    public final double Weight;
}
