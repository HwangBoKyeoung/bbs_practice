package egovframework.example.movie.sevice;

public class MovieVO {

	private int movieNo;
	private String movieName;
	private String movieConent;
	private int movieHit;
	private String movieDirector;
	private String movieActor;
	private int moviePrice;
//	private String movieCd;
	private String userId;
	
	// join할 객체
	private MovieCodeVO movieCodeVO;

	public int getMovieNo() {
		return movieNo;
	}

	public void setMovieNo(int movieNo) {
		this.movieNo = movieNo;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getMovieConent() {
		return movieConent;
	}

	public void setMovieConent(String movieConent) {
		this.movieConent = movieConent;
	}

	public int getMovieHit() {
		return movieHit;
	}

	public void setMovieHit(int movieHit) {
		this.movieHit = movieHit;
	}

	public String getMovieDirector() {
		return movieDirector;
	}

	public void setMovieDirector(String movieDirector) {
		this.movieDirector = movieDirector;
	}

	public String getMovieActor() {
		return movieActor;
	}

	public void setMovieActor(String movieActor) {
		this.movieActor = movieActor;
	}

	public int getMoviePrice() {
		return moviePrice;
	}

	public void setMoviePrice(int moviePrice) {
		this.moviePrice = moviePrice;
	}

	/*public String getMovieCd() {
		return movieCd;
	}

	public void setMovieCd(String movieCd) {
		this.movieCd = movieCd;
	}*/

	public MovieCodeVO getMovieCodeVO() {
		return movieCodeVO;
	}

	public void setMovieCodeVO(MovieCodeVO movieCodeVO) {
		this.movieCodeVO = movieCodeVO;
	}

	@Override
	public String toString() {
		return "MovieVO [movieNo=" + movieNo + ", movieName=" + movieName + ", movieConent=" + movieConent
				+ ", movieHit=" + movieHit + ", movieDirector=" + movieDirector + ", movieActor=" + movieActor
				+ ", moviePrice=" + moviePrice + ", movieCodeVO=" + movieCodeVO + "]";
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

}
