package egovframework.example.free.sevice;

import java.sql.Date;

public class FreeBulletinReplyVO {

	private int replyReplyNo;
	private String replyUpdateWriter;
	private Date replyUpdateDate;
	private int replyNo;
	private Date replyDate;
	private String replyContent;
	private int freeNo;

	public int getReplyReplyNo() {
		return replyReplyNo;
	}

	public void setReplyReplyNo(int replyReplyNo) {
		this.replyReplyNo = replyReplyNo;
	}

	public String getReplyUpdateWriter() {
		return replyUpdateWriter;
	}

	public void setReplyUpdateWriter(String replyUpdateWriter) {
		this.replyUpdateWriter = replyUpdateWriter;
	}

	public Date getReplyUpdateDate() {
		return replyUpdateDate;
	}

	public void setReplyUpdateDate(Date replyUpdateDate) {
		this.replyUpdateDate = replyUpdateDate;
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

	public int getFreeNo() {
		return freeNo;
	}

	public void setFreeNo(int freeNo) {
		this.freeNo = freeNo;
	}

	@Override
	public String toString() {
		return "FreeBulletinReplyVO [replyReplyNo=" + replyReplyNo + ", replyUpdateWriter=" + replyUpdateWriter
				+ ", replyUpdateDate=" + replyUpdateDate + ", replyNo=" + replyNo + ", replyDate=" + replyDate
				+ ", replyContent=" + replyContent + ", freeNo=" + freeNo + "]";
	}

}
