package flight.reservation;

import flight.reservation.flight.ScheduledFlight;
import flight.reservation.order.FlightOrder;
import flight.reservation.order.FlightOrderBuilder;
import flight.reservation.order.Order;
import flight.reservation.order.OrderObserver;

import java.util.ArrayList;
import java.util.List;

public class Customer {

    private String email;
    private String name;
    private List<Order> orders;
    private final List<OrderObserver> observers = new ArrayList<>();

    public Customer(String name, String email) {
        this.name = name;
        this.email = email;
        this.orders = new ArrayList<>();
    }

    public FlightOrder createOrder(List<String> passengerNames, List<ScheduledFlight> flights, double price) {
        FlightOrder order = new FlightOrderBuilder()
                .forCustomer(this)
                .onFlights(flights)
                .withPassengers(passengerNames)
                .atPrice(price)
                .build();
        notifyObservers(order);
        return order;
    }

    public void addObserver(OrderObserver observer) {
        if (observer != null) {
            observers.add(observer);
        }
    }

    public void removeObserver(OrderObserver observer) {
        observers.remove(observer);
    }

    public void notifyObservers(FlightOrder order) {
        observers.forEach(observer -> observer.onOrderCreated(order));
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

}
