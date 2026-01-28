package librarymanagementsystem;

import java.util.Scanner;

public class MainClass {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		MemberActions lm=new MemberActions();
		Librarian l=new Librarian();
		boolean flag=true;
		while(flag) {
			System.out.println("1:Member\n2:Librarian\n3:exit");
			System.out.println("Enter choice:");
			int choice=sc.nextInt();
			switch(choice) {
			case 1:{
				boolean f1=true;
				while(f1) {
					System.out.println("1:Register\n2:Login\n3:Go Back");
					System.out.println("enter your choice:");
					int ch=sc.nextInt();
					switch(ch) {
					case 1:{
						System.out.println("Enter the name:");
						String name=sc.next();
						System.out.println("Enter the age");
						int age=sc.nextInt();
						System.out.println("Enter the email");
						String email=sc.next();
						System.out.println("Enter the contact no:");
						long contact=sc.nextLong();
						System.out.println("Enter the password to process");
						String password=sc.next();
						lm.registerMember(new LibraryMember(name,age,email,contact,password));
						break;
						}
					case 2:{
						boolean fh1=true;
						while(fh1) {
							System.out.println("1:LoginWithEmail\n2:LoginWithContact\n3:Go Back");
							System.out.println("enter your choice:");
							int ch2=sc.nextInt();
							switch(ch2) {
								case 1:{
									System.out.println("Enter your email");
									String email=sc.next();
									System.out.println("Enter your password");
									String pass=sc.next();
									lm.loginWithEmail(email, pass);
									break;
								}
								case 2:{
									System.out.println("Enter your contact");
									long contact=sc.nextLong();
									lm.loginWithContact(contact);
									break;
								}
								case 3:{
									fh1=false;
									break;
								}
								default:{
									System.out.println("Enter the numbers b/w 1 and 3");
								}
							}
						}
						break;
					}
					case 3:{
						f1=false;
						break;
					}
					default:{
						System.out.println("Enter the numbers b/w 1 and 3");
						}
					}
				}
				
				}
			case 2:{
					boolean fh1=true;
					while(fh1) {
						System.out.println("1:LoginWithEmail\n2:LoginWithContact\n3:Go Back");
						System.out.println("enter your choice:");
						int ch2=sc.nextInt();
						switch(ch2) {
							case 1:{
								System.out.println("Enter your email");
								String email=sc.next();
								System.out.println("Enter your password");
								String pass=sc.next();
								l.loginWithEmail(email, pass);
								break;
							}
							case 2:{
								System.out.println("Enter your contact");
								long contact=sc.nextLong();
								l.loginWithContact(contact);
								break;
							}
							case 3:{
								fh1=false;
								break;
							}
							default:{
								System.out.println("Enter the numbers b/w 1 and 3");
							}
						}
					}
				}
			case 3:{
				flag=false;
				break;
			}
			default:{
				System.out.println("Enter btw 1 and 3");
			}
			}
		}
	}
}
