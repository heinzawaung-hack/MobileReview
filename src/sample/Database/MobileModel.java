package sample.Database;

public class MobileModel {
    private int id;
    private String userName;
    private String password;
    private String gender;
    private String country;

    public MobileModel(int id, String userName, String password, String gender, String country) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.gender = gender;
        this.country = country;
    }

    public MobileModel(String userName, String password, String gender, String country) {
        this.userName = userName;
        this.password = password;
        this.gender = gender;
        this.country = country;
    }

    public MobileModel(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getGender() {
        return gender;
    }

    public String getCountry() {
        return country;
    }
}
