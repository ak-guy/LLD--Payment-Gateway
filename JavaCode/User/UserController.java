package User;

public class UserController {
    UserService userService;

    public UserController() {
        this.userService = new UserService();
    }

    public UserDO addUser(UserDO userDO) {
        return userService.addUser(userDO);
    }

    public UserDO getUser(int userID) {
        return userService.getUser(userID);
    }
}
