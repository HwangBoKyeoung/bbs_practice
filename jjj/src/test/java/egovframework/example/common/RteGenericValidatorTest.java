package egovframework.example.common;

import java.io.Serializable;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:/egovframework/spring/context-*.xml")
public class RteGenericValidatorTest implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
	public static boolean isValidIdIhNum(String value) {
//		값의 길이가 13자리, 7번째 자리가 1,2,3,4 중 하나인지 체크
//		String regex = "\\d{6}[1234]\\d{6}"; // egov document
		String regex = "^(?:[0-9]{2}(?:0[1-9]|1[0-2])(?:0[1-9]|[1,2][0-9]|3[0,1]))-[1-4][0-9]{6}$"; // java regex
		
		/*if(!value.matches(regex)) {
			return false;
		}*/
		
//		앞 6자리의 값이 유효한 날짜인지
		String strDate = value.substring(0,6);
//		950405 => 19950405 / 000101 => 20000101
		strDate = ((value.charAt(6) == '1' || value.charAt(6) == '2') ? "19" : "20") + strDate;
		strDate = strDate.substring(0,4) + "/" + strDate.substring(4,6) + "/" + strDate.substring(6,8);
		
		System.out.println("-----------------------------------date: " + strDate);
		
		/*char[] charArr = value.toCharArray();
		for(int i=0; i<charArr.length; i++) {
			System.out.println("-----------------------------------Arr[" + i + "]" + ": " + charArr[i]);
		}
		
		long sum = 0;
		int[] arrDivide = new int[] {2,3,4,5,6,7,8,9,2,3,4,5};
		
		for(int i=0; i<(charArr.length-1); i++) {
			sum += Integer.parseInt(String.valueOf(charArr[i])) + arrDivide[i];
		}
		
		int checkdigit = (int) ((int)(11 - sum % 11)) % 10;*/
/*		
		System.out.println("===============================sum" + sum);
		System.out.println("===============================checkdigit" + checkdigit);
		System.out.println("===============================check"+Integer.parseInt(String.valueOf(charArr[12])));*/
		
		char[] charArray = value.toCharArray();
		long sum = 0;
		int[] arrDivide = new int[] { 2, 3, 4, 5, 6, 7, 8, 9, 2, 3, 4, 5 };
		for (int i = 0; i < charArray.length - 1; i++) {
			sum += Integer.parseInt(String.valueOf(charArray[i]))
					* arrDivide[i];
		}
		int checkdigit = (int) ((int) (11 - sum % 11)) % 10;
		System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^"+sum);
		System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^"+checkdigit);
		System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^"+charArray[12]);

		return (checkdigit == Integer.parseInt(String.valueOf(charArray[12]))) ? true
				: false;
	}
	
	@Test
	public void test() {
		if(isValidIdIhNum("9504052691419")) {
			System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^성공!");
		}
		
	}
	

}
