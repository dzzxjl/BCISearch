package util;

import java.sql.*;

public class DBUtil {
	private final String DBDRIVER = "com.mysql.jdbc.Driver";
	private final String DBURL = "jdbc:mysql://localhost:3306/breastCancer";
	private final String DBUSER = "root";
	private final String DBPASSWORD = "123456";
	
	private Connection conn = null;
	
	public DBUtil(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			this.conn = DriverManager.getConnection(DBURL,DBUSER,DBPASSWORD);
		} catch (Exception e) {
			System.out.println("database connection fault");
		}
	}
	public Connection getConnection(){
		return conn;
	}
	
	public void close(Connection conn,Statement stat,ResultSet rs){
		if(rs != null){
			try {
				rs.close();
			} catch (SQLException e) {
				System.out.println("���ݿ����ӹر�ʧ�ܣ�");
			}finally{
				if(stat != null){
					try {
						stat.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}finally{
						if(conn != null){
							try {
								conn.close();
							} catch (SQLException e) {
								e.printStackTrace();
							}
						}
					}
				}
			}
		}
	}
	  

}

