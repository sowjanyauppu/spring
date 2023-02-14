package com.bitlabs.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.bitlabs.dao.UserDetails;

public class DaoImpl {
	Connection con=null;

	public DaoImpl() {
		//loading driver class
				try
				{
					Class.forName("com.mysql.jdbc.Driver");
					//connection establishment
					con=DriverManager.getConnection("jdbc:mysql://localhost:3306/socialnetworking","root","root");
					if(con!=null)
					{
						System.out.println("connection established");
					}
					
				}
				catch(Exception e)
				{
					System.out.println(e);
				}
	}

	public int register(UserDetails r) {
		// TODO Auto-generated method stub
		int i=0;
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		try {
			PreparedStatement pstmt=con.prepareStatement("insert into user(name,email,password,mobilenumber,dob,city,longitude,latitude,gender,marital) values(?,?,?,?,?,?,?,?,?,?)");
			pstmt.setString(1, r.getName());
			pstmt.setString(2,r.getEmail());
			pstmt.setString(3, r.getPassword());
			pstmt.setLong(4,r.getMobilenumber());
			pstmt.setString(5, r.getDob());
			pstmt.setString(6, r.getCity());
			pstmt.setString(7,"1");
			pstmt.setString(8, "1");
			pstmt.setString(9, r.getGender());
			pstmt.setString(10, r.getMarital());
			i=pstmt.executeUpdate();
		
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		return i;
		
	}

	public UserDetails login(UserDetails r)
	{
		UserDetails u=null;
		try
		{
		 java.sql.Statement stmt=con.createStatement();
		 ResultSet rs=stmt.executeQuery("select * from user where email='"+r.email+"' and password='"+r.password+"'");
		 while(rs.next()) {
			 u=new UserDetails();
			 u.setId(rs.getInt(1));
			 u.setName(rs.getString(2));
			 u.setEmail(rs.getString(3));
			 u.setPassword(rs.getString(4));
			 u.setMobilenumber(rs.getLong(5));
			 u.setDob(rs.getString(6));
			 u.setCity(rs.getString(7));
			 u.setLongitude(rs.getString(8));
			 u.setLatitude(rs.getString(9));
			 
		 }
		 
		}
		catch(Exception e)
		{
		System.out.println(e);
		}
		return u;
	}
	
	public List<UserDetails> search(Search s)
	{
		List<UserDetails> userList=new ArrayList<UserDetails>();
		try
		{
		 java.sql.Statement stmt=con.createStatement();
		 String query="select * from user where Id!="+s.getId()+" ";
		 if(s.getFromAge()!="")
			 query+=" and TIMESTAMPDIFF(YEAR, dob,CURDATE())>="+s.getFromAge();
		 if(s.getToAge()!="")
			 query+=" and TIMESTAMPDIFF(YEAR, dob,CURDATE())<="+s.getToAge();
		 if(s.getCity()!="")
			 query+=" and city='"+s.getCity()+"'";
		 if(s.getGender()!="")
			 query+=" and gender='"+s.getGender()+"'";
		 if(s.getMarital()!="")
			 query+=" and marital='"+s.getMarital()+"'";
		 System.out.println(query);
		 ResultSet rs=stmt.executeQuery(query);
		 while(rs.next()) {
			 UserDetails u=new UserDetails();
			 u.setId(rs.getInt(1));
			 u.setName(rs.getString(2));
			 u.setEmail(rs.getString(3));
			 u.setPassword(rs.getString(4));
			 u.setMobilenumber(rs.getLong(5));
			 u.setDob(rs.getString(6));
			 u.setCity(rs.getString(7));
			 u.setLongitude(rs.getString(8));
			 u.setLatitude(rs.getString(9));
			 u.setGender(rs.getString(10));
			 u.setMarital(rs.getString(11));
			 userList.add(u);
		 }
		}
		catch(Exception e)
		{
		System.out.println(e);
		}
		return userList;
	}
	
	public List<UserDetails> myFriends(int id)
	{
		List<UserDetails> userList=new ArrayList<UserDetails>();
		try
		{
		 java.sql.Statement stmt=con.createStatement();
		 String query="select * from user where Id in (select f.friend_id from user u inner join friends f on f.user_id = u.Id where f.accepted=1 and f.user_id="+id+")";
		 
		 ResultSet rs=stmt.executeQuery(query);
		 while(rs.next()) {
			 UserDetails u=new UserDetails();
			 u.setId(rs.getInt(1));
			 u.setName(rs.getString(2));
			 u.setEmail(rs.getString(3));
			 u.setPassword(rs.getString(4));
			 u.setMobilenumber(rs.getLong(5));
			 u.setDob(rs.getString(6));
			 u.setCity(rs.getString(7));
			 u.setLongitude(rs.getString(8));
			 u.setLatitude(rs.getString(9));
			 u.setAccepted(true);
			 userList.add(u);
		 }
		 
 query="select distinct * from user where Id in (select f.user_id from user u inner join friends f on f.user_id = u.Id where f.accepted=0 and f.friend_id="+id+")";
		 
		 rs=stmt.executeQuery(query);
		 while(rs.next()) {
			 UserDetails u=new UserDetails();
			 u.setId(rs.getInt(1));
			 u.setName(rs.getString(2));
			 u.setEmail(rs.getString(3));
			 u.setPassword(rs.getString(4));
			 u.setMobilenumber(rs.getLong(5));
			 u.setDob(rs.getString(6));
			 u.setCity(rs.getString(7));
			 u.setLongitude(rs.getString(8));
			 u.setLatitude(rs.getString(9));
			 u.setAccepted(false);
			 userList.add(u);
		 }
		}
		catch(Exception e)
		{
		System.out.println(e);
		}
		return userList;
	}

	public boolean addFriend(int userId,int friendId)
	{
		try
		{
		 java.sql.Statement stmt=con.createStatement();
		 String query="insert into friends(user_id,friend_id,createdOn,accepted) values("+userId+","+friendId+",'"+LocalDate.now()+"',false)";
		 System.out.println(query);
		 int i=stmt.executeUpdate(query);
		 if(i>0) {
			 return true;
		 }
		}
		catch(Exception e)
		{
		System.out.println(e);
		}
		return false;
	}
	public boolean approve(int userId,int friendId)
	{
		try
		{
		System.out.println(userId+ " "+friendId);
		 java.sql.Statement stmt=con.createStatement();
		 String query="update friends set accepted=true where friend_id="+userId+" and user_id="+friendId;
		 System.out.println(query);
		 int i=stmt.executeUpdate(query);
		 if(i>0) {
			 return true;
		 }
		}
		catch(Exception e)
		{
		System.out.println(e);
		}
		return false;
	}
	public boolean reject(int userId,int friendId)
	{
		try
		{
		 java.sql.Statement stmt=con.createStatement();
		 String query="delete from friends where friend_id="+userId+" and user_id="+friendId;
		 int i=stmt.executeUpdate(query);
		 if(i>0) {
			 return true;
		 }
		}
		catch(Exception e)
		{
		System.out.println(e);
		}
		return false;
	}
	public int update(UserDetails r) {
		// TODO Auto-generated method stub
		int i=0;
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		try {
			PreparedStatement pstmt=con.prepareStatement("update user set name='"+r.getName()+
					"',email='"+r.getEmail()+"',mobilenumber='"+r.getMobilenumber()+
					"',dob='"+r.getDob()+"',city='"+r.getCity()+"' where Id="+r.getId());
			i=pstmt.executeUpdate();
		
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		System.out.println(i);
		return i;
		
	}

	public int delete(int id) {
		// TODO Auto-generated method stub
		int i=0;
		try {
			PreparedStatement pstmt=con.prepareStatement("delete from user where Id="+id);
			i=pstmt.executeUpdate();
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		System.out.println(i);
		return i;
		
	}
}
