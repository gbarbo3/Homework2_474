import java.util.ArrayList;

public class Student extends Person {

    ArrayList<Course> coursesTaken;
    ArrayList<Course> coursesEnrolled;
    double gpa;

    public Student(String firstName, String lastName, String email, int userID, ArrayList<Course> coursesTaken, ArrayList<Course> coursesEnrolled, double gpa) {
        super(firstName, lastName, email, userID);
        this.coursesTaken = coursesTaken;
        this.coursesEnrolled = coursesEnrolled;
        this.gpa = gpa;
    }
}
