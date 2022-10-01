package controller;

import dto.Course;
import dto.Teacher;
import org.hibernate.SessionFactory;
import repository.CourseRepository;
import repository.TeacherRepository;

import java.util.ArrayList;
import java.util.Scanner;

public class TeacherController {
    private final TeacherRepository teacherRepository;
    private final CourseRepository courseRepository;
    private Scanner scanner;

    public TeacherController(Scanner scanner, SessionFactory sessionFactory) {
        this.scanner = scanner;
        this.teacherRepository = new TeacherRepository(sessionFactory);
        this.courseRepository = new CourseRepository(sessionFactory);
    }

    public void createTeacher(){
        Teacher teacher = new Teacher();
        System.out.println("Enter teacher first name :");
        teacher.setFirstName(scanner.nextLine());
        System.out.println("Enter teacher last name :");
        teacher.setLastName(scanner.nextLine());
        System.out.println("Enter course id for teacher :");
        Course course = courseRepository.findCourseById(Long.parseLong(scanner.nextLine()));
        if (course == null) {
            System.out.println("Please provide valid course ID!");
            return;
        }
        teacher.setCourse(course);
        teacher.getCourse().getTitle();
        teacherRepository.createTeacher(teacher);
        System.out.println(teacher.getFirstName() + " Created successfully");

    }


    public void findTeacherById(){
        Teacher teacher = new Teacher();
        System.out.println("Enter teacher id :");
        int id = scanner.nextInt();
        System.out.println("Enter teacher's new lastname: ");
        String replace = scanner.next();
        teacher.setId((long) id);
        teacher.setLastName(replace);

        teacherRepository.findTeacherById(teacher.getId());

        System.out.println(teacher.getLastName() + " successfully updated");

    }

    public void displayAllTeachers() {
        ArrayList<Teacher> teachers = teacherRepository.getAllTeachers();

        System.out.println("ID | teacher Name");

        for (Teacher teacher: teachers){
            System.out.println(teacher.getId() + " | " + teacher.getFirstName() + " " + teacher.getLastName());
        }
    }

}
