package chapter03_문자열과비교및필터.ch03_04_collect메서드와Collectos클래스사용;

import java.util.ArrayList;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BinaryOperator;
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
		 * step1 가변성과 forEach() 메서드를 사용하여 collect 기능 사용
		 * collect() 메서드는 컬렉슨을 다른 형태, 즉 가변 컬렉션(mutable collection)
		 * 으로 변경하는데 유용한 리듀스(Reduce) 오퍼레이션이다.
		 * 
		 * 문제점
		 * 1. 타깃 컬렉션에 엘리먼트를 추가하는 오퍼레이션이 너무 로우 레벨이다.
		 * 2. 가변성을 병렬화를 어렵게 한다.
		 * 
		 * 해결방법
		 * 1. collect() 메서드 사용
		 * 
		 */
		List<Person> olderThan20 = new ArrayList<Person>();
		people.stream()
				.filter(person -> person.getAge() > 20)
				.forEach(person -> olderThan20.add(person));
		System.out.println("People older than 20: "+olderThan20);
		
		/**
		 * step2 collect() 메서드 사용
		 * collect() 메서드는 엘리먼트들에 대한 스트림을 가지며 결과 컨테이너로 그 스트림을 모은다.
		 * 
		 * 아래와 같이 collect 하기 위해서는 다음 세가지를 알아야 한다.
		 * 1. 결과 컨테이너를 만드는 방법(예를 들어, ArrayList::new 메서드를 사용하는것)
		 * 2. 하나의 엘리먼트를 결과 컨테이너에 추가하는 방법(예를 들어, ArrayList::add 메서드를 사용하는 것)
		 * 3. 하나의 결과 컨테이너를 다른 것과 합치는 방법(예를 들어, ArrayList::addAll 메서드를 사용하는 것)
		 * 
		 * collect 사용 장점
		 * 1. 서술적으로 프로그래밍 가능
		 * 2. 이터레이션의 실행 병령화
		 * 3. 다른 서브 리스트 간의 병렬 덧셈을 수행하여 그 결과를 스레드 세이프하게
		 * 좀더 큰 규모의 리스트로 합칠 수 있다.
		 */
		List<Person> olderThan20_2 = people.stream()
											.filter(person -> person.getAge()>20)
											.collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
		System.out.println("People older than 20 : " + olderThan20_2);
		
		/**
		 * step3 Collectors.toList() 사용하여 stream 합치기
		 * toList()외의 다른 Collectors
		 * toSet() : 집합을 모으는 toSet()
		 * toMap() : key-value 컬렉션에 모으는 toMap()
		 * joining() : 엘리먼트를 스트링으로 합치는 joining()
		 * mapping(), collectingAndThen(), minBy(), maxBy(), groupingBy()와 같은
		 * 메서드를 사용하여 여러 오퍼레이션을 합쳐서 사용이 가능하다.
		 */
		List<Person> olderThan20_3 = people.stream()
											.filter(person -> person.getAge()>20)
											.collect(Collectors.toList());
		System.out.println("People older than 20 : " + olderThan20_3);
		
		/**
		 * step4 사람들의 나이를 값으로 사용해서 그룹으로 묶는 groupingBy() 사용
		 * 1. groupingBy() 메서드는 다중 영역을 조합하여 묶을 수 있다.
		 * 2. groupingBy() 메서드는 람다 표현식이나 메서드 레퍼런스를 인수로 갖는다.
		 * 3. groupingBy() 메서드의 람다 표현식이나 메서드 레퍼런스 인수를 분류 함수(classifier function)
		 * 이라고 한다.
		 * 4. 이 분류함수는 우리가 그룹핑하려고 하는 엘리먼트의 속성값을 리턴한다.
		 */
		Map<Integer,List<Person>> peopleByAge =
												people.stream()
														.collect(Collectors.groupingBy(Person::getAge));
		System.out.println("Grouped by age : " + peopleByAge);
		
		/**
		 * step5 나이로 Person의 객체에 대한 맵을 생성하지 않고 사람들의 이름과 나이 순서대로 정렬
		 * 1. groupingBy 첫번째 파라미터로 그룹핑을 시전
		 * 2. 두번째 파라미터는 mapping() 함수 호출의 결과인 Collector
		 * 3. mapping() 메서드는 두 개의 정보를 가지며 그 정보 중 하나는 어떤 map(이 경우에는 이름)
		 * 을 사용할지에 대한 속성이고 다른 하나는 모으는 객체의 타입이다.
		 * 결과는 이름 리스트가 나이로 그룹 지어졌다.
		 */
		Map<Integer, List<String>> nameOfPeopleByAge = people.stream()
											.collect(
														Collectors.groupingBy(Person::getAge, 
																		Collectors.mapping(Person::getName, Collectors.toList()))
													);
		System.out.println("People grouped by age: " + nameOfPeopleByAge);
		
		/**
		 * step6 첫번째 문자로 이름을  그룹핑하고 나서 각 그룹에서 가장 나이가 많은 사람을 얻기
		 * 1. 첫번째 문자를 기반으로 이름을 그룹핑한다. 이 작업을 위해 groupingBy() 메서드에
		 *  첫번째 파라미터로 람다 표현식을 전달한다.
		 *  이 람다 표현식에서 그룹핑을 위해 이름의 첫번째 문자를 리턴한다.
		 * 2. 두번째 파라미터는 매핑 대신에 리듀스 오퍼레이션을 수행한다. 각 그룹에서 가장 나이가
		 * 많은 사람으로 엘리먼트들을 리듀스 한다.
		 * 3. 가장 나이 많은 사람을 선택하는 기능은 maxBy() 메서드를 사용한다.
		 */
		Comparator<Person> byAge = Comparator.comparing(Person::getAge);
		Map<Character, Optional<Person>> oldestPersonOfEachLetter =
				people.stream()
						.collect(Collectors.groupingBy(person -> person.getName().charAt(0),
									Collectors.reducing(BinaryOperator.maxBy(byAge))));
		System.out.println("Oldest person of each letter:");
		System.out.println(oldestPersonOfEachLetter);
	}

	public static void printPeople(String description, List<Person> list)
	{
		System.out.println(description);
		list.forEach(System.out::println);
	}

}
