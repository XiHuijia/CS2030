import java.util.HashMap;
import java.util.Optional;

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
        return this.get(name).flatMap(x -> x.get(module))
        .flatMap(x -> x.get(assessment)).map(Assessment::getGrade)
        .orElse(String.format("No such record: %s %s %s", name, module, assessment));
        
    } 
}
