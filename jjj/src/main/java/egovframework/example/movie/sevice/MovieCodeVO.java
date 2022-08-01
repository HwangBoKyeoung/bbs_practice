package egovframework.example.movie.sevice;

//	영화 파일 저장 테이블 관련 VO (영화 1건 - 파일 n건)
public class MovieCodeVO {

	private int movieCdNo;
	private int movieNo;
	private String movieCdDetail;
	private String movieCdRename;

	public int getMovieCdNo() {
		return movieCdNo;
	}

	public void setMovieCdNo(int movieCdNo) {
		this.movieCdNo = movieCdNo;
	}

	public int getMovieNo() {
		return movieNo;
	}

	public void setMovieNo(int movieNo) {
		this.movieNo = movieNo;
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
		return "MovieCodeVO [movieCdNo=" + movieCdNo + ", movieNo=" + movieNo + ", movieCdDetail=" + movieCdDetail
				+ ", movieCdRename=" + movieCdRename + "]";
	}

}
