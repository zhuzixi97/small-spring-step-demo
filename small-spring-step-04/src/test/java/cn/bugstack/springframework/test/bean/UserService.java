package cn.bugstack.springframework.test.bean;

public class UserService {
    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void printUserName(){
        System.out.println(userName);
    }

    private UserDao userDao;
    private String userName;
}
