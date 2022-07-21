package egovframework.example.cost.sevice;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import egovframework.example.common.SysCodeDtlVO;

public class CostVO {

	private int costNo;
	@JsonFormat(pattern = "yyyy-MM-dd")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date costDate;
	private String costMethod;
	private String costCategory;
	private String costDetail;
	private String costBuyer;
	private int costSum;
	private String fileName;
	private String fileRename;
	
	private Date start;
	private Date end;
	private String title;
	
	private SysCodeDtlVO sysCodeDtlVO;
	

	public int getCostNo() {
		return costNo;
	}

	public void setCostNo(int costNo) {
		this.costNo = costNo;
	}

	public Date getCostDate() {
		return costDate;
	}

	public void setCostDate(Date costDate) {
		this.costDate = costDate;
	}

	public String getCostMethod() {
		return costMethod;
	}

	public void setCostMethod(String costMethod) {
		this.costMethod = costMethod;
	}

	public String getCostCategory() {
		return costCategory;
	}

	public void setCostCategory(String costCategory) {
		this.costCategory = costCategory;
	}

	public String getCostDetail() {
		return costDetail;
	}

	public void setCostDetail(String costDetail) {
		this.costDetail = costDetail;
	}

	public String getCostBuyer() {
		return costBuyer;
	}

	public void setCostBuyer(String costBuyer) {
		this.costBuyer = costBuyer;
	}

	public int getCostSum() {
		return costSum;
	}

	public void setCostSum(int costSum) {
		this.costSum = costSum;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileRename() {
		return fileRename;
	}

	public void setFileRename(String fileRename) {
		this.fileRename = fileRename;
	}

	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	public Date getEnd() {
		return end;
	}

	public void setEnd(Date end) {
		this.end = end;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public SysCodeDtlVO getSysCodeDtlVO() {
		return sysCodeDtlVO;
	}

	public void setSysCodeDtlVO(SysCodeDtlVO sysCodeDtlVO) {
		this.sysCodeDtlVO = sysCodeDtlVO;
	}

	@Override
	public String toString() {
		return "CostVO [costNo=" + costNo + ", costDate=" + costDate + ", costMethod=" + costMethod + ", costCategory="
				+ costCategory + ", costDetail=" + costDetail + ", costBuyer=" + costBuyer + ", costSum=" + costSum
				+ ", fileName=" + fileName + ", fileRename=" + fileRename + ", start=" + start + ", end=" + end
				+ ", title=" + title + ", sysCodeDtlVO=" + sysCodeDtlVO + "]";
	}

}
