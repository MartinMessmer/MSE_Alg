package models;

public class Gift {
    public final int id;
    public final Coordinate coordinate;
    public final double weight;
    public int tourId;

    public Gift(int id, Coordinate coordinate, double weight, int tourId) {
        this.id = id;
        this.coordinate = coordinate;
        this.weight = weight;
        this.tourId = tourId;
    }
}