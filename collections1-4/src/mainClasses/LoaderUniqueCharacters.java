package mainClasses;

import java.util.LinkedHashMap;
import java.util.Map;

public class LoaderUniqueCharacters {
    public Map<String, Map<Character, Integer>> cache = new LinkedHashMap<>();


    public Map<Character, Integer> loadingUniqueCharacters(String text) {
        Map<Character, Integer> calculatedUniqueCharactersMap = new LinkedHashMap<>();
        CharCounter charCounter = new CharCounter();
        if(cache.containsKey(text)){
            calculatedUniqueCharactersMap = cache.get(text);
        }
        else {
            calculatedUniqueCharactersMap = charCounter.countUniqueCharacters(text);
            cache.put(text, calculatedUniqueCharactersMap);
        }
        return calculatedUniqueCharactersMap;
    }
}
