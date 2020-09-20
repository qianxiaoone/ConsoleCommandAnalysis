package ConsoleCommandAnalysis;

import java.util.Objects;

public class Arg {
    private final String key;
    private final String value;

    public Arg(String key, String value) {

        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Arg that = (Arg) o;
        return Objects.equals(key, that.key) &&
                Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, value);
    }

    @Override
    public String toString() {
        return "Arg{" +
                "key='" + key + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
