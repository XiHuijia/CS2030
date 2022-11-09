import java.util.HashMap;
import java.util.Optional;

class KeyableMap<V extends Keyable> implements Keyable {
    private final String key;
    private final HashMap<String, V> map;

    KeyableMap(String key) {
        this.key = key;
        this.map = new HashMap<String, V>();
    }

    public String getKey() {
        return this.key;
    }

    Optional<V> get(String key) {
        Optional<V> output = Optional.ofNullable(this.map.get(key));
        return output;
    }

    KeyableMap<V> put(V item) {
        this.map.put(item.getKey(), item);
        return this;
    }

    public String toString() {
        String output = "";
        int count = 0;
        for (HashMap.Entry<String, V> e: map.entrySet()) {
            count += 1;
            if (count == 1) {
                output += String.format("%s", e.getValue());
            } else {
                output += String.format(", %s", e.getValue());
            }           
        }
        return String.format("%s: {%s}", this.getKey(), output);
    }
}
