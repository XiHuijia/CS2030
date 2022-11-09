class Roster extends KeyableMap<Student> {
    public Roster(String key) {
        super(key);
    }

    @Override
    public String getKey() {
        return super.getKey();
    }

    @Override
    public Roster put(Student student) {
        super.put(student);
        return (Roster) this;
    }

    public String getGrade(String name, String module, String assessment) {
        if (this.get(name) == null ||
        this.get(name).get(module) == null ||
                this.get(name).get(module).get(assessment) == null) {
            return "No such record: " + name + " " + module + " " + assessment;
        }
        return this.get(name).get(module).get(assessment).getGrade();
    }
}
