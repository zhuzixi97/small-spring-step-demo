package cn.bugstack.springframework.test.bean;

public class UserService {
    private String name;
    UserService(String name){
        this.name = name;
    }
    public void queryUserInfo(){
        System.out.println("查询用户信息");
    }

}
