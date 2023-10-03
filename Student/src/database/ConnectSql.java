package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectSql {
	public static Connection getConnection(String url,String user,String password)throws Exception
	{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection(url,user,password);
		return con;
	}
	public static void createTable(String sqlQuery,Connection con) throws SQLException
	{
		Statement statement = con.createStatement();
        String createTableSQL = sqlQuery;
        statement.executeUpdate(createTableSQL);
        statement.close();
	}
	public static ResultSet select(String seleQuery,Connection con) throws SQLException
	{
		Statement st=con.createStatement();
		ResultSet rs= st.executeQuery(seleQuery);
		return rs;
//		while(rs.next()) {
//			String name=rs.getInt(1)+" : "+rs.getString(2)+" : "+rs.getString(3);
//			System.out.println(name);
//			}
	}
}

