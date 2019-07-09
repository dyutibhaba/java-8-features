package examples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class BusCount {

	public static String busRanking(List<String> busModels) {

		TreeMap<String, Long> collect = busModels.stream().filter(e -> e != null && !e.startsWith("V"))
				.collect(Collectors.groupingBy(bus -> bus, TreeMap::new, Collectors.counting()));
		System.out.println(collect);

		Map<String, Long> counters = busModels.stream().skip(1).filter(Objects::nonNull)
				.filter(bus -> !bus.startsWith("V")).collect(Collectors.groupingBy(bus -> bus, Collectors.counting()));

		Map<String, Long> finalMap = new LinkedHashMap<>();
		counters.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
				.forEachOrdered(e -> finalMap.put(e.getKey(), e.getValue()));

		/*
		 * Map<String, Long> finalMap1 = new LinkedHashMap<>();
		 * counters.entrySet().stream().sorted(Map.Entry.comparingByKey((
		 * Comparator.reverseOrder()))) .forEachOrdered(e ->
		 * finalMap1.put(e.getKey(), e.getValue()));
		 */

		return finalMap.toString();
	}

	public void MapListSort() {
		ArrayList<Map.Entry<String, Long>> list = new ArrayList<>();

	}

	public static void main(String[] args) {
		/*
		 * List<String> busModels = Arrays.asList("10",
		 * "Setra","Mercedes","Volvo","Mercedes","Skoda","Iveco","MAN",null,
		 * "Skoda","Iveco"); String busRanking = busRanking(busModels);
		 * System.out.println(busRanking);
		 */
		List<String> busModels = Arrays.asList("Setra", "Mercedes", "Volvo", "Mercedes", "Skoda", "Iveco", "MAN", null,
				"Skoda", "Iveco");

		/*
		 * Map<String, Long> collect = busModels.stream()
		 * .filter(Objects::nonNull)
		 * .collect(Collectors.groupingBy(Function.identity(),
		 * Collectors.counting()));
		 * 
		 * String busRanking = new TreeMap<>(collect).toString();
		 * System.out.println(busRanking);
		 */

		// List<String> busModels = Arrays.asList(
		// "Setra","Mercedes","Volvo","Mercedes","Skoda","Iveco","MAN",null,"Skoda","Iveco");

		Map<String, Long> collect = busModels.stream().filter(Objects::nonNull)
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println(collect);

		TreeMap<String, Long> stringLongTreeMap = new TreeMap<>(collect);
		System.out.println(stringLongTreeMap);

		Set<Map.Entry<String, Long>> entries = stringLongTreeMap.entrySet();
		ArrayList<Map.Entry<String, Long>> list = new ArrayList<>(entries);
		System.out.println(list);

		list.sort((o1, o2) -> o2.getValue().compareTo(o1.getValue()));
		String busRanking = list.toString();
		System.out.println(busRanking);
	}
}
