package SEAT;

// 결제페이지에서 사용할 선택한 좌석이름, 총가격을 저장공간

//좌석페이지에서 결제버튼을 누르면 선택한 좌석이름(A1, A2...), 총가격의 값이 이곳에 저장됨.

public class Seat_infoDTO {

	static private String seatPosition_info; // 좌석이름
	static private int totalPrice_info;      // 총가격
	
	public static String getSeatPosition_info() {
		return seatPosition_info;
	}
	public static void setSeatPosition_info(String seatPosition_info) {
		Seat_infoDTO.seatPosition_info = seatPosition_info;
	}
	public static int getTotalPrice_info() {
		return totalPrice_info;
	}
	public static void setTotalPrice_info(int totalPrice_info) {
		Seat_infoDTO.totalPrice_info = totalPrice_info;
	}

	
}