package egovframework.example.movie.sevice;

public class MovieCodeVO {

	private int movieCdNo;
	private String movieCd;
	private String movieCdDetail;
	private String movieCdRename;

	public int getMovieCdNo() {
		return movieCdNo;
	}

	public void setMovieCdNo(int movieCdNo) {
		this.movieCdNo = movieCdNo;
	}

	public String getMovieCd() {
		return movieCd;
	}

	public void setMovieCd(String movieCd) {
		this.movieCd = movieCd;
	}

	public String getMovieCdDetail() {
		return movieCdDetail;
	}

	public void setMovieCdDetail(String movieCdDetail) {
		this.movieCdDetail = movieCdDetail;
	}

	public String getMovieCdRename() {
		return movieCdRename;
	}

	public void setMovieCdRename(String movieCdRename) {
		this.movieCdRename = movieCdRename;
	}

	@Override
	public String toString() {
		return "MovieCodeVO [movieCdNo=" + movieCdNo + ", movieCd=" + movieCd + ", movieCdDetail=" + movieCdDetail
				+ ", movieCdRename=" + movieCdRename + "]";
	}

}
