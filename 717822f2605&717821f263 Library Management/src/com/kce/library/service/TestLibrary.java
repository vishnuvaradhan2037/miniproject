package com.kce.library.service;
import com.kce.library.bean.*;
import java.util.*;

import com.kce.library.dao.DBConnectivity;

public class TestLibrary {
 public static void main(String[] args) {
	 try {
	Scanner in=new Scanner(System.in);
	System.out.println("\t\t\tWelcome to Library Management System\t\t\t\n");
	while(true) {
		System.out.println("Press 1 for Library details");
		System.out.println("Press 2 for User details");
		int n=in.nextInt();
	switch(n) {
	case 1:
		while(true) {
			System.out.println("press 1 to Add books");
			System.out.println("press 2 for Ordering the Books");
			System.out.println("press 3 for updating the book details");
			System.out.println("press 4 to viewing book");
			int a=in.nextInt();
			switch(a) {
			case 1:
				System.out.println("Please enter Book details: ");
				System.out.println("Enter Book Id: ");
				int bookid=in.nextInt();
				in.nextLine();
				System.out.println("Enter Book Name: ");
				String bookname=in.nextLine();
			    System.out.println("Enter Book Author: ");
			    String bookAuthor=in.nextLine();
			    System.out.println("Enter Book Genre: ");
			    String bookgenre=in.nextLine();
			    System.out.println("Enter cost of Book: ");
			    int bookcost=in.nextInt();
			    LibraryBean book=new LibraryBean(bookname,bookid,bookAuthor,bookgenre,bookcost);
			    if(DBConnectivity.addBooks(book)) {
			    	System.out.println("\nBook details added successfully");
			    }
			    else {
			    	System.out.println("\n Book details already exists");
			    }
			    break;
			case 2:
				System.out.println("Ordering the books");
				System.out.println(DBConnectivity.OrderBooks());
				break;
			case 3:
				System.out.println("Updating details: ");
                System.out.println("Enter a number: ");
                int z=in.nextInt();
				DBConnectivity.updateBook();
			case 4:
				System.out.println("Viewing the Book");
				List<LibraryBean> list=new ArrayList<>();
	              list=DBConnectivity.viewBook();
	              for(LibraryBean u:list) {
	            	  System.out.println(u);
	              }
		}
		}
	case 2:
		while(true) {
			System.out.println("press 1 to Add users");
			System.out.println("press 2 for Viewing the users");
			System.out.println("press 3 to update User details");
			System.out.println("press 4 to order users based on their name");
			int s=in.nextInt();
			switch(s) {
			case 1:
		System.out.println("User details");
		System.out.println("Enter User Id: ");
		String memberId=in.nextLine();
		in.nextLine();
			System.out.println("Enter the User Name: ");
		String membername=in.nextLine();
	
	    System.out.println("Enter User age: ");
	    int memberage=in.nextInt();
	    System.out.println("Enter User email: ");
	    String memberemail=in.next();
	    System.out.println("Enter user Library Id: ");
	    String memberId1=in.next();
	  UserLibrary use=new UserLibrary(membername,memberage,memberemail,memberId1);
	  if(DBConnectivity.UserDetails(use)) {
		  System.out.println("User details inseted successfully");
	  }
	  else {
		  System.out.println("User details already exists");
	  }
	  break;
			case 2:
				System.out.println("Viewing the Users");
				List<UserLibrary> list=new ArrayList<>();
              list=DBConnectivity.viewUsers();
              for(UserLibrary u:list) {
            	  System.out.println(u);
              }
               break;
			case 3:
				System.out.println("Updating details: ");
				DBConnectivity.UpdateUser();
			    break;
			case 4:
				System.out.println("Ordering the books");
				System.out.println(DBConnectivity.OrderUsers());
				break;
	}
		}
	}
	}
	 }
	 catch(Exception e) {
		 System.out.println(e);
	 }
}
	 }
