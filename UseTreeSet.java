package ocp;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class UseTreeSet {
static class Rabbit{int id;}

	public static <Duck> void main(String[] args) {
		// 
Map<String, Integer> counts = new HashMap<>();
counts.put("jenny", 68);
counts.put("sam", 3);

counts.computeIfPresent("jenny", (k, v) -> null);
counts.computeIfAbsent("sam", k -> 23);
System.out.println(counts);
//System.out.println(jenny);
	}

}
