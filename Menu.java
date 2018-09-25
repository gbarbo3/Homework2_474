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

    public void InsertPersonManual()
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


    public void SearchDirectory()
    {
        System.out.println("Enter name to search:");

        // no space search
        sc  = getScanner();
        String line = sc.nextLine();
        String[] names = line.split(" ");

        if(names.length == 1)
        {
            for (Person p : directory)
            {
                if(p.firstName.toUpperCase().contains(names[0].toUpperCase()) || p.firstName.toUpperCase().contains(names[0].toUpperCase()))
                    System.out.println(p.firstName + " " + p.lastName);
            }
        }
        //space search
        else if(names.length == 2)
        {
            for(Person p : directory)
            {
                if(p.firstName.toUpperCase().contains(names[0].toUpperCase()))
                    System.out.println(p.firstName + " " + p.lastName);

                else if (p.lastName.toUpperCase().contains(names[1].toUpperCase()))
                    System.out.println(p.firstName + " " + p.lastName);

                else{}
            }
        }
        else
        {
            System.out.println("No Results Found");
        }
    }

    public void CourseInfo()
    {
        System.out.println("Enter Course Name :");
        sc = getScanner();

        String line = sc.nextLine();
        ArrayList<Instructor> instructors = new ArrayList<>();
        ArrayList<Student> students = new ArrayList<>();
        ArrayList<TA> tas = new ArrayList<>();

        for (Person p : directory)
        {
            if(p instanceof Instructor)
            {
                for(Course c : ((Instructor) p).coursesTeaching)
                {
                    if(c.name.toUpperCase().contains(line.toUpperCase()))
                    {
                        instructors.add((Instructor) p);
                        break;
                    }

                }
            }
            else if(p instanceof Student)
            {
                for(Course c : ((Student) p).coursesEnrolled)
                {
                    if(c.name.toUpperCase().contains(line.toUpperCase()))
                    {
                        students.add((Student) p);
                        break;
                    }
                }
            }
            else if(p instanceof TA)
            {
                for(Course c : ((TA) p).coursesTeaching)
                {
                    if(c.name.toUpperCase().contains(line.toUpperCase()))
                    {
                        tas.add((TA) p);
                        break;
                    }
                }
            }

        }
        //Print Results
        for(Instructor i : instructors)
            System.out.println(i.firstName + " " + i.lastName);

        for (TA t : tas)
            System.out.println(t.firstName + " " + t.lastName);

        for (Student s : students)
            System.out.println(s.firstName + " " + s.lastName);



    }

    public void ListCoursesWOInstructorAndAllCourseTaughtByInstructor()
    {
        //TODO
        //Get all of Courses enrolled from Students and all of coursesTeaching from Instructors
        // Filter into new list
        //Print list

        //Listing all Instructors with classes they are teaching
        System.out.println("Listing all instructors and courses they are teaching:");
        for(Person p : directory)
        {
            if(p instanceof Instructor)
            {
                System.out.print(p.firstName + " " +p.lastName + ": ");
                for(Course c : ((Instructor) p).coursesTeaching)
                    System.out.print(c.name + "| ");
                System.out.println();
            }
        }
    }

    public void UpdatePayment()
    {
        System.out.println("Updating Payment");
        for(Person p : directory)
        {
            if(p instanceof Instructor)
            {
                System.out.println("Instructor Payment to " + p.firstName + " " + p.lastName+ "of amount: " + ((Instructor) p).salary * ((Instructor) p).coursesTeaching.size());
            }
            else if(p instanceof TA)
            {
                System.out.println("TA Payment to " + p.firstName + " " + p.lastName+ "of amount: " + ((TA) p).salary * ((TA) p).hoursAssigned);
            }
            else if(p instanceof Staff)
            {
                System.out.println("Staff Payment to " + p.firstName + " " + p.lastName+ "of amount: " + ((Staff) p).salary);

            }

            System.out.println("Payments Updated...");
        }
    }

    public Person Search(String s)
    {
        return null;
    }

    public void SendEmail()
    {
        System.out.println("Enter full name of person sending the email:");
        sc = getScanner();
        String name = sc.nextLine();
        String[] fullName = name.split(" ");

        System.out.println("Enter emails to send to . Enter comma separated");
        String line = sc.nextLine();
        String[] emails = line.split(",");

        String type = "null";
        // search for person
        for(Person p : directory)
        {
            if(p.firstName.toUpperCase().contains(fullName[0].toUpperCase()) &&
                    p.lastName.toUpperCase().contains(fullName[1].toUpperCase()))
            {
                // get type
                if(p instanceof Student){type = "Student";}
                else if(p instanceof Instructor){type = "Instructor";}
                else if(p instanceof TA){type = "TA";}
                else if(p instanceof Staff){type = "Staff";}


            }
        }

        if (type.equalsIgnoreCase("Student")){

             for(String s : emails) {
               Person p =  Search(s.trim());
               if(p instanceof TA)
                   System.out.println("Email was successfully sent to " + s);
               else
                   System.out.println("Email was  not successfully sent to " + s);
             }

        }
        else if (type.equalsIgnoreCase("Instructor")){

            for(String s : emails) {
                Person p =  Search(s.trim());
                if(p instanceof Instructor || p instanceof Staff)
                    System.out.println("Email was successfully sent to " + s);
                else
                    System.out.println("Email was  not successfully sent to " + s);
            }
        }
        else if(type.equalsIgnoreCase("TA")){

            for(String s : emails) {
                Person p =  Search(s.trim());
                if(p instanceof Staff || p == null)
                    System.out.println("Email was  not successfully sent to " + s);
                else
                    System.out.println("Email was successfully sent to " + s);
            }
        }
        else if(type.equalsIgnoreCase("Staff")){

            for(String s : emails) {
                Person p =  Search(s.trim());
                if(p instanceof Instructor || p == null)
                    System.out.println("Email was  not successfully sent to " + s);
                else
                    System.out.println("Email was successfully sent to " + s);
            }
        }
        else {
            System.out.println("User was not found");
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
                InsertPersonManual();
                break;
            case 3:
                SearchDirectory();
                break;
            case 4:
                CourseInfo();
                break;
            case 5:
                ListCoursesWOInstructorAndAllCourseTaughtByInstructor();
                break;
            case 6:
                UpdatePayment();
                break;
            case 7:
                SendEmail();
                break;
            case 0:
                System.out.println("0");
                break;
            default:
                System.out.println("try again");
        }

    }
}
