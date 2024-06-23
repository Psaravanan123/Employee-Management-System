package vsb;
import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mysql.cj.protocol.Resultset;

public class index {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		try {
			String str="insert into employee5 values(?,?,?,?,?,?)";
			Connection cn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/vsb","root","123456");
			PreparedStatement ps=cn.prepareStatement(str);
			  System.out.println("enter employee details");
		        
		        System.out.print("enter id:");
		        ps.setInt(1, sc.nextInt());
		        sc.nextLine(); // Consume newline left-over
		        
		        System.out.print("enter name:");
		        ps.setString(2, sc.nextLine());
		        
		        System.out.print("enter salary:");
		        ps.setInt(3, sc.nextInt());
		        sc.nextLine(); // Consume newline left-over
		        
		        System.out.print("enter age :");
		        ps.setInt(4, sc.nextInt());
		        sc.nextLine(); // Consume newline left-over
		        
		        System.out.print("enter gender:");
		        ps.setString(5, sc.nextLine());
		        
		        System.out.print("enter d_o_j:");
		        ps.setString(6, sc.nextLine());

		        ps.executeUpdate(); // Use executeUpdate() for INSERT operations
    String str2="select * from employee5";
    PreparedStatement th=cn.prepareStatement(str2);
		        ResultSet rs=th.executeQuery();
		        while(rs.next()) {
	 	        	int id=rs.getInt(1);
		        	String name=rs.getString(2);
		        	int salary=rs.getInt(3);
		        	int age=rs.getInt(4);
		        	String gender=rs.getString(5);
		        	String d_o_j=rs.getString(6);
		        	System.out.println(id);
		        	System.out.println(name);
		        	System.out.println(salary);
		        	System.out.println(age);
		        	System.out.println(gender);
		        	System.out.println(d_o_j);
		        }
		        ps.execute();
		        cn.close();
		} catch (Exception e) {
		e.printStackTrace();
		}

	}

}
