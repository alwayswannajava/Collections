package mainClasses;

import java.util.*;

public class CharCounter {

    protected Map<Character, Integer> countUniqueCharacters(String text){
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