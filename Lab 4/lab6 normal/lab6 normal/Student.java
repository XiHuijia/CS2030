import java.util.Map;
import java.util.HashMap;

public class Student extends KeyableMap<String, String, Module> {

    private String name;
    private Map<String, Module> map;

    Student (String name) {
        super(name);
        this.name = name;
        this.map = new HashMap<>();
    }

    @Override
    Student put (Module module) {
        this.map.put(module.getKey(), module);
        return this;
    }

    Module get(String items) {
        if (this.map.containsKey(items)) {
            return this.map.get(items);
        } else {
            return null;
        }
    }

    @Override
    public String toString() {

        return (this.name + ": " + map.values()).replace("[", "{").replace("]", "}");
    }

}