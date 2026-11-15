package ru.ranepa;

public class Main {
    public static void main(String[] args) {
        University university = new University();
        int studentCount = 3;
        long ivanID = university.enroll("Иванов Иван");
        long petrID = university.enroll("Петров Пётр");
        long annaID = university.enroll("Смирнова Анна");

        university.addGrade(ivanID, 4);
        university.addGrade(ivanID, 5);
        university.addGrade(petrID, 2);
        university.addGrade(petrID, 3);
        university.addGrade(annaID, 4);
        System.out.println("Перевод со средним баллом больше 2.5:");
        university.transferToNextCourse(ivanID);

        System.out.println("Перевод со средним баллом ровно 2.5:");
        university.transferToNextCourse(petrID);

        System.out.println("Перевод на 3 и 4 курсы и выпуск:");
        university.transferToNextCourse(ivanID);
        university.transferToNextCourse(ivanID);
        university.transferToNextCourse(ivanID);

        System.out.println("Отчисление и попытка поставить оценку:");
        university.expel(annaID);
        try {
            university.addGrade(annaID, 5);
        } catch (IllegalArgumentException e) {
            System.out.println("Отказ: " + e.getMessage());
        }

        System.out.println("Повторное зачисление создаёт нового студента:");
        long newAnnaID = university.enroll("Смирнова Анна");
        university.addGrade(newAnnaID, 5);
        university.printSummary();
    }
}
