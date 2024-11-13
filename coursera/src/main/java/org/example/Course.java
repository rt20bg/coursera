package org.example;

import java.time.Duration;
import java.time.LocalDateTime;

public class Course {
    private String id;
    private String name;
    private Duration totalTime; // Duration to capture hours and minutes
    private int credit;
    private int instructorId; // Optionally, you could have an Instructor object instead
    private LocalDateTime timeCreated;

    // Full constructor
    public Course(String id, String name, Duration totalTime, int credit, int instructorId, LocalDateTime timeCreated) {
        this.id = id;
        this.name = name;
        this.totalTime = totalTime;
        this.credit = credit;
        this.instructorId = instructorId;
        this.timeCreated = timeCreated;
    }



    // Getters
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Duration getTotalTime() {
        return totalTime;
    }

    public int getCredit() {
        return credit;
    }

    public int getInstructorId() {
        return instructorId;
    }

    public LocalDateTime getTimeCreated() {
        return timeCreated;
    }

    // Convenience method to get total time in hours for reports
    public long getTotalTimeInHours() {
        return totalTime.toHours();
    }

    // Optionally, override toString for easy printing
    @Override
    public String toString() {
        return "Course{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", totalTime=" + totalTime.toHours() + " hours" +
                ", credit=" + credit +
                ", instructorId=" + instructorId +
                ", timeCreated=" + timeCreated +
                '}';
    }
}
