package com.bbd;

import java.util.ArrayList;
import java.util.List;

public class Course {

    private String name;
    private List<Student> students;
    private int capacity;//max capacity

    private static int numberOfCourses;

    public Course(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        students = new ArrayList<>();
        numberOfCourses++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public int getCap() {
        return capacity;
    }

    public void setCap(int capacity) {
        this.capacity = capacity;
    }

    public static int getNumberOfCourses() {
        return numberOfCourses;
    }

    public static void setNumberOfCourses(int numberOfCourses) {
        Course.numberOfCourses = numberOfCourses;
    }

    public boolean enrollStudent(Student s){
        int currentCap = getCap();
        if(getStudents().size()<currentCap){
            students.add(s);
            setCap(currentCap++);
            return true;
        }
        return false;
    }

    public boolean unenrollStudent(Student s){

        boolean removed = students.remove(s);
//        boolean found =  students.stream().filter(o -> o.getName().equals(s.getName()) &&
//                o.getDob().equals(s.getName()) &&
//                o.getStudentNumber() == s.getStudentNumber()).findFirst().isPresent();
        int currentCap = getCap();
//        if(found) setCap(currentCap--);
//
//        return found;
        if(removed)  setCap(currentCap--);
        return removed;
    }

    @Override
    public String toString() {
        String s = "Course{" +
                "name='" + name + '\'' +
                ", capacity=" + capacity +

                ", num of students=" + students.size() + "\nStudent List:\n";

        for(Student sty:students){
            s+=sty.toString() + "\n";
        }
        return s;
    }
}
