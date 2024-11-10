package org.example;

import java.sql.Date;

public class StudentsCoursesXref {

    private String studentPin;
    private int courseId;
    private Date completionDate;

    // Constructor
    public StudentsCoursesXref(String studentPin, int courseId, Date completionDate) {
        this.studentPin = studentPin;
        this.courseId = courseId;
        this.completionDate = completionDate;
    }

    // Getters and setters
    public String getStudentPin() {
        return studentPin;
    }

    public void setStudentPin(String studentPin) {
        this.studentPin = studentPin;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public Date getCompletionDate() {
        return completionDate;
    }

    public void setCompletionDate(Date completionDate) {
        this.completionDate = completionDate;
    }

    public String toString() {
        return "StudentsCoursesXref{" +
                "studentPin='" + studentPin + '\'' +
                ", courseId=" + courseId +
                ", completionDate=" + completionDate +
                '}';
    }
}
