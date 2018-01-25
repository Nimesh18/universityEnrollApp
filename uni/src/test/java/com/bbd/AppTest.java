package com.bbd;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AppTest 
{
    static Student student;
    static Course course;//
    static List<Student> prosStudents; // 5 prospective students

    @BeforeAll
    public static void init(){
        assertEquals(0,Course.getNumberOfCourses());
        prosStudents = new ArrayList<>(Arrays.asList(new Student("Jordain",613574946,"20/12/1997"),
                new Student("Aland",246168517,"22/10/1992"), new Student("Roma",869599304,"04/10/2002"),
                new Student("Fields",494414696,"19/10/1993"),new Student("Kimmie",736143725,"12/06/1994")));
    }

    @Test
    public void createStudent(){
        Student s = new Student("John",214535001,"18/04/1990");
        assertNotNull(s);
        assertEquals("John",s.getName());
        assertEquals(214535001,s.getStudentNumber());
        assertEquals("18/04/1990",s.getDob());
    }

    @Test
    public void createCourse(){
        int numCourses = Course.getNumberOfCourses();
        course  = new Course("Accounting",100);
        assertEquals(++numCourses,Course.getNumberOfCourses());
        assertEquals("Accounting",course.getName());
        assertEquals(100,course.getCap());
        assertEquals(0,course.getStudents().size());
    }

    @Test
    public void enrollStudent(){
        Course c = new Course("BA", 5);
        student = new Student("Bob",1891489481,"22/09/1999");
        assertEquals(0,c.getStudents().size());// 0 students before enrollment
        assertFalse(c.unenrollStudent(student));
        assertTrue(c.enrollStudent(student));
        assertEquals(1,c.getStudents().size());
        assertTrue(c.unenrollStudent(student));
    }

    @Test
    public void enroll5Students(){
        Course c = new Course("BSc Comp Sci", 4);
        for(Student s: prosStudents)
            c.enrollStudent(s);

        assertEquals(4,c.getStudents().size());
        Student s = new Student("John",214535001,"18/04/1990");
        assertFalse(c.enrollStudent(s));//max capacity met, cannot enroll

        System.out.println("Enrolled students for course " + c.getName() + "\n" + c.getStudents());
    }

    @Test
    public void unenrollStudent(){
        Student s = new Student("John",214535001,"18/04/1990");
        Course c = new Course("BSc Eng", 4);
        assertFalse(c.unenrollStudent(s));//no student enrolled yet, expected return is false

        assertTrue(c.enrollStudent(s));//student s enrolled

        assertTrue(c.unenrollStudent(s));//student s unenrolled

        assertFalse(c.unenrollStudent(s));//nobody left to unenroll
    }

    @AfterAll
    static void tearDown(){
        prosStudents = null;
        course = null;
        student = null;
    }
}
