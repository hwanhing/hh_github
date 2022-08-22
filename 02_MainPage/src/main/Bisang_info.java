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

public class Bisang_info extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Bisang_info frame = new Bisang_info();
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
	public Bisang_info() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton backbutton = new JButton("");
		backbutton.setIcon(new ImageIcon(Bisang_info.class.getResource("/img/back3.png")));
		backbutton.setBounds(16, 15, 49, 49);
		contentPane.add(backbutton);
		backbutton.setContentAreaFilled(false);
		backbutton.setBorder(null);
		
		JLabel imgLabel = new JLabel("New label");
		imgLabel.setForeground(Color.WHITE);
		imgLabel.setBackground(Color.WHITE);
		imgLabel.setIcon(new ImageIcon(Topgun_info.class.getResource("/img/movie_image_topgun.jpg")));
		imgLabel.setBounds(22, 60, 200, 290);
		contentPane.add(imgLabel);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(Alian_info.class.getResource("/img/tmplogo_small.png")));
		lblNewLabel.setBounds(441, -1, 144, 69);
		contentPane.add(lblNewLabel);
		
		JLabel infoLable_1 = new JLabel("제목 : 비상선언");
		infoLable_1.setFont(new Font("Lucida Grande", Font.BOLD, 18));
		infoLable_1.setBounds(249, 70, 228, 27);
		contentPane.add(infoLable_1);
		
		JLabel infoLable_2 = new JLabel("등급 : 12세 관람가");
		infoLable_2.setFont(new Font("Lucida Grande", Font.BOLD, 18));
		infoLable_2.setBounds(249, 105, 308, 27);
		contentPane.add(infoLable_2);
		
		JLabel infoLable_3 = new JLabel("장르 : 드라마");
		infoLable_3.setFont(new Font("Lucida Grande", Font.BOLD, 18));
		infoLable_3.setBounds(249, 142, 129, 27);
		contentPane.add(infoLable_3);
		
		JLabel infoLable_3_1 = new JLabel("상영시간 : 140분");
		infoLable_3_1.setFont(new Font("Lucida Grande", Font.BOLD, 18));
		infoLable_3_1.setBounds(249, 177, 200, 27);
		contentPane.add(infoLable_3_1);
		
		JLabel infoLable_3_1_1 = new JLabel("[소개]");
		infoLable_3_1_1.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		infoLable_3_1_1.setBounds(249, 207, 200, 27);
		contentPane.add(infoLable_3_1_1);
		
		JTextPane textPane = new JTextPane();
		textPane.setFont(new Font("굴림", Font.BOLD, 12));
		textPane.setText("베테랑 형사 팀장 인호(송강호)는 비행기 테러 예고 영상 제보를 받고 사건을 수사하던 중 용의자가 실제로 KI501 항공편에 타고 있음을 파악한다. 딸의 치료를 위해 비행 공포증임에도 불구하고 하와이로 떠나기로 한 재혁(이병헌)은 주변을 맴돌며 위협적인 말을 하는 낯선 이가 신경 쓰인다. 인천에서 하와이로 이륙한 KI501 항공편비행기 안은 물론 지상까지 혼란과 두려움의 현장으로 뒤바뀐다.");
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
