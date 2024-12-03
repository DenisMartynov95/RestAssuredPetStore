package positiveTests.POGOForPositiveTests.requests;

public class LogIn {

    private String password = "123456";
    private String username = "Denis";

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public LogIn(String password, String username) {
        this.password = password;
        this.username = username;
    }

    public LogIn() {

    }
}

