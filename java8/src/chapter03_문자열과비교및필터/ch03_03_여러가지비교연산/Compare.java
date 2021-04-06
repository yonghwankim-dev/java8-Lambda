package chapter03_문자열과비교및필터.ch03_03_여러가지비교연산;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Compare {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		final List<Person> people = Arrays.asList(new Person("John",20),
													new Person("Sara",21),
													new Person("Jane",21),
													new Person("Greg",35));
		
		/**
		 * step1 이름을 비교해서 사람들을 정렬
		 * 아래 기능을 활용하면 다중 비교를 더욱 다양하게 할 수 있다.
		 */
		final Function<Person, String> byName = person -> person.getName();
		people.stream()
				.sorted(Comparator.comparing(byName));
		
		
		/**
		 * step2 나이와 이름을 비교해서 사람들을 정렬
		 * thenComparing() 메서드를 호출해서 나이와 이름 두 값에 따라 비교하는
		 * 복합 comparator를 생성하게 된다.
		 */
		final Function<Person, Integer> byAge = person -> person.getAge();
		final Function<Person, String> byTheirName = person -> person.getName();
		
		printPeople("Sorted in ascending order by age and name : ",
						people.stream()
								.sorted(Comparator.comparing(byAge).thenComparing(byTheirName))
								.collect(Collectors.toList()));
		
		
	}

	public static void printPeople(String description, List<Person> list)
	{
		System.out.println(description);
		list.forEach(System.out::println);
	}

}
