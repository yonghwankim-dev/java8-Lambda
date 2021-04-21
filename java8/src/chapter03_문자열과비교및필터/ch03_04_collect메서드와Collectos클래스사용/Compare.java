package chapter03_���ڿ����񱳹�����.ch03_04_collect�޼����CollectosŬ�������;

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
		 * step1 �������� forEach() �޼��带 ����Ͽ� collect ��� ���
		 * collect() �޼���� �÷����� �ٸ� ����, �� ���� �÷���(mutable collection)
		 * ���� �����ϴµ� ������ ���ེ(Reduce) ���۷��̼��̴�.
		 * 
		 * ������
		 * 1. Ÿ�� �÷��ǿ� ������Ʈ�� �߰��ϴ� ���۷��̼��� �ʹ� �ο� �����̴�.
		 * 2. �������� ����ȭ�� ��ư� �Ѵ�.
		 * 
		 * �ذ���
		 * 1. collect() �޼��� ���
		 * 
		 */
		List<Person> olderThan20 = new ArrayList<Person>();
		people.stream()
				.filter(person -> person.getAge() > 20)
				.forEach(person -> olderThan20.add(person));
		System.out.println("People older than 20: "+olderThan20);
		
		/**
		 * step2 collect() �޼��� ���
		 * collect() �޼���� ������Ʈ�鿡 ���� ��Ʈ���� ������ ��� �����̳ʷ� �� ��Ʈ���� ������.
		 * 
		 * �Ʒ��� ���� collect �ϱ� ���ؼ��� ���� �������� �˾ƾ� �Ѵ�.
		 * 1. ��� �����̳ʸ� ����� ���(���� ���, ArrayList::new �޼��带 ����ϴ°�)
		 * 2. �ϳ��� ������Ʈ�� ��� �����̳ʿ� �߰��ϴ� ���(���� ���, ArrayList::add �޼��带 ����ϴ� ��)
		 * 3. �ϳ��� ��� �����̳ʸ� �ٸ� �Ͱ� ��ġ�� ���(���� ���, ArrayList::addAll �޼��带 ����ϴ� ��)
		 * 
		 * collect ��� ����
		 * 1. ���������� ���α׷��� ����
		 * 2. ���ͷ��̼��� ���� ����ȭ
		 * 3. �ٸ� ���� ����Ʈ ���� ���� ������ �����Ͽ� �� ����� ������ �������ϰ�
		 * ���� ū �Ը��� ����Ʈ�� ��ĥ �� �ִ�.
		 */
		List<Person> olderThan20_2 = people.stream()
											.filter(person -> person.getAge()>20)
											.collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
		System.out.println("People older than 20 : " + olderThan20_2);
		
		/**
		 * step3 Collectors.toList() ����Ͽ� stream ��ġ��
		 * toList()���� �ٸ� Collectors
		 * toSet() : ������ ������ toSet()
		 * toMap() : key-value �÷��ǿ� ������ toMap()
		 * joining() : ������Ʈ�� ��Ʈ������ ��ġ�� joining()
		 * mapping(), collectingAndThen(), minBy(), maxBy(), groupingBy()�� ����
		 * �޼��带 ����Ͽ� ���� ���۷��̼��� ���ļ� ����� �����ϴ�.
		 */
		List<Person> olderThan20_3 = people.stream()
											.filter(person -> person.getAge()>20)
											.collect(Collectors.toList());
		System.out.println("People older than 20 : " + olderThan20_3);
		
		/**
		 * step4 ������� ���̸� ������ ����ؼ� �׷����� ���� groupingBy() ���
		 * 1. groupingBy() �޼���� ���� ������ �����Ͽ� ���� �� �ִ�.
		 * 2. groupingBy() �޼���� ���� ǥ�����̳� �޼��� ���۷����� �μ��� ���´�.
		 * 3. groupingBy() �޼����� ���� ǥ�����̳� �޼��� ���۷��� �μ��� �з� �Լ�(classifier function)
		 * �̶�� �Ѵ�.
		 * 4. �� �з��Լ��� �츮�� �׷����Ϸ��� �ϴ� ������Ʈ�� �Ӽ����� �����Ѵ�.
		 */
		Map<Integer,List<Person>> peopleByAge =
												people.stream()
														.collect(Collectors.groupingBy(Person::getAge));
		System.out.println("Grouped by age : " + peopleByAge);
		
		/**
		 * step5 ���̷� Person�� ��ü�� ���� ���� �������� �ʰ� ������� �̸��� ���� ������� ����
		 * 1. groupingBy ù��° �Ķ���ͷ� �׷����� ����
		 * 2. �ι�° �Ķ���ʹ� mapping() �Լ� ȣ���� ����� Collector
		 * 3. mapping() �޼���� �� ���� ������ ������ �� ���� �� �ϳ��� � map(�� ��쿡�� �̸�)
		 * �� ��������� ���� �Ӽ��̰� �ٸ� �ϳ��� ������ ��ü�� Ÿ���̴�.
		 * ����� �̸� ����Ʈ�� ���̷� �׷� ��������.
		 */
		Map<Integer, List<String>> nameOfPeopleByAge = people.stream()
											.collect(
														Collectors.groupingBy(Person::getAge, 
																		Collectors.mapping(Person::getName, Collectors.toList()))
													);
		System.out.println("People grouped by age: " + nameOfPeopleByAge);
		
		/**
		 * step6 ù��° ���ڷ� �̸���  �׷����ϰ� ���� �� �׷쿡�� ���� ���̰� ���� ����� ���
		 * 1. ù��° ���ڸ� ������� �̸��� �׷����Ѵ�. �� �۾��� ���� groupingBy() �޼��忡
		 *  ù��° �Ķ���ͷ� ���� ǥ������ �����Ѵ�.
		 *  �� ���� ǥ���Ŀ��� �׷����� ���� �̸��� ù��° ���ڸ� �����Ѵ�.
		 * 2. �ι�° �Ķ���ʹ� ���� ��ſ� ���ེ ���۷��̼��� �����Ѵ�. �� �׷쿡�� ���� ���̰�
		 * ���� ������� ������Ʈ���� ���ེ �Ѵ�.
		 * 3. ���� ���� ���� ����� �����ϴ� ����� maxBy() �޼��带 ����Ѵ�.
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
