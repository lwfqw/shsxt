package classTest.POJO;

/**
 * @author lwf
 * @title: Users
 * @projectName 11_02Ojdbc
 * @description: TODO
 * @date 2020/11/221:23
 */
public class Users {
    private String name;
    private String password;

    public String getName() {
        return name;
    }

    public void setName(Object name) {
        this.name = (String)name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(Object password) {
        this.password = (String)password;
    }

    @Override
    public String toString() {
        return "Users{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
