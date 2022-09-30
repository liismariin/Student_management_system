import controller.MenuController;
import dto.Course;
import dto.Student;
import dto.Teacher;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        MenuController menuController = new MenuController();
        menuController.start();
    }
}
/*
 choose what options we want
*  create student
* create teacher
* create course3
* grades for students
* */