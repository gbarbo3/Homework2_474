import java.util.ArrayList;

public class TA extends Student {
    ArrayList<Course> coursesTeaching;
    int salary;
    double hoursAssigned;

    public TA(String firstName, String lastName, String email, int userID, ArrayList<Course> coursesTaken, ArrayList<Course> coursesEnrolled, double gpa, ArrayList<Course> coursesTeaching, int salary, double hoursAssigned) {
        super(firstName, lastName, email, userID, coursesTaken, coursesEnrolled, gpa);
        this.coursesTeaching = coursesTeaching;
        this.salary = salary;
        this.hoursAssigned = hoursAssigned;
    }
}
