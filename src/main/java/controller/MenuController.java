package controller;

import dto.Course;
import dto.Student;
import dto.StudentResults;
import dto.Teacher;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class MenuController {
    private final SessionFactory sessionFactory;
    private final CourseController courseController;
    private final TeacherController teacherController;
    private final StudentController studentController;
  //  private final StudentResultsController studentsResultsController;
    Scanner scanner = new Scanner(System.in);
    public MenuController(){
        this.sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Teacher.class)
                .addAnnotatedClass(Student.class)
                .addAnnotatedClass(StudentResults.class)
                .buildSessionFactory();

        this.courseController = new CourseController(scanner, sessionFactory);
        this.teacherController = new TeacherController(scanner, sessionFactory);
        this.studentController = new StudentController(scanner, sessionFactory);
        //this.StudentsResultsController = new studentResultController(scanner, sessionFactory);
    }
    public void start(){
        System.out.println("""
            Welcome to student management system
            choose an option below
            
            1. Create course
            2. Create teacher
            3. Create student
            4. Enter Exam Result
            5. Register student to course

            6. View Courses
            7. View Teachers
            8. View Students
                        
            9. Update Course
            10. Update Teacher
            11. Update Student
            
            12. Delete Course
            13. Delete Teacher
            14. Delete Student
            
            15. Exit / end program
        """);

        String userChoice = scanner.nextLine();
        this.handleUserChoice(userChoice);
        this.start();
    }

    private void handleUserChoice(String userChoice) {
        switch (userChoice){
            case "1":
                System.out.println("==== Creating Course =====");
                this.courseController.createCourse();
                break;
            case "2":
                System.out.println("==== Creating Teacher =====");
                this.teacherController.createTeacher();
                break;
            case "3":
                System.out.println("==== Creating student =====");
                this.studentController.createStudent();
                break;
            case "4":
                System.out.println("==== Enter Exam Score =====");

                break;

            case "6":
                System.out.println("==== All Courses =====");
                courseController.displayAllCourses();
                break;

            case "7":
                System.out.println("==== All teachers ====");
                teacherController.displayAllTeachers();
                break;

            case "8":
                System.out.println("==== All students ====");
                studentController.displayAllStudents();
                break;

            case "9":
                System.out.println("==== Change course info ====");
                courseController.findCourseById();
                break;

            case "10":
                System.out.println("==== Change teacher info =====");
                teacherController.findTeacherById();
                break;

            case "11":
                System.out.println("==== Change student info ====");
                studentController.findStudentById();
                break;

            case "12":
                System.out.println("==== Delete course =====");
                this.courseController.deleteCourseById();
                break;

            case "13":
                System.out.println("==== Delete teacher =====");
 //               teacherController.deleteTeacher();
                break;

            case "14":
                System.out.println("==== Delete student =====");

                break;

            case "15":
                System.out.println("==== Good Bye =====");
                System.exit(0);
                break;
            default:
                System.out.println("Please choose one of available options");
        }
    }
}
