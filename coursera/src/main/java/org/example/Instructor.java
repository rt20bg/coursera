package org.example;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Instructor {

    private int id;
    private String firstName;
    private String lastName;
    private LocalDateTime timeCreated;
    private List<Course> coursesTaught;

    // Constructor with required fields
    public Instructor(int id, String firstName, String lastName, LocalDateTime timeCreated ) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.timeCreated = timeCreated;
        this.coursesTaught = new ArrayList<>();
    }

    // Method to add a course taught by this instructor
    public void addCourse(Course course) {
        if (course != null && !coursesTaught.contains(course)) {
            coursesTaught.add(course);
        }
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDateTime getTimeCreated() {
        return timeCreated;
    }

    public List<Course> getCoursesTaught() {
        return new ArrayList<>(coursesTaught); // Return a copy to prevent external modification
    }

    // Convenience method to get the full name
    public String getFullName() {
        return firstName + " " + lastName;
    }

    // Override toString for printing instructor details
    @Override
    public String toString() {
        return "Instructor{" +
                "id=" + id +
                ", name='" + getFullName() + '\'' +
                ", timeCreated=" + timeCreated +
                ", coursesTaught=" + coursesTaught.size() + " courses" +
                '}';
    }
}
