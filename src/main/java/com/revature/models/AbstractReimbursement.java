package com.revature.models;

import java.util.Objects;

public abstract class AbstractReimbursement {

    private int id;
    private Status status;
    private User author;
    private User resolver;
    private double amount;
    private String date;
    private String location;
    private String justification;
    private String grade;
    private String title;

    public AbstractReimbursement() {
        super();
    }

    public AbstractReimbursement(int id, Status status, User author, User resolver, double amount, String date, String location, String justification, String grade, String title) {
        super();
        this.id = id;
        this.status = status;
        this.author = author;
        this.amount = amount;
        this.date = date;
        this.location = location;
        this.justification = justification;
        this.grade = grade;
        this.title = title;


    }


    public AbstractReimbursement(int id, Status status, User author, User resolver, Double amount, String date, String location, String justification, String title) {
        this.id = id;
        this.status = status;
        this.author = author;
        this.resolver = resolver;
        this.amount = amount;
        this.date = date;
        this.location = location;
        this.justification = justification;
        this.title = title;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public int getId() {return id;}

    public void setId(int id) {this.id = id;}




    public void setStatus(Status status) {this.status = status;}


    public double getAmount() {return amount;}

    public void setAmount(double amount) {this.amount = amount;}


    public abstract String getStatus();

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public User getAuthor(){return author;}

    public void setAuthor(User author) {this.author = author;}

    public User getResolver() {return resolver;}

    public void setResolver(User resolver) {this.resolver = resolver;}

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getJustification() {
        return justification;
    }

    public void setJustification(String justification) {
        this.justification = justification;
    }

    @Override
    public int hashCode() {return Objects.hash(id, status, author, resolver, amount);}

    public String toString() {
        return "AbstractReimbusrement{" +
                "id=" + id +
                ", status=" +status+
                ", author=" +author+
                ",resolver=" + resolver+
                ", amount=" + amount +
                ", date=" + date +
                ", location=" + location +
                ", justification="+ justification +
                ", title=" + title +
                "}";
    }
}
