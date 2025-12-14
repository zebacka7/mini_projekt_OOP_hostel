package hostel.domain;

public class Guest 
{
protected String name;
protected String id;
protected String email;
// konstruktor gościa
public Guest(String id, String name, String email) {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("ID nie może być puste");
        }
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Imię nie może być puste");
        }
        if (email == null || !email.contains("@")) {
            throw new IllegalArgumentException("Niepoprawny format email");
        }

        this.id = id;
        this.name = name;
        this.email = email;
    }
// pobranie ID
    public String getId() {
        return id;
    }
// pobranie imienia
    public String getName() {
        return name;
    }
// pobranie emaila
    public String getEmail() {
        return email;
    }
// reprezentacja tekstowa gościa
    @Override
    public String toString() {
        return name + " (" + email + ")";
    }
}