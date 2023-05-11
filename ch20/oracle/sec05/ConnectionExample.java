package ch20.oracle.sec05;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionExample {

	public static void main(String[] args) {
	String driver = "oracle.jbdc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:ex";
	String userid = "박태선";
	String passwd = "12345";
	
	Connection con = null;
	Statement stmt = null;
	ResultSet rs = null;
	
	try {
		Class.forName(driver);
		con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ex","박태선","12345");
		String sql = "select drptno, dname, loc from dept";
		stmt = con.createStatement();
		rs = stmt.executeQuery(sql);
		while(rs.next()) {
		int deptno = rs.getInt("deptno");
		String dname = rs.getString("dname");
		String loc = rs.getString("loc");
		System.out.println(deptno + "\t" + dname + "\t"+ loc);}
	}catch(ClassNotFoundException e) {
		e.getStackTrace();
	}catch(SQLException e) {
		e.getStackTrace();}
	finally {
		try {
			if(rs!=null) rs.close();
			if(stmt!=null)stmt.close();
			if(con!=null)con.close();
		}catch(SQLException e) {
			e.getStackTrace();
		}
	}
	

	}

}

