import java.util.Map;
import java.util.HashMap;

public class Roster extends KeyableMap<String, String, Student> {

    private String year;
    private Map<String, Student> map;

    Roster (String year) {
        super(year);
        this.year = year;
        this.map = new HashMap<>();
    }

    @Override
    Roster put (Student student) {
        this.map.put(student.getKey(), student);
        return this;
    }

    Student get(String items) {
        if (this.map.containsKey(items)) {
            return this.map.get(items);
        } else {
            return null;
        }
    }

    String getGrade (String name, String code, String assessment) throws NoSuchRecordException {

        if( get(name) == null || get(name).get(code) == null || get(name).get(code).get(assessment) == null) {
            throw new NoSuchRecordException("No such record: " + name + " " + code + " " + assessment);
        } else {
            return get(name).get(code).get(assessment).getGrade();
        }
    }

    @Override
    public String toString() {

        return (this.year + ": " + map.values()).replace("[", "{").replace("]", "}");
    }

}