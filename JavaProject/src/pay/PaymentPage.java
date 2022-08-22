package pay;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import login.LoginMember_DTO;
import main.Cinema_DTO;

import javax.swing.*;

public class PaymentPage extends JFrame{
	
	static LoginMember_DTO member = new LoginMember_DTO();
	
	ImageIcon icon_back;
	ImageIcon icon_cgv;
	
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

	
	public PaymentPage() {	
		
		member.setCardNum("11111");
		
		setTitle("결제 페이지");

		JPanel container_img = new JPanel();
		JPanel container1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel container2 = new JPanel();
		JPanel container3 = new JPanel();
		JPanel container_north = new JPanel(new BorderLayout());
		JPanel container_empty = new JPanel();
		
		//배경 흰색으로
		container_img.setBackground(Color.WHITE);
		container1.setBackground(Color.WHITE);
		container2.setBackground(Color.WHITE);
		container3.setBackground(Color.WHITE);
		container_north.setBackground(Color.WHITE);
		container_empty.setBackground(Color.WHITE);
		
		
		//상단	뒤로가기
		icon_back = new ImageIcon("src/img/back3.png");
		JButton button1 = new JButton();
		button1.setBounds(100, 100, 100, 100);
		button1.setIcon(icon_back);
		button1.setBorder(null);
		button1.setContentAreaFilled(false);
		
		
		//중단	예매정보
		

		icon_cgv = new ImageIcon("src/img/tmplogo.png");
		JLabel jimg = new JLabel();
		jimg.setIcon(icon_cgv);

		//임시
		//가능하면 DTO에서 저장된 정보를 가져와서 사용
		movieAge = "12세";
		movieName="매버릭";
		cinemaDate="2022/08/18";
		cinemaTime="15:00";
		cinemaRoom="1관";
		seatPosition="F12";
		totalNum=1;
//		cinemaName= Cinema_DTO.getcinemaName();
//		movieName = Cinema_DTO.getmovieName();
//		cinemaDate = Cinema_DTO.getcinemaDate();
//		cinemaTime = Cinema_DTO.getcinemaRoom();

		JLabel jl1 = new JLabel("<html><head><center><p style=\"font-size:40px\">영화관람권</p></center></head>"
		+"<body><left>"+"===================================<br>"+movieAge+"이상관람가<br>"
		+"<p style=\"font-size:20px;\"><strong>"+movieName+"</strong></p>"
		+"EXIT<br>"+cinemaDate+" "+cinemaTime+"<br>"+cinemaRoom+" "+seatPosition+"<br>"+"총인원 "+totalNum
		+"명 <br><br><br>"+"<strong>"+cinemaName+"</strong>"+"<br>"+ "</left></body></html>");
		jl1.setFont(new Font("Serif",Font.PLAIN,17));
		
		//하단	결제버튼
		JButton button2 = new JButton("결  제");
		
		
		//컨테이너에 추가
		container1.add(button1);
		container_img.add(jimg);
		container2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		container2.add(jl1);
		container3.add(button2);
		
		container_north.add(container1,BorderLayout.NORTH);
		container_north.add(container_img,BorderLayout.CENTER);
		container_north.add(container2,BorderLayout.SOUTH);
		
		getContentPane().add(container_north,BorderLayout.NORTH);
		getContentPane().add(container_empty,BorderLayout.CENTER);
		
		JPanel container2_1 = new JPanel();
		container2_1.setBackground(Color.WHITE);
		container_empty.add(container2_1);
		
		JLabel jl1_1 = new JLabel("");
		jl1_1.setBounds(5, 5, 0, 0);
		jl1_1.setFont(new Font("Serif", Font.PLAIN, 17));
		Cinema_DTO dto = new Cinema_DTO();
		String name = dto.getmovieName();
		container2_1.setLayout(null);
		jl1_1.setText(name);
		container2_1.add(jl1_1);
		
		setBounds(500,90,700,900);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setVisible(true);
		
		//뒤로가기
		button1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				//new TestMainPage();  좌석선택페이지 클래스로 이동
				setVisible(false);
			
			}
		});
		
		//결제
		button2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new PaymentCheckPage();// 카드번호 확인 페이지로 이동
				setVisible(false);
			
			
			}
		});
	}
}
