package egovframework.example.free.sevice;

public class FreeBulletinReplyVO {

	private String replyWriter;
	private int replyNo;
	private String replyDate;
	private String replyContent;
	private int freeNo;

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

	public String getReplyDate() {
		return replyDate;
	}

	public void setReplyDate(String replyDate) {
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
		return "FreeBulletinReplyVO [replyWriter=" + replyWriter + ", replyNo=" + replyNo + ", replyDate=" + replyDate
				+ ", replyContent=" + replyContent + ", freeNo=" + freeNo + "]";
	}

}
