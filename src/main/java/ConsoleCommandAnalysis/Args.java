package ConsoleCommandAnalysis;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Args {
    private String argsText;
    private Schema schema;
    private Set<Arg> argSet = new HashSet<>();
    private final String space = " ";

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
        argsText = inputHandle();
        List<String> keyValues = Arrays.asList(argsText.split("-"));
        keyValues = keyValues.stream()
                .collect(Collectors.toList());
        keyValues = keyValues.subList(1, keyValues.size());
        List<Arg> args = new ArrayList<>();
        keyValues.forEach(keyValue -> {
            String[] splitKeyValue = keyValue.split(" ");
            String key = splitKeyValue[0].trim();
            String value = "";
            if (splitKeyValue.length < 2){
                value = getDefaultValue(key);
            }else {
                value = splitKeyValue[1].trim();
            }
            paramCheck(key, value);
            args.add(new Arg(key, value));
        });
        argSet = new HashSet<>(args);
    }

    public boolean containsFlagOfSchema(String flag) {
        for (FlagSchema flagSchema : schema.getFlagsSchema()) {
            if (flagSchema.containsFlag(flag)) {
                return true;
            }
        }
        return false;
    }

    public String inputHandle() {
        return argsText.replaceAll(" +", " ").trim();
    }

    public void paramCheck(String key, String value) {
        if (!containsFlagOfSchema(key)) {
            try {
                throw new IllegalArgumentException(key + " is not defined!");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (key.startsWith(space) || value.trim().contains(space)) {
            try {
                throw new IllegalArgumentException("Param is illegal!");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
