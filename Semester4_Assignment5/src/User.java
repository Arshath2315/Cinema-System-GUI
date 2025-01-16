import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class User {
    private String username;
    private String password;
    private String email;
    private int loyaltyPoints;

    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.loyaltyPoints = 0;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getLoyaltyPoints() {
        return loyaltyPoints;
    }

    public void setLoyaltyPoints(int loyaltyPoints) {
        this.loyaltyPoints = loyaltyPoints;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", loyaltyPoints=" + loyaltyPoints +
                '}';
    }
}
