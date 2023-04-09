package anagram;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

public class AnagramFinder {

	public static void main(String[] args) {
		String wordsFilePath = "C:\\HCL Coding test\\words.txt";
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a word in the console:");
		String word = input.nextLine();
		input.close();
		
		Multimap<String, String> wordsMap = readFile(wordsFilePath);
		List<String> anagramList = findAnagrams(word, wordsMap);
		anagramList.stream().sorted().forEach(System.out::println);
	}

	public static Multimap<String, String> readFile(String filePath){
		Multimap<String, String> wordsMultiMap = ArrayListMultimap.create();
		File file = new File(filePath);
		Scanner fileInput = null;
		try {
			fileInput = new Scanner(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		while(fileInput.hasNextLine()) {
			String temp = fileInput.next().trim();
			wordsMultiMap.put(getOrderCharacters(temp), temp);
		}
		return wordsMultiMap;
	}
	
	public static String getOrderCharacters(String word) {
		char[] charArray = word.toCharArray();
		Arrays.sort(charArray);
		return new String(charArray);
	}

	public static List<String> findAnagrams(String word, Multimap<String, String> wordsMap) {
		return (List<String>) wordsMap.get(getOrderCharacters(word));
	}
}
