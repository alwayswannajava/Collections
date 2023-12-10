package mainClasses;

import java.util.Map;

public class OutputResult {
    private StringBuilder outputResultInfo = new StringBuilder();

    public StringBuilder outputResultMap(Map<Character, Integer> outputMap) {
        outputMap.forEach((key, value) -> outputResultInfo.append("\'" + key + "\'" + " - " + value).append("\n"));
        return outputResultInfo;
    }
}
