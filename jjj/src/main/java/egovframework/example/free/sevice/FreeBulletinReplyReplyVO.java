package egovframework.example.free.sevice;

public class FreeBulletinReplyReplyVO {

	private String replyWriter;
	private int replyReNo;
	private String replyDate;
	private String replyContent;
	private int replyNo;

	public String getReplyWriter() {
		return replyWriter;
	}

	public void setReplyWriter(String replyWriter) {
		this.replyWriter = replyWriter;
	}

	public int getReplyReNo() {
		return replyReNo;
	}

	public void setReplyReNo(int replyReNo) {
		this.replyReNo = replyReNo;
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

	public int getReplyNo() {
		return replyNo;
	}

	public void setReplyNo(int replyNo) {
		this.replyNo = replyNo;
	}

	@Override
	public String toString() {
		return "FreeBulletinReplyReplyVO [replyWriter=" + replyWriter + ", replyReNo=" + replyReNo + ", replyDate="
				+ replyDate + ", replyContent=" + replyContent + ", replyNo=" + replyNo + "]";
	}

}
