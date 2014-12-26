package sql;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionSingleton{
	
	Connection con;
	
	private static ConnectionSingleton comMgr = null;

	private ConnectionSingleton() {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			con = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/demo?user=root&password=password");
		} catch (Exception e) {
			System.out.println("Error loading jdbc driver: " + e);
		}
	}

	public static synchronized ConnectionSingleton getConnectionMgrInstance() {
		if (comMgr == null)
			comMgr = new ConnectionSingleton();
		return comMgr;
	}

	public Connection getConnection() {
		return con;
	}

	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}
	
	public static void main(String args[])throws Exception{
		Connection con = null;
		con = ConnectionSingleton.getConnectionMgrInstance().getConnection();
		if(con != null)
			System.out.println("Success!");
	}
}