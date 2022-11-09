import java.util.Map;
import java.util.HashMap;

public class KeyableMap<T, K, V extends Keyable<K>> implements Keyable<T> {

  private T name;
  private Map<K, V> map;
  KeyableMap(T name) {
    this.name = name;
    this.map = new HashMap<>();
  }

  KeyableMap<T, K, V> put(V item) {
    this.map.put(item.getKey(), item);
    return this;
  }

  V get(K items) {
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

        @Override
        public T getKey() {
        return this.name;
        }
        }
