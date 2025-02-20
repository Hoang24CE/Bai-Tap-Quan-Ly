public class Author {
    private String name;
    private String email;
    private char gender; // 'm' hoặc 'f'

    // Constructor
    public Author(String name, String email, char gender) {
        this.name = name;
        this.email = email;
        this.gender = gender;
    }

    // Getter cho name
    public String getName() {
        return name;
    }

    // Getter cho email
    public String getEmail() {
        return email;
    }

    // Setter cho email
    public void setEmail(String email) {
        this.email = email;
    }

    // Getter cho gender
    public char getGender() {
        return gender;
    }

    // toString method
    @Override
    public String toString() {
        return "Author[name=" + name + ", email=" + email + ", gender=" + gender + "]";
    }
}
