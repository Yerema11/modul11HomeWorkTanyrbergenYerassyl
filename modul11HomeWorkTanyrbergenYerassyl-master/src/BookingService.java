import java.util.ArrayList;
import java.util.List;

public class BookingService implements IBookingService {

    private List<Booking> bookings = new ArrayList<>();

    @Override
    public boolean bookRoom(String hotelName, String userName, String startDate, String endDate) {
        if (checkRoomAvailability(hotelName, startDate, endDate)) {
            bookings.add(new Booking(hotelName, userName, startDate, endDate));
            return true;
        }
        return false;
    }

    @Override
    public boolean checkRoomAvailability(String hotelName, String startDate, String endDate) {
        for (Booking booking : bookings) {
            if (booking.getHotelName().equals(hotelName) && booking.getStartDate().equals(startDate) && booking.getEndDate().equals(endDate)) {
                return false;
            }
        }
        return true;
    }
}

class Booking {
    private String hotelName;
    private String userName;
    private String startDate;
    private String endDate;

    public Booking(String hotelName, String userName, String startDate, String endDate) {
        this.hotelName = hotelName;
        this.userName = userName;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getHotelName() {
        return hotelName;
    }

    public String getUserName() {
        return userName;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }
}
