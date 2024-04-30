package com.practice.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class JavaComparator {

    static class Checker implements Comparator<Student> {
        @Override
        public int compare(Student p1, Student p2) {
            if (p1.getCgpa() < p2.getCgpa()) {
                return 1;
            } else if (p1.getCgpa() > p2.getCgpa()) {
                return -1;
            } else {
                if(p1.getFname().equals(p2.getFname())) {
                    if (p1.getId() < p2.getId()) {
                        return -1;
                    } else if (p1.getId() > p2.getId()) {
                        return 1;
                    } else {
                        return 0;
                    }
                } else {
                    return (p1.getFname().compareTo(p2.getFname()));
                }
            }
        }
    }

    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<Student>();
        Checker checker = new Checker();
        Collections.sort(studentList, checker);
    }
}


class Student{
    private int id;
    private String fname;
    private double cgpa;
    public Student(int id, String fname, double cgpa) {
        super();
        this.id = id;
        this.fname = fname;
        this.cgpa = cgpa;
    }
    public int getId() {
        return id;
    }
    public String getFname() {
        return fname;
    }
    public double getCgpa() {
        return cgpa;
    }
}
