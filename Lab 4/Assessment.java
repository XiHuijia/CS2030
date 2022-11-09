import java.util.HashMap;

class Assessment implements Keyable {
    private final String grade;
    private final String name;

    Assessment(String name, String grade) {
        this.name = name;
        this.grade = grade;
    }

    String getGrade() {
        return this.grade;
    }

    public String getKey() {
        return this.name;
    }

    public String toString() {
        return String.format("{%s: %s}", this.getKey(), this.getGrade());
    }
}
