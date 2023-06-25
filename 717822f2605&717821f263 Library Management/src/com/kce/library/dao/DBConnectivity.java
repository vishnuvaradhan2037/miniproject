package com.kce.library.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import com.kce.library.bean.LibraryBean;
import com.kce.library.bean.UserLibrary;
import com.kce.library.util.getConnection;
public class DBConnectivity {
 static PreparedStatement ps;
 static Connection c=getConnection.getConnection();
 static ResultSet rs;

 public static boolean addBooks(LibraryBean book) {
//	 Scanner in=new Scanner(System.in);
	 try {
		 ps=c.prepareStatement("select bookid from Book");
		 rs=ps.executeQuery();
		 int counter=0;
		 while(rs.next()) {
			 if(rs.getInt(1)==book.getBookId()) 
				 counter++;
		 }
		 if(counter==0) {
			 ps=c.prepareStatement("insert into Book values(?,?,?,?,?)");
			 ps.setString(1,book.getBookName());
			 ps.setInt(2,book.getBookId());
			 ps.setString(3,book.getBookAuthor());
			 ps.setString(4,book.getBookGenre());
			 ps.setInt(5,book.getCostOfBook());
			 ps.execute();
			 return true;
		 }
		 else return false;
	 }
	 catch(Exception e) {
		 e.printStackTrace();
	 }
	 return false;
 }
 public static boolean  UserDetails(UserLibrary use) {
	 try {
		 ps=c.prepareStatement("select userId from UserLibrary");
		 rs=ps.executeQuery();
		 int counter=0;
		 while(rs.next()) {
			 if(rs.getString(1)==use.getUserId()) 
				 counter++;
		 }
		 if(counter==0) {
			 ps=c.prepareStatement("insert into UserLibrary values(?,?,?,?)");
			 ps.setString(1,use.getName());
			 ps.setInt(2,use.getAge());
			 ps.setString(3,use.getEmail());
			 ps.setString(4,use.getUserId());
			 ps.execute();
			 return true;
		 }
		 else return false;
	 }
	 catch(Exception e) {
		 e.printStackTrace();
	 }
	 return false;
 }
 public static void UpdateUser() {
 Scanner in=new Scanner(System.in);
	try {
		while(true) {
		System.out.println("Enter the Choice 1 to Update User Name:");
		System.out.println("Enter the Choice 2 to Update User age:");
		System.out.println("Enter the Choice 3 to Update User email:");
		System.out.println("Enter the Choice 4 to Update User Library Id:");
		System.out.println("Enter the Choice 5 to Save Changes :");
		int n=in.nextInt();
		if(n==1) {
			System.out.println("updating the User Name: ");
			System.out.println("Enter new User Name: ");
			String a=in.next();
			System.out.println("Enter the User Id: ");
			String b=in.next();
			 ps=c.prepareStatement("Update UserLibrary set name=? where userId=? ");
			 ps.setString(1, a);
			 ps.setString(2, b);
			 ps.execute();
		}
		if(n==2) {
			System.out.println("updating the User Age: ");
			System.out.println("Enter new User age: ");
			int e=in.nextInt();
			System.out.println("Enter th User Id: ");
			String f=in.next();
			 ps=c.prepareStatement("Update UserLibrary set age=? where userId=? ");
			 ps.setInt(1, e);
			 ps.setString(2, f);
			 ps.execute();
		}
		if(n==3) {
			System.out.println("updating the User email: ");
			System.out.println("Enter new User email: ");
			String g=in.next();
			System.out.println("Enter the User name: ");
			String h=in.next();
			 ps=c.prepareStatement("Update UserLibrary set email=? where name=? ");
			 ps.setString(1, g);
			 ps.setString(2, h);
			 ps.execute();
		}
		if(n==4) {
			System.out.println("updating the User Id: ");
			System.out.println("Enter new User Id: ");
			String i=in.next();
			System.out.println("Enter the User name: ");
			String j=in.next();
			 ps=c.prepareStatement("Update UserLibrary set userId=? where name=? ");
			 ps.setString(1, i);
			 ps.setString(2, j);
			 ps.execute();
		}
		if(n==5) {
			System.out.println("All Changes are saved");
		}
	}
}
	catch(Exception e) {
		System.out.println(e);
	}
}
 public static List<UserLibrary> viewUsers() {
	 List<UserLibrary> list=new ArrayList<>();
	 try {
		 ps=c.prepareStatement("select * from UserLibrary");
		 rs=ps.executeQuery();
		 while(rs.next()) {
			list.add(new UserLibrary(rs.getString(1),rs.getInt(2),rs.getString(3),rs.getString(4)));
		 }
	 }
	 catch(Exception e) {
		 System.out.println(e);
	 }
	 Collections.sort(list);
	 return list;
 }
 public static List<LibraryBean> OrderBooks(){
	 List<LibraryBean> l=new ArrayList<>();
	 try {
		 ps=c.prepareStatement("select * from Book");
		 rs=ps.executeQuery();
		 while(rs.next()) {
			 l.add(new LibraryBean (rs.getString(1),rs.getInt(2),rs.getString(3),rs.getString(4),rs.getInt(5)));
		 }
	       Collections.sort(l);
	 }
	 catch(Exception e) {
		 System.out.println(e);
	 }
	return l;
 }
 public static void updateBook() {
	 Scanner in=new Scanner(System.in);
	try {
		while(true) {
		System.out.println("Enter the Choice 1 to Update Book Name:");
		System.out.println("Enter the Choice 2 to Update Book Author:");
		System.out.println("Enter the Choice 3 to Update Book Genre:");
		System.out.println("Enter the Choice 4 to Update Book Cost:");
		System.out.println("Enter the Choice 5 to Update Book Id:");
		System.out.println("Enter the Choice 6 to Save Changes :");
		int n=in.nextInt();
		if(n==1) {
			System.out.println("updating the Book name: ");
			System.out.println("Enter new Book name: ");
			String a=in.next();
			System.out.println("Enter th book Id: ");
			int b=in.nextInt();
			 ps=c.prepareStatement("Update Book set BookName=? where BookId=? ");
			 ps.setString(1, a);
			 ps.setInt(2, b);
			 ps.execute();
		}
		if(n==2) {
			System.out.println("updating the Book Author: ");
			System.out.println("Enter new Book Author: ");
			String e=in.next();
			System.out.println("Enter th book Id: ");
			int f=in.nextInt();
			 ps=c.prepareStatement("Update Book set BookAuthor=? where BookId=? ");
			 ps.setString(1, e);
			 ps.setInt(2, f);
			 ps.execute();
		}
		if(n==3) {
			System.out.println("updating the Book Genre: ");
			System.out.println("Enter new Book Genre: ");
			String g=in.next();
			System.out.println("Enter th book Genre: ");
			String h=in.next();
			 ps=c.prepareStatement("Update Book set BookGenre=? where BookGenre=? ");
			 ps.setString(1, g);
			 ps.setString(2, h);
			 ps.execute();
		}
		if(n==4) {
			System.out.println("updating the Book cost: ");
			System.out.println("Enter new Book cost: ");
			int i=in.nextInt();
			System.out.println("Enter th book Name: ");
			String j=in.next();
			 ps=c.prepareStatement("Update Book set costOfBook=? where BookName=? ");
			 ps.setInt(1, i);
			 ps.setString(2, j);
			 ps.execute();
		}
		if(n==5) {
			System.out.println("updating the Book Id: ");
			System.out.println("Enter new Book Id: ");
			int ci=in.nextInt();
			System.out.println("Enter th book Name: ");
			String d=in.next();
			ps = c.prepareStatement("update Book set BookId = ? where BookName = ?");
			 ps.setInt(1, ci);
			 ps.setString(2, d);
			 ps.execute();
		}
		if(n==6) {
			System.out.println("All Changes are saved");
		}
	}
 }
	catch(Exception e) {
		System.out.println(e);
	}
 }
 public static List<LibraryBean>  viewBook() {
	 List<LibraryBean> list=new ArrayList<>();
	 try {
		 ps=c.prepareStatement("select * from Book");
		 rs=ps.executeQuery();
		 while(rs.next()) {
			list.add(new LibraryBean(rs.getString(1),rs.getInt(2),rs.getString(3),rs.getString(4),rs.getInt(5)));
		 }
	 }
	 catch(Exception e) {
		 System.out.println(e);
	 }
	 return list;
 }
 public static List<UserLibrary> OrderUsers(){
	 List<UserLibrary> t=new ArrayList<>();
	 try {
		 ps=c.prepareStatement("select * from UserLibrary");
		 rs=ps.executeQuery();
		 while(rs.next()) {
			 t.add(new UserLibrary (rs.getString(1),rs.getInt(2),rs.getString(3),rs.getString(4)));
		 }
	       Collections.sort(t);
	 }
	 catch(Exception e) {
		 System.out.println(e);
	 }
	return t;
 }
 }
