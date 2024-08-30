package User;

import java.util.*;

public class UserService {
    static List<User> userList;

    public UserDO addUser(UserDO userDo) {
        // doing some validation and creating User object
        User user = new User();
        user.setEmail(userDo.getEmail());
        user.setUserName(userDo.getName());
        user.setUserID(new Random().nextInt(100));
        userList.add(user);

        return convertUserDOToUser(user);
    }

    public UserDO convertUserDOToUser(User user) {
        UserDO userDO = new UserDO();
        userDO.setEmail(user.getEmail());
        userDO.setName(user.getUserName());
        userDO.setUserID(user.getUserID());

        return userDO;
    }

    public UserDO getUser(int userID) {
        for (User user: userList) {
            if (user.getUserID() == userID) {
                return convertUserDOToUser(user);
            }
        }
        System.out.println("User not present");
        return null;
    }
}