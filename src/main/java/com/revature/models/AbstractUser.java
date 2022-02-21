package com.revature.models;

import java.util.Objects;

public class AbstractUser {
    private int id;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String position;
    private String email;


    public AbstractUser() {
        super();
    }

    public AbstractUser(int id, String username, String password, String position) {
        super();
        this.id = id;
        this.username = username;
        this.password = password;
        this.position = position;
    }

    public AbstractUser(int id, String firstName, String lastName, String username, String password) {
        super();
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
    }

    public AbstractUser(int id, String firstName, String lastName, String username, String password, String position) {
        super();
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.position = position;
    }



    public AbstractUser(int id, String firstName, String lastName, String username, String email, String password, String position){
        super();
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.email = email;
        this.password = password;
        this.position = position;


}
public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public int getId() {return id;}

    public void setId(int id) {
        this.id = id;
    }
        public String getUsername () {return username;}

        public void setUsername(String username){
        this.username = username;}

    public String getPassword() {
        return password;
    }

    public String getFirstName() {

        return firstName;
    }

    public void setFirstName(String firstName) {

        this.firstName = firstName;
    }

    public String getLastName() {

        return lastName;
    }

    public void setLastName(String lastName) {

        this.lastName = lastName;
    }

    public String getPosition() {

        return position;
    }

    public void setPosition(String position) {

        this.position = position;
    }

    public void setPassword(String password) {

        this.password = password;
    }

    public String getRole() {

        return position;
    }

    public void setRole(String role) {

        this.position = position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractUser that = (AbstractUser) o;
        return id == that.id && Objects.equals(username, that.username) && Objects.equals(password, that.password) && position == that.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, position);
    }

    @Override
    public String toString() {
        return "AbstractUser{" +
                "id=" + id +
                "firstName=" + firstName + '\'' +
                "lastName=" + lastName + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", position=" + position +
                '}';
    }
}


