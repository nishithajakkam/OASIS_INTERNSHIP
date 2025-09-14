public class User {
    private final String id;
    private final String pin;


    public User(String id, String pin) {
        this.id = id;
        this.pin = pin;
    }

    public String getId() {
        return id;
    }

    public String getPin() {
        return pin;
    }
}
