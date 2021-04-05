package chapter03_문자열과비교및필터.ch03_02_Comparator인터페이스구현;

import java.util.Arrays;
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
