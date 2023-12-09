import java.util.*;

public class CharCounter {


    public static void main(String[] args) {
        LoaderUniqueCharacters loader = new LoaderUniqueCharacters();
        OutputResult outputResult = new OutputResult();
        Map<Character, Integer> characterIntegerMapOne = loader.loadingUniqueCharacters("hello");
        Map<Character, Integer> characterIntegerMapTwo = loader.loadingUniqueCharacters("world");
        Map<Character, Integer> expectedCacheMap = loader.loadingUniqueCharacters("hello");
        outputResult.outputResultMap(expectedCacheMap);

    }

    public Map<Character, Integer> countUniqueCharacters(String text){
        Map<Character, Integer> uniqueCharactersMap = new LinkedHashMap<>();
        text.chars().forEach((ch) -> {
            Character currentChar = (char) ch;
            if(uniqueCharactersMap.containsKey(currentChar)){
                uniqueCharactersMap.put(currentChar, uniqueCharactersMap.get(currentChar) + 1);
            }
            else {
                uniqueCharactersMap.put(currentChar, 1);
            }
        });
        return uniqueCharactersMap;
    }
}