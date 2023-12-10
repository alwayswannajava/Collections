package test;

import mainClasses.OutputResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.LinkedHashMap;
import java.util.Map;

public class OutputResultTest {

    @Test
    @DisplayName("Output result #1")
    void testCorrectOutputResultNumberOne(){
        OutputResult outputResult = new OutputResult();
        String expectedOutput = "'h' - 1\n" +
                "'e' - 1\n" +
                "'l' - 2\n" +
                "'o' - 1\n";
        Map<Character, Integer> expectedOutputMap = new LinkedHashMap<>();
        expectedOutputMap.put('h', 1);
        expectedOutputMap.put('e', 1);
        expectedOutputMap.put('l', 2);
        expectedOutputMap.put('o', 1);
        StringBuilder actualOutput = outputResult.outputResultMap(expectedOutputMap);
        assertEquals(expectedOutput, actualOutput.toString());
    }

    @Test
    @DisplayName("Output result #2")
    void testCorrectOutputResultNumberTwo(){
        OutputResult outputResult = new OutputResult();
        String expectedOutput = "'w' - 1\n" +
                "'o' - 1\n" +
                "'r' - 1\n" +
                "'l' - 1\n" +
                "'d' - 1\n";
        Map<Character, Integer> expectedOutputMap = new LinkedHashMap<>();
        expectedOutputMap.put('w', 1);
        expectedOutputMap.put('o', 1);
        expectedOutputMap.put('r', 1);
        expectedOutputMap.put('l', 1);
        expectedOutputMap.put('d', 1);
        StringBuilder actualOutput = outputResult.outputResultMap(expectedOutputMap);
        assertEquals(expectedOutput, actualOutput.toString());
    }

    @Test
    @DisplayName("Output result #3")
    void testCorrectOutputResultNumberThree(){
        OutputResult outputResult = new OutputResult();
        String expectedOutput = "'a' - 6\n" +
                "'b' - 4\n";
        Map<Character, Integer> expectedOutputMap = new LinkedHashMap<>();
        expectedOutputMap.put('a', 6);
        expectedOutputMap.put('b', 4);
        StringBuilder actualOutput = outputResult.outputResultMap(expectedOutputMap);
        assertEquals(expectedOutput, actualOutput.toString());
    }
}
