package name_Application;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.*;

public class Airplane {
	public static void main(String[] op) {
		List<Integer> list = new ArrayList<>();
		list.add(2);
		list.add(3);
		list.add(4);
		print(list, e -> e < 0);
	}

	public static void print(List<Integer> list, Predicate<Integer> p) {
		for (Integer num : list)
//			if(p.test(num))
			System.out.println(num);
			
	}
}
