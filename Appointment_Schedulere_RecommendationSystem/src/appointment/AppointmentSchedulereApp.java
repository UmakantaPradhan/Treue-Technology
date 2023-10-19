package appointment;
import java.time.LocalDateTime;
import java.util.Scanner;
public class AppointmentSchedulereApp 
{
	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		AppointmentSchedulere schedulere = new AppointmentSchedulere();	
		System.out.println("--------Welcome to AppointmentSchedulere-----------");
		while(true) 
		{
			System.out.println("\nMenu");
			System.out.println("1. Register");
			System.out.println("2. Login");
			System.out.println("3. Exit");
			System.out.println("Choose an option :");
			int choice = s.nextInt();
			s.nextLine();
			switch(choice)
			{
			case 1:
				System.out.println("Enter your username : ");
				String 	regUsername = s.nextLine();
				System.out.println("Enter your password : ");
				String 	regPassword = s.nextLine();
				System.out.println("Enter your first name : ");
				String 	firstName = s.nextLine();
				System.out.println("Enter your last name : ");
				String 	lastName = s.nextLine();
				System.out.println("Enter your email : ");
				String 	email = s.nextLine(); 
				System.out.println("Enter your phone number : ");
				String 	phoneNumber = s.nextLine();
				User newUser = new User(regUsername,regPassword,firstName,lastName,email,phoneNumber);
				schedulere.addUser(newUser);
				System.out.println("Registration Sucessful..");
				break;
			case 2:
				System.out.println("Enter your username : ");
				String 	username = s.nextLine();
				System.out.println("Enter your password : ");
				String 	password = s.nextLine();
				if(schedulere.isValidUser(username, password)) 
				{
					User loggedInUser = new User(username,password, "", "", "", "");
					System.out.println("Login Sucessful..");
					while(true) 
					{
						System.out.println("\nUser Menu");
						System.out.println("1. Add Appointment");
						System.out.println("2. View Appointment");
						System.out.println("3. Logout");
						System.out.println("Choose an option :");
						int userChoice = s.nextInt();						
						switch(userChoice)
						{
						case 1:
							System.out.println("Enter appointment start year : ");
							int year = s.nextInt();
							System.out.println("Enter appointment start month : ");
							int month = s.nextInt();
							System.out.println("Enter appointment start day : ");
							int day = s.nextInt();
							System.out.println("Enter appointment start hour : ");
							int hour = s.nextInt();
							System.out.println("Enter appointment start minute : ");
							int minute = s.nextInt();
							s.nextLine();
							LocalDateTime startTime = LocalDateTime.of(year,month,day,hour,minute); 
							LocalDateTime endTime = startTime.plusHours(1);
							System.out.println("Enter appointment description : ");
							String description = s.nextLine();
							schedulere.addAppointment(startTime, endTime, description, loggedInUser);
							System.out.println("Appointment added..");
							break;
						case 2:
							System.out.println("Youe Appointments :");
							for(Appointment appointment : schedulere.getappointmentsByUser(loggedInUser)) {
								System.out.println(appointment);
							}
							break;
						case 3:
							System.out.println("Logging out..");
							break;
						default :
							System.out.println("Invalid option!");
							break;	
					  }
						if(userChoice == 3) {
							break;
						}
					}
				}
				else {
					System.out.println("Invalid username or password..");
				}
				break;
			case 3:
				System.out.println("Exiting..");
				s.close();
				System.exit(0);
				break;
			default :
					System.out.println("Invalid option..");
					break;
			}
		}
	}
}
