package person;

import person.consciousness.Knowledge;

public class Student {
    private String name;
    private Knowledge knowledge;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Knowledge getKnowledge() {
        return knowledge;
    }

    public void setKnowledge(Knowledge knowledge) {
        this.knowledge = knowledge;
    }

    public Student(String name) {
        this.name = name;
    }

    public Student(String name, int level) {
        this.name = name;
        this.knowledge = new Knowledge(level);
    }

    @Override
    public String toString() {
        return name + ": " + knowledge.getLevel();
    }
}
