public interface IUserManagementService {
    boolean registerUser(String username, String password);
    boolean authenticateUser(String username, String password);
}
