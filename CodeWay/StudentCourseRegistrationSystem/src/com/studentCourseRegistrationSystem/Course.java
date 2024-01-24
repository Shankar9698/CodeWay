package com.studentCourseRegistrationSystem;

import java.util.ArrayList;
import java.util.List;

public class Course {
    private String courseCode;
    private String courseTitle;
    private String courseDescription;
    private int courseCapacity;
    private List<Student> registeredStudents;

    public Course(String courseCode, String courseTitle, String courseDescription, int courseCapacity) {
        this.courseCode = courseCode;
        this.courseTitle = courseTitle;
        this.courseDescription = courseDescription;
        this.courseCapacity = courseCapacity;
        this.registeredStudents = new ArrayList<>();
    }

    public String getCourseCode() {
        return courseCode;
    }

    public List<Student> getRegisteredStudents() {
        return registeredStudents;
    }

    public boolean registerStudent(Student student) {
        if (registeredStudents.size() < courseCapacity) {
            registeredStudents.add(student);
            return true;
        } else {
            return false; // Course is full
        }
    }

    public void displayCourseDetails() {
        System.out.println("Course Code: " + courseCode);
        System.out.println("Course Title: " + courseTitle);
        System.out.println("Course Description: " + courseDescription);
        System.out.println("Course Capacity: " + courseCapacity);
        System.out.println("Registered Students: " + registeredStudents.size());
    }
}
