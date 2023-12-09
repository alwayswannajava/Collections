import java.util.Map;

public class OutputResult {
    public void outputResultMap(Map<Character, Integer> outputMap) {
        outputMap.forEach((key, value) -> System.out.println("\"" + key + "\"" + " - " + value));
    }
}
