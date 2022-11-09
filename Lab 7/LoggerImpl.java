import java.util.List;
import java.util.ArrayList;
import java.util.stream.Stream;
import java.util.function.Function;
import java.util.function.Predicate;

class LoggerImpl<V> implements Logger<V> {
    private final V value;
    private final List<String> log;

    LoggerImpl(V value, String newlog) {
        this.value = value;
        this.log = List.of(newlog);
    }

    LoggerImpl(V value, List<String> oldLog) {
        this.value = value;
        this.log = new ArrayList<String>();
        this.log.addAll(oldLog);
    }

    LoggerImpl(V value, String newlog, List<String> oldLog) {
        this(value, oldLog);
        this.log.add(newlog);
    }

    public void printlog() {
        this.log.stream().forEach(x -> System.out.println(x));
    }

    public V getValue() {
        return this.value;
    }

    public List<String> getLog() {
        return this.log;
    }

    public boolean equals(Object another) {
        if (this == another) {
            return true;
        } else if (another instanceof LoggerImpl) {
            LoggerImpl<?> newAnother = (LoggerImpl<?>) another;
            return this.value.equals(newAnother.getValue()) && this.log.equals(newAnother.getLog());
        } else {
            return false;
        }
    }

    public String toString() {
        return String.format("Logger[%s]", this.value);
    }

    public <U> Logger<U> map(Function<? super V, ? extends U> mapper) {
        U newValue = mapper.apply(this.value);
        if (newValue.equals(this.value)) {
            return new LoggerImpl<U>(newValue, String.format("Value unchanged. Value = %s", newValue), this.log);
        } else {
            return new LoggerImpl<U>(newValue, String.format("Value changed! New value = %s", newValue), this.log);
        }
    }

    public <U> Logger<U> flatMap(Function<? super V, ? extends Logger<? extends U>> mapper) {
        List<String> combined = new ArrayList<String>();
        combined.addAll(this.log);
        Logger<? extends U> newLoggerImpl = mapper.apply(this.value);
        combined.addAll(newLoggerImpl.getLog());
        combined.remove(this.log.size()); //remove the line of initialization in flatmap
        return new LoggerImpl<U>(newLoggerImpl.getValue(), combined);
    }

    public boolean test(Predicate<? super V> pred) {
        return pred.test(this.value);
    }
}