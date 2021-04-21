package chapter03_���ڿ����񱳹�����.ch03_05_���͸�����������ϸ���Ʈȭ;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ListFiles {
	
	/**
	 * step1 fpij ���͸����� �ڹ� ���ϵ��� ��� �����ϴ��� �м�
	 * 1. FilenameFilter �������̽��� �����ϴ� ���ϸӽ� �̳� Ŭ������ �ν��Ͻ���
	 * list() �޼����� �Ķ���ͷ� �����ϴ� ���� �������� ����̴�.
	 * @throws IOException
	 */
	public static void example1()
	{
		final String[] files = 
				new File("fpij").list(new FilenameFilter() {
					
					@Override
					public boolean accept(File dir, String name) {
						// TODO Auto-generated method stub
						return name.endsWith(".java");
					}
				});
	}
	
	/**
	 * step2 ���� ǥ������ ����Ͽ� fpij ���͸��� �ִ� ��� �ڹ� ������
	 * ����Ʈ�� ��������
	 * @throws IOException
	 */
	public static void example2() throws IOException
	{
		Files.newDirectoryStream(
				Paths.get("fpij"), path -> path.toString().endsWith(".java"))
				.forEach(System.out::println);
	}
	
	/**
	 * step3 ���� ���͸����� ���� ���ϵ��� ����Ʈ�� ���
	 * @throws IOException
	 */
	public static void example3() throws IOException
	{
		final File[] files = new File(".").listFiles(file -> file.isHidden());
	}
	
	/**
	 * step4 step3���� ���� ǥ���� ��� �޼ҵ� ���۷����� ����Ͽ� �ڵ� ����
	 * @throws IOException
	 */
	public static void example4() throws IOException
	{
		final File[] files = new File(".").listFiles(File::isHidden);
		
	}

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
//		example1();
//		example2();
//		example3();
		example4();
	}

}
