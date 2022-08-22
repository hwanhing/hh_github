package book;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.event.*;
import java.awt.image.ImageObserver;
import java.sql.*;
import java.text.AttributedCharacterIterator;
import java.time.LocalDateTime;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import com.toedter.calendar.JDateChooser;
import main.Mainpage;
import main.Hunt_info;
import main.Cinema_DTO;

public class asd extends JFrame{
	LocalDateTime now = LocalDateTime.now();
	Connection con = null;			//DB연동
	PreparedStatement st = null;	//DB연결
	ResultSet rs = null;			//SQL문 실행
	String sql;
	DefaultTableModel model1 = null;
	DefaultTableModel model2 = null;
	JTable table1 = null;
	JTable table2 = null;
	String Theater = "";
	private JPanel contentPane;
	public JTextField jtf1 = null;
	JTextField jtf2 = null;
	JTextField jtf3 = null;
	JTextField jtf4 = null;
	JTextField jtf5 = null;
	String movie_time = null;
	String cal1 = null;
	int movie_name1 = 0;
	String cinemaname1 = null;
	JLabel bisang = null;
	JLabel hansan = null;
	JLabel alien = null;
	JLabel mini = null;
	JLabel hunt = null;
	JLabel topgun = null;
	JDateChooser dateChooser = null;
	JButton rb1 = null;
	JButton rb2 = null;
	JButton rb3 = null;
	JButton rb4 = null;
	JButton rb5 = null;
	JButton rb6 = null;
	
	
	public asd() {
		
		/*************************************
		 * 달력
		 */
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(Color.DARK_GRAY);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("예매하기");
		dateChooser = new JDateChooser();
		dateChooser.getCalendarButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
			}
		});
		dateChooser.setBounds(230, 130, 220, 36);
		dateChooser.setForeground(Color.WHITE);
		dateChooser.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		dateChooser.setBackground(Color.DARK_GRAY);
		contentPane.add(dateChooser);
		JTextField jl1 = new JTextField("상영 날짜");
		jl1.setBackground(Color.RED);
		jl1.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		jl1.setBounds(305, 100, 233, 30);
		jl1.setForeground(Color.WHITE);
		jl1.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		
		/*************************************
		 * 영화관
		 */
		String header1 [] = {"영화관"};
		model1 = new DefaultTableModel(header1,0);
		table1 = new JTable(model1);
		table1.setBounds(0, 130, 222, 310);
		table1.setForeground(Color.DARK_GRAY);
		table1.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		table1.setShowVerticalLines(false);
		table1.setShowHorizontalLines(false);
		table1.setBackground(Color.WHITE);
		JScrollPane jsp1 = new JScrollPane(table1,ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		//jsp1.setPreferredSize(new Dimension(200,350));
		//jsp1.setBounds(0, 130, 222, 419);
		JTextField jl3 = new JTextField("                     영화관");
		jl3.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		jl3.setBounds(0, 100, 305, 30);
		jl3.setBackground(Color.RED);
		jl3.setForeground(Color.WHITE);
		jl3.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		
		table1.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int row = table1.getSelectedRow();
				Theater = model1.getValueAt(row,0).toString();
				jtf2.setText(Theater);
			}
		});
		
		/*************************************
		 * 상영 시간
		 */
		String header2 [] = {"상영 시간"};
		model2 = new DefaultTableModel(header2,0);
		table2 = new JTable(model2);
		table2.setBounds(465, 130, 222, 310);
		table2.setForeground(Color.BLACK);
		table2.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		table2.setShowVerticalLines(false);
		table2.setShowHorizontalLines(false);
		table2.setBackground(Color.WHITE);
		JScrollPane jsp2 = new JScrollPane(table2,ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		//jsp2.setPreferredSize(new Dimension(200,350));
		//jsp2.setBounds(465, 130, 222, 419);
		JTextField jl4 = new JTextField("상영 시간");
		jl4.setBackground(Color.RED);
		jl4.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		jl4.setBounds(538, 100, 206, 30);
		jl4.setForeground(Color.WHITE);
		jl4.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		
		table2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table2.getSelectedRow();
				movie_time = model2.getValueAt(row,0).toString();
				jtf5.setText(movie_time);
				
			}
		});
		
		/**************************************
		 * 컴포넌트
		 */
		
		JButton movie2 = new JButton("날짜 확인");
		movie2.setForeground(Color.WHITE);
		movie2.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		movie2.setBackground(Color.RED);
		JButton button1 = new JButton("예매하기");
		button1.setForeground(Color.WHITE);
		button1.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		button1.setBackground(new Color(255, 69, 0));
		//JButton button2 = new JButton("뒤로가기");
		JButton backbutton = new JButton(new ImageIcon("C:\\img\\back3.png"));
		backbutton.setBorderPainted(false);
		backbutton.setContentAreaFilled(false);
		backbutton.setFocusPainted(false);
		JLabel title = new JLabel("영화 제목 : ");
		title.setForeground(Color.WHITE);
		title.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		JLabel location = new JLabel("상영 영화관 : ");
		location.setForeground(Color.WHITE);
		location.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		JLabel cal = new JLabel("상영 날짜 : ");
		cal.setForeground(Color.WHITE);
		cal.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		JLabel Theater_1 = new JLabel("상영관 : ");
		Theater_1.setForeground(Color.WHITE);
		Theater_1.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		JLabel when = new JLabel("상영 시간 : ");
		when.setForeground(Color.WHITE);
		when.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		jtf1 = new JTextField(20);
		jtf1.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		jtf1.setBackground(Color.DARK_GRAY);
		jtf1.setForeground(Color.WHITE);
		jtf1.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		jtf2 = new JTextField(20);
		jtf2.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		jtf2.setBackground(Color.DARK_GRAY);
		jtf2.setForeground(Color.WHITE);
		jtf2.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		jtf3 = new JTextField(20);
		jtf3.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		jtf3.setBackground(Color.DARK_GRAY);
		jtf3.setForeground(Color.WHITE);
		jtf3.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		jtf4 = new JTextField(20);
		jtf4.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		jtf4.setBackground(Color.DARK_GRAY);
		jtf4.setForeground(Color.WHITE);
		jtf4.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		jtf5 = new JTextField(20);
		jtf5.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		jtf5.setBackground(Color.DARK_GRAY);
		jtf5.setForeground(Color.WHITE);
		jtf5.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		//button2.setBounds(22, 30, 70, 70);			//뒤로가기
		backbutton.setBounds(22,30,70,70);
		button1.setBounds(462, 776, 165, 31);		//예매하기
		movie2.setBounds(263, 179,165, 31);			//날짜 확인
		title.setBounds(462, 500, 86, 50);
		location.setBounds(462,550, 100, 50);
		cal.setBounds(462, 600, 86, 50);
		Theater_1.setBounds(462, 650, 86, 50);
		when.setBounds(462, 700, 86, 50);
		jtf1.setBounds(556, 515, 116, 21);
		jtf2.setBounds(556, 565, 116, 21);
		jtf3.setBounds(556, 615, 116, 21);
		jtf4.setBounds(556, 665, 116, 21);
		jtf5.setBounds(556, 715, 116, 21);
		rb1 = new JButton("1관");
		rb1.setBounds(240, 249, 100, 64);
		rb2 = new JButton("2관");
		rb2.setBounds(240, 313, 100, 64);
		rb3 = new JButton("3관");
		rb3.setBounds(240, 377, 100, 64);
		rb4 = new JButton("4관");
		rb4.setBounds(346, 249, 100, 64);
		rb5 = new JButton("5관");
		rb5.setBounds(346, 313, 100, 64);
		rb6 = new JButton("6관");
		rb6.setBounds(346, 377, 100, 64);
		ButtonGroup bg = new ButtonGroup();
		bg.add(rb1); bg.add(rb2); bg.add(rb3);
		bg.add(rb4); bg.add(rb5); bg.add(rb6);
		rb1.setForeground(Color.WHITE);
		rb1.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		rb1.setBackground(Color.RED);
		rb2.setForeground(Color.WHITE);
		rb2.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		rb2.setBackground(Color.RED);
		rb3.setForeground(Color.WHITE);
		rb3.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		rb3.setBackground(Color.RED);
		rb4.setForeground(Color.WHITE);
		rb4.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		rb4.setBackground(Color.RED);
		rb5.setForeground(Color.WHITE);
		rb5.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		rb5.setBackground(Color.RED);
		rb6.setForeground(Color.WHITE);
		rb6.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		rb6.setBackground(Color.RED);
		
		JLabel jl2 = new JLabel("상영관");
		jl2.setBounds(317, 213, 206, 30);
		jl2.setForeground(Color.WHITE);
		jl2.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		
		JLabel logo = new JLabel("New label");
		logo.setIcon(new ImageIcon("C:\\NCS\\tmplogo_small.png"));
		logo.setBounds(281, 10, 142, 63);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 684, 130);
		panel.setBackground(Color.WHITE);
		
		// 뒤로가기 버튼
		JButton backbutton1 = new JButton("");
		backbutton1.setIcon(new ImageIcon(Hunt_info.class.getResource("/img/back3.png")));
		backbutton1.setBounds(16, 30, 49, 49);
		contentPane.add(backbutton1);
		backbutton1.setContentAreaFilled(false);
		backbutton1.setBorder(null);
		
		
		
		bisang = new JLabel("New label");
		bisang.setIcon(new ImageIcon(Mainpage.class.getResource("/img/비상선언.jpg")));
		bisang.setForeground(Color.GRAY);
		bisang.setBackground(Color.MAGENTA);
		bisang.setBounds(0, 441, 305, 437);
		
		mini = new JLabel("New label");
		mini.setIcon(new ImageIcon(Mainpage.class.getResource("/img/미니언즈2.jpg")));
		mini.setBounds(0, 441, 305, 437);
		
		topgun = new JLabel("New label");
		topgun.setIcon(new ImageIcon(Mainpage.class.getResource("/img/탑건매버릭.jpg")));
		topgun.setBounds(0, 441, 305, 437);
		
		hansan = new JLabel("New label");
		hansan.setIcon(new ImageIcon(Mainpage.class.getResource("/img/한산.jpg")));
		hansan.setForeground(Color.GRAY);
		hansan.setBackground(Color.MAGENTA);
		hansan.setBounds(0, 441, 305, 437);
		
		alien = new JLabel("New label");
		alien.setIcon(new ImageIcon(Mainpage.class.getResource("/img/외+계인.jpg")));
		alien.setBounds(0, 441, 305, 437);
		
		hunt = new JLabel("New label");
		hunt.setIcon(new ImageIcon(Mainpage.class.getResource("/img/헌트.jpg")));
		hunt.setBounds(0, 441, 305, 437);
		
		
		add(movie2); add(jl1); add(table1); add(table2);add(Theater_1);
		add(button1); add(backbutton1); add(title); add(location);
		add(cal); add(when); add(jtf1); add(jtf2); add(jtf3); add(jtf4);add(jtf5);
		add(rb1); add(rb2); add(rb3); add(jl2); add(rb4); add(rb5); add(rb6);
		add(jl3); add(jl4); add(logo); add(panel);
		
		
		setBounds(500, 90, 700, 900);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		
		button1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Cinema_DTO dto = new Cinema_DTO();
				String movieName = null;
				String cinemaName = null;


				dto.setmovieName(movieName);
				dto.setcinemaName(cinemaName);

				
				JOptionPane.showMessageDialog(null, "영화정보저장");
			}
		});
		
		// 뒤로가기 버튼 이벤트
		backbutton1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
						Mainpage.main(null);
						setVisible(false);
					}
				});
		
		
		/**************************************
		 * 날짜 확인 및 상영시간표 호출
		 */	
		movie2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
//				if((int)dateChooser.getDate().getDate() > (int)now.getDayOfMonth()+30) {
//					JOptionPane.showMessageDialog(null, "상영 가능한 영화가 없습니다.");
//					return;
//				}else if((int)dateChooser.getDate().getDate() < (int)now.getDayOfMonth()){
//					JOptionPane.showMessageDialog(null,"상영 날짜가 지났습니다.");
//					return;
//				}
				JOptionPane.showMessageDialog(null,Theater+"에서 "+(dateChooser.getDate().getMonth()+1)+"월 "+dateChooser.getDate().getDate()+"일이 맞습니까??");
				jtf3.setText(String.valueOf(dateChooser.getDate().getMonth()+1)+"월"+dateChooser.getDate().getDate()+"일");			
				reset();
				buttonclose1();
				
				buttonclose2();
				
				buttonclose3();
				
				buttonclose4();
				
				buttonclose5();
				
				buttonclose6();
				
			}

		});
		
		rb1.addActionListener(new ActionListener() {
			//8월17일
			@Override
			public void actionPerformed(ActionEvent e) {
				
				cinemadate();
				movienum();
				cinemaname();
				jtf4.setText("1관");
				model2.setRowCount(0);
				try {
//					Class.forName("oracle.jdbc.driver.OracleDriver");
//					con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.40.56:1521:xe","system1" ,"1234" );
//					con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.40.56:1521:xe","system1" ,"1234" );
//					st = con.prepareStatement("select cinematime from cinema_info where cinemaroom = '1관' and cinemadate = ? and cinemaname = ? and movienum = ?");
					con = DBConnect.getConnection();
					sql = "select cinematime from cinema_info where cinemaroom = '1관' and cinemadate = ? and cinemaname = ? and movienum = ?";
					st = con.prepareStatement(sql);
					st.setString(1, cal1);
					st.setString(2, cinemaname1);
					st.setInt(3,movie_name1);
					rs = st.executeQuery();
					System.out.println(rs.next());
					while(rs.next()) {
						String cinematime = rs.getString("cinematime");
						Object data [] = {cinematime};
						model2.addRow(data);
						//System.out.println(dateChooser.getDate().getDate());
				}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
			}
		});
		rb2.addActionListener(new ActionListener() {
			//8월17일
			@Override
			public void actionPerformed(ActionEvent e) {
				
				cinemadate();
				movienum();
				cinemaname();
				jtf4.setText("2관");
				model2.setRowCount(0);
				try {
//					Class.forName("oracle.jdbc.driver.OracleDriver");
//					con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.40.56:1521:xe","system1" ,"1234" );
//					st = con.prepareStatement("select cinematime from cinema_info where cinemaroom = '2관' and cinemadate = ? and cinemaname = ? and movienum = ?");
					con = DBConnect.getConnection();
					sql = "select cinematime from cinema_info where cinemaroom = '2관' and cinemadate = ? and cinemaname = ? and movienum = ?";
					st = con.prepareStatement(sql);
					st.setString(1, cal1);
					st.setString(2, cinemaname1);
					st.setInt(3,movie_name1);
					rs = st.executeQuery();
					while(rs.next()) {
						String cinematime = rs.getString("cinematime");
						Object data [] = {cinematime};
						model2.addRow(data);
						//System.out.println(dateChooser.getDate().getDate());
				}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
			}
		});
		rb3.addActionListener(new ActionListener() {
			//8월17일
			@Override
			public void actionPerformed(ActionEvent e) {
				
				cinemadate();
				movienum();
				cinemaname();
				jtf4.setText("3관");
				model2.setRowCount(0);
				try {
//					Class.forName("oracle.jdbc.driver.OracleDriver");
//					con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.40.56:1521:xe","system1" ,"1234" );
//					st = con.prepareStatement("select cinematime from cinema_info where cinemaroom = '3관' and cinemadate = ? and cinemaname = ? and movienum = ?");
					con = DBConnect.getConnection();
					sql = "select cinematime from cinema_info where cinemaroom = '3관' and cinemadate = ? and cinemaname = ? and movienum = ?";
					st = con.prepareStatement(sql);
					st.setString(1, cal1);
					st.setString(2, cinemaname1);
					st.setInt(3,movie_name1);
					rs = st.executeQuery();
					while(rs.next()) {
						String cinematime = rs.getString("cinematime");
						Object data [] = {cinematime};
						model2.addRow(data);
						//System.out.println(dateChooser.getDate().getDate());
				}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
			}
		});
		rb4.addActionListener(new ActionListener() {
			//8월17일
			@Override
			public void actionPerformed(ActionEvent e) {
				
				cinemadate();
				movienum();
				cinemaname();
				jtf4.setText("4관");
				model2.setRowCount(0);
				try {
//					Class.forName("oracle.jdbc.driver.OracleDriver");
//					con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.40.56:1521:xe","system1" ,"1234" );
//					st = con.prepareStatement("select cinematime from cinema_info where cinemaroom = '4관' and cinemadate = ? and cinemaname = ? and movienum = ?");
					con = DBConnect.getConnection();
					sql = "select cinematime from cinema_info where cinemaroom = '4관' and cinemadate = ? and cinemaname = ? and movienum = ?";
					st = con.prepareStatement(sql);
					st.setString(1, cal1);
					st.setString(2, cinemaname1);
					st.setInt(3,movie_name1);
					rs = st.executeQuery();
					while(rs.next()) {
						String cinematime = rs.getString("cinematime");
						Object data [] = {cinematime};
						model2.addRow(data);
						//System.out.println(dateChooser.getDate().getDate());
				}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
			}
		});
		rb5.addActionListener(new ActionListener() {
			//8월17일
			@Override
			public void actionPerformed(ActionEvent e) {
				
				cinemadate();
				movienum();
				cinemaname();
				jtf4.setText("5관");
				model2.setRowCount(0);
				try {
//					Class.forName("oracle.jdbc.driver.OracleDriver");
//					con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.40.56:1521:xe","system1" ,"1234" );
//					st = con.prepareStatement("select cinematime from cinema_info where cinemaroom = '5관' and cinemadate = ? and cinemaname = ? and movienum = ?");
					con = DBConnect.getConnection();
					sql = "select cinematime from cinema_info where cinemaroom = '5관' and cinemadate = ? and cinemaname = ? and movienum = ?";
					st = con.prepareStatement(sql);
					st.setString(1, cal1);
					st.setString(2, cinemaname1);
					st.setInt(3,movie_name1);
					rs = st.executeQuery();
					while(rs.next()) {
						String cinematime = rs.getString("cinematime");
						Object data [] = {cinematime};
						model2.addRow(data);
						//System.out.println(dateChooser.getDate().getDate());
				}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
			}
		});
		rb6.addActionListener(new ActionListener() {
			//8월17일
			@Override
			public void actionPerformed(ActionEvent e) {
				
				cinemadate();
				movienum();
				cinemaname();
				jtf4.setText("6관");
				model2.setRowCount(0);
				try {
//					Class.forName("oracle.jdbc.driver.OracleDriver");
//					con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.40.56:1521:xe","system1" ,"1234" );
//					st = con.prepareStatement("select cinematime from cinema_info where cinemaroom = '6관' and cinemadate = ? and cinemaname = ? and movienum = ?");
					con = DBConnect.getConnection();
					sql = "select cinematime from cinema_info where cinemaroom = '6관' and cinemadate = ? and cinemaname = ? and movienum = ?";
					st = con.prepareStatement(sql);
					st.setString(1, cal1);
					st.setString(2, cinemaname1);
					st.setInt(3,movie_name1);
					rs = st.executeQuery();
					while(rs.next()) {
						String cinematime = rs.getString("cinematime");
						Object data [] = {cinematime};
						model2.addRow(data);
						//System.out.println(dateChooser.getDate().getDate());
				}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
			}
		});
	}
	
	protected void reset() {
		rb1.setBorderPainted(true);
		rb1.setContentAreaFilled(true);
		rb1.setFocusPainted(true);
		rb2.setBorderPainted(true);
		rb2.setContentAreaFilled(true);
		rb2.setFocusPainted(true);
		rb3.setBorderPainted(true);
		rb3.setContentAreaFilled(true);
		rb3.setFocusPainted(true);
		rb4.setBorderPainted(true);
		rb4.setContentAreaFilled(true);
		rb4.setFocusPainted(true);
		rb5.setBorderPainted(true);
		rb5.setContentAreaFilled(true);
		rb5.setFocusPainted(true);
		rb6.setBorderPainted(true);
		rb6.setContentAreaFilled(true);
		rb6.setFocusPainted(true);
		
		
	}
	
	protected void buttonclose6() {
		try {
			cinemadate();
			movienum();
			cinemaname();
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//			con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.40.56:1521:xe","system1" ,"1234" );
//			st = con.prepareStatement("select cinematime from cinema_info where cinemaroom = '6관' and cinemadate = ? and cinemaname = ? and movienum = ?");
		
			con = DBConnect.getConnection();
			sql = "select cinematime from cinema_info where cinemaroom = '6관' and cinemadate = ? and cinemaname = ? and movienum = ?";
			st = con.prepareStatement(sql);st.setString(1, cal1);
			
			st.setString(2, cinemaname1);
			st.setInt(3,movie_name1);
			rs = st.executeQuery();
			if(!rs.next()) {
					rb6.setBorderPainted(false);
					rb6.setContentAreaFilled(false);
					rb6.setFocusPainted(false);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	protected void buttonclose5() {
		try {
			cinemadate();
			movienum();
			cinemaname();
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//			con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.40.56:1521:xe","system1" ,"1234" );
//			st = con.prepareStatement("select cinematime from cinema_info where cinemaroom = '5관' and cinemadate = ? and cinemaname = ? and movienum = ?");
			con = DBConnect.getConnection();
			sql = "select cinematime from cinema_info where cinemaroom = '5관' and cinemadate = ? and cinemaname = ? and movienum = ?";
			st = con.prepareStatement(sql);
			
			st.setString(1, cal1);
			st.setString(2, cinemaname1);
			st.setInt(3,movie_name1);
			rs = st.executeQuery();
			if(!rs.next()) {
					rb5.setBorderPainted(false);
					rb5.setContentAreaFilled(false);
					rb5.setFocusPainted(false);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	protected void buttonclose4() {
		try {
			cinemadate();
			movienum();
			cinemaname();
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//			con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.40.56:1521:xe","system1" ,"1234" );
//			st = con.prepareStatement("select cinematime from cinema_info where cinemaroom = '4관' and cinemadate = ? and cinemaname = ? and movienum = ?");
			con = DBConnect.getConnection();
			sql = "select cinematime from cinema_info where cinemaroom = '4관' and cinemadate = ? and cinemaname = ? and movienum = ?";
			st = con.prepareStatement(sql);
			
			st.setString(1, cal1);
			st.setString(2, cinemaname1);
			st.setInt(3,movie_name1);
			rs = st.executeQuery();
			if(!rs.next()) {
					rb4.setBorderPainted(false);
					rb4.setContentAreaFilled(false);
					rb4.setFocusPainted(false);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	protected void buttonclose3() {
		try {
			cinemadate();
			movienum();
			cinemaname();
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//			con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.40.56:1521:xe","system1" ,"1234" );
//			st = con.prepareStatement("select cinematime from cinema_info where cinemaroom = '3관' and cinemadate = ? and cinemaname = ? and movienum = ?");
			con = DBConnect.getConnection();
			sql = "select cinematime from cinema_info where cinemaroom = '3관' and cinemadate = ? and cinemaname = ? and movienum = ?";
			st = con.prepareStatement(sql);
			
			st.setString(1, cal1);
			st.setString(2, cinemaname1);
			st.setInt(3,movie_name1);
			rs = st.executeQuery();
			if(!rs.next()) {
					rb3.setBorderPainted(false);
					rb3.setContentAreaFilled(false);
					rb3.setFocusPainted(false);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	protected void buttonclose2() {
		try {
			cinemadate();
			movienum();
			cinemaname();
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//			con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.40.56:1521:xe","system1" ,"1234" );
//			st = con.prepareStatement("select cinematime from cinema_info where cinemaroom = '2관' and cinemadate = ? and cinemaname = ? and movienum = ?");
			con = DBConnect.getConnection();
			sql = "select cinematime from cinema_info where cinemaroom = '2관' and cinemadate = ? and cinemaname = ? and movienum = ?";
			st = con.prepareStatement(sql);
			
			st.setString(1, cal1);
			st.setString(2, cinemaname1);
			st.setInt(3,movie_name1);
			rs = st.executeQuery();
			if(!rs.next()) {
					rb2.setBorderPainted(false);
					rb2.setContentAreaFilled(false);
					rb2.setFocusPainted(false);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	protected void buttonclose1() {
		try {
			cinemadate();
			movienum();
			cinemaname();
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//			con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.40.56:1521:xe","system1" ,"1234" );
//			st = con.prepareStatement("select cinematime from cinema_info where cinemaroom = '1관' and cinemadate = ? and cinemaname = ? and movienum = ?");
			con = DBConnect.getConnection();
			sql = "select cinematime from cinema_info where cinemaroom = '1관' and cinemadate = ? and cinemaname = ? and movienum = ?";
			st = con.prepareStatement(sql);
			
			st.setString(1, cal1);
			st.setString(2, cinemaname1);
			st.setInt(3,movie_name1);
			rs = st.executeQuery();
			if(!rs.next()) {
					rb1.setBorderPainted(false);
					rb1.setContentAreaFilled(false);
					rb1.setFocusPainted(false);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	protected void cinemaname() {
		if(jtf2.getText().toString().equalsIgnoreCase("CGV동대문")) {
			cinemaname1 = "CGV동대문";
		}else if(jtf2.getText().toString().equalsIgnoreCase("CGV강남")) {
			cinemaname1 = "CGV강남";
		}else if(jtf2.getText().toString().equalsIgnoreCase("CGV건대입구")) {
			cinemaname1 = "CGV건대입구";
		}
		
	}
	public void movienum() {
		if(jtf1.getText().toString().equalsIgnoreCase("헌트")) {
			movie_name1 = 1;
		}else if(jtf1.getText().toString().equalsIgnoreCase("외계+인")) {
			movie_name1 = 2;
		}else if(jtf1.getText().toString().equalsIgnoreCase("한산")) {
			movie_name1 = 3;
		}else if(jtf1.getText().toString().equalsIgnoreCase("탑건:매버릭")) {
			movie_name1 = 4;
		}else if(jtf1.getText().toString().equalsIgnoreCase("미니언즈2")) {
			movie_name1 = 5;
		}else if(jtf1.getText().toString().equalsIgnoreCase("비상선언")) {
			movie_name1 = 6;
		}		
	}
	public void cinemadate() {
		if(jtf3.getText().toString().equalsIgnoreCase("9월1일")) {
			cal1 = "2022/09/01";
		}else if(jtf3.getText().toString().equalsIgnoreCase("9월2일")) {
			cal1 = "2022/09/02";
		}else if(jtf3.getText().toString().equalsIgnoreCase("9월3일")) {
			cal1 = "2022/09/03";
		}		
	}
	public void call() {
		
		model1.setRowCount(0);
		try {
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//			con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.40.56:1521:xe","system1" ,"1234" );
//			st = con.prepareStatement("select distinct cinemaname from cinema_info");
			con = DBConnect.getConnection();
			sql = "select distinct cinemaname from cinema_info";
			st = con.prepareStatement(sql);
			rs = st.executeQuery();
			while(rs.next()) {
				String cinemaname = rs.getString("cinemaname");
				Object data [] = {cinemaname};
				model1.addRow(data);
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}	
		if(jtf1.getText().toString().equalsIgnoreCase("헌트")) {
			add(hunt);
		}else if(jtf1.getText().toString().equalsIgnoreCase("외계+인")) {
			add(alien);
		}else if(jtf1.getText().toString().equalsIgnoreCase("한산")) {
			add(hansan);
		}else if(jtf1.getText().toString().equalsIgnoreCase("탑건:매버릭")) {
			add(topgun);
		}else if(jtf1.getText().toString().equalsIgnoreCase("미니언즈2")) {
			add(mini);
		}else if(jtf1.getText().toString().equalsIgnoreCase("비상선언")) {
			add(bisang);
		}
		
}

		
        
	



	


	public static void main(String[] args) {
		
		new asd();
		
	}

}
