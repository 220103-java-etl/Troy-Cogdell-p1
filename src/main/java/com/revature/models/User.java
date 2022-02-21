package com.revature.models;

public class User extends AbstractUser {



    public User(int id, String status, String author, String resolver, String amount, String date, String location, String justification, String title){super();}

     private int id;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String position;
    private String email;

    public User(int id, String firstName, String lastName, String username, String email,String password, String position) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.email = email;
        this.password = password;
        this.position = position;
    }

         public User(String firstName, String lastName, String username, String password, String position){
            this.firstName = firstName;
            this.lastName = lastName;
            this.username = username;
            this.password = password;
            this.position = position;

    }

    public User() {

    }

    public User(String firstName, String lastName, String username, String email, String password, String position) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.email = email;
        this.password = password;
        this.position = position;

    }

    public int getId() {
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    public String getFirstName(){
        return firstName;

    }
    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String toString(){
        return "User [id="+ this.id +", firstName="+this.firstName +
                ", lastName=" +this.lastName + ", Username=" + this.username+
                ", email=" + this.email +
                ", password=" + this.password + ", position=" + this.position + "]";
    }
}


