package sandbox.lockc.javacert.jdbc;

import java.sql.*;
import java.util.Enumeration;

public class JDBCDriverManager {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		
		String url = "jdbc:sqlite:src/main/resources/recipes.db";
		
		Class.forName("org.sqlite.JDBC");
		
		Driver sqlLiteDriver = DriverManager.getDriver(url);
		System.out.println(sqlLiteDriver.toString());
		System.out.println(sqlLiteDriver.getMajorVersion() + "." + sqlLiteDriver.getMinorVersion());
		System.out.println(sqlLiteDriver.jdbcCompliant());
		
		
		Enumeration<Driver> drivers = DriverManager.getDrivers();
		while(drivers.hasMoreElements()) {
			Driver driver = drivers.nextElement();
			System.out.println(driver.toString());
		}
		
		
		
		
		Connection conn = DriverManager.getConnection(url);
		
		String sql = "select * from recipes";
		
		PreparedStatement ps = conn.prepareStatement(
				sql, ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
		
		
		
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			System.out.println(rs.getInt(1));
		}
		rs.close();
		
		
		
		boolean res = ps.execute();
		rs = ps.getResultSet();
		System.out.println(ps.getUpdateCount());
		while(rs.next()) {
			System.out.println(rs.getInt(1));
		}
		rs.close();
		
		
		ps.close();
		conn.close();
		
	}

}
