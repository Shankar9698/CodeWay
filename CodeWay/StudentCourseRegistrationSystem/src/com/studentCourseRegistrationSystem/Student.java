package com.studentCourseRegistrationSystem;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private int studentID;
    private String name;
    private List<Course> registeredCourses;

    public Student(int studentID, String name) {
        this.studentID = studentID;
        this.name = name;
        this.registeredCourses = new ArrayList<>();
    }

    public int getStudentID() {
        return studentID;
    }

    public List<Course> getRegisteredCourses() {
        return registeredCourses;
    }

    public boolean registerForCourse(Course course) {
        if (!registeredCourses.contains(course)) {
            if (course.registerStudent(this)) {
                registeredCourses.add(course);
                return true;
            } else {
                System.out.println("Course " + course.getCourseCode() + " is full. Cannot register.");
                return false;
            }
        } else {
            System.out.println("Already registered for course " + course.getCourseCode());
            return false;
        }
    }

    public void dropCourse(Course course) {
        if (registeredCourses.contains(course)) {
            registeredCourses.remove(course);
            course.getRegisteredStudents().remove(this);
            System.out.println("Dropped course " + course.getCourseCode());
        } else {
            System.out.println("Not registered for course " + course.getCourseCode());
        }
    }

    public void displayStudentDetails() {
        System.out.println("Student ID: " + studentID);
        System.out.println("Name: " + name);
        System.out.println("Registered Courses: " + registeredCourses.size());
    }
}
