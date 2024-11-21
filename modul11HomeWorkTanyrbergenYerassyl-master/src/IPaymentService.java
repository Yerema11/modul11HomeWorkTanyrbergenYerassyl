public interface IPaymentService {
    boolean processPayment(double amount, String paymentMethod);
}
