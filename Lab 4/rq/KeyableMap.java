import java.util.HashMap;
import java.util.Map;

class KeyableMap<V extends Keyable> implements Keyable {
    private final String key;
    private final Map<String, V> map;

    @Override
    public String getKey() {
        return key;
    }

    public Map<String, V> getMap() {
        return map;
    }

    public KeyableMap(String key) {
        this.key = key;
        this.map = new HashMap<String, V>();
    }

    public KeyableMap(String key, Map<String, V> map) {
        this.key = key;
        this.map = map;
    }

    public KeyableMap() {
        key = null;
        map = null;
    }

    public KeyableMap<V> put(V item) {
        map.put(item.getKey(), item);
        return this;
    }

    public V get(String key) {
        if (map.get(key) != null) {
            V item = map.get(key);
            return item;
        }
        return null;
    }

    @Override
    public String toString() {
        String s = "";
        int j = this.getMap().size();
        for (V v: this.getMap().values()) {
            s += v;
            if (j != 1) {
                s += ", ";
            }
            j--;
        }
        return String.format("%s: {%s}", this.getKey(), s);
    }
}
