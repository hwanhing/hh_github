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

public class Hansan_info extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Hansan_info frame = new Hansan_info();
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
	public Hansan_info() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600 , 400);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton backbutton = new JButton("");
		backbutton.setIcon(new ImageIcon(Hansan_info.class.getResource("/img/back3.png")));
		backbutton.setBounds(16, 15, 49, 49);
		contentPane.add(backbutton);
		backbutton.setContentAreaFilled(false);
		backbutton.setBorder(null);
		
		JLabel imgLabel = new JLabel("New label");
		imgLabel.setForeground(Color.WHITE);
		imgLabel.setBackground(Color.WHITE);
		imgLabel.setIcon(new ImageIcon(Hansan_info.class.getResource("/img/movie_image_hansan.jpg")));
		imgLabel.setBounds(22, 60, 200, 290);
		contentPane.add(imgLabel);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(Alian_info.class.getResource("/img/tmplogo_small.png")));
		lblNewLabel.setBounds(441, -1, 144, 69);
		contentPane.add(lblNewLabel);
		
		JLabel infoLable_1 = new JLabel("제목 : 한산");
		infoLable_1.setFont(new Font("Lucida Grande", Font.BOLD, 18));
		infoLable_1.setBounds(249, 70, 228, 27);
		contentPane.add(infoLable_1);
		
		JLabel infoLable_2 = new JLabel("등급 : 12세 관람가");
		infoLable_2.setFont(new Font("Lucida Grande", Font.BOLD, 18));
		infoLable_2.setBounds(249, 105, 308, 27);
		contentPane.add(infoLable_2);
		
		JLabel infoLable_3 = new JLabel("장르 : 액션");
		infoLable_3.setFont(new Font("Lucida Grande", Font.BOLD, 18));
		infoLable_3.setBounds(249, 142, 129, 27);
		contentPane.add(infoLable_3);
		
		JLabel infoLable_3_1 = new JLabel("상영시간 : 129분");
		infoLable_3_1.setFont(new Font("Lucida Grande", Font.BOLD, 18));
		infoLable_3_1.setBounds(249, 177, 200, 27);
		contentPane.add(infoLable_3_1);
		
		JLabel infoLable_3_1_1 = new JLabel("[소개]");
		infoLable_3_1_1.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		infoLable_3_1_1.setBounds(249, 207, 200, 27);
		contentPane.add(infoLable_3_1_1);
		
		JTextPane textPane = new JTextPane();
		textPane.setFont(new Font("굴림", Font.BOLD, 12));
		textPane.setText("1592년 4월, 조선은 임진왜란 발발 후 단 15일 만에 왜군에 한양을 빼앗기며 절체절명의 위기에 놓인다. 조선을 단숨에 점령한 왜군은 명나라로 향하는 야망을 꿈꾸며 대규모 병역을 부산포로 집결시킨다. 한편, 이순신 장군은 연이은 전쟁의 패배와 선조마저 의주로 파천하며 수세에 몰린 상황에서도 조선을 구하기 위해 전술을 고민하며 출전을 준비한다. ");
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
