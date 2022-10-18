package date1017.com.dao;

import date1017.com.domain.User;

public class DaoFactory {
    public UserDao awsUserDao() {
        return new UserDao(awsConnectionMaker());
    }

    public UserDao localUserDao() {
        return new UserDao(localConnectionMaker());
    }

    public ConnectionMaker awsConnectionMaker() {
        return new AWSConnectionMaker();
    }

    public ConnectionMaker localConnectionMaker() {
        return new LocalConnectionMaker();
    }
}
