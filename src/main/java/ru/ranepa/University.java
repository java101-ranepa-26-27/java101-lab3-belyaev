package ru.ranepa;

import java.util.ArrayList;
import java.util.List;

public class University {

    private final List<Student> students = new ArrayList<>();
    private long nextStudentID = 1;

    public long enroll(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Имя студента не должно быть пустым");
        }
        Student student = Student.create(name, nextStudentID);
        students.add(student);
        nextStudentID++;
        return student.getStudentID();
    }

    public void transferToNextCourse(long studentID) {
        Student student = findActiveStudent(studentID);
        if (student.average() <= 2.5) {
            student.setState(State.DISMISSED);
            System.out.println(student.getName() + ": средний балл не больше 2.5, студент отчислен");
        } else if (student.getCourse() == 4) {
            student.setState(State.GRADUATED);
            System.out.println(student.getName() + ": студент выпустился");
        } else {
            student.setCourse(student.getCourse() + 1);
            System.out.println(student.getName() + ": переведён на курс " + student.getCourse());
        }
    }

    public void expel(long studentID) {
        Student student = findActiveStudent(studentID);
        student.setState(State.DISMISSED);
        System.out.println(student.getName() + ": студент отчислен");
    }

    public void addGrade(long studentID, int grade) {
        Student student = findActiveStudent(studentID);
        if (grade < 2 || grade > 5) {
            throw new IllegalArgumentException("Оценка должна быть от 2 до 5");
        }
        student.getGrades().add(grade);
    }

    private Student findActiveStudent(long studentID) {
        for (Student student : students) {
            if (student.getStudentID() == studentID) {
                if (student.getState() == State.DISMISSED) {
                    throw new IllegalArgumentException("Студент уже отчислен");
                }
                if (student.getState() == State.GRADUATED) {
                    throw new IllegalArgumentException("Студент уже выпустился");
                }
                return student;
            }
        }
        throw new IllegalArgumentException("Неизвестный номер студенческого билета: " + studentID);
    }

    public void printSummary() {
        System.out.println("Сводка университета:");
        for (Student student : students) {
            student.printReport();
            System.out.println();
        }
    }
}
