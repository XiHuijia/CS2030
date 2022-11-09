import java.util.HashMap;

class Roster extends KeyableMap<Student> implements Keyable {

    Roster(String rosterName) {
        super(rosterName);     
    }

    Roster put(Student student) {
        super.put(student);
        return (Roster)this;
    }

    public String getKey() {
        return super.getKey();
    }

    String getGrade(String name, String module, String assessment) {
        if (this.get(name) == null || this.get(name).get(module) == null || 
            this.get(name).get(module).get(assessment) == null) {
            return String.format("No such record: %s %s %s", name, module, assessment);
        } else {
            return this.get(name).get(module).get(assessment).getGrade();
        }
    } 
}