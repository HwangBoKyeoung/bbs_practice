package egovframework.example.free.sevice;

public class FreeBulletinVO {

	private int freeNo;
	private String freeTitle;
	private String freeContent;
	private String freeWriter;
	private String freeDate;
	private int freeHit;
	private int freeRegYn;
	private int freeNoticeYn;

	public int getFreeNo() {
		return freeNo;
	}

	public void setFreeNo(int freeNo) {
		this.freeNo = freeNo;
	}

	public String getFreeTitle() {
		return freeTitle;
	}

	public void setFreeTitle(String freeTitle) {
		this.freeTitle = freeTitle;
	}

	public String getFreeContent() {
		return freeContent;
	}

	public void setFreeContent(String freeContent) {
		this.freeContent = freeContent;
	}

	public String getFreeWriter() {
		return freeWriter;
	}

	public void setFreeWriter(String freeWriter) {
		this.freeWriter = freeWriter;
	}

	public String getFreeDate() {
		return freeDate;
	}

	public void setFreeDate(String freeDate) {
		this.freeDate = freeDate;
	}

	public int getFreeHit() {
		return freeHit;
	}

	public void setFreeHit(int freeHit) {
		this.freeHit = freeHit;
	}

	public int getFreeRegYn() {
		return freeRegYn;
	}

	public void setFreeRegYn(int freeRegYn) {
		this.freeRegYn = freeRegYn;
	}

	public int getFreeNoticeYn() {
		return freeNoticeYn;
	}

	public void setFreeNoticeYn(int freeNoticeYn) {
		this.freeNoticeYn = freeNoticeYn;
	}

	@Override
	public String toString() {
		return "FreeBulletinVO [freeNo=" + freeNo + ", freeTitle=" + freeTitle + ", freeContent=" + freeContent
				+ ", freeWriter=" + freeWriter + ", freeDate=" + freeDate + ", freeHit=" + freeHit + ", freeRegYn="
				+ freeRegYn + ", freeNoticeYn=" + freeNoticeYn + "]";
	}

}
