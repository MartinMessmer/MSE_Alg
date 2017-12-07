package models;

public class Gift {
    public final int id;
    public final double latitude;
    public final double longitude;
    public final double weight;
    public int tourId;

    public Gift(int id, double latitude, double longitude, double weight, int tourId) {
        this.id = id;
        this.latitude = latitude;
        this.longitude = longitude;
        this.weight = weight;
        this.tourId = tourId;
    }
}