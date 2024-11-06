package marcoDomingues.user_App;

public class User {
    private String id;
    private String userName;
    private String name;
    private String email;
    private String password;
    private String age;
    private String genre;

    public User(String id,String userName,String password,String name,String email,String age, String genre) {
        this.id = id;
        this.userName = userName;
        this.name = name;
        this.email = email;
        this.password = password;
        this.age = age;
        this.genre = genre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}



