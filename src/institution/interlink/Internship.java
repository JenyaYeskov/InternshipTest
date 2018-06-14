package institution.interlink;

import institution.University;
import person.Student;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Internship {
    private final String name;
    private Map<Integer, Student> internshipStudents = new HashMap<>();

    public Internship(String name) {
        this.name = name;
    }

    public void setStudent(Student student, University university) {
        if (!university.getStudents().containsValue(student)) {
            university.addStudent(student);
        }

        if (student.getKnowledge().getLevel() > university.getAverage() && !internshipStudents.containsValue(student)) {
            for (Map.Entry<Integer, Student> studentEntry : university.getStudents().entrySet()) {
                if (Objects.equals(studentEntry.getValue(), student))
                    internshipStudents.put(studentEntry.getKey(), student);
            }
        }
    }

    public void setStudents(University university) {
        double avg = university.getAverage();

        for (Map.Entry<Integer, Student> student : university.getStudents().entrySet()) {
            if (student.getValue().getKnowledge().getLevel() > avg && !this.internshipStudents.containsValue(student.getValue()))
                internshipStudents.put(student.getKey(), student.getValue());
        }
    }

    public Map<Integer, Student> getStudents() {
        return internshipStudents;
    }
}
