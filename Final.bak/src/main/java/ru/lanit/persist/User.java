package ru.lanit.persist;

import javax.persistence.*;
import java.util.Objects;

@NamedQueries ({ @NamedQuery(name = "findByKeyword", query = "FROM User WHERE firstName LIKE :keyword ") })
@Entity
@Table(name = "\"USER\"")
public class User implements java.io.Serializable
{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="ID")
    private Long    id;
    private String  email;
    private String  password;
    @Column(name="FIRST_NAME")
    private String  firstName;
    @Column(name="LAST_NAME")
    private String  lastName;
    private Integer age;
    private Integer gender;
    private Integer role;

    public User(){}
    public User(Long id)
    {
        this.setId(id);
    }
    public User(Long id, String email, String password, String firstName, String lastName, Integer age, Integer gender, Integer role)
    {
        this.setId(id);
        this.setEmail(email);
        this.setPassword(password);
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setAge(age);
        this.setGender(gender);
        this.setRole(role);
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "EMAIL")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "PASSWORD")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "FIRST_NAME")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "LAST_NAME")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    @Column(name = "AGE")
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Basic
    @Column(name = "GENDER")
    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    @Basic
    @Column(name = "ROLE")
    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User that = (User) o;
        return id == that.id &&
                Objects.equals(email, that.email) &&
                Objects.equals(password, that.password) &&
                Objects.equals(firstName, that.firstName) &&
                Objects.equals(lastName, that.lastName) &&
                Objects.equals(age, that.age) &&
                Objects.equals(gender, that.gender) &&
                Objects.equals(role, that.role);
    }

    public String toString()
    {
        return this.getClass().getName() +
                " id=" + this.getId() +
                " email=" + this.getEmail() +
                " password=" + this.getPassword() +
                " firstName=" + this.getFirstName() +
                " lastName=" + this.getLastName() +
                " age=" + this.getAge() +
                " gender=" + this.getGender() +
                " role=" + this.getRole();
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, password, firstName, lastName, age, gender, role);
    }

}
