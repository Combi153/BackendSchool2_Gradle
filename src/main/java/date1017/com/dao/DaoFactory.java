package date1017.com.dao;

import date1017.com.domain.User;

public class DaoFactory {
    public UserDao awsUserDao() {
        ConnectionMaker connectionMaker = new AWSConnectionMaker();
        UserDao userDao = new UserDao(connectionMaker);
        return userDao;
    }

    public UserDao localUserDao() {
        ConnectionMaker connectionMaker = new LocalConnectionMaker();
        UserDao userDao = new UserDao(connectionMaker);
        return userDao;
    }
}
