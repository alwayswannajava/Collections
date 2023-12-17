package test;

import mainClasses.LoaderUniqueCharacters;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.util.LinkedHashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class LoaderUniqueCharactersTest {


    @Test
    @DisplayName("Loading unique characters test #1")
    void testCorrectLoadingUniqueCharactersNumberOne() {
        LoaderUniqueCharacters loader = new LoaderUniqueCharacters();
        Map<Character, Integer> expectedMap = new LinkedHashMap<>();
        expectedMap.put('h', 1);
        expectedMap.put('e', 1);
        expectedMap.put('l', 2);
        expectedMap.put('o', 1);
        Map<Character, Integer> actualMap = loader.loadingUniqueCharacters("hello");
        assertEquals(expectedMap, actualMap);
    }

    @Test
    @DisplayName("Loading unique characters test #2")
    void testCorrectLoadingUniqueCharactersNumberTwo() {
        LoaderUniqueCharacters loader = new LoaderUniqueCharacters();
        Map<Character, Integer> expectedMap = new LinkedHashMap<>();
        expectedMap.put('w', 1);
        expectedMap.put('o', 1);
        expectedMap.put('r', 1);
        expectedMap.put('l', 1);
        expectedMap.put('d', 1);
        Map<Character, Integer> actualMap = loader.loadingUniqueCharacters("world");
        assertEquals(expectedMap, actualMap);
    }

    @Test
    @DisplayName("Loading unique characters test #3")
    void testCorrectLoadingUniqueCharactersNumberThree() {
        LoaderUniqueCharacters loader = new LoaderUniqueCharacters();
        Map<Character, Integer> expectedMap = new LinkedHashMap<>();
        expectedMap.put('m', 1);
        expectedMap.put('u', 1);
        expectedMap.put('s', 1);
        expectedMap.put('i', 1);
        expectedMap.put('c', 1);
        Map<Character, Integer> actualMap = loader.loadingUniqueCharacters("music");
        assertEquals(expectedMap, actualMap);
    }

    @Test
    @DisplayName("Loading unique characters test #4")
    void testCorrectLoadingUniqueCharactersNumberFour() {
        LoaderUniqueCharacters loader = new LoaderUniqueCharacters();
        Map<Character, Integer> expectedMap = new LinkedHashMap<>();
        expectedMap.put('a', 6);
        expectedMap.put('b', 4);
        Map<Character, Integer> actualMap = loader.loadingUniqueCharacters("abbabaaaba");
        assertEquals(expectedMap, actualMap);
    }

    @Test
    @DisplayName("Cache loading test #1")
    void testCorrectLoadingUniqueCharactersFromCacheNumberOne() {
        LoaderUniqueCharacters loader = new LoaderUniqueCharacters();
        Map<Character, Integer> actualMap = loader.loadingUniqueCharacters("abbabaaaba");
        Map<Character, Integer> expectedCacheMap = loader.cache.get("abbabaaaba");
        assertEquals(expectedCacheMap, actualMap);
    }


    @Test
    @DisplayName("Cache loading test #2")
    void testCorrectLoadingUniqueCharactersFromCacheNumberTwo() {
        LoaderUniqueCharacters loader = Mockito.spy(new LoaderUniqueCharacters());
        Map<Character, Integer> actualMap = loader.cache.get("world");
        when(loader.loadingUniqueCharacters("world"))
                .thenReturn(actualMap);
        assertEquals(loader.loadingUniqueCharacters("world"), actualMap);
    }

    @Test
    @DisplayName("Cache loading test #3")
    void testCorrectLoadingUniqueCharactersFromCacheNumberThree() {
        LoaderUniqueCharacters loader = Mockito.spy(new LoaderUniqueCharacters());
        Map<Character, Integer> actualMap = loader.cache.get("java");
        when(loader.loadingUniqueCharacters("java"))
                .thenReturn(actualMap);
        assertEquals(loader.loadingUniqueCharacters("java"), actualMap);
    }

    @Test
    @DisplayName("Check not invoking of PUT method in cache after invoking of GET method")
    void testCheckingNotPutMethodInCacheAfterGetMethod() {
        LoaderUniqueCharacters loader = new LoaderUniqueCharacters();
        loader.cache = mock(Map.class);
        String expectedInput = "abbabaaaba";
        Map<Character, Integer> expectedCharIntegerMap = new LinkedHashMap<>();
        expectedCharIntegerMap.put('a', 6);
        expectedCharIntegerMap.put('b', 4);
        when(loader.cache.containsKey(expectedInput)).thenReturn(true);
        verify(loader.cache, times(0)).put("abbabaaaba",expectedCharIntegerMap);
    }

    @Test
    @DisplayName("Check invoking of PUT method in cache after not found by GET method")
    void testCheckInvokingOfPutMethodAfterNotFoundByGetMethod() {
        LoaderUniqueCharacters loader = new LoaderUniqueCharacters();
        loader.cache = mock(Map.class);
        String expectedInput = "abbabaaaba";
        Map<Character, Integer> expectedCharIntegerMap = new LinkedHashMap<>();
        expectedCharIntegerMap.put('a', 6);
        expectedCharIntegerMap.put('b', 4);
        when(!loader.cache.containsKey(expectedInput)).thenReturn(false);
        loader.cache.put("abbabaaaba", expectedCharIntegerMap);
        verify(loader.cache, times(1)).put("abbabaaaba",expectedCharIntegerMap);
    }

}