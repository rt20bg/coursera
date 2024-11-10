package org.example;

import java.sql.*;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class DatabaseDataSource implements DataSource {

    private DatabaseConnection databaseConnection;

    // Constructor to receive DatabaseConnection and use it for data retrieval
    public DatabaseDataSource(DatabaseConnection databaseConnection) {
        this.databaseConnection = databaseConnection;
    }

    // Retrieve all students from the database
    @Override
    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        String query = "SELECT * FROM students";

        try (Connection connection = databaseConnection.connect();
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                String pin = rs.getString("pin");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                Timestamp timeCreated = rs.getTimestamp("time_created");
                // Assuming timeCreated is a Timestamp in the database, convert it to LocalDateTime
                students.add(new Student(pin, firstName, lastName, timeCreated.toLocalDateTime()));
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle exceptions properly
        }
        return students;
    }

    // Retrieve all courses from the database
    @Override
    public List<Course> getAllCourses() {
        List<Course> courses = new ArrayList<>();
        String query = "SELECT * FROM courses";

        try (Connection connection = databaseConnection.connect();
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                String id = rs.getString("id");
                String name = rs.getString("name");
                int totalTime = rs.getInt("total_time");
                int credit = rs.getInt("credit");
                int instructorId = rs.getInt("instructor_id");
                Timestamp timeCreated = rs.getTimestamp("time_created");
                // Assuming timeCreated is a Timestamp in the database, convert it to LocalDateTime
                courses.add(new Course(id, name, Duration.ofHours(totalTime), credit, instructorId, timeCreated.toLocalDateTime()));
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle exceptions properly
        }
        return courses;
    }

    // Retrieve a student by pin
    @Override
    public Student getStudent(String pin) {
        Student student = null;
        String query = "SELECT * FROM students WHERE pin = ?";

        try (Connection connection = databaseConnection.connect();
             PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, pin);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    String firstName = rs.getString("first_name");
                    String lastName = rs.getString("last_name");
                    Timestamp timeCreated = rs.getTimestamp("time_created");
                    student = new Student(pin, firstName, lastName, timeCreated.toLocalDateTime());
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle exceptions properly
        }
        return student;
    }

    // Retrieve all students-courses xrefs (student-course relationships) from the database
    @Override
    public List<StudentsCoursesXref> getAllStudentsCoursesXref() {
        List<StudentsCoursesXref> xrefs = new ArrayList<>();
        String query = "SELECT * FROM students_courses_xref";

        try (Connection connection = databaseConnection.connect();
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                String studentPin = rs.getString("student_pin");
                int courseId = rs.getInt("course_id");
                Date completionDate = rs.getDate("completion_date");
                xrefs.add(new StudentsCoursesXref(studentPin, courseId, completionDate));
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle exceptions properly
        }
        return xrefs;
    }
}
