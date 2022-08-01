package egovframework.example.movie.sevice;

public class MovieReplyVO {

	private int movieReplyNo;
	private String movieReplyConent;
	private String movieReplyWriter;
	private int movieReplyStar;
	private int movieNo;
	
//	영화 점수 평균 낸 값을 저장할 필드
	private float replyAvg;

	public int getMovieReplyNo() {
		return movieReplyNo;
	}

	public void setMovieReplyNo(int movieReplyNo) {
		this.movieReplyNo = movieReplyNo;
	}

	public String getMovieReplyConent() {
		return movieReplyConent;
	}

	public void setMovieReplyConent(String movieReplyConent) {
		this.movieReplyConent = movieReplyConent;
	}

	public String getMovieReplyWriter() {
		return movieReplyWriter;
	}

	public void setMovieReplyWriter(String movieReplyWriter) {
		this.movieReplyWriter = movieReplyWriter;
	}

	public int getMovieReplyStar() {
		return movieReplyStar;
	}

	public void setMovieReplyStar(int movieReplyStar) {
		this.movieReplyStar = movieReplyStar;
	}

	public int getMovieNo() {
		return movieNo;
	}

	public void setMovieNo(int movieNo) {
		this.movieNo = movieNo;
	}

	public float getReplyAvg() {
		return replyAvg;
	}

	public void setReplyAvg(float replyAvg) {
		this.replyAvg = replyAvg;
	}

	@Override
	public String toString() {
		return "MovieReplyVO [movieReplyNo=" + movieReplyNo + ", movieReplyConent=" + movieReplyConent
				+ ", movieReplyWriter=" + movieReplyWriter + ", movieReplyStar=" + movieReplyStar + ", movieNo="
				+ movieNo + ", replyAvg=" + replyAvg + "]";
	}

}
