package institution;

import main.DBCredentials;
import person.Student;
import person.consciousness.Knowledge;

import java.sql.*;
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


    //Не знаю що саме мені потрібно було зрбити в цьому методі, адже для додавання студентів в університет
    //вже є addStudent(), тому зробив метод що змінює вже існуючого студента за ім'ям.
    public void setStudent(String name, String newName, int knowledge) {
        for (Map.Entry<Integer, Student> student : universityStudents.entrySet()) {
            if (Objects.equals(student.getValue().getName(), name)) {
                universityStudents.get(student.getKey()).setName(newName);
                universityStudents.get(student.getKey()).setKnowledge(new Knowledge(knowledge));
            }
        }
    }

    //Метод повертає середнє арифметичне рівня знань всіх студентів що є в університеті
    public double getAverage() {
        List<Integer> vals = new ArrayList<>();

        for (Student s : universityStudents.values()) {
            vals.add(s.getKnowledge().getLevel());
        }

        return Arrays.stream(vals.stream().mapToInt(i -> i).toArray()).average().orElse(Double.NaN);
    }


    public void setStudentsFromDB(DBCredentials creds) {
        try (Connection conn = DriverManager.getConnection(creds.getDbURL(), creds.getUsername(), creds.getPassword());
             PreparedStatement statement = conn.prepareStatement("SELECT id, name, knowledge FROM students")) {

            ResultSet result = statement.executeQuery();

            while (result.next()) {
                this.addStudent(new Student(result.getString("name"), result.getInt("knowledge")),
                        result.getInt("id"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
