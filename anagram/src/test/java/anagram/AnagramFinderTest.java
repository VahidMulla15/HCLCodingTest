package anagram;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

public class AnagramFinderTest {
	
	@Test
	void getOrderCharactersTest() {
		String result = AnagramFinder.getOrderCharacters("okay");
		assertEquals("akoy", result, "Success");
	}
	
	@Test
	void findAnagramsTest() {
		String wordToSearch = "cat";
		Multimap<String, String> wordsMap = ArrayListMultimap.create();
		wordsMap.put("act", "cat");
		wordsMap.put("act", "tac");
		wordsMap.put("act", "act");
		wordsMap.put("aemt", "team");
		wordsMap.put("aemt", "meat");
		
		List<String> result = AnagramFinder.findAnagrams(wordToSearch, wordsMap);
		assertEquals(3, result.size(), "Success");
		assertEquals(true, result.contains("tac"), "Success");
		assertEquals(true, result.contains("act"), "Success");
		assertEquals(true, result.contains("cat"), "Success");
		assertEquals(false, result.contains("team"), "Success");
	}
	
	@Test
	void readFileTest() {
		String filePath = "C:\\HCL Coding test\\wordsTest.txt";
		/*File content: elbow below dusty study state taste cat act */
		Multimap<String, String> wordsMultiMap =  AnagramFinder.readFile(filePath);
		assertEquals(2, wordsMultiMap.get("act").size(), "Success");
		assertEquals(2, wordsMultiMap.get("dstuy").size(), "Success");
	}

}
