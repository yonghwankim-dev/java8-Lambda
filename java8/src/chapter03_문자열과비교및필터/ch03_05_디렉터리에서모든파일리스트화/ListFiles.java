package chapter03_문자열과비교및필터.ch03_05_디렉터리에서모든파일리스트화;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ListFiles {
	
	/**
	 * step1 fpij 디렉터리에서 자바 파일들을 어떻게 선택하는지 분석
	 * 1. FilenameFilter 인터페이스를 구현하는 어노니머스 이너 클래스의 인스턴스를
	 * list() 메서드의 파라미터로 전달하는 것은 습관적인 방법이다.
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
	 * step2 람다 표현식을 사용하여 fpij 디렉터리에 있는 모든 자바 파일의
	 * 리스트를 가져오기
	 * @throws IOException
	 */
	public static void example2() throws IOException
	{
		Files.newDirectoryStream(
				Paths.get("fpij"), path -> path.toString().endsWith(".java"))
				.forEach(System.out::println);
	}
	
	/**
	 * step3 현재 디렉터리에서 히든 파일들의 리스트를 출력
	 * @throws IOException
	 */
	public static void example3() throws IOException
	{
		final File[] files = new File(".").listFiles(file -> file.isHidden());
	}
	
	/**
	 * step4 step3에서 람다 표현식 대신 메소드 레퍼런스를 사용하여 코드 감축
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
