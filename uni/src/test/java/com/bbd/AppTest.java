package com.bbd;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AppTest 
{
    static Student student;
    static Course course = new Course("Accounting",4);
    static List<Student> prosStudents; //prosprective students

    @BeforeAll
    public static void init(){
        System.out.println("Initialization");
        System.out.println("Number of Courses: "+Course.getNumberOfCourses());
        prosStudents = new ArrayList<>(Arrays.asList(new Student("Jordain",613574946,"20/12/1997"),
                new Student("Aland",246168517,"22/10/1992"), new Student("Roma",869599304,"04/10/2002"),
                new Student("Fields",494414696,"19/10/1993"),new Student("Kimmie",736143725,"12/06/1994")));

    }

    @Test
    public void createStudent(){

        Student s = new Student("John",214535001,"18/04/1990");
        assertNotNull(s);
    }

    @Test
    public void createCourse(){
        System.out.println("\nCreating a course...");
        System.out.println("Number of courses before creating a new course: " +Course.getNumberOfCourses());
        Course c = new Course("Bsc Comp Sci", 100);
        System.out.println("Number of courses after creation of Course " + c.getName()+ ": " +Course.getNumberOfCourses());
    }

    @Test
    public void enrollStudent(){
        Course c = new Course("BA", 5);
        student = new Student("Bob",1891489481,"22/09/1999");
        System.out.println("Currently enrolled students in course " + c.getName() + " before enrollment: "+ c.getStudents().size());
        assertFalse(c.unenrollStudent(student));
        assertTrue(c.enrollStudent(student));
        System.out.println("Currently enrolled students in course " + c.getName() + " after enrollement : "+ c.getStudents().size());
        assertTrue(c.unenrollStudent(student));

    }

    @Test
    public void enroll5Students(){
        System.out.println("Course details before enrollment process: " + course);
        for(Student s: prosStudents) {
            course.enrollStudent(s);
            System.out.println("\nCourse details after enrollment of "+ s + " is..\n " + course);
        }

    }

    @Test
    public void unenrollStudent(){
        //course = new Course("BA", 100);
        //student = new Student("Bob",1891489481,"22/09/1999");
        System.out.println("Unenrollment...");
        System.out.println("Student list of course " + course.getName() + " before unenrollment process:\n"+ course.getStudents());
        Student toRemove = prosStudents.get(new Random().nextInt(course.getCap()));
        System.out.println("Student to remove: "+toRemove);
        boolean success = course.unenrollStudent(toRemove);
        System.out.println("Student list of course " + course.getName() + " after unenrollment:\n"+course.getStudents());
        System.out.println("Student removal " + (success?"success":"unsuccessful"));
    }
}
