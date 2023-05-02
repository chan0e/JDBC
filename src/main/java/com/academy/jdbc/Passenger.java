package com.academy.jdbc;

public class Passenger {

    private int PassengerNo;
    private String PassengerName;
    private int Grade;
    private int Age;

    public Passenger(int passengerNo, String passengerName, int grade, int age) {
        PassengerNo = passengerNo;
        PassengerName = passengerName;
        Grade = grade;
        Age = age;
    }

    public int getPassengerNo() {
        return PassengerNo;
    }

    public void setPassengerNo(int passengerNo) {
        PassengerNo = passengerNo;
    }

    public String getPassengerName() {
        return PassengerName;
    }

    public void setPassengerName(String passengerName) {
        PassengerName = passengerName;
    }

    public int getGrade() {
        return Grade;
    }

    public void setGrade(int grade) {
        Grade = grade;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

//    @Override
//    public String toString() {
//        return " : " + getPassengerName() + "\n";
//    }
}
