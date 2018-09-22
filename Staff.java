public class Staff extends Person {
    int salary;

    public Staff(String firstName, String lastName, String email, int userID, int salary) {
        super(firstName, lastName, email, userID);
        this.salary = salary;
    }
}
