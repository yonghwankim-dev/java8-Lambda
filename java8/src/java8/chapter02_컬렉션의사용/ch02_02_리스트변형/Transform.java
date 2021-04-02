package java8.chapter02_�÷����ǻ��.ch02_02_����Ʈ����;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Transform {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final List<String> friends = Arrays.asList("Brian","Nate","Neal","Raju","Sara","Scott");
		
		/**
		 * step1 ���ο� �÷��� �����Ͽ� �빮�ڷ� ��ȯ�� ����
		 */
		final List<String> uppercaseNames = new ArrayList<String>();
		for(String name : friends)
		{
			uppercaseNames.add(name.toUpperCase());
		}
		
		/**
		 * step2 ���� iterator ���
		 * - ���� iterator�� ��������� ������ �� ����Ʈ(uppercaseNames)�� �ʿ��ϰ� �� ����Ʈ�� ������Ʈ��
		 * �߰��ϴ� �۾��� �ʿ��ϴ�.
		 */
		uppercaseNames.clear();
		friends.forEach(name -> uppercaseNames.add(name.toUpperCase()));
		
		/**
		 * step3 map �޼��� ���
		 * - map() �޼��带 ����ϸ� ������(mutability)�� �߻����� �ʵ��� �� �� ������
		 * �ڵ带 �� �����ϰ� ���� �� �ִ�.
		 * - map() �޼���� �Է� ������ ��� ������ �����ϰų� �Է� ������ �ٸ� ������ �������
		 * �����Ѵ�.
		 * - map() �޼���� ���� ǥ������ ���� ����� �����Ͽ� ��� �÷������� �����Ѵ�.
		 */
		uppercaseNames.clear();
		friends.stream()
				.map(name -> name.toUpperCase())
				.forEach(name -> System.out.print(name + " "));
		System.out.println();
		
		/**
		 * step4 �� �̸��� �ִ� ������ ���� ī��Ʈ
		 * 
		 */
		uppercaseNames.clear();
		friends.stream()
				.map(name -> name.length())
				.forEach(count -> System.out.print(count + " "));
		
		/**
		 * step5 �޼ҵ� ���۷����� ���
		 * name -> name.toUpperCase()  => String::toUpperCase
		 */
		friends.stream()
				.map(String::toUpperCase)
				.forEach(name -> System.out.println(name));
		
		/**
		 * �޼ҵ� ���۷����� ���� ����ؾ� �ϴ°�?
		 * ���� ǥ������ ����� �� �Ķ���͸� �������� �ʴ� ����� �޼��� ���۷����� ����� �� �ִٴ� �ǹ�
		 */
	}

}
