package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import java.awt.Color;

public class Mini_info extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mini_info frame = new Mini_info();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Mini_info() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton backbutton = new JButton("");
		backbutton.setIcon(new ImageIcon(Mini_info.class.getResource("/img/back3.png")));
		backbutton.setBounds(16, 15, 49, 49);
		contentPane.add(backbutton);
		backbutton.setContentAreaFilled(false);
		backbutton.setBorder(null);
		
		JLabel imgLabel = new JLabel("New label");
		imgLabel.setForeground(Color.WHITE);
		imgLabel.setBackground(Color.WHITE);
		imgLabel.setIcon(new ImageIcon(Mini_info.class.getResource("/img/movie_image_mini.jpg")));
		imgLabel.setBounds(22, 60, 200, 290);
		contentPane.add(imgLabel);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(Alian_info.class.getResource("/img/tmplogo_small.png")));
		lblNewLabel.setBounds(441, -1, 144, 69);
		contentPane.add(lblNewLabel);
		
		JLabel infoLable_1 = new JLabel("제목 : 미니언즈2");
		infoLable_1.setFont(new Font("Lucida Grande", Font.BOLD, 18));
		infoLable_1.setBounds(249, 70, 228, 27);
		contentPane.add(infoLable_1);
		
		JLabel infoLable_2 = new JLabel("등급 : 전체 관람가");
		infoLable_2.setFont(new Font("Lucida Grande", Font.BOLD, 18));
		infoLable_2.setBounds(249, 105, 308, 27);
		contentPane.add(infoLable_2);
		
		JLabel infoLable_3 = new JLabel("장르 : 애니메이션");
		infoLable_3.setFont(new Font("Lucida Grande", Font.BOLD, 18));
		infoLable_3.setBounds(249, 142, 200, 27);
		contentPane.add(infoLable_3);
		
		JLabel infoLable_3_1 = new JLabel("상영시간 : 87분");
		infoLable_3_1.setFont(new Font("Lucida Grande", Font.BOLD, 18));
		infoLable_3_1.setBounds(249, 177, 200, 27);
		contentPane.add(infoLable_3_1);
		
		JLabel infoLable_3_1_1 = new JLabel("[소개]");
		infoLable_3_1_1.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		infoLable_3_1_1.setBounds(249, 207, 200, 27);
		contentPane.add(infoLable_3_1_1);
		
		JTextPane textPane = new JTextPane();
		textPane.setFont(new Font("굴림", Font.BOLD, 12));
		textPane.setText("세계 최고의 슈퍼 악당을 꿈꾸는 미니보스 ‘그루’와 그를 따라다니는 미니언들. 어느 날 그루는 최고의 악당 조직 ‘빌런6’의 마법 스톤을 훔치는데 성공하지만 뉴페이스 미니언 ‘오토’의 실수로 스톤을 잃어버리고 빌런6에게 납치까지 당한다. 미니보스를 구하기 위해 잃어버린 스톤을 되찾아야 하는 ‘오토’극장가를 점령할 MCU(미니언즈 시네마틱 유니버스)가 돌아온다!");
		textPane.setBounds(249, 231, 313, 116);
		contentPane.add(textPane);
		
		// 뒤로가기 버튼 이벤트
		backbutton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
						setVisible(false);
					}
				});
	}

}
