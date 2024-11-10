// DataSource.java
package org.example;

import java.util.List;

public interface DataSource {
    List<Student> getAllStudents();
    List<Course> getAllCourses();
    Student getStudent(String pin);
    List<StudentsCoursesXref> getAllStudentsCoursesXref();
}
