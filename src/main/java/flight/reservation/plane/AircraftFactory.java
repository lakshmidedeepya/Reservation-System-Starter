package flight.reservation.plane;

public class AircraftFactory {

    public static Aircraft create(String type, String model) {

        switch (type.toUpperCase()) {

            case "PLANE":
                return new PassengerPlane(model);

            case "HELI":
                return new Helicopter(model);

            case "DRONE":
                return new PassengerDrone(model);

            default:
                throw new IllegalArgumentException("Unknown: " + type);
        }
    }
}