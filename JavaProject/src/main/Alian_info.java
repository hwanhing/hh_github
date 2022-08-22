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

public class Alian_info extends JFrame {

	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Alian_info frame = new Alian_info();
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
	public Alian_info() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton backbutton = new JButton("");
		backbutton.setIcon(new ImageIcon(Alian_info.class.getResource("/img/back3.png")));
		backbutton.setBounds(16, 15, 49, 49);
		contentPane.add(backbutton);
		backbutton.setContentAreaFilled(false);
		backbutton.setBorder(null);
		
		JLabel imgLabel = new JLabel("New label");
		imgLabel.setForeground(Color.WHITE);
		imgLabel.setBackground(Color.WHITE);
		imgLabel.setIcon(new ImageIcon(Alian_info.class.getResource("/img/movie_image_alien.jpg")));
		imgLabel.setBounds(22, 60, 200, 292);
		contentPane.add(imgLabel);
		
		JLabel infoLable_1 = new JLabel("제목 : 외계+인");
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
		
		JLabel infoLable_3_1 = new JLabel("상영시간 : 142분");
		infoLable_3_1.setFont(new Font("Lucida Grande", Font.BOLD, 18));
		infoLable_3_1.setBounds(249, 177, 200, 27);
		contentPane.add(infoLable_3_1);
		
		JLabel infoLable_3_1_1 = new JLabel("[소개]");
		infoLable_3_1_1.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		infoLable_3_1_1.setBounds(249, 207, 200, 27);
		contentPane.add(infoLable_3_1_1);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(Alian_info.class.getResource("/img/tmplogo_small.png")));
		lblNewLabel.setBounds(441, -1, 144, 69);
		contentPane.add(lblNewLabel);
		
		JTextPane textPane = new JTextPane();
		textPane.setFont(new Font("굴림", Font.BOLD, 12));
		textPane.setContentType("Lucida Grande");
		textPane.setText("‘가드’(김우빈)’와 ‘썬더’는 인간의 몸에 가두어진 외계인 죄수를 관리하며 지구에 살고 있다. 어느 날, 서울 상공에 우주선이 나타나고 형사 ‘문도석’(소지섭)은 기이한 광경을 목격하게 되는데 한편, 630년 전 고려에선 얼치기 도사 ‘무륵’(류준열)과 천둥 쏘는 처자 ‘이안’이 엄청난 현상금이 걸린 신검을 차지하기 위해 서로를 속고 속이는 가운데 신검의 비밀을 찾는 신검 쟁탈전에 나선다.");
		textPane.setBounds(249, 230, 321, 118);
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
