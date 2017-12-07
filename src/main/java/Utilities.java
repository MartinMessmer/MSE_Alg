public class Utilities {

    private static final int EARTH_RADIUS = 6371; // Approx Earth radius in KM

    public static double HaversineDistance(double startLat, double startLong,
                                           double endLat, double endLong) {

        double dLat  = Math.toRadians((endLat - startLat));
        double dLong = Math.toRadians((endLong - startLong));

        startLat = Math.toRadians(startLat);
        endLat   = Math.toRadians(endLat);

        double a = sinPow(dLat) + Math.cos(startLat) * Math.cos(endLat) * sinPow(dLong);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return EARTH_RADIUS * c; // <-- d
    }

    private static double sinPow(double val) {
        return Math.pow(Math.sin(val / 2), 2);
    }
}
