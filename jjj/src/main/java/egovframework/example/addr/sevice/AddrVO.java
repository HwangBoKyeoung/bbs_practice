package egovframework.example.addr.sevice;

public class AddrVO {

	private int addrNo;
	private String userId;
	private int postNo;
	private String newAddr;
	private String oldAddr;
	private String engAddr;

	public int getAddrNo() {
		return addrNo;
	}

	public void setAddrNo(int addrNo) {
		this.addrNo = addrNo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getPostNo() {
		return postNo;
	}

	public void setPostNo(int postNo) {
		this.postNo = postNo;
	}

	public String getNewAddr() {
		return newAddr;
	}

	public void setNewAddr(String newAddr) {
		this.newAddr = newAddr;
	}

	public String getOldAddr() {
		return oldAddr;
	}

	public void setOldAddr(String oldAddr) {
		this.oldAddr = oldAddr;
	}

	public String getEngAddr() {
		return engAddr;
	}

	public void setEngAddr(String engAddr) {
		this.engAddr = engAddr;
	}

	@Override
	public String toString() {
		return "AddrVO [addrNo=" + addrNo + ", userId=" + userId + ", postNo=" + postNo + ", newAddr=" + newAddr
				+ ", oldAddr=" + oldAddr + ", engAddr=" + engAddr + "]";
	}

}
