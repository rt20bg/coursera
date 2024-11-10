package org.example;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

// Student class: Represents student data
public class Student {

    private String pin;
    private String firstName;
    private String lastName;
    private int totalCredit;
    private List<Course> courses;
    private LocalDateTime timeCreated;

    public Student(String pin, String firstName, String lastName, LocalDateTime timeCreated ) {
        this.pin = pin;
        this.firstName = firstName;
        this.lastName = lastName;
        this.totalCredit = 0;
        this.courses = new ArrayList<>();
        this.timeCreated = timeCreated;
    }

    public void addCourse(String courseName, Duration totalTime, int credit, int instructorName) {
        Course course = new Course(courseName, totalTime, credit, instructorName);
        this.courses.add(course);
        this.totalCredit += credit;
    }

    public String getPin() {
        return this.pin;
    }

    public String getName() {
        return this.firstName + " " + this.lastName;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public int getTotalCredit() {
        return totalCredit;
    }

    public List<Course> getCourses() {
        return this.courses;
    }

    public LocalDateTime getFirstEnrolment() {
        return this.timeCreated;
    }

    public String toString() {
        return "Student{" +
                "pin='" + pin + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", timeCreated=" + timeCreated +
                '}';
    }

}
