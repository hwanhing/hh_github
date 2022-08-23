package pay;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import SEAT.Seat1;
import login.LoginMember_DTO;
import pay.Cinema_DTO;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JTextPane;
import javax.swing.JButton;

public class PaymentPage1 extends JFrame {

	static LoginMember_DTO member = new LoginMember_DTO();
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	String sql;
	
	//DTO에서 가져와야할 변수들
	String movieAge;
	String movieName;
	String cinemaDate;
	String cinemaTime;
	String cinemaRoom;String seatPosition;
	int totalNum;
	String cinemaName;
	
	// 라벨 null값
	String dateTimeLabel = null;
	String cinemaLabel = null;
	String movieAgeLabel = null;
	String movieNameLabel = null;
	String nowDateTimeLabel = null;
	String cinemaNumLabel = null;
	String seatNumLabel = null;
	int numLabel = 0;
	int numAdultLabel = 0;
	int numChildLabel = 0;
	String totalPriceLabel = null;
	String adult = null;
	String child = null;
	
	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PaymentPage1 frame = new PaymentPage1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public PaymentPage1() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 700);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// 고정 된 값 --------------------------------------------------------------------------------------------
		JLabel logoLabel = new JLabel("");
		logoLabel.setIcon(new ImageIcon(PaymentPage1.class.getResource("/img/tmplogo.png")));
		logoLabel.setBounds(118, 11, 222, 101);
		contentPane.add(logoLabel);
		
		JLabel title = new JLabel("영화 입장권");
		title.setFont(new Font("굴림", Font.BOLD, 30));
		title.setBounds(122, 116, 179, 48);
		contentPane.add(title);
		
		JLabel people = new JLabel("총인원");
		people.setFont(new Font("굴림", Font.BOLD, 18));
		people.setBounds(19, 406, 58, 31);
		contentPane.add(people);
		
		JTextPane textPane = new JTextPane();
		textPane.setText("======================================================================\r\n");
		textPane.setBounds(14, 196, 393, 19);
		contentPane.add(textPane);
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setText("======================================================================\r\n");
		textPane_1.setBounds(14, 376, 393, 19);
		contentPane.add(textPane_1);
		
		JLabel total = new JLabel("총금액");
		total.setFont(new Font("굴림", Font.BOLD, 18));
		total.setBounds(19, 505, 58, 31);
		contentPane.add(total);
		
		JButton paybutton = new JButton("결제하기");
		paybutton.setForeground(Color.WHITE);
		paybutton.setBackground(Color.RED);
		paybutton.setFont(new Font("굴림", Font.BOLD, 18));
		paybutton.setBounds(142, 590, 130, 49);
		contentPane.add(paybutton);
		paybutton.setBorder(null); 
		
		// --------------------------------------------------------------------------------------------------
		
		// 현재 시간 라벨
		JLabel dateTimeLabel = new JLabel("2022.08.24  15:00~17:00");
		dateTimeLabel.setForeground(Color.WHITE);
		dateTimeLabel.setFont(new Font("굴림", Font.BOLD, 17));
		dateTimeLabel.setBounds(25, 293, 247, 32);
		contentPane.add(dateTimeLabel);
		
		// 영화관 이름 라벨
		JLabel cinemaLabel = new JLabel("CGV강남");
		cinemaLabel.setFont(new Font("굴림", Font.BOLD, 15));
		cinemaLabel.setBounds(329, 177, 116, 26);
		contentPane.add(cinemaLabel);
		
		// 영화 관람 연령 라벨
		JLabel movieAgeLabel = new JLabel("전체관람가");
		movieAgeLabel.setFont(new Font("굴림", Font.BOLD, 15));
		movieAgeLabel.setBounds(19, 216, 130, 26);
		contentPane.add(movieAgeLabel);
		
		// 영화 제목 라벨
		JLabel movieNameLabel = new JLabel("탑건 : 매버릭");
		movieNameLabel.setFont(new Font("HY견고딕", Font.PLAIN, 27));
		movieNameLabel.setBounds(19, 240, 279, 49);
		contentPane.add(movieNameLabel);
		
		// 영화 시간 라벨
		JLabel nowDateTimeLabel = new JLabel("2022-08-23 10:24");
		nowDateTimeLabel.setFont(new Font("굴림", Font.BOLD, 15));
		nowDateTimeLabel.setBounds(21, 177, 179, 26);
		contentPane.add(nowDateTimeLabel);
		
		// 영화관 관 번호 라벨
		JLabel cinemaNumLabel = new JLabel("2관");
		cinemaNumLabel.setFont(new Font("굴림", Font.BOLD, 17));
		cinemaNumLabel.setBounds(22, 340, 34, 26);
		contentPane.add(cinemaNumLabel);
		
		// 영화관 좌석 라벨
		JLabel seatNumLabel = new JLabel("A1, A2, A3");
		seatNumLabel.setFont(new Font("굴림", Font.BOLD, 17));
		seatNumLabel.setBounds(67, 340, 185, 26);
		contentPane.add(seatNumLabel);
		
		// 예매 인원 라벨
		JLabel numLabel = new JLabel("3명");
		numLabel.setFont(new Font("굴림", Font.BOLD, 18));
		numLabel.setBounds(82, 406, 50, 31);
		contentPane.add(numLabel);
		
		// 예매 인원 세부정보 라벨
		// 일반 인원 정보
		JLabel numAdultLabel = new JLabel("(일반 2명,");
		numAdultLabel.setFont(new Font("굴림", Font.BOLD, 17));
		numAdultLabel.setBounds(118, 407, 92, 26);
		contentPane.add(numAdultLabel);
		
		//청소년 인원 정보
		JLabel numChildLabel = new JLabel("청소년 1명)");
		numChildLabel.setFont(new Font("굴림", Font.BOLD, 17));
		numChildLabel.setBounds(202, 407, 92, 26);
		contentPane.add(numChildLabel);
		
		// 영화 티켓 가격 라벨
		JLabel totalPriceLabel = new JLabel("24,000원");
		totalPriceLabel.setFont(new Font("굴림", Font.BOLD, 18));
		totalPriceLabel.setBounds(82, 505, 118, 31);
		contentPane.add(totalPriceLabel);
		
		JLabel adult = new JLabel("일반 20,000원");
		adult.setFont(new Font("굴림", Font.BOLD, 17));
		adult.setBounds(19, 439, 222, 26);
		contentPane.add(adult);
		
		JLabel child = new JLabel("청소년 8,000원");
		child.setFont(new Font("굴림", Font.BOLD, 17));
		child.setBounds(19, 469, 222, 26);
		contentPane.add(child);
		
		
		// 고정 된 값 -----------------------------------------------------------------------------
		JLabel backgroundLabel = new JLabel("블랙배경");
		backgroundLabel.setIcon(new ImageIcon(PaymentPage1.class.getResource("/img/black.png")));
		backgroundLabel.setForeground(Color.WHITE);
		backgroundLabel.setFont(new Font("굴림", Font.BOLD, 15));
		backgroundLabel.setBounds(20, 293, 277, 33);
		contentPane.add(backgroundLabel);
		
		//상단	뒤로가기
		JButton backbutton = new JButton("");
		backbutton.setIcon(new ImageIcon(PaymentPage1.class.getResource("/img/back3.png")));
		backbutton.setContentAreaFilled(false);
		backbutton.setBorder(null);
		backbutton.setBounds(7, 11, 49, 49);
		contentPane.add(backbutton);
		
		//---------------------------------------------------------------------------------------
		member.setCardNum("11111");
		
		setTitle("결제 페이지");
		//테스트작업임..
		Cinema_DTO dto = new Cinema_DTO();
		
		String name = dto.getMovieName();
		String movieTime = dto.getCinematime();
		String movieDate = dto.getCinemaDate();
		String movieAge = dto.getMovieAge();
		String cinemaNum = dto.getCinemaRoom();
		String cinemaName = dto.getCinemaName();
		String seatNum = dto.getSeatPosition();
		String totalPrice = dto.getTotalPrice();
		String adultPrice = dto.getAdultPrice();
		String childPrice = dto.getChildPrice();
		int totalnum = dto.getTotalNum();
		int adultNum = dto.getAdultNum();
		int childNum = dto.getChildNum();
		
		movieNameLabel.setText(name);
		movieNameLabel.setFont(new Font("HY견고딕", Font.PLAIN, 27));
		
		movieAgeLabel.setText(movieAge);
		cinemaLabel.setText(cinemaName);
		cinemaNumLabel.setText(cinemaNum);
		seatNumLabel.setText(seatNum);
		totalPriceLabel.setText(totalPrice);
		
		
		
//		String dateTimeLabel = null;
//		String cinemaLabel = null;
//		String movieAgeLabel = null;
//		String movieNameLabel = null;
//		String nowDateTimeLabel = null;
//		String cinemaNumLabel = null;
//		String seatNumLabel = null;
//		int numLabel = 0;
//		int numAdultLabel = 0;
//		int numChildLabel = 0;
//		String totalPriceLabel = null;
//		String adult = null;
//		String child = null;

		
		
		
		backbutton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Seat1.main(null);
				setVisible(false);
			}
		});
	
		paybutton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				PaymentCheckPage checkPage = new PaymentCheckPage();
			}
		});
	}
}
