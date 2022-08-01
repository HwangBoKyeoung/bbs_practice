package egovframework.example.common;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RteGenericValidator implements Serializable {

//	주민등록번호 eGov validator을 사용해보려 했으나.. 
	
	private static final long serialVersionUID = 1L;
	
	public static boolean isValidIdIhNum(String value) {
//		값의 길이가 13자리, 7번째 자리가 1,2,3,4 중 하나인지 체크
//		String regex = "\\d{6}[1234]\\d{6}"; // egov document
		String regex = "^(?:[0-9]{2}(?:0[1-9]|1[0-2])(?:0[1-9]|[1,2][0-9]|3[0,1]))-[1-4][0-9]{6}$"; // java regex
		
		if(!value.matches(regex)) {
			return false;
		}
		
//		앞 6자리의 값이 유효한 날짜인지
		String strDate = value.substring(0,6);
//		950405 => 19950405 / 000101 => 20000101
		strDate = ((value.charAt(6) == '1' || value.charAt(6) == '2') ? "19" : "20") + strDate;
//		1995/04/05
		strDate = strDate.substring(0,4) + "/" + strDate.substring(4,6) + "/" + strDate.substring(6,8);
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		try {
			Date date = dateFormat.parse(strDate);
			String resultStr = dateFormat.format(date);
			
//			equalsIgnoreCase => 문자열비교 함수, 대소문자 구분 없음
			if(!resultStr.equalsIgnoreCase(strDate)) {
				return false;
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
//		주민등록번호 마지막 자리를 이용한 check
//		value 값 한 글자씩 뽑아내기
		char[] charArray = value.toCharArray();
		long sum = 0;
		int[] arrDivide = new int[] { 2, 3, 4, 5, 6, 7, 8, 9, 2, 3, 4, 5 };
		for (int i = 0; i < charArray.length - 1; i++) {
			sum += Integer.parseInt(String.valueOf(charArray[i]))
					* arrDivide[i];
		}
		int checkdigit = (int) ((int) (11 - sum % 11)) % 10;
		
		return (checkdigit == Integer.parseInt(String.valueOf(charArray[12]))) ? true : false;
	}

}
