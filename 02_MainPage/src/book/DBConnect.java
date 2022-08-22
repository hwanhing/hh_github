package book;

import java.sql.Connection;
import java.sql.DriverManager;


/*
 * 
 * 클래스명 : DBConnect 
 * DBConnect.getConnection();
 *
 */

public class DBConnect {


	public static Connection getConnection() {
	
			Connection con = null;
		
		// 윈도우용 
			 String driver = "oracle.jdbc.driver.OracleDriver";	
			 String url = "jdbc:oracle:thin:@192.168.40.56:1521:xe";
			 String user = "system1";
			 String pwd = "1234";
			
//			 String url = "jdbc:oracle:thin:@localhost:1521:xe"; 
		
//		// 오라클 개인 주소값(맥)
//			String driver = "oracle.jdbc.driver.OracleDriver";
//			String url = "jdbc:oracle:thin:@SYSTEM_high?TNS_ADMIN=/Users/hye/oraclewallet/Wallet_system";
//			String userid = "admin";
//			String pwd = "Asdfghjklzxc0";
	
		// 오라클 드라이버 로딩 및 데이터 베이스 연결 
		try {
			/* 1단계 오라클 드라이버 로딩 */
			Class.forName(driver);
			
			/* 2단계 : 데이터베이스 연결 및 준비 */
 	        con = DriverManager.getConnection(url, user, pwd); 
 	        // System.out.println("오라클 로딩, 데이터베이스 연결 완료!");
 	        
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return con;
			
			
		
	}
	

}

