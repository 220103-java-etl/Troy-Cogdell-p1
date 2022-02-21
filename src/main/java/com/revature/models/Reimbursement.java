package com.revature.models;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Reimbursement extends AbstractReimbursement implements List<Reimbursement> {
    private int id;
    private String status;
    private User author;
    private User resolver;
    private double amount;
    private String date;
    private String location;
    private String justification;
    private String title;
    private String grade;

    public Reimbursement(int id, String status, User author, User resolver, int amount, String date, String location, String justification, String title, String grade) {
        this.id = id;
        this.status = status;
        this.author = author;
        this.resolver = resolver;
        this.amount = amount;
        this.date = date;
        this.location = location;
        this.justification = justification;
        this.title = title;
        this.grade = grade;

    }

    /*public Reimbursement(int reimbursementId, Status status, User author, User resolver, Double amount, String date, String location, String justification, String grade) {
        this.id = reimbursementId;
        this.status = String.valueOf(status);
        this.author = author;
        this.resolver = resolver;
        this.amount = amount;
        this.date = date;
        this.location = location;
        this.justification = justification;
        this.grade = grade;
    }*/

    public Reimbursement(int reimbursementId, Status status, User author, User resolver, Double amount, String grade) {
        this.id = reimbursementId;
        this.status = String.valueOf(status);
        this.author = author;
        this.resolver = resolver;
        this.amount = amount;
        this.grade = grade;

    }

    public Reimbursement(int id, String status, User author, User resolver, double amount, String date, String location, String justification, String title) {
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

    public Reimbursement(int id, Status status, User author, User resolver, Double amount, String date, String location, String description, String justification) {
        this.id = id;
        this.status = String.valueOf(status);
        this.author = author;
        this.resolver = resolver;
        this.amount = amount;
        this.date = date;
        this.location = location;
        this.justification = justification;

    }

    public Reimbursement(int reimbursementId, Status status, User author, User resolver, Double amount) {
        this.id = reimbursementId;
        this.status = String.valueOf(status);
        this.author = author;
        this.resolver = resolver;
        this.amount = amount;
    }


    /*public Reimbursement(int id, Status status, User author, User resolver, Double amount, String date, String location, String justification, String title) {
        this.id = id;
        this.status = String.valueOf(status);
        this.author = author;
        this. resolver = resolver;
        this. amount = amount;
        this.date = date;
        this.location = location;
        this.justification = justification;
        this. title = title;
    }*/

    public Reimbursement(int id, Status status, User author, Double amount, User resolver, String date, String location, String justification, String title, String grade) {
        this.id =id;
        this.status = String.valueOf(status);
        this.author = author;
        this.amount = amount;
        this.resolver = resolver;
        this.date = date;
        this.location = location;
        this.justification = justification;
        this. title = title;
    }
    public Reimbursement(int id, Status status, User author, Double amount, String date, String location, String justification, String title, String grade) {
        this.id = id;
        this.status = String.valueOf(status);
        this.author = author;
        this.amount = amount;
        this.date = date;
        this.location = location;
        this.justification = justification;
        this.title = title;
        this.grade = grade;

    }



    @Override
    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    @Override
    public User getResolver() {
        return resolver;
    }

    public void setResolver(User resolver) {
        this.resolver = resolver;
    }

    @Override
    public double getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String getDate() {
        return date;
    }

    @Override
    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String getLocation() {
        return location;
    }

    @Override
    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String getJustification() {
        return justification;
    }

    @Override
    public void setJustification(String justification) {
        this.justification = justification;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    @Override
    public String toString() {
        return "Reimbursement{" +
                "id=" + id +
                ", status='" + status + '\'' +
                ", author='" + author + '\'' +
                ", resolver='" + resolver + '\'' +
                ", amount=" + amount +
                ", date='" + date + '\'' +
                ", location='" + location + '\'' +
                ", justification='" + justification + '\'' +
                ", title='" + title + '\'' +
                '}';
    }



    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<Reimbursement> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(Reimbursement reimbursement) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends Reimbursement> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends Reimbursement> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public Reimbursement get(int index) {
        return null;
    }

    @Override
    public Reimbursement set(int index, Reimbursement element) {
        return null;
    }

    @Override
    public void add(int index, Reimbursement element) {

    }

    @Override
    public Reimbursement remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<Reimbursement> listIterator() {
        return null;
    }

    @Override
    public ListIterator<Reimbursement> listIterator(int index) {
        return null;
    }

    @Override
    public List<Reimbursement> subList(int fromIndex, int toIndex) {
        return null;
    }
}



