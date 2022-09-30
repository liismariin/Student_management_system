package repository;

import dto.Course;
import dto.Student;
import dto.Teacher;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;

public class StudentRepository {
    private final SessionFactory factory;
    private Session session;
    private Transaction transaction;

    public StudentRepository(SessionFactory sessionFactory) {
        this.factory = sessionFactory;
    }

    public String createStudent(Student student) {
        String message;
        try {
            session = factory.openSession();
            transaction = session.beginTransaction();
            session.persist(student);
            transaction.commit();
            message = "Student created successfully";
        } catch (Exception exception) {
            if (transaction != null) {
                transaction.rollback();
            }
            message = exception.getClass() + ": " + exception.getMessage();
        } finally {
            session.close();
        }

        return message;
    }

    public ArrayList<Student> getAllStudents() {
        ArrayList<Student> students = new ArrayList<>();
        try {
            session = factory.openSession();
            transaction = session.beginTransaction();
            students = (ArrayList<Student>) session.createQuery("FROM students", Student.class).list();
        } catch (Exception exception) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.out.println(exception.getClass() + ": " + exception.getMessage());
        } finally {
            session.close();
        }

        return students;
    }

    public Student findStudentById(Long Id) {
        Student student = new Student();
        try {
            session = factory.openSession();
            transaction = session.beginTransaction();
            student = session.find(Student.class, Id);

        } catch (Exception exception) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.out.println(exception.getClass() + ": " + exception.getMessage());
        } finally {
            session.persist(student);
            transaction.commit();
            session.close();
        }

        return student;
    }
}
