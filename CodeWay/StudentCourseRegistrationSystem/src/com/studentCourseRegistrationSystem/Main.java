package com.studentCourseRegistrationSystem;

public class Main {
    public static void main(String[] args) {
        // Creating courses
        Course mathCourse = new Course("MATH101", "Introduction to Mathematics", "Basic math concepts", 3);
        Course javaCourse = new Course("CS101", "Introduction to Java Programming", "Basic Java programming", 2);

        // Creating students
        Student student1 = new Student(1, "John Doe");
        Student student2 = new Student(2, "Jane Smith");

        // Registering students for courses
        student1.registerForCourse(mathCourse);
        student1.registerForCourse(javaCourse);

        student2.registerForCourse(mathCourse);

        // Displaying student and course details
        student1.displayStudentDetails();
        student2.displayStudentDetails();

        mathCourse.displayCourseDetails();
        javaCourse.displayCourseDetails();

        // Dropping a course
        student1.dropCourse(mathCourse);

        // Displaying updated details after dropping a course
        student1.displayStudentDetails();
        mathCourse.displayCourseDetails();
    }
}

