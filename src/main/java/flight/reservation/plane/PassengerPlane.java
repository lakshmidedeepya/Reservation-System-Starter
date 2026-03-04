package flight.reservation.plane;

import java.util.Map;

public class PassengerPlane implements Aircraft {

    private static final Map<String, int[]> MODEL_SPECS = Map.of(
            "A380", new int[]{500, 42},
            "A350", new int[]{320, 40},
            "Embraer 190", new int[]{25, 5},
            "Antonov AN2", new int[]{15, 3}
    );

    private final String model;
    private final int passengerCapacity;
    private final int crewCapacity;

    public PassengerPlane(String model) {

        if (!MODEL_SPECS.containsKey(model)) {
            throw new IllegalArgumentException(
                    String.format("Model type '%s' is not recognized", model)
            );
        }

        this.model = model;

        int[] specs = MODEL_SPECS.get(model);
        this.passengerCapacity = specs[0];
        this.crewCapacity = specs[1];
    }

    @Override
    public String getModel() {
        return model;
    }

    @Override
    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    @Override
    public int getCrewCapacity() {
        return crewCapacity;
    }
}