import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        IUserManagementService userService = new UserManagementService();
        IHotelService hotelService = new HotelService();
        IBookingService bookingService = new BookingService();
        IPaymentService paymentService = new PaymentService();
        INotificationService notificationService = new NotificationService();

        // Регистрация пользователя
        System.out.println("Введите команду (регистрация, поиск отелей, бронирование, оплата):");
        String command = scanner.nextLine();

        if ("регистрация".equals(command)) {
            System.out.println("Введите имя пользователя:");
            String username = scanner.nextLine();
            System.out.println("Введите пароль:");
            String password = scanner.nextLine();
            if (userService.registerUser(username, password)) {
                System.out.println("Регистрация прошла успешно!");
            } else {
                System.out.println("Ошибка при регистрации!");
            }
        }

        // Поиск отелей
        if ("поиск отелей".equals(command)) {
            System.out.println("Введите местоположение:");
            String location = scanner.nextLine();
            System.out.println("Введите тип класса отеля:");
            String classType = scanner.nextLine();
            System.out.println("Введите максимальную цену:");
            double maxPrice = scanner.nextDouble();
            scanner.nextLine();  // Чтобы избавиться от нового строки после ввода числа

            // Предположим, что метод searchHotels возвращает список отелей
            List<Hotel> hotels = hotelService.searchHotels(location, classType, maxPrice);
            if (!hotels.isEmpty()) {
                System.out.println("Найденные отели:");
                for (Hotel hotel : hotels) {
                    System.out.println(hotel.getName() + " в " + hotel.getLocation() + " - " + hotel.getPrice() + " за ночь");
                }
            } else {
                System.out.println("Отели не найдены по заданным критериям.");
            }
        }

        // Бронирование
        if ("бронирование".equals(command)) {
            System.out.println("Введите название отеля:");
            String hotelName = scanner.nextLine();
            System.out.println("Введите имя пользователя:");
            String userName = scanner.nextLine();
            System.out.println("Введите дату заезда (в формате YYYY-MM-DD):");
            String startDate = scanner.nextLine();
            System.out.println("Введите дату выезда (в формате YYYY-MM-DD):");
            String endDate = scanner.nextLine();

            if (bookingService.bookRoom(hotelName, userName, startDate, endDate)) {
                System.out.println("Бронирование успешно!");
                notificationService.sendBookingConfirmation(userName, hotelName);
            } else {
                System.out.println("Ошибка при бронировании.");
            }
        }

        // Оплата
        if ("оплата".equals(command)) {
            System.out.println("Введите сумму для оплаты:");
            double amount = scanner.nextDouble();
            scanner.nextLine();  // Чтобы избавиться от новой строки после ввода числа
            System.out.println("Введите метод оплаты (например, карта, PayPal):");
            String paymentMethod = scanner.nextLine();

            if (paymentService.processPayment(amount, paymentMethod)) {
                System.out.println("Оплата прошла успешно!");
                notificationService.sendPaymentReminder("пользователь");
            } else {
                System.out.println("Ошибка при оплате.");
            }
        }
    }
}
