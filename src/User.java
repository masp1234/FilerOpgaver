public class User {
    int id;
    String name;
    String password;

    public User(int id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }
    public User(int id) {
        this.id = id;
    }
    public String toString() {
        return id + " " + name + " " + password;
    }
}
