package ConsoleCommandAnalysis;

import java.util.*;
import java.util.stream.Collectors;

public class Args {
    private String argsText;
    private Schema schema;
    private Set<Arg> argSet = new HashSet<>();

    public Args(String argsText, Schema schema) {
        this.argsText = argsText;
        this.schema = schema;
        this.scan();
    }

    public Set<Arg> getArgSet() {
        return argSet;
    }

    public String getValueOf(String flag) throws Exception {
        for (Arg arg : argSet) {
            if (arg.getKey().equalsIgnoreCase(flag)) {
                return arg.getValue();
            }
        }
        if (getDefaultValue(flag) != null) {
            return getDefaultValue(flag);
        }
        throw new IllegalArgumentException(flag + " is not find!");
    }

    private String getDefaultValue(String flag) {
        for (FLAGENUM flagenum : FLAGENUM.values()) {
            if (flag.equalsIgnoreCase(flagenum.getFlag())) {
                return flagenum.getDefaultValue();
            }
        }
        return null;
    }

    public void scan() {
        List<String> keyValues = Arrays.asList(argsText.split("-"));
        keyValues = keyValues.stream()
                .map(String::trim)
                .collect(Collectors.toList());
        keyValues = keyValues.subList(1, keyValues.size());
        List<Arg> args = new ArrayList<>();
        keyValues.forEach(keyValue -> {
            String[] splitKeyValue = keyValue.split(" ");
            String key = splitKeyValue[0];
            String value = splitKeyValue[1];
            if (!containsFlagOfSchema(key)) {
                try {
                    throw new IllegalArgumentException(key + " is not defined!");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            args.add(new Arg(key, value));
        });
        argSet = new HashSet<>(args);
    }

    public boolean containsFlagOfSchema(String flag) {
        for (FlagSchema flagSchema : schema.getFlagsSchema()) {
            if (flagSchema.containsFlag(flag)){
                return true;
            }
        }
        return false;
    }

}
