package main;

import institution.University;
import institution.interlink.Internship;
import person.Student;

public class Application {
    public static void main(String[] args) {
        University university = new University("CH.U.I.");
        university.addStudent(new Student("Andrew Kostenko", 5));
        university.addStudent(new Student("Julia Veselkina", 8));
        university.addStudent(new Student("Maria Perechrest", 7));

        Student student1 = new Student("student1", 3);
        Student student2 = new Student("student2", 7);
        Student student3 = new Student("student3", 9);

        university.addStudent(student1);
        university.addStudent(student3);

        university.setStudent("student3", "voldemort", 10);

        Internship internship = new Internship("Interlink");
        internship.setStudent(student1, university);
        internship.setStudent(student2, university);
        internship.setStudent(student3, university);

        internship.setStudents(university);

        System.out.println("List of internship's students:");
        System.out.println(internship.getStudents());
    }
}
