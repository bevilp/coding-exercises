package codingame;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Defibrilators
 *
 * @since 2015-11-27
 */
public class Defibrilators {

    public static class Defibrilator {

        final int num;

        final String name;

        final String address;

        final String phoneNumber;

        final double lonDegrees;

        final double latDegrees;

        public Defibrilator(String defibrilatorString) {
            String[] tokens = defibrilatorString.split(";");
            this.num = Integer.valueOf(tokens[0]);
            this.name = tokens[1];
            this.address = tokens[2];
            this.phoneNumber = tokens[3];
            this.lonDegrees = Double.valueOf(tokens[4].replace(',', '.'));
            this.latDegrees = Double.valueOf(tokens[5].replace(',', '.'));
        }
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        String lon = in.next();
        in.nextLine();
        String lat = in.next();
        in.nextLine();
        int N = in.nextInt();
        in.nextLine();
        lon = lon.replace(',', '.');
        lat = lat.replace(',', '.');
        List<Defibrilator> defibrilatorList = new ArrayList<>(N);

        for (int i = 0; i < N; i++) {
            String defibString = in.nextLine();
            defibrilatorList.add(new Defibrilator(defibString));
        }

        Defibrilator closest = getClosest(defibrilatorList, Double.valueOf(lon), Double.valueOf(lat));

        // Write an action using System.out.println()
        // To debug: System.err.println("Debug messages...");

        System.out.println(closest.name);
    }

    public static Defibrilator getClosest(List<Defibrilator> defibrilatorList, double currentLon, double currentLat) {
        Defibrilator closest = defibrilatorList.get(0);
        double closestDistance = distance(currentLon, currentLat, closest.lonDegrees, closest.latDegrees);
        for (Defibrilator defibrilator : defibrilatorList) {
            double distance = distance(currentLon, currentLat, defibrilator);
            if (distance <= closestDistance) {
                closest = defibrilator;
                closestDistance = distance;
            }
        }

        return closest;
    }

    public static double distance(double currentLon, double currentLat, Defibrilator defibrilator) {
        return distance(currentLon, currentLat, defibrilator.lonDegrees, defibrilator.latDegrees);
    }

    public static double distance(double lon1, double lat1, double lon2, double lat2) {
        double x = (lon2 - lon1) * Math.cos((lon1 + lon2) / 2.0);
        double y = lat2 - lat1;
        return Math.sqrt(x * x + y * y) * 6371.0;
    }
}
