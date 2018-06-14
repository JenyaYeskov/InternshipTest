package institution;

import person.Student;
import person.consciousness.Knowledge;

import java.util.*;

public class University {
    private final String name;
    private Map<Integer, Student> universityStudents = new HashMap<>();

    public University(String name) {
        this.name = name;
    }

    public Map<Integer, Student> getStudents() {
        return universityStudents;
    }

    public void setStudent(String name, String newName, int knowledge) {
        for (Map.Entry<Integer, Student> st : universityStudents.entrySet()) {
            if (Objects.equals(st.getValue().getName(), name)) {
                universityStudents.get(st.getKey()).setName(newName);
                universityStudents.get(st.getKey()).setKnowledge(new Knowledge(knowledge));
            }
        }
    }

    public void addStudent(Student student) {
        if (!universityStudents.containsValue(student)) {
            int id = universityStudents.size();
            while (universityStudents.containsKey(id)) {
                id++;
            }
            universityStudents.put(id, student);
        }
    }

    public void addStudent(Student student, int id) {
        if (!universityStudents.containsValue(student))
            universityStudents.put(id, student);
    }

    public double getAverage() {
        List<Integer> vals = new ArrayList<>();

        for (Student s : universityStudents.values()) {
            vals.add(s.getKnowledge().getLevel());
        }

        return Arrays.stream(vals.stream().mapToInt(i -> i).toArray()).average().orElse(Double.NaN);
    }

}
