package User;

/*
 * This UserDO will be POJO of client request which can be mapped to User class
 */

public class UserDO {
    int userID;
    String email;
    String name;

    public UserDO() {

    }

    public UserDO(int userID, String email, String name) {
        this.userID = userID;
        this.email = email;
        this.name = name;
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
    public String getName() {
        return name;
    }
    public void setName(String userName) {
        this.name = userName;
    }
}
