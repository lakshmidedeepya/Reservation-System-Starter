package flight.reservation.order;

import flight.reservation.Customer;
import flight.reservation.flight.ScheduledFlight;

import java.util.List;

public class OrderRequest {
    private final Customer customer;
    private final List<String> passengerNames;
    private final List<ScheduledFlight> flights;

    public OrderRequest(Customer customer, List<String> passengerNames, List<ScheduledFlight> flights) {
        this.customer = customer;
        this.passengerNames = passengerNames;
        this.flights = flights;
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<String> getPassengerNames() {
        return passengerNames;
    }

    public List<ScheduledFlight> getFlights() {
        return flights;
    }
}
