package flight.reservation.order;

public class NoFlyCustomerHandler extends ValidationHandler {
    @Override
    protected boolean handle(OrderRequest request) {
        if (request.getCustomer() == null) {
            return false;
        }
        return !FlightOrder.getNoFlyList().contains(request.getCustomer().getName());
    }
}
