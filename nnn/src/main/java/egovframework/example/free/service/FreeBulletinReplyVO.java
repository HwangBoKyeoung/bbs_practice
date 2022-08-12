package egovframework.example.free.service;



import java.sql.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class FreeBulletinReplyVO {

	private int freeNo;
	private int replyNo;
	private int replyParentNo;
	private String replyContent;
	private String replyWriter;
	private String replyDeleteAt;
	@DateTimeFormat(pattern="yy-MM-dd")
	@JsonFormat(pattern="yy-MM-dd")
	private Date replyDate;
	@DateTimeFormat(pattern="yy-MM-dd")
	@JsonFormat(pattern="yy-MM-dd")
	private Date replyUpdateDate;
	@DateTimeFormat(pattern="yy-MM-dd")
	@JsonFormat(pattern="yy-MM-dd")
	private Date replyDeleteDate;
	
	
//	레벨
	private int commentLevel;

	public int getFreeNo() {
		return freeNo;
	}

	public void setFreeNo(int freeNo) {
		this.freeNo = freeNo;
	}

	public int getReplyNo() {
		return replyNo;
	}

	public void setReplyNo(int replyNo) {
		this.replyNo = replyNo;
	}

	public int getReplyParentNo() {
		return replyParentNo;
	}

	public void setReplyParentNo(int replyParentNo) {
		this.replyParentNo = replyParentNo;
	}

	public String getReplyContent() {
		return replyContent;
	}

	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}

	public String getReplyWriter() {
		return replyWriter;
	}

	public void setReplyWriter(String replyWriter) {
		this.replyWriter = replyWriter;
	}

	public String getReplyDeleteAt() {
		return replyDeleteAt;
	}

	public void setReplyDeleteAt(String replyDeleteAt) {
		this.replyDeleteAt = replyDeleteAt;
	}

	public Date getReplyDate() {
		return replyDate;
	}

	public void setReplyDate(Date replyDate) {
		this.replyDate = replyDate;
	}

	public Date getReplyUpdateDate() {
		return replyUpdateDate;
	}

	public void setReplyUpdateDate(Date replyUpdateDate) {
		this.replyUpdateDate = replyUpdateDate;
	}

	public Date getReplyDeleteDate() {
		return replyDeleteDate;
	}

	public void setReplyDeleteDate(Date replyDeleteDate) {
		this.replyDeleteDate = replyDeleteDate;
	}

	public int getCommentLevel() {
		return commentLevel;
	}

	public void setCommentLevel(int commentLevel) {
		this.commentLevel = commentLevel;
	}

	@Override
	public String toString() {
		return "FreeBulletinReplyVO [freeNo=" + freeNo + ", replyNo=" + replyNo + ", replyParentNo=" + replyParentNo
				+ ", replyContent=" + replyContent + ", replyWriter=" + replyWriter + ", replyDeleteAt=" + replyDeleteAt
				+ ", replyDate=" + replyDate + ", replyUpdateDate=" + replyUpdateDate + ", replyDeleteDate="
				+ replyDeleteDate + ", commentLevel=" + commentLevel + "]";
	}

}
