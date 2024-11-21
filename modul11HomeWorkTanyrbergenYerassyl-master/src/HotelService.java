import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class HotelService implements IHotelService {
    @Override
    public List<Hotel> searchHotels(String location, String classType, double maxPrice) {
        // Пример: создать список отелей для тестирования
        List<Hotel> hotels = new ArrayList<>();

        // Добавим несколько отелей в список для теста
        hotels.add(new Hotel("Отель 1", "Алматы", "люкс", 500000));
        hotels.add(new Hotel("Отель 2", "Алматы", "эконом", 200000));
        hotels.add(new Hotel("Отель 3", "Алматы", "люкс", 700000));

        // Фильтруем отели по критериям
        List<Hotel> filteredHotels = new ArrayList<>();
        for (Hotel hotel : hotels) {
            if (hotel.getLocation().equals(location) &&
                    hotel.getClassType().equals(classType) &&
                    hotel.getPrice() <= maxPrice) {
                filteredHotels.add(hotel);
            }
        }

        return filteredHotels;  // Возвращаем список подходящих отелей
    }
}


class Hotel {
    private String name;
    private String location;
    private String classType;
    private double price;

    public Hotel(String name, String location, String classType, double price) {
        this.name = name;
        this.location = location;
        this.classType = classType;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public String getClassType() {
        return classType;
    }

    public double getPrice() {
        return price;
    }
}
