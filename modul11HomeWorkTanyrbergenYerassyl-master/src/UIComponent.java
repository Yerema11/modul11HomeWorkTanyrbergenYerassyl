import java.util.List;
import java.util.Scanner;

public class UIComponent {
    private IHotelService hotelService;
    private IBookingService bookingService;
    private IPaymentService paymentService;
    private INotificationService notificationService;
    private IUserManagementService userManagementService;

    public UIComponent(IHotelService hotelService, IBookingService bookingService, IPaymentService paymentService,
                       INotificationService notificationService, IUserManagementService userManagementService) {
        this.hotelService = hotelService;
        this.bookingService = bookingService;
        this.paymentService = paymentService;
        this.notificationService = notificationService;
        this.userManagementService = userManagementService;
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Введите команду (регистрация, поиск отелей, бронирование, оплата):");
            String command = scanner.nextLine();

            if (command.equals("регистрация")) {
                System.out.println("Введите имя пользователя:");
                String username = scanner.nextLine();
                System.out.println("Введите пароль:");
                String password = scanner.nextLine();
                userManagementService.registerUser(username, password);
            }
            // Аналогично для других команд: поиск отелей, бронирование, оплата.
        }
    }
}
