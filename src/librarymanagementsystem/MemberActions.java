package librarymanagementsystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Random;
import java.util.Scanner;

public class MemberActions {
	Scanner sc=new Scanner(System.in);
	public void registerMember(LibraryMember member) {
		String sql="insert into user(name,age,email,contact,password) values(?,?,?,?,?)";
		try {
			Connection con=DatabaseConnection.getConnection();
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, member.getName());
            ps.setInt(2, member.getAge());
            ps.setString(3, member.getEmail());
            ps.setLong(4, member.getContact());
            ps.setString(5, member.getPassword());
            ps.execute();
            System.out.println("Registration successfully");
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println("Registration failed");
		}
	}
	public void loginWithEmail(String email,String password) {
		String sql = "SELECT * FROM user WHERE email=? AND password=?";
		try {
			Connection con=DatabaseConnection.getConnection();
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs=ps.executeQuery();
            if(rs.next()) {
            	System.out.println("Login successful");
            }else {
            	System.out.println("Details mismatch");
            }
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println("Login failed");
		}
	}
	public void loginWithContact(long contact) {
		String sql = "SELECT * FROM user WHERE contact=?";
		try {
			Connection con=DatabaseConnection.getConnection();
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setLong(1, contact);
            ResultSet rs = ps.executeQuery();
            Random ran=new Random();
			int otp=ran.nextInt(10000);
			System.out.println(otp);
			System.out.println("Enter the otp");
			int otp1=sc.nextInt();
            if(rs.next()&&otp==otp1) {
            	System.out.println("Login successful");
            }
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println("Login failed");
		}
	}
}
