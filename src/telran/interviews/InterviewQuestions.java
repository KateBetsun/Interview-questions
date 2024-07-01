package telran.interviews;

import java.util.*;

public class InterviewQuestions {
	public static void displayOccurances(String[] strings) {
		HashMap<String, Integer> mapOccurrences = getOccurrencesMap(strings);
		TreeMap<Integer, TreeSet<String>> treeMapOccurrences = getTreeMapOccurrences(mapOccurrences);
		displayOccurrences(treeMapOccurrences);
	}

	private static void displayOccurrences(TreeMap<Integer, TreeSet<String>> treeMapOccurrences) {
		treeMapOccurrences.entrySet().forEach(e -> {
			e.getValue().forEach(str -> System.out.printf("%s => %d\n", str, e.getKey()));
		});
		
	}

	private static TreeMap<Integer, TreeSet<String>> getTreeMapOccurrences(HashMap<String, Integer> mapOccurrences) {
		TreeMap<Integer, TreeSet<String>> result = new TreeMap<Integer, TreeSet<String>>(Comparator.reverseOrder());
		mapOccurrences.entrySet().forEach(e -> result.computeIfAbsent(e.getValue(), k -> new TreeSet<>()).add(e.getKey()));
		return result;
	}

	private static HashMap<String, Integer> getOccurrencesMap(String[] strings) {
		HashMap<String, Integer> result = new HashMap<>();
		for(String str: strings) {
			result.merge(str, 1, Integer::sum);
		}
		return result;
	}
	public static boolean isSum2(int[] array, int sum) {
		//TODO returns true if a given array contains two numbers, the summing of which
		//equals a given 'sum' value
		//complexity O[N] only one pass over the elements
		Set<Integer> hashSet = new HashSet<>();
		boolean res = false;
		for(int num: array) {
			int resNum = sum - num;
			if(hashSet.contains(resNum)){
				res = true;
			}
			hashSet.add(num);
		}
		return res;
	}
	public static int getMaxWithNegativePresentation(int[] array) {	
		//TODO returns maximal positive value for which exists negative one with the same abs value
		//if no pair of positive and negative values with the same abs value the method returns -1
		//complexity O[N] only one pass over the elements
		int res = -1;	
		Set<Integer> hashSet = new HashSet<>();
		for(int num: array) {
			hashSet.add(num);
			if(hashSet.contains(-num)) {
				res = Math.max(num, res);
			}
		}
		return res;
	}
	
	
}