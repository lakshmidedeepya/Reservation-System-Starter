package flight.reservation.order;

public class EmailConfirmationObserver implements OrderObserver {
    @Override
    public void onOrderCreated(FlightOrder order) {
        if (order.getCustomer() == null) {
            System.out.println("Order created. Customer email is not set.");
            return;
        }
        System.out.println("Confirmation email sent to " + order.getCustomer().getEmail());
    }
}
