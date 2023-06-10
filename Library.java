package Project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Library 
{
	public static void main(String[] args) throws ClassNotFoundException, SQLException 
	{
		
		Class.forName("com.mysql.cj.jdbc.Driver"); // this will do by compiler implicit before 1.4 we have to register like this
		
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","Saibaba7@#");
		
		Scanner sc=new Scanner(System.in);
		
		System.out.println("please select");
		System.out.println("1.ADMIN 2.USER");
		int choice=sc.nextInt();
		
		switch (choice) 
		{
			case 1: //for admin
			{	
				System.out.println("Enter No of Operation Which you want to do");
				System.out.println("1.ADD BOOK");
				System.out.println("2,VIEW BOOK DETAIL BY ID");
				System.out.println("3.UPDATE BOOK");
				System.out.println("4.VIEW ALL BOOKS"); 
				System.out.println("5.DELETE BOOK BY ID");
				System.out.println("6.ADD USER");
				System.out.println("7.VIEW USER BY ID");
				System.out.println("8.VIEW ALL USERS");
				System.out.println("9.`DELETE USER BY ID");
				 int key=sc.nextInt();
				
				switch (key) 
				{
					case 1: //ADD BOOK
					{
						PreparedStatement ps=con.prepareStatement("insert into books values(?,?,?,?)");
						 ///input 
						System.out.println("Enter Id");
						int id=sc.nextInt();
						
						System.out.println("Enter Name");
						String name=sc.next();
						
						System.out.println("Enter Author");
						String auth=sc.next();
						
						System.out.println("Enter Genre");
						String gen=sc.next();
						
						ps.setInt(1, id);
						ps.setString(2, name);
						ps.setString(3,auth);
						ps.setString(4, gen);
						ps.execute();
						
						System.out.println("Book Added");
						break;
					}
					case 2: //VIEW BOOK DETAIL BY ID
					{
						PreparedStatement pst=con.prepareStatement("select * from books where id=?");
						
						System.out.println("enter id to display details");  
						int id=sc.nextInt();  
						
						pst.setInt(1, id);
						
						ResultSet res=pst.executeQuery();
						
						if (res.next()) 
						{
							System.out.print(res.getInt(1)+   " ");
							System.out.print(res.getString(2)+" ");
							System.out.print(res.getString(3)+" ");
							System.out.print(res.getString(4)+" ");
						}
						else
						{
							System.out.println("invalid id data not found");
						}
						break;
					}	
					
					case 3: //UPDATE BOOK
					{
						
						PreparedStatement ps=con.prepareStatement("update books set name=? where id=?");
						
						System.out.println("enter id to update");
						int id=sc.nextInt();
						ps.setInt(2, id);
						
						System.out.println("enter name to update");
						String name=sc.next();
						ps.setString(1,name);
						
						ps.execute();
						
						System.out.println("Data updated succesfully");
						
						break;
					}	
					case 4: //VIEW ALL BOOKS"
					{
						PreparedStatement ps=con.prepareStatement("select * from books");
						ResultSet res=ps.executeQuery();
						
						while (res.next()) 
						{
							System.out.print(res.getInt(1)+" ");
							System.out.print(res.getString(2)+" ");
							System.out.print(res.getString(3)+" ");
							System.out.print(res.getString(4)+" ");
						}
						break;
					}	
					case 5: //5.DELETE BOOK BY ID
					{
						PreparedStatement ps=con.prepareStatement("delete from books where id=?");
						System.out.println("enter id which you want to delete");
						int id=sc.nextInt();
						
						ps.setInt(1, id);
						ps.execute();
						
						System.out.println("book deleted of id");
						break;
					}	
					case 6: //6.ADD USER"
					{
						PreparedStatement pst=con.prepareStatement("insert into users values(?,?,?)");
						
						System.out.println("Enter ID");
						int id=sc.nextInt();
						pst.setInt(1, id);
						
						System.out.println("Enter Name");
						String name=sc.next();
						pst.setString(2, name);
						
						System.out.println("Enter Phone Number");
						String phno=sc.next();
						pst.setString(3, phno);
						
						pst.execute();
						System.out.println("User Added succesfully");
						break;
					}	
					case 7: //7.VIEW USER BY ID
					{
						PreparedStatement pst=con.prepareStatement("select * from users where id=?");
						
						System.out.println("enter id to display user details");  
						int id=sc.nextInt();  
						
						pst.setInt(1, id);
						
						ResultSet res=pst.executeQuery();
						
						if (res.next()) 
						{
							System.out.print(res.getInt(1)+   " ");
							System.out.print(res.getString(2)+" ");
							System.out.print(res.getInt(3)+" ");
						}
						else
						{
							System.out.println("invalid id data not found");
						}
						break;
					}	
					case 8: //8.VIEW ALL USERS
					{
						PreparedStatement ps=con.prepareStatement("select * from users");
						ResultSet res=ps.executeQuery();
						
						while (res.next()) 
						{
							System.out.print(res.getInt(1)+" ");
							System.out.print(res.getString(2)+" ");
							System.out.print(res.getInt(3)+" ");
						}
						break;
					}	
					case 9: //9.`DELETE USER BY ID
					{
						PreparedStatement ps=con.prepareStatement("delete from users where id=?");
						System.out.println("enter id which you want to delete");
						int id=sc.nextInt();
						
						ps.setInt(1, id);
						ps.execute();
						
						System.out.println("user deleted of id");
						break;
					}	
					default:
					{	break; }
				}
				break;
			}
			case 2: // for user
			{	System.out.println("1.CREATE ACCOUNT");
				System.out.println("2.VIEW BOOK BY ID");
				System.out.println("3.VIEW BOOK BY AUTHOR");
				System.out.println("4.VIEW BOOK BY GENRE");
				System.out.println("5.UPDATE USER");
				
				int key=sc.nextInt();
				switch (key) 
				{
					case 1: //1.CREATE ACCOUNT
					{

						PreparedStatement pst=con.prepareStatement("insert into users values(?,?,?)");
						
						System.out.println("Enter ID");
						int id=sc.nextInt();
						pst.setInt(1, id);
						
						System.out.println("Enter Name");
						String name=sc.next();
						pst.setString(2, name);
						
						System.out.println("Enter Phone Number");
						String phno=sc.next();
						pst.setString(3, phno);
						
						pst.execute();
						System.out.println("Account created successfully");
						break;
					}
					case 2: //2.VIEW BOOK BY ID
					{
						PreparedStatement pst=con.prepareStatement("select * from books where id=?");
						
						System.out.println("enter id to display details");  
						int id=sc.nextInt();  
						
						pst.setInt(1, id);
						
						ResultSet res=pst.executeQuery();
						
						if (res.next()) 
						{
							System.out.print(res.getInt(1)+   " ");
							System.out.print(res.getString(2)+" ");
							System.out.print(res.getString(3)+" ");
							System.out.print(res.getString(4)+" ");
						}
						else
						{
							System.out.println("invalid id data not found");
						}
						break;
					}
					case 3: //3.VIEW BOOK BY AUTHOR
					{
						PreparedStatement pst=con.prepareStatement("select * from books where author=?");
						
						System.out.println("enter author name to display details");  
						String aut=sc.next();  
						
						pst.setString(1, aut);
						
						ResultSet res=pst.executeQuery();
						
						if (res.next()) 
						{
							System.out.print(res.getInt(1)+   " ");
							System.out.print(res.getString(2)+" ");
							System.out.print(res.getString(3)+" ");
							System.out.print(res.getString(4)+" ");
						}
						else
						{
							System.out.println("invalid id data not found");
						}
						break;
					}
					case 4: //4.VIEW BOOK BY GENRE"
					{
						PreparedStatement pst=con.prepareStatement("select * from books where genere=?");
						
						System.out.println("enter genre name to display details");  
						String gen=sc.next();  
						
						pst.setString(1, gen);
						
						ResultSet res=pst.executeQuery();
						
						if (res.next()) 
						{
							System.out.print(res.getInt(1)+   " ");
							System.out.print(res.getString(2)+" ");
							System.out.print(res.getString(3)+" ");
							System.out.print(res.getString(4)+" ");
						}
						else
						{
							System.out.println("invalid id data not found");
						}
						break;
					}
					case 5: //5.UPDATE USER
					{
						PreparedStatement ps=con.prepareStatement("update users set name=? where id=?");
						
						System.out.println("enter id to update");
						int id=sc.nextInt();
						ps.setInt(2, id);
						
						System.out.println("enter name to update");
						String name=sc.next();
						ps.setString(1,name);
						
						ps.execute();
						
						System.out.println("Data updated succesfully");
						
						break;
					}
				default:
					{ break; }
				}
			
				break;
			}
		default:
			{	break;	}
		}
		
		
	}

}
