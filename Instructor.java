import java.util.ArrayList;

public class Instructor extends Person {
    ArrayList<Course> coursesTeaching;
    int salary;

    public Instructor(String firstName, String lastName, String email, int userID, ArrayList<Course> coursesTeaching, int salary) {
        super(firstName, lastName, email, userID);
        this.coursesTeaching = coursesTeaching;
        this.salary = salary;
    }
}
