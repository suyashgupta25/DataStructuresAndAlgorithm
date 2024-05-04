package com.practice.dsa.queue;

import java.util.*;
import java.util.stream.Collectors;


class Student {
    private int id;
    private String name;
    private double cgpa;

    public Student(int id, String name, double cgpa) {
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getCgpa() {
        return cgpa;
    }
}

class Priorities implements Comparator<Student> {
    private Queue<Student> queue = new PriorityQueue<>(this);

    void serve() {
        if (queue.isEmpty()) {
            return;
        }
        queue.poll();
    }

    void enter(Student student) {
        queue.add(student);
    }

    List<Student> getStudents(List<String> events) {
        for (int i = 0; i < events.size(); i++) {
            String event = events.get(i);
            if (event.equals("SERVED")) {
                serve();
            } else {
                String[] strings = event.split(" ");
                int id = Integer.parseInt(strings[3]);
                String name = strings[1];
                double cgpa = Double.parseDouble(strings[2]);
                Student st = new Student(id, name, cgpa);
                enter(st);
            }
        }
        return queue.stream().sorted(this).collect(Collectors.toList());
    }

    @Override
    public int compare(Student o1, Student o2) {
        if (o1.getCgpa() > o2.getCgpa()) {
            return -1;
        } else if (o1.getCgpa() < o2.getCgpa()) {
            return 1;
        } else {
            if (o1.getName().equals(o2.getName())) {
                if (o1.getId() > o2.getId()) {
                    return 1;
                } else {
                    return -1;
                }
            } else {
                return o1.getName().compareTo(o2.getName());
            }
        }
    }
}
public class PriorityQueueDemo {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        Priorities priorities = new Priorities();
        List<String> events = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String event = in.nextLine();
            events.add(event);
        }
        List<Student> students1 = priorities.getStudents(events);
        for (int i = 0; i < students1.size(); i++) {
            System.out.println(students1.get(i).getName());
        }
        if(students1.isEmpty()) {
            System.out.println("EMPTY");
        }
    }
}
