package ru.ranepa;

import java.util.ArrayList;
import java.util.List;

public class Student {

    private final String name;
    private final long studentID;
    private int course;
    private State state;
    private final List<Integer> grades;

    private Student(String name, long studentID) {
        this.name = name;
        this.studentID = studentID;
        this.grades = new ArrayList<>();
        this.course = 1;
        this.state = State.ACTIVE;
    }

    static Student create(String name, long studentID) {
        return new Student(name, studentID);
    }

    public String getName() {
        return name;
    }

    public List<Integer> getGrades() {
        return grades;
    }

    public double average() {
        if (grades.isEmpty()) {
            return 0.0;
        }
        int sum = 0;
        for (int grade : grades) {
            sum += grade;
        }
        return (double) sum / grades.size();
    }

    void setCourse(int course) {
        this.course = course;
    }

    void setState(State state) {
        this.state = state;
    }

    private String report() {
        return "Студент: " + name + System.lineSeparator()
                + "Номер билета: " + studentID + System.lineSeparator()
                + "Курс: " + course + System.lineSeparator()
                + "Состояние: " + state + System.lineSeparator()
                + "Оценки: " + grades + System.lineSeparator()
                + "Средний балл: " + average();
    }

    public void printReport() {
        System.out.println(report());
    }

    public int getCourse() {
        return course;
    }

    public State getState() {
        return state;
    }

    public long getStudentID() {
        return studentID;
    }
}
