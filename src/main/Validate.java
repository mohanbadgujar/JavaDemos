package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Validate {
	public static boolean checkUser(String email, String pass) {

		boolean st = false;
		try {

			// loading drivers for mysql 
			Class.forName("com.mysql.jdbc.Driver");
			
			// creating connection with the database
			Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/LoginForm", "root",
					"bridgeit");

			PreparedStatement ps = con.prepareStatement("select * from LoginDetails where UserName=? and PassWord =?");
			ps.setString(1, email);
			ps.setString(2, pass);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				st = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return st;
	}
}