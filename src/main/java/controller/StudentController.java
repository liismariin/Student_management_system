package controller;

import dto.Course;
import dto.GRADE;
import dto.Student;
import dto.Teacher;
import org.hibernate.SessionFactory;
import repository.CourseRepository;
import repository.StudentRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentController {
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;
    private Scanner scanner;

    public StudentController(Scanner scanner, SessionFactory sessionFactory) {
        this.scanner = scanner;
        this.studentRepository = new StudentRepository(sessionFactory);
        this.courseRepository = new CourseRepository(sessionFactory);
    }

    public void createStudent() {
        Student student = new Student();
        System.out.println("Enter students first name :");
        student.setFirstName(scanner.nextLine());
        System.out.println("Enter students last name :");
        student.setLastName(scanner.nextLine());
        System.out.println("Enter course id for student :");
        Course course = courseRepository.findCourseById(Long.parseLong(scanner.nextLine()));
        if (course == null) {
            System.out.println("Please provide valid course ID!");
            return;
        }
        System.out.println("Enter students course exam score; ");
        if ((scanner.nextInt()) > 50) {
            System.out.println("Course exam " + GRADE.PASS);
        } else {
            System.out.println("Course exam " + GRADE.FAILED);
        }
        // student.setCourse(List<Course> course);
        studentRepository.createStudent(student);

        System.out.println(student.getFirstName() + " Created successfully");
    }

    public void displayAllStudents() {
        ArrayList<Student> students = studentRepository.getAllStudents();

        System.out.println("ID | Student Last name");

        for (Student student : students) {
            System.out.println(student.getId() + " | " + student.getLastName());
        }
    }

    public void findStudentById() {
        Student student = new Student();
        System.out.println("Enter student's id :");
        int id = scanner.nextInt();
        System.out.println("Enter student's new first name: ");
        String replace = scanner.next();
        student.setId((long) id);
        student.setLastName(replace);

        studentRepository.findStudentById(student.getId());

        System.out.println(student.getFirstName() + " successfully updated");

    }

}
