import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class MenuTest {
    @BeforeEach
    public void initEach(){
        Course course1 = new Course("CS 101");
        Course course2 = new Course("CS 102");
        Course course3 = new Course("CS 103");
        Course course4 = new Course("CS 204");
        Course course5 = new Course("CS 205");
        Course course6 = new Course("CS 206");
        Course course7 = new Course("CS 307");
        Course course8 = new Course("CS 308");
        Course course9 = new Course("CS 309");

        ArrayList<Course> freshman = new ArrayList<>();
        ArrayList<Course> sophomore = new ArrayList<>();
        ArrayList<Course> jr = new ArrayList<>();

        freshman.add(course1);
        freshman.add(course2);
        freshman.add(course3);

        sophomore.add(course4);
        sophomore.add(course5);
        sophomore.add(course6);

        jr.add(course7);
        jr.add(course8);
        jr.add(course9);



        Student s1 = new Student("firstname1","lastName1", "email1@uic.edu",1, freshman,sophomore,3.0);
        Student s2 = new Student("firstname2","lastName2", "email2@uic.edu",2, sophomore,freshman,2.0);
        Student s3 = new Student("firstname3","lastName3", "email3@uic.edu",3, jr,sophomore,4.0);

    }
}