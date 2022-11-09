class Assessment implements Keyable {
    private final String key;
    private final String grade;

    public Assessment (String key, String grade) {
        this.key = key;
        this.grade = grade;
    }

    public String getGrade() {
        return grade;
    }

    @Override
    public String getKey() {
        return key;
    }

    @Override
    public String toString() {
        return "{" + key + ": " + grade + "}";
    }
}
