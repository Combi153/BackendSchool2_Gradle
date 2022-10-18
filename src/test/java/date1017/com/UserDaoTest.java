package date1017.com;

import date1017.com.domain.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserDaoTest {

    @Test
    void addAndSelect() {
        UserDao userDao = new UserDao();
        User user = new User("10", "Ruby", "1135");
        userDao.add(user);

        User selectedUser = userDao.findById("10");
        Assertions.assertEquals("Ruby", selectedUser.getName());
    }
}