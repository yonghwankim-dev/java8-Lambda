package chapter03_문자열과비교및필터.ch03_03_여러가지비교연산;

/**
 * step1 인스턴스의 비교 정렬을 위하여 클래스 생성 
 */
public class Person {
	private String name;
	private int age;
	
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}
	
	public int ageDifference(final Person other)
	{
		return age - other.age;
	}

	@Override
	public String toString() {
		return name + " - " + age;
	}	
}
