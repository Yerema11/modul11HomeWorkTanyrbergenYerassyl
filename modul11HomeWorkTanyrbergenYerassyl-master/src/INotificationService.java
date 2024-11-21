public interface INotificationService {
    void sendBookingConfirmation(String userName, String hotelName);
    void sendPaymentReminder(String userName);
}
