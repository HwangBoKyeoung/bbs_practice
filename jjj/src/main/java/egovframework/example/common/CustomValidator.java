package egovframework.example.common;

import org.apache.commons.validator.Field;
import org.apache.commons.validator.ValidatorAction;
import org.springframework.validation.Errors;
import org.springmodules.validation.commons.FieldChecks;

import egovframework.example.common.RteGenericValidator;

public class CustomValidator extends FieldChecks {

	private static final long serialVersionUID = 1L;
	
	public static boolean validateIhIdNum(Object bean, ValidatorAction va, Field field, Errors errors) {
//		bean에서 해당 field값 추출
		String ihidnum = FieldChecks.extractValue(bean, field);
		
//		주민등록번호 유효성 검사 알고리즘은 RteGenericValidator가 가지고 있음
		if(!RteGenericValidator.isValidIdIhNum(ihidnum)) {  //유효하지 않다면
			FieldChecks.rejectValue(errors, field, va);  //에러처리
			return false;
		} else {
			return true;
		}
	}
	
	
}
