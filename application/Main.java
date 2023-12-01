package ZenFit.application;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import ZenFit.classes.FoodLog;
import ZenFit.classes.Goals;
import ZenFit.classes.Profile;
import ZenFit.classes.User;
import ZenFit.classes.WorkoutLog;
import ZenFit.dao.FoodLogDAO;
import ZenFit.dao.GoalsDAO;
import ZenFit.dao.ProfileDAO;
import ZenFit.dao.UserDAO;
import ZenFit.dao.WorkoutLogDAO;
import ZenFit.daoimpl.FoodLogDaoImpl;
import ZenFit.daoimpl.GoalsDaoImpl;
import ZenFit.daoimpl.ProfileDaoImpl;
import ZenFit.daoimpl.UserDaoImpl;
import ZenFit.daoimpl.WorkoutLogDaoImpl;

public class Main {

	public static void main(String[] args) throws SQLException {
		System.out.println("                                                                                          \r\n"
				+ "                                                                            =+=-.         \r\n"
				+ "       --------:  :--------   --:   :--   :-------:  .--.  --------:         ****+        \r\n"
				+ "      -@@@@@@@@-  #@@@@@@@@. :@@@:  *@@-  @@@@@@@@@  =@@* .@@@@@@@@%        :*****=       \r\n"
				+ "       ....#@@+   #@@-.....  :@@@%  *@@-  @@@:.....  =@@*  ..:@@%...   .:  =*******       \r\n"
				+ "          =@@#    #@@.       :@@@@* *@@-  @@@        =@@*    .@@%     -*=.+***+-**=       \r\n"
				+ "         .@@@.    #@@*+++=   :@@@@@-*@@-  @@@++++-   =@@*    .@@%    :***+**+-.-**- .=.   \r\n"
				+ "         %@@:     #@@@%%%#   :@@%=@@%@@-  @@@%%%%+   =@@*    .@@%    +****++-..:++*****   \r\n"
				+ "        *@@-      #@@.       :@@% #@@@@-  @@@        =@@*    .@@%    +**++++:...:=+****:  \r\n"
				+ "       =@@*       #@@.       :@@% .@@@@-  @@@        =@@*    .@@%    :**++.-:.....-+***.  \r\n"
				+ "      :@@@%%%%%-  #@@%%%%%%. :@@%  -@@@-  @@@        =@@*    .@@%     :++=.........++*:   \r\n"
				+ "      +++++++++:  =++++++++  .++=   =++.  +++        :++-     ++=      .-+-:.....:=+-.    \r\n"
				+ "                                                                          .:::::::.       \r\n"
				+ "");
		// TODO Auto-generated method stub
		Scanner s=new Scanner(System.in);
		UserDAO userDao = new UserDaoImpl();
		ProfileDAO profileDao = new ProfileDaoImpl();
		GoalsDAO goalsDao=new GoalsDaoImpl();
		WorkoutLogDAO workoutDao=new WorkoutLogDaoImpl();
		FoodLogDAO foodDao=new FoodLogDaoImpl();
		
		while(true)
		{
			System.out.println("1.New User");
			System.out.println("2.Login");
			System.out.print("Enter your Choice: ");
			int choice=s.nextInt();
			s.nextLine();
			switch(choice)
			{
			case 1:
				System.out.println("\n-----------------Register User------------------");
				User newUser = new User();
		        System.out.print("Enter username: ");
		        newUser.setUsername(s.nextLine());
		        System.out.print("Enter password: ");
		        newUser.setPassword(s.nextLine());
		        userDao.addUser(newUser);
	
		        
		        Profile newProfile = new Profile();
		        newProfile.setUserId(newUser.getUserId()); // Set the user's ID as the foreign key value
		        System.out.print("Enter age: ");
		        newProfile.setAge(s.nextInt());
		        s.nextLine(); // Consume the newline character left by nextInt()
		        System.out.print("Enter first name: ");
		        newProfile.setFirstName(s.nextLine());
		        System.out.print("Enter last name: ");
		        newProfile.setLastName(s.nextLine());
		        System.out.print("Enter height: ");
		        newProfile.setHeight(s.nextDouble());
		        s.nextLine(); // Consume the newline character left by nextDouble()
		        System.out.print("Enter gender: ");
		        newProfile.setGender(s.nextLine());
		        profileDao.addProfile(newProfile);
		        
		        System.out.print("Enter current weight: ");
		        double currentWeight = s.nextDouble();
		        s.nextLine();
		        System.out.print("Enter current fat %: ");
		        int currentFat = s.nextInt();	
		        s.nextLine();
		        System.out.print("Enter target fat %: ");
		        int targetFat = s.nextInt();
		        s.nextLine();
		        System.out.print("Enter current calories: ");
		        int currentCalories = s.nextInt();
		        s.nextLine();
		        Goals newGoal=new Goals(currentWeight,currentFat,targetFat,currentCalories);
		        newGoal.setUserId(newUser.getUserId());
		        goalsDao.addGoal(newGoal);
		        System.out.println("\n\nThanks for Registering...!Wish You a fit Journey..!");
		        break;
			case 2:
				System.out.println("\n<<-----------------Login User------------------>>\n");
				System.out.print("Enter username: ");
				String uname=s.nextLine();
				System.out.print("Enter password: ");
				String pwd=s.nextLine();
				int userId=userDao.verifyUser(uname,pwd);
				if(userId!=0)
				{
					Profile profile=profileDao.getProfileById(userId);
					System.out.print("\nWelcome Back "+profile.getFirstName()+" "+profile.getLastName()+"!");
					
					while(true)
					{
						 System.out.println("\n\n-------------------------------------");
					        System.out.println("|           Fitness App Menu         |");
					        System.out.println("-------------------------------------");
					        System.out.println("| 1. View Profile                    |");
					        System.out.println("| 2. Update Profile                  |");
					        System.out.println("| 3. Log Workout                     |");
					        System.out.println("| 4. View Workout History            |");
					        System.out.println("| 5. Log Food Intake                 |");
					        System.out.println("| 6. View Food History               |");
					        System.out.println("| 7. Update Goal                     |");
					        System.out.println("| 8. Update Weight                   |");
					        System.out.println("| 9. View Net Calories               |");
					        System.out.println("| 10. Delete Workout Log             |");
					        System.out.println("| 11. Delete Food Log                |");
					        System.out.println("| 12. Logout                         |");
					        System.out.println("---------------------------------------");
						System.out.print("Enter Your Choice : ");
						int choice2=s.nextInt();
						if(choice2==12)
						{
							System.out.println("Logout successful");
							break;
						}
						s.nextLine();
						switch(choice2)
						{
							case 1:
								Profile profile1=profileDao.getProfileById(userId);
								if(profile1!=null)
								{   
									System.out.println("\n                    <<----PROFILE---->>");
									System.out.println("---------------------------------------------------------------");
					            System.out.printf("%-15s | %-15s | %-5s | %-6s | %-8s |\n", "First Name", "Last Name", "Age", "Gender", "Height");
					            System.out.println("---------------------------------------------------------------");
		
					            System.out.printf("%-15s | %-15s | %-5d | %-6s | %-8.2f |\n",
					                    profile1.getFirstName(),
					                    profile1.getLastName(),
					                    profile1.getAge(),
					                    profile1.getGender(),
					                    profile1.getHeight());
		
					            System.out.println("---------------------------------------------------------------");
					       }
								break;
							case 2:
							    System.out.println("\n<<-----------------Update Profile------------------>>\n");
							    
							    
							        if (profile != null) {
							            System.out.println("\nCurrent Profile Information:");
							            System.out.println("---------------------------------------------------------------");
							            System.out.printf("%-15s | %-15s | %-5s | %-6s | %-8s |\n", "First Name", "Last Name", "Age", "Gender", "Height");
							            System.out.println("---------------------------------------------------------------");
				
							            System.out.printf("%-15s | %-15s | %-5d | %-6s | %-8.2f |\n",
							                    profile.getFirstName(),
							                    profile.getLastName(),
							                    profile.getAge(),
							                    profile.getGender(),
							                    profile.getHeight());
				
							            System.out.println("---------------------------------------------------------------");


							            System.out.println("\nEnter new profile information:");

							            System.out.print("Enter age: ");
							            int newAge = s.nextInt();
							            s.nextLine(); // Consume the newline character left by nextInt()
							            System.out.print("Enter first name: ");
							            String newFirstName = s.nextLine();
							            System.out.print("Enter last name: ");
							            String newLastName = s.nextLine();
							            System.out.print("Enter height: ");
							            double newHeight = s.nextDouble();
							            s.nextLine(); // Consume the newline character left by nextDouble()
							            System.out.print("Enter gender: ");
							            String newGender = s.nextLine();

							            Profile updatedProfile = new Profile(newFirstName, newLastName, newAge, newHeight, newGender, userId);
							            boolean isUpdated = profileDao.updateProfile(userId, updatedProfile);
							            if (isUpdated) {
							                System.out.println("Profile updated successfully.");
							            } else {
							                System.out.println("Failed to update profile.");
							            }
							        }
							   
							    break;
	
							case 3:
								System.out.println("\n                    <<----Log Your Workout Here---->>\n");
								System.out.print("Enter Date(YYYY-MM-DD):");
								String strDate=s.nextLine();
								Date date=Date.valueOf(strDate);
								System.out.print("Enter Workout Name :");
								String name=s.nextLine();
								System.out.print("Enter Workout Intensity :");
								String intensity=s.nextLine();
								System.out.print("Enter Workout Category :");
								String category=s.nextLine();
								System.out.print("Enter Time(mins) :");
								int time=s.nextInt();
								s.nextLine();
								System.out.print("Enter No. of Reps :");
								int reps=s.nextInt();
								s.nextLine();
								System.out.print("Enter Calories Burnt :");
								int cal=s.nextInt();
								s.nextLine();
								WorkoutLog workout=new WorkoutLog(date,name,intensity,time,reps,cal,userId,category);
								workoutDao.addWorkoutLog(workout);
								break;
							case 4:
								List<WorkoutLog> log=workoutDao.viewWorkoutLog(userId);
								 System.out.println("------------------------------------------------------------------------------------------------------------------------------");
							        System.out.printf("%-10s | %-15s | %-20s | %-15s | %-8s | %-8s | %-15s | %-10s |\n", 
							                "Id","Date", "Name", "Intensity", "Time (min)", "Reps", "Category", "Calories");
							        System.out.println("------------------------------------------------------------------------------------------------------------------------------");
		
							        for (WorkoutLog workoutLog : log) {
							            System.out.printf("%10s | %-15s | %-20s | %-15s | %-10d | %-8d | %-15s | %-10d |\n",
							                    workoutLog.getId(),
							                    workoutLog.getDate(),
							                    workoutLog.getName(),
							                    workoutLog.getIntensity(),
							                    workoutLog.getTime(),
							                    workoutLog.getReps(),
							                    workoutLog.getCategory(),
							                    workoutLog.getCalories());
							        }
							        System.out.println("------------------------------------------------------------------------------------------------------------------------------");
								break;
							case 5:
								System.out.print("Enter Date(YYYY-MM-DD):");
								String strDate2=s.nextLine();
								Date date2=Date.valueOf(strDate2);
								System.out.print("Enter Calories :");
								int foodCal=s.nextInt();
								s.nextLine();
								System.out.print("Enter Description : ");
								String des=s.nextLine();
								FoodLog food=new FoodLog(date2,foodCal,des,userId);
								foodDao.addFoodLog(food);
								break;
							case 6:
								List<FoodLog> logs = foodDao.viewFoodLog(userId);
							    System.out.println("--------------------------------------------------------------------------------------");
						        System.out.printf("%-10s | %-10s | %-15s | %-30s | %-8s |\n","Id", "User ID", "Date", "Description", "Calories");
						        System.out.println("--------------------------------------------------------------------------------------");
		
						        for (FoodLog foodLog : logs) {
						            System.out.printf("%-10d | %-10s | %-15s | %-30s | %-8d |\n",
						            		foodLog.getId(),
						                    foodLog.getUserId(),
						                    foodLog.getDate(),
						                    foodLog.getDescription(),
						                    foodLog.getCalories());
						        }
						        System.out.println("------------------------------------------------------------------------------------");
						   
						        break;
							case 7:
								goalsDao.updateGoal(userId);
								break;
								
							case 8:
								if(goalsDao.updateWeight(75, userId))
									System.out.println("Updated successfully");
								break;
							case 9:
								System.out.print("Enter Date(YYYY-MM-DD):");
								String str3=s.nextLine();
								Date date3=Date.valueOf(str3);
								goalsDao.viewNetCalories(date3, userId);
								break;
							case 10:
								System.out.print("Enter Workout Log Id to delete :");
								if(workoutDao.deleteWorkoutLog(s.nextInt()))
									System.out.println("\nSuccessfully Deleted");
								break;
							case 11:
								System.out.print("Enter Food Log Id to delete :");
								if(foodDao.deleteFoodLog(s.nextInt()))
									System.out.println("\nSuccessfully Deleted\n");
								break;
								
								 
						}
					}
				}
	
			}
		}
}

}
