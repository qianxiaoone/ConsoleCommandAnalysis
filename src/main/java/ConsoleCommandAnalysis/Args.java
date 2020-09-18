package ConsoleCommandAnalysis;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Args {
    private String argsText;

    public Args(String argsText) {
        this.argsText = argsText;
    }

    public List<KeyValuePair> scan() {
        List<String> keyValues = Arrays.asList(argsText.split("-"));
        keyValues = keyValues.stream()
//                    .map(keyValue -> keyValue.trim())
                .map(String::trim)
                .collect(Collectors.toList());
        /*
        * List<String> keyValues = Arrays.asList(" ".concat(argsText).split("-"));
        * */

        keyValues = keyValues.subList(1,keyValues.size());

        List<KeyValuePair> keyValuePairs = new ArrayList<>();
        keyValues.forEach(keyValue -> {
            String[] splitKeyValue = keyValue.split(" ");
            String key = splitKeyValue[0];
            String value = splitKeyValue[1];
            keyValuePairs.add(new KeyValuePair(key,value));
        });
        return keyValuePairs;
    }
}
