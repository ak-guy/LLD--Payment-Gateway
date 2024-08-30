package User;

public class User {
    int userID;
    String email;
    String userName;

    public User() {

    }

    public User(int userID, String email, String userName) {
        this.userID = userID;
        this.email = email;
        this.userName = userName;
    }

    public int getUserID() {
        return userID;
    }
    public void setUserID(int userID) {
        this.userID = userID;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }

}
