package egovframework.example.test;

import java.util.Scanner;

public class MainTest1000 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int result=0;
		int A = scan.nextInt();
		int B = scan.nextInt();
		
		if(A < 10 && B < 10) {
			result = A+B;
		}
		
		System.out.println(result);
	}
}
