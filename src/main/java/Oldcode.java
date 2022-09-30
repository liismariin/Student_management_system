//import dto.Course;
//import dto.Student;
//import dto.Teacher;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.Transaction;
//import org.hibernate.cfg.Configuration;
//
//import javax.persistence.Query;
//import java.util.*;
//
//public class Oldcode {
//    public static void Oldcode(String[] args) {
//        SessionFactory sessionFactory = new Configuration()
//                .configure("hibernate.cfg.xml")
//                .addAnnotatedClass(Student.class)
//                .addAnnotatedClass(Teacher.class)
//                .addAnnotatedClass(Course.class)
//                .buildSessionFactory();
//
//        Session session = sessionFactory.openSession();
//        Transaction transaction = session.beginTransaction();
//
//        Scanner YesNo = new Scanner(System.in);
//        Scanner scanner = new Scanner(System.in);
//        Teacher teacher3 = new Teacher();
//        Student student3 = new Student();
//        Course course3 = new Course();
//        int n = 1000;
//
//        for (int i = 0; i < n; i++) {
//            teacher3.getId();// ei toota
//            System.out.println("Enter teacher first name :");
//            teacher3.setFirstName(scanner.nextLine());
//            System.out.println("Enter teacher last name :");
//            teacher3.setLastName(scanner.nextLine());
////            System.out.println("Enter course name :");
////            teacher3.setCourse(scanner.nextLine());
//            session.persist(teacher3);
//            System.out.println(teacher3);
//            System.out.println("Do you want continue input teachers? yes/no :");
//            String yesno = YesNo.next();
//            if (yesno.equals("yes")) {
//                continue;
//            } else {
//                System.out.println("Create student :");
//                System.out.println("Enter student first name :");
//                student3.setFirstName(scanner.nextLine());
//                System.out.println("Enter student last name :");
//                student3.setLastName(scanner.nextLine());
//                session.persist(student3);
//                System.out.println(student3);
//                System.out.println("Do you want continue input student? yes/no :");
//                String yesno1 = YesNo.next();
//                if (yesno1.equals("yes")) {
//                    continue;
//                } else {
//                    System.out.println("Enter course name :");
//                    course3.setCourse(scanner.nextLine());
//                    session.persist(course3);
//                    System.out.println(course3);
//                    System.out.println("Do you want to continue entering course's data? yes/no :");
//                    String yesno2 = YesNo.next();
//                    if (yesno2.equals("yes")) {
//                        continue;
//                    } else {
//                        System.out.println("You have succesfully input data");
//
//                        Student student = session.load(Student.class, 2L);
//                        student.setFirstName("Juku");
//                        session.update(student);
//
//                        String qryString = "delete from Student s where s.studentId=17";
//                        Query query4 = session.createQuery(qryString);
//                        int count = query4.executeUpdate();
//                        System.out.println(count + " Record(s) Deleted.");
//
//                        transaction.commit();
//                        session.close();
//                        break;
//                    }
//                }
//
//
//
//
//
////READ
////                Student foundStudent = session.get(Student.class, 1L);
////                System.out.println(foundStudent);
////
////                ArrayList<Teacher> query = (ArrayList<Teacher>) session.createQuery("FROM teachers where lastName = 'Marple'", Teacher.class).list();
////                ArrayList<Student> query1 = (ArrayList<Student>) session.createQuery("from students where age=22", Student.class).list();
////
////                System.out.println(query);
////                System.out.println(query1);
////                // }*/
//
////
////                transaction.commit();
////                session.close();
//
////                Scanner scanner = new Scanner(System.in);
////                System.out.println("Do you want to input a teacher?");
////                if (scanner.nextLine().equals("yes")) {
////                    Teacher teacher3 = new Teacher();
////                    System.out.println("Enter teacher first name :");
////                    teacher3.setFirstName(scanner.nextLine());
////                    System.out.println("Enter teacher last name :");
////                    teacher3.setLastName(scanner.nextLine());
////                    System.out.println("Enter course name :");
////                    teacher3.setCourse(scanner.nextLine());
////                    System.out.println(teacher3);
////                } if (scanner.nextLine().equals("no")) {
////                    System.out.println("Do you want to input a teacher?");
////                    Student student2 = new Student();
////                    System.out.println("Enter students first name :");
////                    student2.setFirstName(scanner.nextLine());
////                    System.out.println("Enter students last name :");
////                    student2.setLastName(scanner.nextLine());
////                    System.out.println("Enter students biology exam score; ");
////                    if ((scanner.nextInt()) > 50) {
////                        System.out.println("Biology exam " + PAST);
////                    } else {
////                        System.out.println("Biology exam " + GRADE.FAILED);
////                    }
////                    System.out.println("Enter students math exam score; ");
////                    if ((scanner.nextInt()) > 50) {
////                        System.out.println("Math exam " + PAST);
////                    } else {
////                        System.out.println("Math exam " + GRADE.FAILED);
////                    }
////                    System.out.println("Enter students IT exam score; ");
////                    if ((scanner.nextInt()) > 50) {
////                        System.out.println("IT exam " + PAST);
////                    } else {
////                        System.out.println("IT exam " + GRADE.FAILED);
////                    }
////                    System.out.println(" ");
////                    System.out.println(student2);
////                    session.persist(student2);
////                    return;
////                }
//
//            }
//
//        }
//    }
//}