package pay;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import login.SignIn;
import login.LoginMember_DTO;
import javax.swing.*;

public class PaymentCheckPage extends JFrame{
	
	ImageIcon icon_back;
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	String sql;
	
	JTextField jtf1;
	JTextField jtf2;
	String cardNum;
	int cardPwd;
	
	public PaymentCheckPage() {
		
		setTitle("카드번호 확인");
		
		JPanel container1 = new JPanel();
		JPanel container2 = new JPanel();
		JPanel container3 = new JPanel();
		JPanel container_center = new JPanel(new BorderLayout());
		JPanel container_back = new JPanel(new FlowLayout(FlowLayout.LEFT));
		
		container_back.setBackground(Color.WHITE);
		container1.setBackground(Color.WHITE);
		container2.setBackground(Color.WHITE);
		container3.setBackground(Color.WHITE);
		container_center.setBackground(Color.WHITE);
		
		//상단 뒤로가기
		icon_back = new ImageIcon("src/img/back3.png");
		JButton button_back = new JButton();
		button_back.setIcon(icon_back);
		button_back.setBorder(null);
		button_back.setContentAreaFilled(false);
		button_back.setPreferredSize(new Dimension(24,20));
		
		//중단
		JLabel jl1 = new JLabel("카드번호 : ");
		jtf1 = new JTextField(10);
		
		JLabel jl2 = new JLabel("비밀번호 : ");
		jtf2 = new JTextField(10);
		
		//하단
		JButton button1 = new JButton("결  제");
		
		//컨테이너에 추가
		container_back.add(button_back);
		container1.add(jl1);container1.add(jtf1);
		container2.add(jl2);container2.add(jtf2);
		container3.add(button1);
		
		container_center.add(container1,BorderLayout.NORTH);
		container_center.add(container2,BorderLayout.CENTER);
		
		add(container_back,BorderLayout.NORTH);
		add(container_center,BorderLayout.CENTER);
		add(container3,BorderLayout.SOUTH);
		
		setBounds(100,100,300,200);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setVisible(true);
		
		
		//뒤로가기
		button_back.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				new PaymentPage();// 좌석선택페이지 클래스로 이동
				setVisible(false);
			
			}
		});
		
		//결제
		button1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(null, "정말로 결제하시겠습니까?","확인",JOptionPane.YES_NO_OPTION);
				
				
				if(result == JOptionPane.YES_OPTION) {
					
					
					
					//로그인 했을 때 저장된 정보를 조회해서 입력한 정보와 같은지 비교 
					if(jtf1.getText().equals(LoginMember_DTO.getCardNum()) && Integer.parseInt(jtf2.getText()) == LoginMember_DTO.getCardPwd()) {
						
						//예메정보 ticket_table에 저장
						int res = insert();
						if(res>0) {
							JOptionPane.showMessageDialog(null, "결제 완료");
							// 메인 페이지 클래스로 이동
							EventQueue.invokeLater(new Runnable() {
								public void run() {
									try {
										SignIn window = new SignIn();
										window.frame.setVisible(true);
									} catch (Exception e) {
										e.printStackTrace();
									}
								}
							});		
							
							dispose();
						}else {
							JOptionPane.showMessageDialog(null, "error");
						}
					}else {
						JOptionPane.showMessageDialog(null, "잘못된 정보를 입력했습니다.");
					}
				}
			}
		});
	}
	
	int insert() {
		sql = "INSERT INTO ticket_info VALUES(?,?)";
		int res = -1;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "1111");//임시
			pstmt.setString(2, "1111");//임시
			
			res = pstmt.executeUpdate();
			
			con.close();pstmt.close();
			
			return res;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
		 
	}
	
}
