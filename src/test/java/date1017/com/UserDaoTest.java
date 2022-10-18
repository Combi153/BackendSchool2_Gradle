package date1017.com;

import date1017.com.dao.AWSConnectionMaker;
import date1017.com.dao.DaoFactory;
import date1017.com.dao.UserDao;
import date1017.com.domain.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class UserDaoTest {

    @Test
    void addAndSelect() {
        UserDao userDao = new DaoFactory().awsUserDao();
        User user = new User("15", "Ruby", "1135");
        userDao.add(user);

        User selectedUser = userDao.findById("15");
        Assertions.assertEquals("Ruby", selectedUser.getName());
    }
}