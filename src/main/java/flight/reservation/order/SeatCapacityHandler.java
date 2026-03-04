package flight.reservation.order;

public class SeatCapacityHandler extends ValidationHandler {
    @Override
    protected boolean handle(OrderRequest request) {
        if (request.getFlights() == null || request.getPassengerNames() == null) {
            return false;
        }
        return request.getFlights().stream().allMatch(scheduledFlight -> {
            try {
                return scheduledFlight.getAvailableCapacity() >= request.getPassengerNames().size();
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
                return false;
            }
        });
    }
}
