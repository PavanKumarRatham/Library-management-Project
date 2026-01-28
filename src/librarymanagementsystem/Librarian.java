package librarymanagementsystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Random;
import java.util.Scanner;

public class Librarian {
	Scanner sc=new Scanner(System.in);
	public void loginWithEmail(String email,String password) {
		String sql = "SELECT * FROM admin WHERE email=? AND password=?";
		try {
			Connection con=DatabaseConnection.getConnection();
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs=ps.executeQuery();
            if(rs.next()) {
            	System.out.println("Login successful");
            	boolean flag=true;
            	while(flag) {
            		System.out.println("1:viewAllMembers\n2:findMember\n3:deleteMember\n4:Exit");
            		System.out.println("Enter the choice");
            		int choice=sc.nextInt();
            		switch(choice) {
            			case 1:{
            				viewAllMembers();
            				break;
            			}
            			case 2:{
            				System.out.println("Enter the person mobile no to find");
            				long mobile=sc.nextLong();
            				findMember(mobile);
            				break;
            			}
            			case 3:{
            				System.out.println("Enter the person email no to find");
            				String email1=sc.next();
            				deleteMember(email1);
            				break;
            			}
            			case 4:{
            				flag=false;
            				break;
            			}
            			default:{
            				System.out.println("Enter btw 1 and 4");
            			}
            		}
            	}
            }
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println("Login failed");
		}
	}
	public void loginWithContact(long contact) {
		String sql = "SELECT * FROM admin WHERE contact=?";
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
            	boolean flag=true;
            	while(flag) {
            		System.out.println("1:viewAllMembers\n2:findMember\n3:deleteMember\n4:Exit");
            		System.out.println("Enter the choice");
            		int choice=sc.nextInt();
            		switch(choice) {
            			case 1:{
            				viewAllMembers();
            				break;
            			}
            			case 2:{
            				System.out.println("Enter the person mobile no to find");
            				long mobile=sc.nextLong();
            				findMember(mobile);
            				break;
            			}
            			case 3:{
            				System.out.println("Enter the person email no to find");
            				String email1=sc.next();
            				deleteMember(email1);
            				break;
            			}
            			case 4:{
            				flag=false;
            				break;
            			}
            			default:{
            				System.out.println("Enter btw 1 and 4");
            			}
            		}
            	}
            }
            else {
            	System.out.println("OTP Mismatch");
            }
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println("Login failed");
		}
	}
	public void viewAllMembers() {
        String sql = "SELECT * FROM user";
        try { 
        	Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println(
                        rs.getString(1) + " | " +
                        rs.getInt(2) + " | " +
                        rs.getString(3) + " | " +
                        rs.getLong(4)
                );
            }
        } catch (Exception e) {
            System.out.println("Error fetching users");
        }
    }
	public void deleteMember(String email) {
		String sql = "DELETE FROM user WHERE email=?";
		try {
			Connection con = DatabaseConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, email);
            ps.executeUpdate();
            System.out.println("User deleted successfully");
		}
		catch (Exception e) {
            System.out.println("Delete failed");
        }
	}
	public void findMember(long contact) {
		String sql="select * from user where contact=?";
		try {
			Connection con = DatabaseConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setLong(1, contact);
            ps.executeUpdate();
            System.out.println("Fetched successfully");
		}
		catch (Exception e) {
            System.out.println("Fetching failed");
        }
	}
}
