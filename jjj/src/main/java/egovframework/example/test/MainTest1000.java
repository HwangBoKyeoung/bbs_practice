package egovframework.example.test;

import java.util.Scanner;

public class MainTest1000 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("숫자 두 개 입력하시오");
		int a = scan.nextInt();
		int b = scan.nextInt();
		
		System.out.println("숫자 2개는 : "+ a + ", " + b);
		System.out.println("숫자 2개 합은 : "+ a + " + " + b + " = " + (a+b));
	}
}
