package milestone2;

/**
 *
 * @author Bryan
 */
public class Person {

    private int id;
    private String name;
    private String surname;
    private int age;
    private String email;
    private String phone;
    private int DepartmentID;
    private String password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getDepartmentID() {
        return DepartmentID;
    }

    public void setDepartmentID(int DepartmentID) {
        this.DepartmentID = DepartmentID;
    }

    public Person(int id, String name, String surname, int age, String email, String phone, int DepartmentID, String password) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.email = email;
        this.phone = phone;
        this.DepartmentID = DepartmentID;
        this.password = password;
    }

    public Person(String name, String surname, int age, String email, String phone, int DepartmentID, String password) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.email = email;
        this.phone = phone;
        this.password = password;        
        this.DepartmentID = DepartmentID;
    }

    public Person(String name, String surname, int age, String email, String phone, int DepartmentID) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.email = email;
        this.phone = phone;
        this.DepartmentID = DepartmentID;
    }
    
    

    public Person(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public Person() {
    }

    @Override
    public String toString() {
        return  id + " " + name + " " + surname + " " + age + " " + email + " " + phone + " " + password + " " + DepartmentID ;
    }
}
