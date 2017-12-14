package others;

import Gift.Coordinate;
import net.jafama.FastMath;

public class HaversineDistanceCalculator {

    private static final int EARTH_RADIUS = 6371; // Approx Earth radius in KM

    public static double HaversineDistance(Coordinate start, Coordinate end) {
        double startLat = start.latitude;
        double startLong = start.longitude;
        double endLat = end.latitude;
        double endLong = end.longitude;

        double dLat  = FastMath.toRadians((endLat - startLat));
        double dLong = FastMath.toRadians((endLong - startLong));

        startLat = FastMath.toRadians(startLat);
        endLat   = FastMath.toRadians(endLat);

        double a = sinPow(dLat) + FastMath.cos(startLat) * FastMath.cos(endLat) * sinPow(dLong);
        double c = 2 * FastMath.atan2(FastMath.sqrt(a), FastMath.sqrt(1 - a));

        return EARTH_RADIUS * c; // <-- d
    }

    private static double sinPow(double val) {
        return Math.pow(FastMath.sin(val / 2), 2);
    }
}
