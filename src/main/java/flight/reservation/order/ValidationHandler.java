package flight.reservation.order;

public abstract class ValidationHandler {
    private ValidationHandler next;

    public ValidationHandler setNext(ValidationHandler next) {
        this.next = next;
        return next;
    }

    public boolean validate(OrderRequest request) {
        if (!handle(request)) {
            return false;
        }
        if (next == null) {
            return true;
        }
        return next.validate(request);
    }

    protected abstract boolean handle(OrderRequest request);
}
