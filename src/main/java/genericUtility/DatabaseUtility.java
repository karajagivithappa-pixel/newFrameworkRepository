package genericUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import org.testng.annotations.Listeners;

import com.mysql.jdbc.Driver;

public class DatabaseUtility {
	public Connection getDbConnection(String url,String userName,String password)throws Exception {
		Driver d=new Driver();
		DriverManager.registerDriver(d);
		return DriverManager.getConnection(url,userName,password);
	}
	
	public boolean validateDataEntry(String url,String userName,String password,String tableName,String colname,String value) throws Exception {
		Connection c=getDbConnection(url,userName,password);
		Statement st = c.createStatement();
		return st.execute("select * from "+tableName+" where "+colname+"='"+value+"';");
	}
}
