import java.util.LinkedHashMap;
import java.util.Map;

public class LoaderUniqueCharacters extends CharCounter {
    Map<String, Map<Character, Integer>> cache = new LinkedHashMap<>();

    public Map<Character, Integer> loadingUniqueCharacters(String text) {
        Map<Character, Integer> calculatedUniqueCharactersMap = new LinkedHashMap<>();
        if(cache.containsKey(text)){
            calculatedUniqueCharactersMap = cache.get(text);
        }
        else {
            calculatedUniqueCharactersMap = countUniqueCharacters(text);
            cache.put(text, calculatedUniqueCharactersMap);
        }
        return calculatedUniqueCharactersMap;
    }
}
