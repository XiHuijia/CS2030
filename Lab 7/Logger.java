import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

interface Logger<V> {
    static <V> Logger<V> make(V value) throws IllegalArgumentException {
        if (value == null) {
            throw new IllegalArgumentException("argument cannot be null");
        } else if (value instanceof Logger) {
            throw new IllegalArgumentException("already a Logger");
        } else {
            return new LoggerImpl<V>(value, String.format("Value initialized. Value = %s", value));
        }        
    }

    void printlog();

    V getValue();

    List<String> getLog();

    public boolean equals(Object another);

    public String toString();

    <U> Logger<U> map(Function<? super V, ? extends U> mapper);

    <U> Logger<U> flatMap(Function<? super V, ? extends Logger<? extends U>> mapper);

    boolean test(Predicate<? super V> pred); 
}