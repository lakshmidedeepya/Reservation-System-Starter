package flight.reservation.order;

import flight.reservation.Customer;
import flight.reservation.Passenger;
import flight.reservation.flight.ScheduledFlight;

import java.util.List;
import java.util.stream.Collectors;

public class FlightOrderBuilder {
    private Customer customer;
    private List<ScheduledFlight> flights;
    private List<String> passengerNames;
    private double price;

    public FlightOrderBuilder forCustomer(Customer customer) {
        this.customer = customer;
        return this;
    }

    public FlightOrderBuilder onFlights(List<ScheduledFlight> flights) {
        this.flights = flights;
        return this;
    }

    public FlightOrderBuilder withPassengers(List<String> passengerNames) {
        this.passengerNames = passengerNames;
        return this;
    }

    public FlightOrderBuilder atPrice(double price) {
        this.price = price;
        return this;
    }

    public FlightOrder build() {
        if (customer == null || flights == null || passengerNames == null) {
            throw new IllegalStateException("Order is not valid");
        }

        OrderRequest request = new OrderRequest(customer, passengerNames, flights);
        ValidationHandler chain = new NoFlyCustomerHandler();
        chain.setNext(new NoFlyPassengerHandler())
                .setNext(new SeatCapacityHandler());

        if (!chain.validate(request)) {
            throw new IllegalStateException("Order is not valid");
        }

        FlightOrder order = new FlightOrder(flights);
        order.setCustomer(customer);
        order.setPrice(price);
        List<Passenger> passengers = passengerNames
                .stream()
                .map(Passenger::new)
                .collect(Collectors.toList());
        order.setPassengers(passengers);
        order.getScheduledFlights().forEach(scheduledFlight -> scheduledFlight.addPassengers(passengers));
        customer.getOrders().add(order);
        return order;
    }
}
