package flight.reservation.order;

public interface OrderObserver {
    void onOrderCreated(FlightOrder order);
}
