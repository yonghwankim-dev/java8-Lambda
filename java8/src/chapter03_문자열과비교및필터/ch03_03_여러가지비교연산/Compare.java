package chapter03_���ڿ����񱳹�����.ch03_03_���������񱳿���;

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
		 * step1 �̸��� ���ؼ� ������� ����
		 * 1. �Ʒ� ����� Ȱ���ϸ� ���� �񱳸� ���� �پ��ϰ� �� �� �ִ�.
		 * 2. comparing() �޼���� Comparator�� �����ϱ� ���� ������ ���� ǥ������
		 * ������ ����Ѵ�.
		 * 3. �����Լ�
		 * 	- �ϳ��� �Լ�(Function)�� ���� �ٸ� ��(Comparator)�� �����Ѵٴ� �ǹ� 
		 *
		 * 
		 */
		final Function<Person, String> byName = person -> person.getName();
		people.stream()
				.sorted(Comparator.comparing(byName));
		
		
		/**
		 * step2 ���̿� �̸��� ���ؼ� ������� ����
		 * thenComparing() �޼��带 ȣ���ؼ� ���̿� �̸� �� ���� ���� ���ϴ�
		 * ���� comparator�� �����ϰ� �ȴ�.
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
