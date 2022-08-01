package egovframework.example.common;

//	공통코드 관련 VO 작성 (CostVO와 연결)
public class SysCodeDtlVO {
	
	private String codeMst;
	private String codeDtl;
	private String codeDtlNm;
	private int dtlOrd;

	public String getCodeMst() {
		return codeMst;
	}

	public void setCodeMst(String codeMst) {
		this.codeMst = codeMst;
	}

	public String getCodeDtl() {
		return codeDtl;
	}

	public void setCodeDtl(String codeDtl) {
		this.codeDtl = codeDtl;
	}

	public String getCodeDtlNm() {
		return codeDtlNm;
	}

	public void setCodeDtlNm(String codeDtlNm) {
		this.codeDtlNm = codeDtlNm;
	}

	public int getDtlOrd() {
		return dtlOrd;
	}

	public void setDtlOrd(int dtlOrd) {
		this.dtlOrd = dtlOrd;
	}

	@Override
	public String toString() {
		return "SysCodeDtlVO [codeMst=" + codeMst + ", codeDtl=" + codeDtl + ", codeDtlNm=" + codeDtlNm + ", dtlOrd="
				+ dtlOrd + "]";
	}
	
}
