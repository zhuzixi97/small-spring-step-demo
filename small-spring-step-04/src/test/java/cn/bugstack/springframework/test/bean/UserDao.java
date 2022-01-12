package cn.bugstack.springframework.test.bean;

public class UserDao {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    public UserDao(String name){
        this.name = name;
    }

    public UserDao(){
    }

}
