package flight.reservation.order;

public class NoFlyPassengerHandler extends ValidationHandler {
    @Override
    protected boolean handle(OrderRequest request) {
        if (request.getPassengerNames() == null) {
            return false;
        }
        return request.getPassengerNames().stream()
                .noneMatch(passenger -> FlightOrder.getNoFlyList().contains(passenger));
    }
}
