package main;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import book.asd;
import login.LoginMember_DTO;
import login.SignIn;
import login.SignUp;
import pay.PaymentPage;

public class Mainpage extends JFrame {
	int movieNum = 0;
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String sql;
	String namelabel = null;
	asd asd = null;
	public JFrame frame;
	
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mainpage frame = new Mainpage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	// 메인화면 ---------------------------------------------------------------------------
	public Mainpage() {
		MainFrame();
	}
		void MainFrame() {
		setTitle("메인화면");

		getContentPane().setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500,90 , 700, 900);
		getContentPane().setLayout(null);
		
		JButton inbutton = new JButton("영화관람권\r티켓");
		inbutton.setIcon(new ImageIcon(Mainpage.class.getResource("/img/ticket_logo1.png")));
		inbutton.setBackground(Color.WHITE);
		inbutton.setForeground(Color.WHITE);
		inbutton.setFont(new Font("HY헤드라인M", Font.PLAIN, 13));
		inbutton.setBounds(577, 25, 96, 85);
		getContentPane().add(inbutton);
		inbutton.setBorder(null); 					// 버튼 테두리 없애는것.
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 131, 684, 745);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		// 영화 한트 이미지.
		JLabel hunt = new JLabel("영화 한트");
		hunt.setIcon(new ImageIcon(Mainpage.class.getResource("/img/movie_image_hunt.jpg")));
		hunt.setBounds(23, 15, 194, 260);
		panel.add(hunt);
		
		//영화 외계+인 이미지.
		JLabel alien = new JLabel("영화 외계+인");
		alien.setIcon(new ImageIcon(Mainpage.class.getResource("/img/movie_image_alien.jpg")));
		alien.setBounds(244, 15, 194, 260);
		panel.add(alien);
	
		//영화 한산 이미지.
		JLabel hansan = new JLabel("영화 한산");
		hansan.setIcon(new ImageIcon(Mainpage.class.getResource("/img/movie_image_hansan.jpg")));
		hansan.setBounds(466, 15, 194, 260);
		panel.add(hansan);
		
		//영화 탑건 이미지.
		JLabel topgun = new JLabel("영화 탑건");
		topgun.setIcon(new ImageIcon(Mainpage.class.getResource("/img/movie_image_topgun.jpg")));
		topgun.setBounds(23, 374, 194, 260);
		panel.add(topgun);
		
		//영화 미니언즈2 이미지.
		JLabel mini = new JLabel("영화 미니언즈2");
		mini.setIcon(new ImageIcon(Mainpage.class.getResource("/img/movie_image_mini.jpg")));
		mini.setBounds(244, 374, 194, 260);
		panel.add(mini);
		
		
		//영화 비상선언 이미지.
		JLabel bisang = new JLabel("영화 비상선언");
		bisang.setIcon(new ImageIcon(Mainpage.class.getResource("/img/movie_image_bisang.jpg")));
		bisang.setBounds(466, 374, 194, 260);
		panel.add(bisang);
		
		
		JButton button_1 = new JButton("예매하기");
		button_1.setForeground(new Color(255, 255, 255));
		button_1.setBackground(new Color(255, 69, 0));
		button_1.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		button_1.setBounds(36, 326, 165, 31);
		panel.add(button_1);
		button_1.setBorder(null); 
		
		JButton button_2 = new JButton("예매하기");
		button_2.setForeground(new Color(255, 255, 255));
		button_2.setBackground(new Color(255, 69, 0));
		button_2.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		button_2.setBounds(263, 326, 165, 31);
		panel.add(button_2);
		button_2.setBorder(null); 
		
		JButton button_3 = new JButton("예매하기");
		button_3.setForeground(new Color(255, 255, 255));
		button_3.setBackground(new Color(255, 69, 0));
		button_3.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		button_3.setBounds(482, 326, 165, 31);
		panel.add(button_3);
		button_3.setBorder(null); 
		
		JButton button_4 = new JButton("예매하기");
		button_4.setForeground(Color.WHITE);
		button_4.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		button_4.setBackground(new Color(255, 69, 0));
		button_4.setBounds(36, 684, 165, 31);
		panel.add(button_4);
		button_4.setBorder(null); 
		
		JButton button_5 = new JButton("예매하기");
		button_5.setForeground(Color.WHITE);
		button_5.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		button_5.setBackground(new Color(255, 69, 0));
		button_5.setBounds(263, 684, 165, 31);
		panel.add(button_5);
		button_5.setBorder(null); 
		
		
		JButton button_6 = new JButton("예매하기");
		button_6.setForeground(Color.WHITE);
		button_6.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		button_6.setBackground(new Color(255, 69, 0));
		button_6.setBounds(482, 684, 165, 31);
		panel.add(button_6);
		button_6.setBorder(null); 
		
		JButton button_1_1 = new JButton("상세보기");
		button_1_1.setForeground(Color.WHITE);
		button_1_1.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		button_1_1.setBackground(new Color(255, 69, 0));
		button_1_1.setBounds(36, 285, 165, 31);
		panel.add(button_1_1);
		button_1_1.setBorder(null); 
		
		JButton button_1_2 = new JButton("상세보기");
		button_1_2.setForeground(Color.WHITE);
		button_1_2.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		button_1_2.setBackground(new Color(255, 69, 0));
		button_1_2.setBounds(263, 285, 165, 31);
		panel.add(button_1_2);
		button_1_2.setBorder(null); 
		
		JButton button_1_3 = new JButton("상세보기");
		button_1_3.setForeground(Color.WHITE);
		button_1_3.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		button_1_3.setBackground(new Color(255, 69, 0));
		button_1_3.setBounds(482, 285, 165, 31);
		panel.add(button_1_3);
		button_1_3.setBorder(null); 
		
		JButton button_1_4 = new JButton("상세보기");
		button_1_4.setForeground(Color.WHITE);
		button_1_4.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		button_1_4.setBackground(new Color(255, 69, 0));
		button_1_4.setBounds(36, 644, 165, 31);
		panel.add(button_1_4);
		button_1_4.setBorder(null); 
		
		JButton button_1_5 = new JButton("상세보기");
		button_1_5.setForeground(Color.WHITE);
		button_1_5.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		button_1_5.setBackground(new Color(255, 69, 0));
		button_1_5.setBounds(263, 644, 165, 31);
		panel.add(button_1_5);
		button_1_5.setBorder(null); 
		
		JButton button_1_6 = new JButton("상세보기");
		button_1_6.setForeground(Color.WHITE);
		button_1_6.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		button_1_6.setBackground(new Color(255, 69, 0));
		button_1_6.setBounds(482, 644, 165, 31);
		panel.add(button_1_6);
		button_1_6.setBorder(null); 
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Mainpage.class.getResource("/img/tmplogo.png")));
		lblNewLabel.setBounds(22, 15, 213, 98);
		getContentPane().add(lblNewLabel);
		
		JLabel namelabel = new JLabel("New label");
		namelabel.setBounds(449, 46, 109, 35);
		getContentPane().add(namelabel);

		// 로그인된 회원정보 라벨에 불러오기.
		LoginMember_DTO dto = new LoginMember_DTO();
		String name = (dto.getMemberName() + "님");
		namelabel.setText(name);
		namelabel.setFont(new Font("HY헤드라인M", Font.PLAIN, 18));
		
		JButton loginoutbtn = new JButton("로그아웃");
		loginoutbtn.setFont(new Font("HY헤드라인M", Font.PLAIN, 12));
		loginoutbtn.setBounds(397, 81, 157, 23);
		getContentPane().add(loginoutbtn);
		loginoutbtn.setBorder(null);
		loginoutbtn.setContentAreaFilled(false);
		
		// 로그아웃 버튼 이벤트처리
		loginoutbtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				SignIn signin = new SignIn();
				SignIn.main(null);
				setVisible(false);
			}
		});
		
		// 이벤트 처리 (헌트 영화 예매하기) ----------------------------------------------------------------------
		button_1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            	int result = JOptionPane.showConfirmDialog(null, "정말로 영화 '헌트(HUNT)'를 예매하시겠습니까?", "확인", JOptionPane.YES_NO_OPTION);
                // 예매하기 버튼을 눌렀을 때 예매페이지로 넘어감.
            	if(result == JOptionPane.YES_OPTION) {
    				asd asd = new asd();
    				asd.jtf1.setText("헌트");
    				asd.call();
    				setVisible(false);
            	}else {
            		MainFrame();
            	}
            }
        });
		
		// 이벤트 처리 (외게인 영화 예매하기)
		button_2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	int result = JOptionPane.showConfirmDialog(null, "정말로 영화 '외계+인'를 예매하시겠습니까?", "확인", JOptionPane.YES_NO_OPTION);
                // 예매하기 버튼을 눌렀을 때 예매페이지로 넘어감.
            	if(result == JOptionPane.YES_OPTION) {
    				asd asd = new asd();
    				asd.jtf1.setText("외계+인");
    				asd.call();
    				setVisible(false);
            	}else {
            		MainFrame();
            	}
            }
		});

		// 이벤트 처리 (한산 영화 예매하기)
		button_3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	int result = JOptionPane.showConfirmDialog(null, "정말로 영화 '한산'를 예매하시겠습니까?", "확인", JOptionPane.YES_NO_OPTION);
                // 예매하기 버튼을 눌렀을 때 예매페이지로 넘어감.
            	if(result == JOptionPane.YES_OPTION) {
    				asd asd = new asd();
    				asd.jtf1.setText("한산");
    				asd.call();
    				setVisible(false);
            	}else {
            		MainFrame();
            	}
            }
		});
            
		
		// 이벤트 처리 (탑건 영화 예매하기)
		button_4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	int result = JOptionPane.showConfirmDialog(null, "정말로 영화 '탑건:매버릭'를 예매하시겠습니까?", "확인", JOptionPane.YES_NO_OPTION);
                // 예매하기 버튼을 눌렀을 때 예매페이지로 넘어감.
            	if(result == JOptionPane.YES_OPTION) {
    				asd asd = new asd();
    				asd.jtf1.setText("탑건:매버릭");
    				asd.call();
    				setVisible(false);
            	}else {
            		MainFrame();
            	}
            }
		});
            

		// 이벤트 처리 (미니언즈2 영화 예매하기)
		button_5.addActionListener(new ActionListener() {
			
            @Override
            public void actionPerformed(ActionEvent e) {
            	int result = JOptionPane.showConfirmDialog(null, "정말로 영화 '미니언즈2'를 예매하시겠습니까?", "확인", JOptionPane.YES_NO_OPTION);
                // 예매하기 버튼을 눌렀을 때 예매페이지로 넘어감.
            	if(result == JOptionPane.YES_OPTION) {
    				asd asd = new asd();
    				asd.jtf1.setText("미니언즈2");
    				asd.call();
    				setVisible(false);
            	}else {
            		MainFrame();
            	}
            }
		});

		// 이벤트 처리 (비상선언 영화 예매하기)
		button_6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	int result = JOptionPane.showConfirmDialog(null, "정말로 영화 '비상선언'를 예매하시겠습니까?", "확인", JOptionPane.YES_NO_OPTION);
                // 예매하기 버튼을 눌렀을 때 예매페이지로 넘어감.
            	if(result == JOptionPane.YES_OPTION) {
    				asd asd = new asd();
    				asd.jtf1.setText("비상선언");
    				asd.call();
    				setVisible(false);
            	}else {
            		MainFrame();
            	}
            }
		});

		// 이벤트 처리 (헌트 상세보기) ----------------------------------------------------------------------
		button_1_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
//				// 예매하기 버튼을 눌렀을 때 예매페이지로 넘어감.
//				 UIManager.put("OptionPane.messageFont", new FontUIResource(new Font(  
//				          "Lucida Grande", Font.BOLD, 15)));
//				JOptionPane.showMessageDialog(null, "영화제목 : 헌트(HUNT)"+"\n"+"관람연령 : 15세 관람가"+"\n"+"상영시간 : 125분"+"\n"+"장르 : 액션"
//										, "상세보기", JOptionPane.PLAIN_MESSAGE);
				Hunt_info.main(null);

			}
		});
		
		// 이벤트 처리 (외계인 상세보기)
		button_1_2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
//				// 예매하기 버튼을 눌렀을 때 예매페이지로 넘어감.
//				 UIManager.put("OptionPane.messageFont", new FontUIResource(new Font(  
//				          "Lucida Grande", Font.BOLD, 15)));
//				JOptionPane.showMessageDialog(null, "영화제목 : 외계+인"+"\n"+"관람연령 : 12세 관람가"+"\n"+"상영시간 : 142분"+"\n"+"장르 : 액션"
//										, "상세보기", JOptionPane.PLAIN_MESSAGE);
				Alian_info.main(null);
			
			}
		});

		// 이벤트 처리 (한산 상세보기)
		button_1_3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// 예매하기 버튼을 눌렀을 때 예매페이지로 넘어감.
//				 UIManager.put("OptionPane.messageFont", new FontUIResource(new Font(  
//				          "Lucida Grande", Font.BOLD, 15)));
//				JOptionPane.showMessageDialog(null, "영화제목 : 한산"+"\n"+"관람연령 : 12세 관람가"+"\n"+"상영시간 : 129분"+"\n"+"장르 : 액션"
//										, "상세보기", JOptionPane.PLAIN_MESSAGE);
				Hansan_info.main(null);
			}
		});
	
		// 이벤트 처리 (탑건 상세보기)
		button_1_4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// 예매하기 버튼을 눌렀을 때 예매페이지로 넘어감.
//				 UIManager.put("OptionPane.messageFont", new FontUIResource(new Font(  
//				          "Lucida Grande", Font.BOLD, 15)));
//				JOptionPane.showMessageDialog(null, "영화제목 : 탑건:메버릭"+"\n"+"관람연령 : 12세 관람가"+"\n"+"상영시간 : 130분"+"\n"+"장르 : 액션"
//										, "상세보기", JOptionPane.PLAIN_MESSAGE);
				Topgun_info.main(null);
			}
		});

		// 이벤트 처리 (미니언즈2 상세보기)
		button_1_5.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
//				 UIManager.put("OptionPane.messageFont", new FontUIResource(new Font(  
//				          "Lucida Grande", Font.BOLD, 15)));
//				JOptionPane.showMessageDialog(null, "영화제목 : 미니언즈2"+"\n"+"관람연령 : 전체 관람가"+"\n"+"상영시간 : 87분"+"\n"+"장르 : 애니메이션"
//										, "상세보기", JOptionPane.PLAIN_MESSAGE);
				Mini_info.main(null);
			}
		});
		
		// 이벤트 처리 (비상선언 상세보기)
		button_1_6.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// 예매하기 버튼을 눌렀을 때 예매페이지로 넘어감.
//				 UIManager.put("OptionPane.messageFont", new FontUIResource(new Font(  
//				          "Lucida Grande", Font.BOLD, 15)));
//				JOptionPane.showMessageDialog(null, "영화제목 : 비상선언"+"\n"+"관람연령 : 12세 관람가"+"\n"+"상영시간 : 140분"+"\n"+"장르 : 드라마"
//										, "상세보기", JOptionPane.PLAIN_MESSAGE);
				Bisang_info.main(null);
			
			}
		});
		
		//예매확인 이벤트 처리
		inbutton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				PaymentPage page = new PaymentPage();
				
				
			}
			
		});
	}

}
