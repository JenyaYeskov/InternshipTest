package institution.interlink;

import person.Student;

import java.util.HashMap;
import java.util.Map;

public class Internship {
    private final String name;
    private Map<Integer, Student> internshipStudents = new HashMap<>();

    public Internship(String name) {
        this.name = name;    }

    public void setStudent(Student student) {
        //TODO: Implementation is needed
    }

    public Map<Integer, Student> getStudents() {
        return internshipStudents;
    }
}
