public class PaymentService implements IPaymentService {

    @Override
    public boolean processPayment(double amount, String paymentMethod) {
        System.out.println("Обработка платежа на сумму " + amount + " через " + paymentMethod + "...");
        return true;
    }
}
