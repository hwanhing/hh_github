package SEAT;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

// import book.asd;
import login.ProjectFrame;
import pay.Cinema_DTO;
import main.Mainpage;
import pay.PaymentPage;

import java.awt.*;
import java.sql.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Seat1 extends JFrame {
	Connection con = null;          // DB와 연동하는 객체
	PreparedStatement pstmt = null; // SQL문을 DB에 전송하는 객체
	ResultSet rs = null;            // SQL문 실행 결과를 가지고 있는 객체
	String sql = null;              // SQL문을 저장하는 객체
	DefaultTableModel model;
	Seat_infoDTO seatdto;
	protected Cinema_DTO cinemadto;
	ProjectFrame pf = new ProjectFrame();
	JButton btn_back = new JButton(new ImageIcon("src/img/back3.png")); 
	ImageIcon icon_logo_small = new ImageIcon("src/img/tmplogo_small.png");
	public JLabel logo = new JLabel("");
	
	// 버튼 크기
	int buttonSize = 42; // 버튼 사이즈
	int btnfontBig = 7; // 두자리 버튼 폰트 크기 (10, 11, ...)
	int btnfont = 9; // 한자리 버튼 폰트 크기 (1, 2, ...)
	int btnspace = 2; // 버튼 사이 공백
	static int lineSpace = 48; // 열사이 공백
	static int aLine = 290; // a열 y축
	static int bLine = aLine+(48*1); // b열 y축
	static int cLine = aLine+(48*2); // c열 y축
	static int dLine = aLine+(48*3); // d열 y축
	static int eLine = aLine+(48*4); // e열 y축
	static int fLine = aLine+(48*5); // f열 y축
	static int gLine = aLine+(48*6); // g열 y축
	
	static String feA1,feA2,feA3,feA4,feA5,feA6,feA7,feA8,feA9,feA10,feA11,feA12,feA13,feA14,
	feB1,feB2,feB3,feB4,feB5,feB6,feB7,feB8,feB9,feB10,feB11,feB12,feB13,feB14,
	feC1,feC2,feC3,feC4,feC5,feC6,feC7,feC8,feC9,feC10,feC11,feC12,feC13,feC14,
	feD1,feD2,feD3,feD4,feD5,feD6,feD7,feD8,feD9,feD10,feD11,feD12,feD13,feD14,
	feE1,feE2,feE3,feE4,feE5,feE6,feE7,feE8,feE9,feE10,feE11,feE12,feE13,feE14,
	feF1,feF2,feF3,feF4,feF5,feF6,feF7,feF8,feF9,feF10,feF11,feF12,feF13,feF14,
	feG1,feG2,feG3,feG4,feG5,feG6,feG7,feG8,feG9,feG10,feG11,feG12,feG13,feG14 = "";
	
	static String sfeA1 = "empty";static String sfeA2 = "empty";static String sfeA3 = "empty";static String sfeA4 = "empty";static String sfeA5 = "empty";static String sfeA6 = "empty";static String sfeA7 = "empty";static String sfeA8 = "empty";static String sfeA9 = "empty";static String sfeA10 = "empty";static String sfeA11 = "empty";static String sfeA12 = "empty";static String sfeA13 = "empty";static String sfeA14 = "empty";
	static String sfeB1 = "empty";static String sfeB2 = "empty";static String sfeB3 = "empty";static String sfeB4 = "empty";static String sfeB5 = "empty";static String sfeB6 = "empty";static String sfeB7 = "empty";static String sfeB8 = "empty";static String sfeB9 = "empty";static String sfeB10 = "empty";static String sfeB11 = "empty";static String sfeB12 = "empty";static String sfeB13 = "empty";static String sfeB14 = "empty";
	static String sfeC1 = "empty";static String sfeC2 = "empty";static String sfeC3 = "empty";static String sfeC4 = "empty";static String sfeC5 = "empty";static String sfeC6 = "empty";static String sfeC7 = "empty";static String sfeC8 = "empty";static String sfeC9 = "empty";static String sfeC10 = "empty";static String sfeC11 = "empty";static String sfeC12 = "empty";static String sfeC13 = "empty";static String sfeC14 = "empty";
	static String sfeD1 = "empty";static String sfeD2 = "empty";static String sfeD3 = "empty";static String sfeD4 = "empty";static String sfeD5 = "empty";static String sfeD6 = "empty";static String sfeD7 = "empty";static String sfeD8 = "empty";static String sfeD9 = "empty";static String sfeD10 = "empty";static String sfeD11 = "empty";static String sfeD12 = "empty";static String sfeD13 = "empty";static String sfeD14 = "empty";
	static String sfeE1 = "empty";static String sfeE2 = "empty";static String sfeE3 = "empty";static String sfeE4 = "empty";static String sfeE5 = "empty";static String sfeE6 = "empty";static String sfeE7 = "empty";static String sfeE8 = "empty";static String sfeE9 = "empty";static String sfeE10 = "empty";static String sfeE11 = "empty";static String sfeE12 = "empty";static String sfeE13 = "empty";static String sfeE14 = "empty";
	static String sfeF1 = "empty";static String sfeF2 = "empty";static String sfeF3 = "empty";static String sfeF4 = "empty";static String sfeF5 = "empty";static String sfeF6 = "empty";static String sfeF7 = "empty";static String sfeF8 = "empty";static String sfeF9 = "empty";static String sfeF10 = "empty";static String sfeF11 = "empty";static String sfeF12 = "empty";static String sfeF13 = "empty";static String sfeF14 = "empty";
	static String sfeG1 = "empty";static String sfeG2 = "empty";static String sfeG3 = "empty";static String sfeG4 = "empty";static String sfeG5 = "empty";static String sfeG6 = "empty";static String sfeG7 = "empty";static String sfeG8 = "empty";static String sfeG9 = "empty";static String sfeG10 = "empty";static String sfeG11 = "empty";static String sfeG12 = "empty";static String sfeG13 = "empty";
	static String sfeG14 = "empty";

	static String seatt = "";
	
	int seatLeftStartX = 48; // 라인 시작점
	int seatCenterStartX = 230; // 라인 시작점
	int seatRightStartX = 500; // 라인 시작점

	int btnpersonSize = 45; 
	
	// 버튼 클릭시 버튼 색상 바뀔 때 쓰는 변수
	// 인원 버튼 클릭시 
	static int adultCount = 0; // 일반 인원 수 (최대 8명)
	static int childCount = 0; // 청소년 인원 수 (최대 8명)
	static int count = adultCount + childCount; // 체크된 총 인원 수 (8명을 넘기면 안됨)
	static int SeatClick = 0; // 클릭한 시트 수 --> count 수를 초과하면 오류
	
	int cinemaNumber = 1;  // 데이터베이스에서 받은 cinemaNum 저장할 공간-------------------------
	
	// 가격 변수
	int adultPrice = 10000; // 일반 10000원 (만원)
	int childPrice = 8000; // 청소년 8000원 (8천원)
	static int totalPrice = 0; // 총 가격

	private JPanel contentPane;
	private JLabel adultLabel, childLabel, seatLabelP;
	private JLabel totalPiceLabel;
	private JLabel aLabel, bLabel, cLabel, dLabel, eLabel, fLabel, gLabel;

	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Seat1 frame = new Seat1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	} // main end
	
	public Seat1() {
		
		connect();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 900);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// 뒤로가기 버튼 
		pf.frameBackBtn();
		btn_back = pf.btn_back;
		btn_back.setBounds(22, 30, 70, 70);
		btn_back.setBorder(null);
		btn_back.setContentAreaFilled(false); 				// 버튼 투명하게
		contentPane.add(btn_back);
		
		// 뒤로가기 버튼 이벤트
		btn_back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn_back.setForeground(Color.blue);
				Mainpage mainpage = new Mainpage();
				mainpage.main(null);
				dispose(); // 기존에 있던 창을 없애주는 메서드
			}
		});
		
		// 결제하기 버튼
		JButton nextbrn = new JButton("결제하기");
		nextbrn.setBounds(462, 776, 165, 31);		// 버튼 위치, 사이즈 462, 776, 165, 31
		nextbrn.setForeground(Color.WHITE);
		nextbrn.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		nextbrn.setBackground(new Color(255, 69, 0));
		contentPane.add(nextbrn);
		
		// 결제하기 버튼 클릭시 이벤트 발생
		nextbrn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			// 정말로 결제하시겠습니까? 창 띄우기
				if(count != 0 && count == SeatClick) {
					int result = JOptionPane.showConfirmDialog(null, "결제 페이지로 넘어가시겠습니까?", "확인", JOptionPane.YES_NO_OPTION);
					if(result == JOptionPane.CLOSED_OPTION) {  // -1
						JOptionPane.showMessageDialog(null, "취소를 클릭하셨습니다.");
					} else if(result == JOptionPane.NO_OPTION) {  // 1
						JOptionPane.showMessageDialog(null, "취소 버튼을 클릭하셨습니다.");
					} else { // 결제 확인 버튼을 누른 경우
						connect();
						// 선택한 좌석이름, 총가격 데이터를 Seat_infoDTO 에 전달
						Seat_infoDTO.setTotalPrice_info(totalPrice);
						Seat_infoDTO.setSeatPosition_info(seatt);
						
						// 결제페이지로 넘어가는 코드들******************
						PaymentPage page = new PaymentPage();
						dispose(); // 기존에 있던 창을 없애주는 메서드
					}
				} else if(count != SeatClick) {
					JOptionPane.showMessageDialog(null, "인원 수 만큼 좌석을 선택해주세요.");
				} else if(count == 0) {
					JOptionPane.showMessageDialog(null, "인원 수 와 좌석을 선택해주세요.");
				}
			}
		});
		
		// CGV 로고
		pf.frameLogoSmall();
		logo = pf.logo;
		logo.setIcon(icon_logo_small);
		logo.setBounds(295, 3, 244, 115);
		contentPane.add(logo);
		
		// 라인 알파벳 위치
		aLabel = new JLabel("A"); linLabel(aLabel, 22, 298);  //48
		bLabel = new JLabel("B"); linLabel(bLabel, 22, 298+(48*1));
		cLabel = new JLabel("C"); linLabel(cLabel, 22, 298+(48*2));
		dLabel = new JLabel("D"); linLabel(dLabel, 22, 298+(48*3));
		eLabel = new JLabel("E"); linLabel(eLabel, 22, 298+(48*4));
		fLabel = new JLabel("F"); linLabel(fLabel, 22, 298+(48*5));
		gLabel = new JLabel("G"); linLabel(gLabel, 22, 298+(48*6));

		seatLabelP = new JLabel("");
		seatLabelP.setBackground(Color.BLACK);
		seatLabelP.setFont(new Font("돋움", Font.BOLD, 25));
		seatLabelP.setForeground(Color.WHITE);
		seatLabelP.setBounds(41, 705, 300, 113);
		contentPane.add(seatLabelP);
		
		
		contentPane.add(aLabel); contentPane.add(bLabel);
		contentPane.add(cLabel); contentPane.add(dLabel);
		contentPane.add(eLabel); contentPane.add(fLabel); contentPane.add(gLabel);
		// 오른쪽------------------------------------------------------------------------
		JButton btnA1 = new JButton("1"); seatbtnA(btnA1, seatLeftStartX, 0, aLine, btnfont);
		JButton btnA2 = new JButton("2"); seatbtnA(btnA2, seatLeftStartX, 1, aLine, btnfont);
		JButton btnA3 = new JButton("3"); seatbtnA(btnA3, seatLeftStartX, 2, aLine, btnfont);
		JButton btnA4 = new JButton("4"); seatbtnA(btnA4, seatLeftStartX, 3, aLine, btnfont);
		// 중단------------------------------------------------------------------------
		JButton btnA5 = new JButton("5"); seatbtnA(btnA5, seatCenterStartX, 0, aLine, btnfont);
		JButton btnA6 = new JButton("6"); seatbtnA(btnA6, seatCenterStartX, 1, aLine, btnfont);
		JButton btnA7 = new JButton("7"); seatbtnA(btnA7, seatCenterStartX, 2, aLine, btnfont);
		JButton btnA8 = new JButton("8"); seatbtnA(btnA8, seatCenterStartX, 3, aLine, btnfont);
		JButton btnA9 = new JButton("9"); seatbtnA(btnA9, seatCenterStartX, 4, aLine, btnfont);
		JButton btnA10 = new JButton("10"); seatbtnA(btnA10, seatCenterStartX, 5, aLine, btnfontBig);
		// 왼쪽------------------------------------------------------------------------
		JButton btnA11 = new JButton("11"); seatbtnA(btnA11, seatRightStartX , 0, aLine, btnfontBig);
		JButton btnA12 = new JButton("12"); seatbtnA(btnA12, seatRightStartX , 1, aLine, btnfontBig);
		JButton btnA13 = new JButton("13"); seatbtnA(btnA13, seatRightStartX , 2, aLine, btnfontBig);
		JButton btnA14 = new JButton("14"); seatbtnA(btnA14, seatRightStartX , 3, aLine, btnfontBig);
		// A열 좌석 클릭시 이벤트 발생 구간-------------------------------------------------------
		seatClickEvent(btnA1, "A1 ");seatClickEvent(btnA2, "A2 ");seatClickEvent(btnA3, "A3 ");
		seatClickEvent(btnA4, "A4 ");seatClickEvent(btnA5, "A5 ");seatClickEvent(btnA6, "A6 ");
		seatClickEvent(btnA7, "A7 ");seatClickEvent(btnA8, "A8 ");seatClickEvent(btnA9, "A9 ");
		seatClickEvent(btnA10, "A10 ");seatClickEvent(btnA11, "A11 ");seatClickEvent(btnA12, "A12 ");
		seatClickEvent(btnA13, "A13 ");seatClickEvent(btnA14, "A14 ");
		// ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
		// ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
		contentPane.add(btnA1);contentPane.add(btnA2);contentPane.add(btnA3);
		contentPane.add(btnA4);contentPane.add(btnA5);contentPane.add(btnA6);
		contentPane.add(btnA7);contentPane.add(btnA8);contentPane.add(btnA9);
		contentPane.add(btnA10);contentPane.add(btnA11);contentPane.add(btnA12);
		contentPane.add(btnA13);contentPane.add(btnA14);
		
		// B열-------------------------------------------------------------------------------------------------------------
		JButton btnB1 = new JButton("1"); seatbtnA(btnB1, seatLeftStartX, 0, bLine, btnfont);
		JButton btnB2 = new JButton("2"); seatbtnA(btnB2, seatLeftStartX, 1, bLine, btnfont);
		JButton btnB3 = new JButton("3"); seatbtnA(btnB3, seatLeftStartX, 2, bLine, btnfont);
		JButton btnB4 = new JButton("4"); seatbtnA(btnB4, seatLeftStartX, 3, bLine, btnfont);
		// 중단------------------------------------------------------------------------
		JButton btnB5 = new JButton("5"); seatbtnA(btnB5, seatCenterStartX, 0, bLine, btnfont);
		JButton btnB6 = new JButton("6"); seatbtnA(btnB6, seatCenterStartX, 1, bLine, btnfont);
		JButton btnB7 = new JButton("7"); seatbtnA(btnB7, seatCenterStartX, 2, bLine, btnfont);
		JButton btnB8 = new JButton("8"); seatbtnA(btnB8, seatCenterStartX, 3, bLine, btnfont);
		JButton btnB9 = new JButton("9"); seatbtnA(btnB9, seatCenterStartX, 4, bLine, btnfont);
		JButton btnB10 = new JButton("10"); seatbtnA(btnB10, seatCenterStartX, 5, bLine, btnfontBig);
		// 왼쪽------------------------------------------------------------------------
		JButton btnB11 = new JButton("11"); seatbtnA(btnB11, seatRightStartX , 0, bLine, btnfontBig);
		JButton btnB12 = new JButton("12"); seatbtnA(btnB12, seatRightStartX , 1, bLine, btnfontBig);
		JButton btnB13 = new JButton("13"); seatbtnA(btnB13, seatRightStartX , 2, bLine, btnfontBig);
		JButton btnB14 = new JButton("14"); seatbtnA(btnB14, seatRightStartX , 3, bLine, btnfontBig);
		// B열 좌석 클릭시 이벤트 발생 구간-------------------------------------------------------
		seatClickEvent(btnB1, "B1 ");seatClickEvent(btnB2, "B2 ");seatClickEvent(btnB3, "B13 ");
		seatClickEvent(btnB4, "B4 ");seatClickEvent(btnB5, "B5 ");seatClickEvent(btnB6, "B16 ");
		seatClickEvent(btnB7, "B7 ");seatClickEvent(btnB8, "B8 ");seatClickEvent(btnB9, "B19 ");
		seatClickEvent(btnB10, "B10 ");seatClickEvent(btnB11, "B11 ");seatClickEvent(btnB12, "B12 ");
		seatClickEvent(btnB13, "B13 ");seatClickEvent(btnB14, "B14 ");

		contentPane.add(btnB1);contentPane.add(btnB2);contentPane.add(btnB3);
		contentPane.add(btnB4);contentPane.add(btnB5);contentPane.add(btnB6);
		contentPane.add(btnB7);contentPane.add(btnB8);contentPane.add(btnB9);
		contentPane.add(btnB10);contentPane.add(btnB11);contentPane.add(btnB12);
		contentPane.add(btnB13);contentPane.add(btnB14);

		// C열-------------------------------------------------------------------------------------------------------------
		JButton btnC1 = new JButton("1"); seatbtnA(btnC1, seatLeftStartX, 0, cLine, btnfont);
		JButton btnC2 = new JButton("2"); seatbtnA(btnC2, seatLeftStartX, 1, cLine, btnfont);
		JButton btnC3 = new JButton("3"); seatbtnA(btnC3, seatLeftStartX, 2, cLine, btnfont);
		JButton btnC4 = new JButton("4"); seatbtnA(btnC4, seatLeftStartX, 3, cLine, btnfont);
		// 중단------------------------------------------------------------------------
		JButton btnC5 = new JButton("5"); seatbtnA(btnC5, seatCenterStartX, 0, cLine, btnfont);
		JButton btnC6 = new JButton("6"); seatbtnA(btnC6, seatCenterStartX, 1, cLine, btnfont);
		JButton btnC7 = new JButton("7"); seatbtnA(btnC7, seatCenterStartX, 2, cLine, btnfont);
		JButton btnC8 = new JButton("8"); seatbtnA(btnC8, seatCenterStartX, 3, cLine, btnfont);
		JButton btnC9 = new JButton("9"); seatbtnA(btnC9, seatCenterStartX, 4, cLine, btnfont);
		JButton btnC10 = new JButton("10"); seatbtnA(btnC10, seatCenterStartX, 5, cLine, btnfontBig);
		// 왼쪽------------------------------------------------------------------------
		JButton btnC11 = new JButton("11"); seatbtnA(btnC11, seatRightStartX , 0, cLine, btnfontBig);
		JButton btnC12 = new JButton("12"); seatbtnA(btnC12, seatRightStartX , 1, cLine, btnfontBig);
		JButton btnC13 = new JButton("13"); seatbtnA(btnC13, seatRightStartX , 2, cLine, btnfontBig);
		JButton btnC14 = new JButton("14"); seatbtnA(btnC14, seatRightStartX , 3, cLine, btnfontBig);
		// C열 좌석 클릭시 이벤트 발생 구간-------------------------------------------------------
		seatClickEvent(btnC1, "C1 ");seatClickEvent(btnC2, "C2 ");seatClickEvent(btnC3, "C2 ");
		seatClickEvent(btnC4, "C4 ");seatClickEvent(btnC5, "C5 ");seatClickEvent(btnC6, "C6 ");
		seatClickEvent(btnC7, "C7 ");seatClickEvent(btnC8, "C8 ");seatClickEvent(btnC9, "C9 ");
		seatClickEvent(btnC10, "C10 ");seatClickEvent(btnC11, "C11 ");seatClickEvent(btnC12, "C11 ");
		seatClickEvent(btnC13, "C13 ");seatClickEvent(btnC14, "C14 ");

		contentPane.add(btnC1);contentPane.add(btnC2);contentPane.add(btnC3);
		contentPane.add(btnC4);contentPane.add(btnC5);contentPane.add(btnC6);
		contentPane.add(btnC7);contentPane.add(btnC8);contentPane.add(btnC9);
		contentPane.add(btnC10);contentPane.add(btnC11);contentPane.add(btnC12);
		contentPane.add(btnC13);contentPane.add(btnC14);
				
		// D열-------------------------------------------------------------------------------------------------------------
		JButton btnD1 = new JButton("1"); seatbtnA(btnD1, seatLeftStartX, 0, dLine, btnfont);
		JButton btnD2 = new JButton("2"); seatbtnA(btnD2, seatLeftStartX, 1, dLine, btnfont);
		JButton btnD3 = new JButton("3"); seatbtnA(btnD3, seatLeftStartX, 2, dLine, btnfont);
		JButton btnD4 = new JButton("4"); seatbtnA(btnD4, seatLeftStartX, 3, dLine, btnfont);
		// 중단------------------------------------------------------------------------
		JButton btnD5 = new JButton("5"); seatbtnA(btnD5, seatCenterStartX, 0, dLine, btnfont);
		JButton btnD6 = new JButton("6"); seatbtnA(btnD6, seatCenterStartX, 1, dLine, btnfont);
		JButton btnD7 = new JButton("7"); seatbtnA(btnD7, seatCenterStartX, 2, dLine, btnfont);
		JButton btnD8 = new JButton("8"); seatbtnA(btnD8, seatCenterStartX, 3, dLine, btnfont);
		JButton btnD9 = new JButton("9"); seatbtnA(btnD9, seatCenterStartX, 4, dLine, btnfont);
		JButton btnD10 = new JButton("10"); seatbtnA(btnD10, seatCenterStartX, 5, dLine, btnfontBig);
		// 왼쪽------------------------------------------------------------------------
		JButton btnD11 = new JButton("11"); seatbtnA(btnD11, seatRightStartX , 0, dLine, btnfontBig);
		JButton btnD12 = new JButton("12"); seatbtnA(btnD12, seatRightStartX , 1, dLine, btnfontBig);
		JButton btnD13 = new JButton("13"); seatbtnA(btnD13, seatRightStartX , 2, dLine, btnfontBig);
		JButton btnD14 = new JButton("14"); seatbtnA(btnD14, seatRightStartX , 3, dLine, btnfontBig);
		// D열 좌석 클릭시 이벤트 발생 구간-------------------------------------------------------
		seatClickEvent(btnD1, "D1 ");seatClickEvent(btnD2, "D2 ");seatClickEvent(btnD3, "D3 ");
		seatClickEvent(btnD4, "D4 ");seatClickEvent(btnD5, "D5 ");seatClickEvent(btnD6, "D6 ");
		seatClickEvent(btnD7, "D7 ");seatClickEvent(btnD8, "D8 ");seatClickEvent(btnD9, "D9 ");
		seatClickEvent(btnD10, "D10 ");seatClickEvent(btnD11, "D11 ");seatClickEvent(btnD12, "D12 ");
		seatClickEvent(btnD13, "D13 ");seatClickEvent(btnD14, "D14 ");

		contentPane.add(btnD1);contentPane.add(btnD2);contentPane.add(btnD3);
		contentPane.add(btnD4);contentPane.add(btnD5);contentPane.add(btnD6);
		contentPane.add(btnD7);contentPane.add(btnD8);contentPane.add(btnD9);
		contentPane.add(btnD10);contentPane.add(btnD11);contentPane.add(btnD12);
		contentPane.add(btnD13);contentPane.add(btnD14);
		
		// E열-------------------------------------------------------------------------------------------------------------
		JButton btnE1 = new JButton("1"); seatbtnA(btnE1, seatLeftStartX, 0, eLine, btnfont);
		JButton btnE2 = new JButton("2"); seatbtnA(btnE2, seatLeftStartX, 1, eLine, btnfont);
		JButton btnE3 = new JButton("3"); seatbtnA(btnE3, seatLeftStartX, 2, eLine, btnfont);
		JButton btnE4 = new JButton("4"); seatbtnA(btnE4, seatLeftStartX, 3, eLine, btnfont);
		// 중단------------------------------------------------------------------------
		JButton btnE5 = new JButton("5"); seatbtnA(btnE5, seatCenterStartX, 0, eLine, btnfont);
		JButton btnE6 = new JButton("6"); seatbtnA(btnE6, seatCenterStartX, 1, eLine, btnfont);
		JButton btnE7 = new JButton("7"); seatbtnA(btnE7, seatCenterStartX, 2, eLine, btnfont);
		JButton btnE8 = new JButton("8"); seatbtnA(btnE8, seatCenterStartX, 3, eLine, btnfont);
		JButton btnE9 = new JButton("9"); seatbtnA(btnE9, seatCenterStartX, 4, eLine, btnfont);
		JButton btnE10 = new JButton("10"); seatbtnA(btnE10, seatCenterStartX, 5, eLine, btnfontBig);
		// 왼쪽------------------------------------------------------------------------
		JButton btnE11 = new JButton("11"); seatbtnA(btnE11, seatRightStartX , 0, eLine, btnfontBig);
		JButton btnE12 = new JButton("12"); seatbtnA(btnE12, seatRightStartX , 1, eLine, btnfontBig);
		JButton btnE13 = new JButton("13"); seatbtnA(btnE13, seatRightStartX , 2, eLine, btnfontBig);
		JButton btnE14 = new JButton("14"); seatbtnA(btnE14, seatRightStartX , 3, eLine, btnfontBig);
		// E열 좌석 클릭시 이벤트 발생 구간-------------------------------------------------------
		seatClickEvent(btnE1, "E1 ");seatClickEvent(btnE2, "E2 ");seatClickEvent(btnE3, "E3 ");
		seatClickEvent(btnE4, "E4 ");seatClickEvent(btnE5, "E5 ");seatClickEvent(btnE6, "E6 ");
		seatClickEvent(btnE7, "E7 ");seatClickEvent(btnE8, "E8 ");seatClickEvent(btnE9, "E9 ");
		seatClickEvent(btnE10, "E10 ");seatClickEvent(btnE11, "E11 ");seatClickEvent(btnE12, "E12 ");
		seatClickEvent(btnE13, "E13 ");seatClickEvent(btnE14, "E14 ");

		contentPane.add(btnE1);contentPane.add(btnE2);contentPane.add(btnE3);
		contentPane.add(btnE4);contentPane.add(btnE5);contentPane.add(btnE6);
		contentPane.add(btnE7);contentPane.add(btnE8);contentPane.add(btnE9);
		contentPane.add(btnE10);contentPane.add(btnE11);contentPane.add(btnE12);
		contentPane.add(btnE13);contentPane.add(btnE14);
		
		// F열-------------------------------------------------------------------------------------------------------------
		JButton btnF1 = new JButton("1"); seatbtnA(btnF1, seatLeftStartX, 0, fLine, btnfont);
		JButton btnF2 = new JButton("2"); seatbtnA(btnF2, seatLeftStartX, 1, fLine, btnfont);
		JButton btnF3 = new JButton("3"); seatbtnA(btnF3, seatLeftStartX, 2, fLine, btnfont);
		JButton btnF4 = new JButton("4"); seatbtnA(btnF4, seatLeftStartX, 3, fLine, btnfont);
		// 중단------------------------------------------------------------------------
		JButton btnF5 = new JButton("5"); seatbtnA(btnF5, seatCenterStartX, 0, fLine, btnfont);
		JButton btnF6 = new JButton("6"); seatbtnA(btnF6, seatCenterStartX, 1, fLine, btnfont);
		JButton btnF7 = new JButton("7"); seatbtnA(btnF7, seatCenterStartX, 2, fLine, btnfont);
		JButton btnF8 = new JButton("8"); seatbtnA(btnF8, seatCenterStartX, 3, fLine, btnfont);
		JButton btnF9 = new JButton("9"); seatbtnA(btnF9, seatCenterStartX, 4, fLine, btnfont);
		JButton btnF10 = new JButton("10"); seatbtnA(btnF10, seatCenterStartX, 5, fLine, btnfontBig);
		// 왼쪽------------------------------------------------------------------------
		JButton btnF11 = new JButton("11"); seatbtnA(btnF11, seatRightStartX , 0, fLine, btnfontBig);
		JButton btnF12 = new JButton("12"); seatbtnA(btnF12, seatRightStartX , 1, fLine, btnfontBig);
		JButton btnF13 = new JButton("13"); seatbtnA(btnF13, seatRightStartX , 2, fLine, btnfontBig);
		JButton btnF14 = new JButton("14"); seatbtnA(btnF14, seatRightStartX , 3, fLine, btnfontBig);
		// F열 좌석 클릭시 이벤트 발생 구간-------------------------------------------------------
		seatClickEvent(btnF1, "F1 ");seatClickEvent(btnF2, "F2 ");seatClickEvent(btnF3, "F3 ");
		seatClickEvent(btnF4, "F4 ");seatClickEvent(btnF5, "F5 ");seatClickEvent(btnF6, "F6 ");
		seatClickEvent(btnF7, "F7 ");seatClickEvent(btnF8, "F8 ");seatClickEvent(btnF9, "F9 ");
		seatClickEvent(btnF10, "F10 ");seatClickEvent(btnF11, "F11 ");seatClickEvent(btnF12, "F12 ");
		seatClickEvent(btnF13, "F13 ");seatClickEvent(btnF14, "F14 ");

		contentPane.add(btnF1);contentPane.add(btnF2);contentPane.add(btnF3);
		contentPane.add(btnF4);contentPane.add(btnF5);contentPane.add(btnF6);
		contentPane.add(btnF7);contentPane.add(btnF8);contentPane.add(btnF9);
		contentPane.add(btnF10);contentPane.add(btnF11);contentPane.add(btnF12);
		contentPane.add(btnF13);contentPane.add(btnF14);
		
		// G열-------------------------------------------------------------------------------------------------------------
		JButton btnG1 = new JButton("1"); seatbtnA(btnG1, seatLeftStartX, 0, gLine, btnfont);
		JButton btnG2 = new JButton("2"); seatbtnA(btnG2, seatLeftStartX, 1, gLine, btnfont);
		JButton btnG3 = new JButton("3"); seatbtnA(btnG3, seatLeftStartX, 2, gLine, btnfont);
		JButton btnG4 = new JButton("4"); seatbtnA(btnG4, seatLeftStartX, 3, gLine, btnfont);
		// 중단------------------------------------------------------------------------
		JButton btnG5 = new JButton("5"); seatbtnA(btnG5, seatCenterStartX, 0, gLine, btnfont);
		JButton btnG6 = new JButton("6"); seatbtnA(btnG6, seatCenterStartX, 1, gLine, btnfont);
		JButton btnG7 = new JButton("7"); seatbtnA(btnG7, seatCenterStartX, 2, gLine, btnfont);
		JButton btnG8 = new JButton("8"); seatbtnA(btnG8, seatCenterStartX, 3, gLine, btnfont);
		JButton btnG9 = new JButton("9"); seatbtnA(btnG9, seatCenterStartX, 4, gLine, btnfont);
		JButton btnG10 = new JButton("10"); seatbtnA(btnG10, seatCenterStartX, 5, gLine, btnfontBig);
		// 왼쪽------------------------------------------------------------------------
		JButton btnG11 = new JButton("11"); seatbtnA(btnG11, seatRightStartX , 0, gLine, btnfontBig);
		JButton btnG12 = new JButton("12"); seatbtnA(btnG12, seatRightStartX , 1, gLine, btnfontBig);
		JButton btnG13 = new JButton("13"); seatbtnA(btnG13, seatRightStartX , 2, gLine, btnfontBig);
		JButton btnG14 = new JButton("14"); seatbtnA(btnG14, seatRightStartX , 3, gLine, btnfontBig);
		// G열 좌석 클릭시 이벤트 발생 구간-------------------------------------------------------
		seatClickEvent(btnG1, "G1 ");seatClickEvent(btnG2, "G2 ");seatClickEvent(btnG3, "G3 ");
		seatClickEvent(btnG4, "G4 ");seatClickEvent(btnG5, "G5 ");seatClickEvent(btnG6, "G6 ");
		seatClickEvent(btnG7, "G7 ");seatClickEvent(btnG8, "G8 ");seatClickEvent(btnG9, "G9 ");
		seatClickEvent(btnG10, "G10 ");seatClickEvent(btnG11, "G11 ");seatClickEvent(btnG12, "G12 ");
		seatClickEvent(btnG13, "G13 ");seatClickEvent(btnG14, "G14 ");

		contentPane.add(btnG1);contentPane.add(btnG2);contentPane.add(btnG3);
		contentPane.add(btnG4);contentPane.add(btnG5);contentPane.add(btnG6);
		contentPane.add(btnG7);contentPane.add(btnG8);contentPane.add(btnG9);
		contentPane.add(btnG10);contentPane.add(btnG11);contentPane.add(btnG12);
		contentPane.add(btnG13);contentPane.add(btnG14);

		// seat_info 테이블의 seatBoolean의 데이터(full, empty)에 따라 버튼이 잠기는 기능
		seatValue("A1", sfeA1, btnA1);
		seatValue("A2", sfeA2, btnA2);seatValue("A3", sfeA3, btnA3);
		seatValue("A4", sfeA4, btnA4);seatValue("A5", sfeA5, btnA5);seatValue("A6", sfeA6, btnA6);
		seatValue("A7", sfeA7, btnA7);seatValue("A8", sfeA8, btnA8);seatValue("A9", sfeA9, btnA9);
		seatValue("A10", sfeA10, btnA10);seatValue("A11", sfeA11, btnA11);seatValue("A12", sfeA12, btnA12);
		seatValue("A13", sfeA13, btnA13);seatValue("A14", sfeA14, btnA14); // a
		seatValue("B1", sfeB1, btnB1);seatValue("B2", sfeB2, btnB2);seatValue("B3", sfeB3, btnB3);
		seatValue("B4", sfeB4, btnB4);seatValue("B5", sfeB5, btnB5);seatValue("B6", sfeB6, btnB6);
		seatValue("B7", sfeB7, btnB7);seatValue("B8", sfeB8, btnB8);seatValue("B9", sfeB9, btnB9);
		seatValue("B10", sfeB10, btnB10);seatValue("B11", sfeB11, btnB11);seatValue("B12", sfeB12, btnB12);
		seatValue("B13", sfeB13, btnB13);seatValue("B14", sfeB14, btnB14); // b
		seatValue("C1", sfeC1, btnC1);seatValue("C2", sfeC2, btnC2);seatValue("C3", sfeC3, btnC3);
		seatValue("C4", sfeC4, btnC4);seatValue("C5", sfeC5, btnC5);seatValue("C6", sfeC6, btnC6);
		seatValue("C7", sfeC7, btnC7);seatValue("C8", sfeC8, btnC8);seatValue("C9", sfeC9, btnC9);
		seatValue("C10", sfeC10, btnC10);seatValue("C11", sfeC11, btnC11);seatValue("C12", sfeC12, btnC12);
		seatValue("C13", sfeC13, btnC13);seatValue("C14", sfeC14, btnC14);
		seatValue("D1", sfeD1, btnD1);seatValue("D2", sfeD2, btnD2);seatValue("D3", sfeD3, btnD3);
		seatValue("D4", sfeD4, btnD4);seatValue("D5", sfeD5, btnD5);seatValue("D6", sfeD6, btnD6);
		seatValue("D7", sfeD7, btnD7);seatValue("D8", sfeD8, btnD8);seatValue("D9", sfeD9, btnD9);
		seatValue("D10", sfeD10, btnD10);seatValue("D11", sfeD11, btnD11);seatValue("D12", sfeD12, btnD12);
		seatValue("D13", sfeD13, btnD13);seatValue("D14", sfeD14, btnD14);
		seatValue("E1", sfeE1, btnE1);seatValue("E2", sfeE2, btnE2);seatValue("E3", sfeE3, btnE3);
		seatValue("E4", sfeE4, btnE4);seatValue("E5", sfeE5, btnE5);seatValue("E6", sfeE6, btnE6);
		seatValue("E7", sfeE7, btnE7);seatValue("E8", sfeE8, btnE8);seatValue("E9", sfeE9, btnE9);
		seatValue("E10", sfeE10, btnE10);seatValue("E11", sfeE11, btnE11);seatValue("E12", sfeE12, btnE12);
		seatValue("E13", sfeE13, btnE13);seatValue("E14", sfeE14, btnE14);
		seatValue("F1", sfeF1, btnF1);seatValue("F2", sfeF2, btnF2);seatValue("F3", sfeF3, btnF3);
		seatValue("F4", sfeF4, btnF4);seatValue("F5", sfeF5, btnF5);seatValue("F6", sfeF6, btnF6);
		seatValue("F7", sfeF7, btnF7);seatValue("F8", sfeF8, btnF8);seatValue("F9", sfeF9, btnF9);
		seatValue("F10", sfeF10, btnF10);seatValue("F11", sfeF11, btnF11);seatValue("F12", sfeF12, btnF12);
		seatValue("F13", sfeF13, btnF13);seatValue("F14", sfeF14, btnF14);
		seatValue("G1", sfeG1, btnG1);seatValue("G2", sfeG2, btnG2);seatValue("G3", sfeG3, btnG3);
		seatValue("G4", sfeG4, btnG4);seatValue("G5", sfeG5, btnG5);seatValue("G6", sfeG6, btnG6);
		seatValue("G7", sfeG7, btnG7);seatValue("G8", sfeG8, btnG8);seatValue("G9", sfeG9, btnG9);
		seatValue("G10", sfeG10, btnG10);seatValue("G11", sfeG11, btnG11);seatValue("G12", sfeG12, btnG12);
		seatValue("G13", sfeG13, btnG13);seatValue("G14", sfeG14, btnG14);
				
		// 인원 버튼 텍스트----------------------------------------------------------
		JLabel adultL = new JLabel("일반");
		adultL.setFont(new Font("굴림", Font.PLAIN, 20));
		adultL.setForeground(Color.WHITE);
		adultL.setBounds(21, 121, 42, 30);
		contentPane.add(adultL);
		
		JLabel childL = new JLabel("청소년");
		childL.setForeground(Color.WHITE);
		childL.setFont(new Font("굴림", Font.PLAIN, 20));
		childL.setBounds(9, 175, 60, 30);
		contentPane.add(childL);
		
		// 인원 체크 버튼----------------------------------------------------------

		// 일반 인원 버튼
		JButton btnNormal1 = new JButton("1");
		btnClickW(btnNormal1);
		btnNormal1.setBounds(81, 114, btnpersonSize, btnpersonSize);
		btnNormal1.setBorderPainted(false);
		contentPane.add(btnNormal1);
		
		JButton btnNormal2 = new JButton("2");
		btnClickW(btnNormal2);
		btnNormal2.setBounds(129, 114, btnpersonSize, btnpersonSize);
		btnNormal2.setBorderPainted(false);
		contentPane.add(btnNormal2);
		
		JButton btnNormal3 = new JButton("3");
		btnClickW(btnNormal3);
		btnNormal3.setBounds(177, 114, btnpersonSize, btnpersonSize);
		btnNormal3.setBorderPainted(false);
		contentPane.add(btnNormal3);
		
		JButton btnNormal4 = new JButton("4");
		btnClickW(btnNormal4);
		btnNormal4.setBounds(225, 114, btnpersonSize, btnpersonSize);
		btnNormal4.setBorderPainted(false);
		contentPane.add(btnNormal4);
		
		JButton btnNormal5 = new JButton("5");
		btnClickW(btnNormal5);
		btnNormal5.setBounds(273, 114, btnpersonSize, btnpersonSize);
		btnNormal5.setBorderPainted(false);
		contentPane.add(btnNormal5);
		
		JButton btnNormal6 = new JButton("6");
		btnClickW(btnNormal6);
		btnNormal6.setBounds(321, 114, btnpersonSize, btnpersonSize);
		btnNormal6.setBorderPainted(false);
		contentPane.add(btnNormal6);

		// 청소년 인원 선택-------------------------------------------------------------
		
		JButton btnchild1 = new JButton("1");
		btnClickW(btnchild1);
		btnchild1.setBounds(81, 168, btnpersonSize, btnpersonSize);
		btnchild1.setBorderPainted(false);
		contentPane.add(btnchild1);
		
		JButton btnchild2 = new JButton("2");
		btnClickW(btnchild2);
		btnchild2.setBounds(129, 168, btnpersonSize, btnpersonSize);
		btnchild2.setBorderPainted(false);
		contentPane.add(btnchild2);
		
		JButton btnchild3 = new JButton("3");
		btnClickW(btnchild3);
		btnchild3.setBounds(177, 168, btnpersonSize, btnpersonSize);
		btnchild3.setBorderPainted(false);
		contentPane.add(btnchild3);
		
		JButton btnchild4 = new JButton("4");
		btnClickW(btnchild4);
		btnchild4.setBounds(225, 168, btnpersonSize, btnpersonSize);
		btnchild4.setBorderPainted(false);
		contentPane.add(btnchild4);
		
		JButton btnchild5 = new JButton("5");
		btnClickW(btnchild5);
		btnchild5.setBounds(273, 168, btnpersonSize, btnpersonSize);
		btnchild5.setBorderPainted(false);
		contentPane.add(btnchild5);
		
		JButton btnchild6 = new JButton("6");
		btnClickW(btnchild6);
		btnchild6.setBounds(321, 168, btnpersonSize, btnpersonSize);
		btnchild6.setBorderPainted(false);
		contentPane.add(btnchild6);
		
		// 일반 인원 버튼 클릭시 이벤트 발생 구간
		btnNormal1.addActionListener(new ActionListener() {
			String situation = "normal";
			@Override
			public void actionPerformed(ActionEvent e) {
				if(SeatClick != 0) {
					errorMess(3);
				} else {
					if(count > 5 && situation == "normal") {
						errorMess(1);
					} else if(count <= 5 && situation == "normal") {
						count = count + 1 ;
						btnClickR(btnNormal1);
						situation = "click";
						adultLabel.setText("일반  1명");
						btnOff(btnNormal2);btnOff(btnNormal3);btnOff(btnNormal4);btnOff(btnNormal5);btnOff(btnNormal6);
						totalPrice();
					} else if(situation == "click") {
						count = count - 1 ;
						btnClickW(btnNormal1);
						situation = "normal";
						adultLabel.setText("일반  0명");
						btnOn(btnNormal2);btnOn(btnNormal3);btnOn(btnNormal4);btnOn(btnNormal5);btnOn(btnNormal6);
						totalPrice();
					}
				}
			}
		});
		btnNormal2.addActionListener(new ActionListener() {
			String situation = "normal";
			@Override
			public void actionPerformed(ActionEvent e) {
				if(SeatClick != 0) {
					errorMess(3);
				} else {
					if(count > 4 && situation == "normal") {
						errorMess(1);
					} else if(count <= 4 && situation == "normal") {
						count = count + 2 ;
						btnClickR(btnNormal2);
						situation = "click";
						adultLabel.setText("일반  2명");
						btnOff(btnNormal1);btnOff(btnNormal3);btnOff(btnNormal4);btnOff(btnNormal5);btnOff(btnNormal6);
						totalPrice();
					} else if(situation == "click") {
						count = count - 2 ;
						btnClickW(btnNormal2);
						situation = "normal";
						adultLabel.setText("일반  0명");
						btnOn(btnNormal1);btnOn(btnNormal3);btnOn(btnNormal4);btnOn(btnNormal5);btnOn(btnNormal6);
						totalPrice();
					}
				}
			}
		});
		btnNormal3.addActionListener(new ActionListener() {
			String situation = "normal";
			@Override
			public void actionPerformed(ActionEvent e) {
				if(SeatClick != 0) {
					errorMess(3);
				} else {
				if(count > 3 && situation == "normal") {
					errorMess(1);
				} else if(count <= 3 && situation == "normal") {
					count = count + 3 ;
					btnClickR(btnNormal3);
					situation = "click";
					adultLabel.setText("일반  3명");
					btnOff(btnNormal1);btnOff(btnNormal2);btnOff(btnNormal4);btnOff(btnNormal5);btnOff(btnNormal6);
					totalPrice();
				} else if(situation == "click") {
					count = count - 3 ;
					btnClickW(btnNormal3);
					situation = "normal";
					adultLabel.setText("일반  0명");
					btnOn(btnNormal1);btnOn(btnNormal2);btnOn(btnNormal4);btnOn(btnNormal5);btnOn(btnNormal6);
					totalPrice();
				}}
			}
		});
		btnNormal4.addActionListener(new ActionListener() {
			String situation = "normal";
			@Override
			public void actionPerformed(ActionEvent e) {
				if(SeatClick != 0) {
					errorMess(3);
				} else {
				if(count > 2 && situation == "normal") {
					errorMess(1);
				} else if(count <= 2 && situation == "normal") {
					count = count + 4 ;
					btnClickR(btnNormal4);
					situation = "click";
					adultLabel.setText("일반  4명");
					btnOff(btnNormal1);btnOff(btnNormal2);btnOff(btnNormal3);btnOff(btnNormal5);btnOff(btnNormal6);
					totalPrice();
				} else if(situation == "click") {
					count = count - 4 ;
					btnClickW(btnNormal4);
					situation = "normal";
					adultLabel.setText("일반  0명");
					btnOn(btnNormal1);btnOn(btnNormal2);btnOn(btnNormal3);btnOn(btnNormal5);btnOn(btnNormal6);
					totalPrice();
				}}
			}
		});
		btnNormal5.addActionListener(new ActionListener() {
			String situation = "normal";
			@Override
			public void actionPerformed(ActionEvent e) {
				if(SeatClick != 0) {
					errorMess(3);
				} else {
				if(count > 1 && situation == "normal") {
					errorMess(1);
				} else if(count <= 1 && situation == "normal") {
					count = count + 5 ;
					btnClickR(btnNormal5);
					situation = "click";
					adultLabel.setText("일반  5명");
					btnOff(btnNormal1);btnOff(btnNormal2);btnOff(btnNormal3);btnOff(btnNormal4);btnOff(btnNormal6);
					totalPrice();
				} else if(situation == "click") {
					count = count - 5 ;
					btnClickW(btnNormal5);
					situation = "normal";
					adultLabel.setText("일반  0명");
					btnOn(btnNormal1);btnOn(btnNormal2);btnOn(btnNormal3);btnOn(btnNormal4);btnOn(btnNormal6);
					totalPrice();
				}}
			}
		});
		btnNormal6.addActionListener(new ActionListener() {
			String situation = "normal";
			@Override
			public void actionPerformed(ActionEvent e) {
				if(SeatClick != 0) {
					errorMess(3);
				} else {
				if(count > 0 && count < 6 || count==6 && situation == "normal") {
					errorMess(1);
				} else if(count == 0 && situation == "normal") {
					count = count + 6 ;
					btnClickR(btnNormal6);
					situation = "click";
					adultLabel.setText("일반  6명");
					btnOff(btnNormal1);btnOff(btnNormal2);btnOff(btnNormal3);btnOff(btnNormal4);btnOff(btnNormal5);
					totalPrice();
				} else if(count==6 && situation == "click") {
					count = count - 6 ;
					btnClickW(btnNormal6);
					situation = "normal";
					adultLabel.setText("일반  0명");
					btnOn(btnNormal1);btnOn(btnNormal2);btnOn(btnNormal3);btnOn(btnNormal4);btnOn(btnNormal5);
					totalPrice();
				}}
			}
		});		
		btnchild1.addActionListener(new ActionListener() {
			String situation = "normal";
			@Override
			public void actionPerformed(ActionEvent e) {
				if(SeatClick != 0) {
					errorMess(3);
				} else {
				if(count > 5 && situation == "normal") {
					errorMess(1);
				} else if(count <= 5 && situation == "normal") {
					count = count + 1 ;
					childCount = childCount + 1 ;
					btnClickR(btnchild1);
					situation = "click";
					childLabel.setText("청소년 1명");
					btnOff(btnchild2);btnOff(btnchild3);btnOff(btnchild4);btnOff(btnchild5);btnOff(btnchild6);
					totalPrice();
				} else if(situation == "click") {
					count = count - 1 ;
					childCount = childCount - 1 ;
					btnClickW(btnchild1);
					situation = "normal";
					childLabel.setText("청소년 0명");
					btnOn(btnchild2);btnOn(btnchild3);btnOn(btnchild4);btnOn(btnchild5);btnOn(btnchild6);
					totalPrice();
				}}
			}
		});
		btnchild2.addActionListener(new ActionListener() {
			String situation = "normal";
			@Override
			public void actionPerformed(ActionEvent e) {
				if(SeatClick != 0) {
					errorMess(3);
				} else {
				if(count > 4 && situation == "normal") {
					errorMess(1);
				} else if(count <= 4 && situation == "normal") {
					count = count + 2 ;
					childCount = childCount + 2 ;
					btnClickR(btnchild2);
					situation = "click";
					childLabel.setText("청소년 2명");
					btnOff(btnchild1);btnOff(btnchild3);btnOff(btnchild4);btnOff(btnchild5);btnOff(btnchild6);
					totalPrice();
				} else if(situation == "click") {
					count = count - 2 ;
					childCount = childCount - 2 ;
					btnClickW(btnchild2);
					situation = "normal";
					childLabel.setText("청소년 0명");
					btnOn(btnchild1);btnOn(btnchild3);btnOn(btnchild4);btnOn(btnchild5);btnOn(btnchild6);
					totalPrice();
				}}
			}
		});
		btnchild3.addActionListener(new ActionListener() {
			String situation = "normal";
			@Override
			public void actionPerformed(ActionEvent e) {
				if(SeatClick != 0) {
					errorMess(3);
				} else {
				if(count > 3 && situation == "normal") {
					errorMess(1);
				} else if(count <= 3 && situation == "normal") {
					count = count + 3 ;
					childCount = childCount + 3 ;
					btnClickR(btnchild3);
					situation = "click";
					childLabel.setText("청소년 3명");
					btnOff(btnchild1);btnOff(btnchild2);btnOff(btnchild4);btnOff(btnchild5);btnOff(btnchild6);
					totalPrice();
				} else if(situation == "click") {
					count = count - 3 ;
					childCount = childCount - 3 ;
					btnClickW(btnchild3);
					situation = "normal";
					childLabel.setText("청소년 0명");
					btnOn(btnchild1);btnOn(btnchild2);btnOn(btnchild4);btnOn(btnchild5);btnOn(btnchild6);
					totalPrice();
				}}
			}
		});
		btnchild4.addActionListener(new ActionListener() {
			String situation = "normal";
			@Override
			public void actionPerformed(ActionEvent e) {
				if(SeatClick != 0) {
					errorMess(3);
				} else {
				if(count > 2 && situation == "normal") {
					errorMess(1);
				} else if(count <= 2 && situation == "normal") {
					count = count + 4 ;
					childCount = childCount + 4 ;
					btnClickR(btnchild4);
					situation = "click";
					childLabel.setText("청소년 4명");
					btnOff(btnchild1);btnOff(btnchild2);btnOff(btnchild3);btnOff(btnchild5);btnOff(btnchild6);
					totalPrice();
				} else if(situation == "click") {
					count = count - 4 ;
					childCount = childCount - 4 ;
					btnClickW(btnchild4);
					situation = "normal";
					childLabel.setText("청소년 0명");
					btnOn(btnchild1);btnOn(btnchild2);btnOn(btnchild3);btnOn(btnchild5);btnOn(btnchild6);
					totalPrice();
				}}
			}
		});
		btnchild5.addActionListener(new ActionListener() {
			String situation = "normal";
			@Override
			public void actionPerformed(ActionEvent e) {
				if(SeatClick != 0) {
					errorMess(3);
				} else {
				if(count > 1 && situation == "normal") {
					errorMess(1);
				} else if(count <= 1 && situation == "normal") {
					count = count + 5 ;
					childCount = childCount + 5 ;
					btnClickR(btnchild5);
					situation = "click";
					childLabel.setText("청소년 5명");
					btnOff(btnchild1);btnOff(btnchild2);btnOff(btnchild3);btnOff(btnchild4);btnOff(btnchild6);
					totalPrice();
				} else if(situation == "click") {
					count = count - 5 ;
					childCount = childCount - 5 ;
					btnClickW(btnchild5);
					situation = "normal";
					childLabel.setText("청소년 0명");
					btnOn(btnchild1);btnOn(btnchild2);btnOn(btnchild3);btnOn(btnchild4);btnOn(btnchild6);
					totalPrice();
				}}
			}
		});
		btnchild6.addActionListener(new ActionListener() {
			String situation = "normal";
			@Override
			public void actionPerformed(ActionEvent e) {
				if(SeatClick != 0) {
					errorMess(3);
				} else {
				if(count > 0 && count < 6 || count==6 && situation == "normal") {
					errorMess(1);
				} else if(count == 0 && situation == "normal") {
					count = count + 6 ;
					childCount = childCount + 6 ;
					btnClickR(btnchild6);
					situation = "click";
					childLabel.setText("청소년 6명");
					btnOff(btnchild1);btnOff(btnchild2);btnOff(btnchild3);btnOff(btnchild4);btnOff(btnchild5);
					totalPrice();
				} else if(count==6 && situation == "click") {
					count = count - 6 ;
					childCount = childCount - 6 ;
					btnClickW(btnchild6);
					situation = "normal";
					childLabel.setText("청소년 0명");
					btnOn(btnchild1);btnOn(btnchild2);btnOn(btnchild3);btnOn(btnchild4);btnOn(btnchild5);
					totalPrice();
				}}
			}
		});	
		// 인원 표시되는 라벨 창
		adultLabel = new JLabel("일반  0명");
		adultLabel.setFont(new Font("굴림", Font.PLAIN, 17));
		adultLabel.setForeground(Color.WHITE);
		adultLabel.setBounds(394, 116, 120, 50);
		contentPane.add(adultLabel);
		
		childLabel = new JLabel("청소년 0명");
		childLabel.setFont(new Font("굴림", Font.PLAIN, 17));
		childLabel.setForeground(Color.WHITE);
		childLabel.setBounds(394, 168, 120, 50);
		contentPane.add(childLabel);
		
		totalPiceLabel = new JLabel("0원");
		totalPiceLabel.setFont(new Font("돋움", Font.BOLD, 19));
		totalPiceLabel.setForeground(Color.WHITE);
		totalPiceLabel.setBounds(500, 138, 110, 51);
		contentPane.add(totalPiceLabel);
		
		
	}
	void connect() {
		String driver = "oracle.jdbc.driver.OracleDriver";	
		String url = "jdbc:oracle:thin:@192.168.40.56:1521:xe";
		String user = "system1";
		String pwd = "1234";
			try {
				Class.forName(driver);
				con = DriverManager.getConnection(url, user, pwd);
			} catch (Exception e) {
				e.printStackTrace();
			}
	} // Connection 메서드 end
	
	// 상영관 표시하는 메서드 // cinema_info 데이터베이스에서 가져옴

	// 가격 값을 화면에 출력하는 코드
	void totalPrice() {
		try {
			totalPrice = count*10000 - childCount*2000;
			totalPiceLabel.setText(totalPrice + "원");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// 버튼 기본 색상
	void btnClickW(JButton e) {
		e.setBackground(Color.WHITE);
	}
	// 버튼 클릭시 색상
	void btnClickR(JButton e) {
		e.setBackground(Color.RED);
	}	

	// 에러코드 모음 메서드 
	void errorMess(int e) {
		switch (e) {
		case 1 : JOptionPane.showMessageDialog(null, "최대 6명을 초과했습니다.");
				break;
		case 2 : JOptionPane.showMessageDialog(null, "선택한 인원을 초과했습니다.");
				break;
		case 3 : JOptionPane.showMessageDialog(null, "인원을 변경하시려면 좌석을 해제 해주세요.");
				break;		
		}
	}

	// 버튼 클릭시 나머지 버튼 비활성화
	void btnOff(JButton e) {
		e.setEnabled(false);
		e.setBackground(Color.GRAY);
		e.setForeground(Color.WHITE);
	}
	// 버튼 재클릭시 나머지 버튼 활성화
	void btnOn(JButton e) {
		e.setEnabled(true);
		e.setBackground(Color.WHITE);
		e.setForeground(Color.BLACK);
	}
	
	// 좌석버튼 클릭시 이벤트 발생 
	void seatClickEvent(JButton e, String s) {
		e.addActionListener(new ActionListener() {
			JButton ebtn = e;
			String situation = "normal";
			@Override
			public void actionPerformed(ActionEvent e) {
				if(count==0 && SeatClick==0)
					JOptionPane.showMessageDialog(null, "인원을 선택해주세요.");
				else if(SeatClick>=count && situation == "normal") {
					errorMess(2);
				} else {
					if(situation == "normal") {
						btnClickR(ebtn);
						situation = "click";
						SeatClick++;
						seatt = seatt + s;
						seatLabelP.setText(seatt);
					} else if(situation == "click") {
						btnClickW(ebtn);
						situation = "normal";
						SeatClick--;
						seatt = seatt.replace(s, "");
						System.out.println(seatt);
						seatLabelP.setText(seatt);
					}
				}
			}
		});
	}


	
	// 각 좌석 변수에 empty, full 값 저장하는 메서드
	void seatValue(String p,String s, JButton e) {
		try {
			sql = "SELECT seatboolean from seat_info where cinemaNum = ? and seatPosition = ?"; // sql문
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, cinemaNumber); // cinemaNumber = 1;
			pstmt.setString(2, p); // 'A1', 'A2', ....
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				 s = rs.getString("seatboolean");
			}
			if(s.equalsIgnoreCase("empty")) {btnOn(e);} else if(s.equalsIgnoreCase("full")){btnOff(e);}
			rs.close();
			pstmt.close();
			
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
	void gettable() {
		sql = "select * from cinema_info";
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int cinemaNum = rs.getInt("cinemaNum");       
				String cinemaName = rs.getString("cinemaName"); 
				String cinemaRoom = rs.getString("cinemaRoom");     
				int cinemaDate = rs.getInt("cinemaDate");           		
				int cinemaTime = rs.getInt("cinemaTime");           
				int movieNum = rs.getInt("영화번호");         

				System.out.println(cinemaNum + "    " + cinemaName +  "    " + cinemaRoom +  "    " + cinemaDate +  "    " + cinemaTime +  "    " + movieNum);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	
	void seatbtnA(JButton e, int x, int s, int l, int p) {
		e.setFont(new Font("굴림", Font.PLAIN, p)); // 버튼 글자 
		e.setBackground(Color.WHITE); // 버튼 배경색
		e.setForeground(Color.BLACK); // 버튼 글자색
		e.setBounds(x + 44*(s), l, buttonSize, buttonSize);  // 버튼 위치, 크기
		e.setBorderPainted(false); // 테두리 없애기
	}
	
	void linLabel(JLabel e, int x, int y) {
		e.setFont(new Font("굴림", Font.BOLD, 20));
		e.setForeground(Color.WHITE);
		e.setBounds(x, y, 30, 30);
	}
}