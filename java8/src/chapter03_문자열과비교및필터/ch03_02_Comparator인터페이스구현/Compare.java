package chapter03_문자열과비교및필터.ch03_02_Comparator인터페이스구현;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Compare {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/**
		 * step2 작업할 사람들의 리스트 생성
		 */
		final List<Person> people = Arrays.asList(new Person("John",20),
													new Person("Sara",21),
													new Person("Jane",21),
													new Person("Greg",35));
		/**
		 * step3 스트림을 통한 sorted() 메소드 활용
		 * 기존 List 인터페이스의 sort() 메소드는 리턴타입이 void이므로 원본 컬렉션이
		 * 변경된다. 이는 원본 리스트를 보존하기 위해서는 복사본을 만들수 밖에 없다.
		 * 위의 문제를 해결하기 위해서 스트림을 사용하면 이러한 문제점을 피할 수 있다.
		 * 
		 * 1. people에 대한 리스트를 stream() 메서드를 사용해서 스트림으로 변환
		 * 2. sorted() 메서드 호출, sorted 메서드는 파라미터로 Comparator 함수형 인터페이스를 갖기
		 * 때문에 람다 표현식을 인수로 쉽게 넘길 수 있다.
		 * 3. collect() 메서드를 호출하고 결과를 하나의 리스트로 만든다.
		 */
		List<Person> ascendingAge = people.stream()
											.sorted((person1, person2)->person1.ageDifference(person2))
											.collect(Collectors.toList());
		
		printPeople("Sorted in ascending order by age : ", ascendingAge);
		
		/**
		 * step5 ageDifference() 메서드의 레퍼런로 변경
		 * 컴파일러는 비교할 대상인 두 개의 person 인스턴스를 가지며 첫번째 파라미터는
		 * ageDifference() 메서드의 타깃을 만들고 두번째는 그 메서드에 대한 파라미터를
		 * 만든다.
		 */
		List<Person> ascendingAge2 = people.stream()
				.sorted(Person::ageDifference)
				.collect(Collectors.toList());

		printPeople("Sorted in ascending order by age : ", ascendingAge2);
		
		/**
		 * step6 나이를 내림차순으로 정렬하여 출력
		 * 아래의 소스 코드를 람다 표현식이 아닌 메서드 레퍼런스로는 쉽게 변경할 수 없다.
		 * 
		 * 이유는 파라미터 순서가 메서드 레퍼런스를 사용하기 위한 파라미터 라우팅 규칙을
		 * 사용하지 않기 때문이다.
		 * 
		 * 첫번째 파라미터는 메서드에 대한 타깃으로 사용되지 않고 오히려 인수로 사용된다.
		 */
		List<Person> descendingAge = people.stream()
											.sorted((person1, person2)->person2.ageDifference(person1))
											.collect(Collectors.toList());
		
		printPeople("Sorted in descending order by age", descendingAge);
		
		/**
		 * step7 reversed() 메서드 사용
		 * 첫번째 Comparator에서 reversed()를 호출하면 비교 결과가 역순으로 된 다른 Comparator를 얻을 수 있다.
		 * 
		 */
		Comparator<Person> compareAscending = (person1, person2) -> person1.ageDifference(person2);
		Comparator<Person> compareDescending = compareAscending.reversed();
		
		/**
		 * step8 Comparator 사용
		 */
		printPeople("Sorted in ascending order by age",
				people.stream()
						.sorted(compareAscending)
						.collect(Collectors.toList())
		);
		printPeople("Sorted in descending order by age",
				people.stream()
						.sorted(compareDescending)
						.collect(Collectors.toList())
		);
		
		/**
		 * step9 이름의 알파벳을 기준으로 오람차순으로 졍렬 (람다 표현식)
		 */
		printPeople("Sorted in ascending order by name:",
				people.stream()
						.sorted((person1, person2)-> person1.getName().compareTo(person2.getName()))
						.collect(Collectors.toList()));
		
		/**
		 * step10 min() 메서드를 사용하여 가장 젋은 사람을 출력
		 * ifPresent 메소드를 사용한 이유는 people 리스트가 없을수도 있다.
		 */
		people.stream()
				.min(Person::ageDifference)
				.ifPresent(youngest -> System.out.println("Youngest: " + youngest));
		
		/**
		 * step11 max() 메서드를 사용하여 가장 나이가 많은 사람 출력
		 */
		people.stream()
				.max(Person::ageDifference)
				.ifPresent(oldest -> System.out.println("Oldest : " + oldest));
	}
	/**
	 * step4 list 출력
	 * @param description
	 * @param list
	 */
	public static void printPeople(String description, List<Person> list)
	{
		System.out.println(description);
		list.forEach(System.out::println);
	}

}
