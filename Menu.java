import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    public Scanner sc;
    public ArrayList<Person> directory;

    public Scanner getScanner()
    {
        if(sc == null)
            sc = new Scanner(System.in);
        return sc;
    }

    public void insertPersonManual()
    {
        System.out.println("Enter First and Last Name:");
        sc = getScanner();
        String fullName = sc.nextLine();
        String[] firstName = fullName.split(" ",2);

        //System.out.println(firstName[0] + " " + firstName[1]);
        System.out.println("Enter Person Type:");

        String person = sc.nextLine();

        if(person.equalsIgnoreCase("Student")){

            System.out.println("Enter information in following format: UserID Email GPA");
            String line = sc.nextLine();
            String[] info = line.split(" ");
            int userID = Integer.parseInt(info[0]);
            double gpa = Double.parseDouble(info[0]);


            ArrayList<Course> coursesTaken = new ArrayList<>();
            System.out.println("Enter courses taken. One per line. Enter q to stop.");
            String courseTaken = sc.nextLine();
            while(!courseTaken.equalsIgnoreCase("q")) {
                coursesTaken.add(new Course(courseTaken.trim()));
                courseTaken = sc.nextLine();
            }

            ArrayList<Course> coursesTaking = new ArrayList<>();
            System.out.println("Enter courses taking. One per line. Enter q to stop.");
            String course = sc.nextLine();
            while(!course.equalsIgnoreCase("q")){
                coursesTaking.add(new Course(course.trim()));
                course = sc.nextLine();
            }

            if(directory == null)
                directory = new ArrayList<>();

            directory.add(new Student(firstName[0], firstName[1], info[1],userID,coursesTaken,coursesTaking,gpa));
            return;
        }
        else if(person.equalsIgnoreCase("TA")){

            System.out.println("Enter information in the following format: UserID Email GPA Salary HoursAssigned ");
            String line = sc.nextLine();
            String[] info = line.split(" ");
            int id = Integer.parseInt(info[0]);
            double gpa = Double.parseDouble(info[2]);
            int salary = Integer.parseInt(info[3]);
            double hoursAssigned = Double.parseDouble(info[4]);

            ArrayList<Course> coursesTaken = new ArrayList<>();
            System.out.println("Enter courses taken. One per line. Enter q to stop.");
            String courseTaken = sc.nextLine();
            while(!courseTaken.equalsIgnoreCase("q")) {
                coursesTaken.add(new Course(courseTaken.trim()));
                courseTaken = sc.nextLine();
            }

            ArrayList<Course> coursesTaking = new ArrayList<>();
            System.out.println("Enter courses taking. One per line. Enter q to stop.");
            String course = sc.nextLine();
            while(!course.equalsIgnoreCase("q")){
                coursesTaking.add(new Course(course.trim()));
                course = sc.nextLine();
            }

            ArrayList<Course> coursesTeaching = new ArrayList<>();
            System.out.println("Enter courses teaching. One per line. Enter q to stop.");
            String courseTeaching = sc.nextLine();
            while(!courseTeaching.equalsIgnoreCase("q")){
                coursesTeaching.add(new Course(courseTeaching.trim()));
                courseTeaching = sc.nextLine();
            }

            if(directory == null)
                directory = new ArrayList<>();

            directory.add(new TA(firstName[0],firstName[1], info[1], id,coursesTaken,coursesTaking, gpa, coursesTeaching,salary, hoursAssigned));
            return;
        }
        else if(person.equalsIgnoreCase("Instructor")){

            System.out.println("Enter information in the following format: UserID Email Salary");
            String line = sc.nextLine();
            String[] info = line.split(" ");
            int id = Integer.parseInt(info[0]);
            String email = info[1];
            int salary = Integer.parseInt(info[2]);

            ArrayList<Course> coursesTeaching = new ArrayList<>();
            System.out.println("Enter courses teaching. One per line. Enter q to stop.");
            String courseTeaching = sc.nextLine();
            while(!courseTeaching.equalsIgnoreCase("q")){
                coursesTeaching.add(new Course(courseTeaching.trim()));
                courseTeaching = sc.nextLine();
            }

            if(directory == null)
                directory = new ArrayList<>();

            directory.add(new Instructor(firstName[0], firstName[1],email,id,coursesTeaching,salary));

        }
        else if(person.equalsIgnoreCase("Staff")){
            System.out.println("Enter information in the following format: UserID Email Salary");
            String line = sc.nextLine();
            String[] info = line.split(" ");
            int id = Integer.parseInt(info[0]);
            String email = info[1];
            int salary = Integer.parseInt(info[2]);

            if(directory == null)
                directory = new ArrayList<>();

            directory.add(new Staff(firstName[0],firstName[1],email,id,salary));

        }
        else{
            System.out.println("Person Type not found. Returning to menu...");
        }

    }

    public void print()
    {
        System.out.println("Enter selection");
        System.out.println("1: Load Directory with CSV File");
        System.out.println("2: Enter Name Manually Into Directory");
        System.out.println("3: Search By Name");
        System.out.println("4: Course Instructor Search");
        System.out.println("5: List Students Without Professor and List Professors With Classes  ");
        System.out.println("6: Pay Staff");
        System.out.println("7: Email Thing Change Me");
        System.out.println("0: Quit");

         this.sc = getScanner();

        while (!sc.hasNextInt())
            sc.next();

        int choice = this.sc.nextInt();
        sc.nextLine();
        switch (choice)
        {
            case 1:
                System.out.println("1");
                break;
            case 2:

                insertPersonManual();
                break;
            case 3:
                System.out.println("3");

                break;
            case 4:
                System.out.println("4");

                break;
            case 5:
                System.out.println("5");

                break;
            case 6:
                System.out.println("6");

                break;
            case 7:
                System.out.println("7");

                break;
            case 0:
                System.out.println("0");
                break;
            default:
                System.out.println("try again");
        }

    }
}
