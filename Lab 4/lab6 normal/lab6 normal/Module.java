import java.util.Map;
import java.util.HashMap;

public class Module extends KeyableMap<String, String, Assessment> {

   private String name;
   private Map<String, Assessment> map;

   Module (String name) {
   super(name);
   this.name = name;
   this.map = new HashMap<>();
     }

   @Override
   Module put (Assessment assessment) {
        this.map.put(assessment.getKey(), assessment);
        return this;
     }

    Assessment get(String items) {
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


