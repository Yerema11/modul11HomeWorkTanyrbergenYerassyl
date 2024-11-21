public class NotificationService implements INotificationService {

    @Override
    public void sendBookingConfirmation(String userName, String hotelName) {
        System.out.println("Отправлено уведомление о подтверждении бронирования для " + userName + " в отеле " + hotelName + ".");
    }

    @Override
    public void sendPaymentReminder(String userName) {
        System.out.println("Напоминание о платеже для пользователя " + userName + ".");
    }
}
