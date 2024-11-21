import java.util.ArrayList;
import java.util.List;

public class UserManagementService implements IUserManagementService {

    private List<User> users = new ArrayList<>();

    @Override
    public boolean registerUser(String username, String password) {
        if (users.stream().anyMatch(u -> u.getUsername().equals(username))) {
            System.out.println("Пользователь с таким именем уже существует.");
            return false;
        }
        users.add(new User(username, password));
        return true;
    }

    @Override
    public boolean authenticateUser(String username, String password) {
        return users.stream().anyMatch(u -> u.getUsername().equals(username) && u.getPassword().equals(password));
    }
}

class User {
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
