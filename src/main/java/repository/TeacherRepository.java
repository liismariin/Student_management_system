package repository;

import dto.Course;
import dto.Student;
import dto.Teacher;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.Query;
import java.util.ArrayList;

public class TeacherRepository {
    private final SessionFactory factory;
    private Session session;
    private Transaction transaction;

    public TeacherRepository(SessionFactory sessionFactory) {
        this.factory = sessionFactory;
    }

    public String createTeacher(Teacher teacher) {
        String message;
        try {
            session = factory.openSession();
            transaction = session.beginTransaction();
            session.persist(teacher);
            transaction.commit();
            message = "Teacher created successfully";
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

    public ArrayList<Teacher> getAllTeachers() {
        ArrayList<Teacher> teachers = new ArrayList<>();
        try {
            session = factory.openSession();
            transaction = session.beginTransaction();
            teachers = (ArrayList<Teacher>) session.createQuery("FROM teachers", Teacher.class).list();
        } catch (Exception exception) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.out.println(exception.getClass() + ": " + exception.getMessage());
        } finally {
            session.close();
        }

        return teachers;
    }

    public Teacher findTeacherById(Long Id) {
        Teacher teacher = new Teacher();
        try {
            session = factory.openSession();
            transaction = session.beginTransaction();
            teacher = session.find(Teacher.class, teacher.getId());
            Query query = session.createQuery("update Teacher set lastName='" + teacher.getLastName() + "' where id='" + teacher.getId() + "' ");
            int result = query.executeUpdate();
            System.out.println(result);
            transaction.commit();
        } catch (Exception exception) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.out.println(exception.getClass() + ": " + exception.getMessage());
        } finally {
            session.close();
        }

        return teacher;
    }
}