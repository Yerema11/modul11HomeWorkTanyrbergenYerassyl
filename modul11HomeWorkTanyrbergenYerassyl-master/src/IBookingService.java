public interface IBookingService {
    boolean bookRoom(String hotelName, String userName, String startDate, String endDate);
    boolean checkRoomAvailability(String hotelName, String startDate, String endDate);
}
