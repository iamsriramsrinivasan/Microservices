package com.iamsriramsrinivasan.DataAccess;

public class Student {
    private long id;
    private String firstName, lastName;

    public Student(long id, String firstName, String lastName){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    @Override
    public String toString(){
        return String.format (
            "Student Details [id=%d, FirtsName=%s, LastName=%s]", id, firstName,lastName);
        }
}
