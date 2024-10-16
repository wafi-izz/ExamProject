import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Student s1 = new Student("john",18,98523);
        Student s2 = new Student("alex",19,645);
        Student s3 = new Student("martin",17,6543);
        Student s4 = new Student("jack",20,6456);
        Student s5 = new Student("anna",21,437);
        Student s6 = new Student("erica",19,6486);
        Student s7 = new Student("julian",18,4536247);
        Student s8 = new Student("joe",17,6486);
        Student s9 = new Student("peter",18,67645);
        Student s10 = new Student("sarah",19,646);

        Course math = new MathematicsCourse(100,"10:30","12:45","Online","an online math class");
        math.enrollStudent(s1);
        math.enrollStudent(s2);
        math.enrollStudent(s3);
        math.enrollStudent(s4);
        math.enrollStudent(s5);

        System.out.println(math.getCourseFee());
        System.out.println(math.getCourseStartTime());
        System.out.println(math.getCourseEndTime());

        math.printCourseDescription();
        math.printEnrolledStudents();

        System.out.println("===========================");

        Course programming = new ProgrammingCourse(100,"02:30","04:45","on campus","an on campus programming class");
        programming.enrollStudent(s6);
        programming.enrollStudent(s7);
        programming.enrollStudent(s8);
        programming.enrollStudent(s9);
        programming.enrollStudent(s10);

        System.out.println(programming.getCourseFee());
        System.out.println(programming.getCourseStartTime());
        System.out.println(programming.getCourseEndTime());

        programming.printCourseDescription();
        programming.printEnrolledStudents();

    }
}

class Student {
    String name;
    int age;
    int studentID;

    public Student(String name, int age, int studentID) {
        this.name = name;
        this.age = age;
        this.studentID = studentID;
    }
    @Override
    public String toString() {
        return "\tname: " + name + ", age: " + age + ", studentID: [" + studentID + "]";
    }
}


interface Course {
     double getCourseFee();
     String getCourseStartTime();
     String getCourseEndTime();
     void printCourseDescription();
     void printEnrolledStudents();
     void enrollStudent(Student student);
     void unEnrollStudent(Student student);
}


abstract class OnlineCourse implements Course {
    double fee;
    String startTiming;
    String endTiming;
    String type;
    String description;
    Set<Student> students;
    public OnlineCourse(double fee , String startTiming, String endTiming, String type, String description) {
        this.fee = fee;
        this.startTiming = startTiming;
        this.endTiming = endTiming;
        this.type = type;
        this.description = description;
        students = new HashSet<>();
    }


    @Override
    public void printCourseDescription() {
        System.out.println(description);
    }
    @Override
    public void printEnrolledStudents() {
        for (Student student : students) {
            System.out.println(student);
        }
    }
    @Override
    public void enrollStudent(Student student) {
        students.add(student);
    }
    @Override
    public void unEnrollStudent(Student student) {
        students.remove(student);
    }
}
abstract class OnCampusCourse implements Course {
    double fee;
    String startTiming;
    String endTiming;
    String type;
    String description;
    Set<Student> students;
    public OnCampusCourse(double fee , String startTiming, String endTiming, String type, String description) {
        this.fee = fee;
        this.startTiming = startTiming;
        this.endTiming = endTiming;
        this.type = type;
        this.description = description;
        students = new HashSet<>();
    }

    @Override
    public void printCourseDescription() {
        System.out.println(description);
    }
    @Override
    public void printEnrolledStudents() {
        for (Student student : students){
            System.out.println(student);
        }
    }
    @Override
    public void enrollStudent(Student student) {
        students.add(student);
    }
    @Override
    public void unEnrollStudent(Student student) {
        students.remove(student);
    }
}

class ProgrammingCourse extends OnlineCourse {
    public ProgrammingCourse(double fee, String startTiming, String endTiming, String type, String description) {
        super(fee, startTiming, endTiming, type, description);
    }

    @Override
    public double getCourseFee() {
        return fee;
    }

    @Override
    public String getCourseStartTime() {
        return startTiming;
    }

    @Override
    public String getCourseEndTime() {
        return endTiming;
    }

    @Override
    public void printCourseDescription() {
        super.printCourseDescription();
    }

    @Override
    public void printEnrolledStudents() {
        System.out.println("Programming Course: \nstudent enrolled:");
        super.printEnrolledStudents();
    }

    @Override
    public void enrollStudent(Student student) {
        super.enrollStudent(student);
    }

    @Override
    public void unEnrollStudent(Student student) {
        super.unEnrollStudent(student);
    }
}
class MathematicsCourse extends OnCampusCourse {
    public MathematicsCourse(double fee, String startTiming, String endTiming, String type, String description) {
        super(fee, startTiming, endTiming, type, description);
    }

    @Override
    public double getCourseFee() {
        return fee;
    }

    @Override
    public String getCourseStartTime() {
        return startTiming;
    }

    @Override
    public String getCourseEndTime() {
        return endTiming;
    }
    @Override
    public void printCourseDescription() {
        super.printCourseDescription();
    }

    @Override
    public void printEnrolledStudents() {
        System.out.println("Mathematics Course: \nstudent enrolled:");
        super.printEnrolledStudents();
    }

    @Override
    public void enrollStudent(Student student) {
        super.enrollStudent(student);
    }

    @Override
    public void unEnrollStudent(Student student) {
        super.unEnrollStudent(student);
    }
}



/**
 * Course Interface:
 *
 *  Define a Course interface with the following methods:
 *  double getCourseFee()
 *  String getCourseStartTime()
 *  String getCourseEndTime()
 *  void printCourseDescription()
 *  void printEnrolledStudents()
 *  void enrollStudent(Student student)
 *  void unEnrollStudent(Student student)
 *
 *
 * OnlineCourse and OnCampusCourse:
 *
 *  Create two abstract classes, OnlineCourse and OnCampusCourse, that implement the Course interface.
 *  These classes should:
     *  Implement the necessary methods from the Course interface.
     *  Store basic course-related information such as course fee, timings, and type (online or on-campus).
     *  Maintain a unique list of enrolled students using a HashSet<Student>.
 *
 *
 * Student Class:
 *
 *  Define a Student class to store basic student information such as name, age, and student ID.
 *
 *
 *  Course Implementations:
 *  Create two concrete classes:
 *  ProgrammingCourse, which extends OnlineCourse.
 *  MathematicsCourse, which extends OnCampusCourse.
 *  Each class should define specific course-related fields and implement any abstract methods.
 *
 *
 * Main Program:
 *
 *  In the main program, create 10 instances of the Student class and assign some of them to either the ProgrammingCourse or  MathematicsCourse then test your interface functions one by one
 *  */