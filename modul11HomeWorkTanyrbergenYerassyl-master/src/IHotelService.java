import java.util.List;
// Интерфейс для взаимодействия с UI-компонентом
public interface IHotelService {
    List<Hotel> searchHotels(String location, String classType, double maxPrice);
}


