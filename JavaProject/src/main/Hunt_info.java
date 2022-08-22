package main;

import java.awt.BorderLayout;
import java.awt.Color;
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

public class Hunt_info extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Hunt_info frame = new Hunt_info();
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
	public Hunt_info() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton backbutton = new JButton("");
		backbutton.setIcon(new ImageIcon(Hunt_info.class.getResource("/img/back3.png")));
		backbutton.setBounds(16, 15, 49, 49);
		contentPane.add(backbutton);
		backbutton.setContentAreaFilled(false);
		backbutton.setBorder(null);
		
		JLabel imgLabel = new JLabel("New label");
		imgLabel.setForeground(Color.WHITE);
		imgLabel.setBackground(Color.WHITE);
		imgLabel.setIcon(new ImageIcon(Hunt_info.class.getResource("/img/movie_image_hunt.jpg")));
		imgLabel.setBounds(22, 60, 200, 290);
		contentPane.add(imgLabel);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(Alian_info.class.getResource("/img/tmplogo_small.png")));
		lblNewLabel.setBounds(441, -1, 144, 69);
		contentPane.add(lblNewLabel);
		
		JLabel infoLable_1 = new JLabel("제목 : 헌트(HUNT)");
		infoLable_1.setFont(new Font("Lucida Grande", Font.BOLD, 18));
		infoLable_1.setBounds(249, 70, 228, 27);
		contentPane.add(infoLable_1);
		
		JLabel infoLable_2 = new JLabel("등급 : 15세 관람가");
		infoLable_2.setFont(new Font("Lucida Grande", Font.BOLD, 18));
		infoLable_2.setBounds(249, 105, 308, 27);
		contentPane.add(infoLable_2);
		
		JLabel infoLable_3 = new JLabel("장르 : 액션");
		infoLable_3.setFont(new Font("Lucida Grande", Font.BOLD, 18));
		infoLable_3.setBounds(249, 142, 129, 27);
		contentPane.add(infoLable_3);
		
		JLabel infoLable_3_1 = new JLabel("상영시간 : 125분");
		infoLable_3_1.setFont(new Font("Lucida Grande", Font.BOLD, 18));
		infoLable_3_1.setBounds(249, 177, 200, 27);
		contentPane.add(infoLable_3_1);
		
		JLabel infoLable_3_1_1 = new JLabel("[소개]");
		infoLable_3_1_1.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		infoLable_3_1_1.setBounds(249, 207, 200, 27);
		contentPane.add(infoLable_3_1_1);
		
		JTextPane textPane = new JTextPane();
		textPane.setFont(new Font("굴림", Font.BOLD, 12));
		textPane.setText("[조직 내 숨어든 스파이를 색출하라! ‘사냥꾼’이 될 것인가, ‘사냥감’이 될 것인가!]망명을 신청한 북한 고위 관리를 통해 정보를 입수한 안기부 해외팀 ‘박평호'와 국내팀 ‘김정도’는 조직 내 숨어든 스파이 ‘동림’ 색출 작전을 시작한다. 스파이를 통해 일급 기밀사항들이 유출되어 위기를 맞게 되자 날 선 대립과 경쟁 속, 해외팀과 국내팀은 상대를 용의선상에 올려두고 조사에 박차를 가한다. ");
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
