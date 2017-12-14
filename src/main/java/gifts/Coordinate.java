package gifts;

public class Coordinate {
    public final double latitude;
    public final double longitude;

    public Coordinate(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double getSquaredEuclidianDistanceTo(final Coordinate c2){
        // No Sqrt for performance purpose
        return Math.pow(c2.latitude - this.latitude,2) + Math.pow(c2.longitude - this.longitude, 2);
    }
}
