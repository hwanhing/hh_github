package pay;


/*
 *  결제하기 페이지
 *  결제하기 버튼을 누른 후 
 *  영화 제목, 영화관 이름, 영화관 번호, 몇세 관람가, 영화 날짜, 영화 시간, 선택한 좌석, 예매인원 총인원(일반 몇명, 청소년 몇명), 예매가격, 예매번호(?)
 */

public class Cinema_DTO {
	
	public static String movieName;			// 영화 제목
	public static String cinemaName;		// 영화관 이름
	public static String cinemaRoom;		// 영화관 관 번호
	public static String movieAge;			// 영화 연령
	public static String cinemaDate;		// 영화 날짜
	public static String cinematime;		// 영화 시간
	public static String seatPosition; 		// 선택한 좌석
	public static int totalNum;				// 예매 총인원
	public static int adultNum;				// 일반 인원
	public static int childNum;				// 청소년 인원
	public static String adultPrice;
	
	
	public static String getAdultPrice() {
		return adultPrice;
	}
	public static void setAdultPrice(String adultPrice) {
		Cinema_DTO.adultPrice = adultPrice;
	}
	public static String getChildPrice() {
		return childPrice;
	}
	public static void setChildPrice(String childPrice) {
		Cinema_DTO.childPrice = childPrice;
	}
	public static String childPrice;
	
	
	public static int getAdultNum() {
		return adultNum;
	}
	public static void setAdultNum(int adultNum) {
		Cinema_DTO.adultNum = adultNum;
	}
	public static int getChildNum() {
		return childNum;
	}
	public static void setChildNum(int childNum) {
		Cinema_DTO.childNum = childNum;
	}
	public static String totalPrice;		// 예매가격	
	
	
	public static String getMovieName() {
		return movieName;
	}
	public static void setMovieName(String movieName) {
		Cinema_DTO.movieName = movieName;
	}
	public static String getCinemaName() {
		return cinemaName;
	}
	public static void setCinemaName(String cinemaName) {
		Cinema_DTO.cinemaName = cinemaName;
	}
	public static String getCinemaRoom() {
		return cinemaRoom;
	}
	public static void setCinemaRoom(String cinemaRoom) {
		Cinema_DTO.cinemaRoom = cinemaRoom;
	}
	public static String getMovieAge() {
		return movieAge;
	}
	public static void setMovieAge(String movieAge) {
		Cinema_DTO.movieAge = movieAge;
	}
	public static String getCinemaDate() {
		return cinemaDate;
	}
	public static void setCinemaDate(String cinemaDate) {
		Cinema_DTO.cinemaDate = cinemaDate;
	}
	public static String getCinematime() {
		return cinematime;
	}
	public static void setCinematime(String cinematime) {
		Cinema_DTO.cinematime = cinematime;
	}
	public static String getSeatPosition() {
		return seatPosition;
	}
	public static void setSeatPosition(String seatPosition) {
		Cinema_DTO.seatPosition = seatPosition;
	}
	public static int getTotalNum() {
		return totalNum;
	}
	public static void setTotalNum(int totalNum) {
		Cinema_DTO.totalNum = totalNum;
	}
	public static String getTotalPrice() {
		return totalPrice;
	}
	public static void setTotalPrice(String totalPrice) {
		Cinema_DTO.totalPrice = totalPrice;
	}

	
}