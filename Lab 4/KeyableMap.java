import java.util.HashMap;

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

    V get(String key) {
        if (this.map.containsKey(key)) {
            return this.map.get(key);
        } else {
            return null;
        }
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