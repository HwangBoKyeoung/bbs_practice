package egovframework.example.cost.sevice;

import java.sql.Date;

public class CostReplyVO {

	private String replyWriter;
	private int replyNo;
	private Date replyDate;
	private String replyContent;
	private int costNo;

	public String getReplyWriter() {
		return replyWriter;
	}

	public void setReplyWriter(String replyWriter) {
		this.replyWriter = replyWriter;
	}

	public int getReplyNo() {
		return replyNo;
	}

	public void setReplyNo(int replyNo) {
		this.replyNo = replyNo;
	}

	public Date getReplyDate() {
		return replyDate;
	}

	public void setReplyDate(Date replyDate) {
		this.replyDate = replyDate;
	}

	public String getReplyContent() {
		return replyContent;
	}

	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}

	public int getCostNo() {
		return costNo;
	}

	public void setCostNo(int costNo) {
		this.costNo = costNo;
	}

	@Override
	public String toString() {
		return "CostReplyVO [replyWriter=" + replyWriter + ", replyNo=" + replyNo + ", replyDate=" + replyDate
				+ ", replyContent=" + replyContent + ", costNo=" + costNo + "]";
	}

}
