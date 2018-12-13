import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author Jaimik
 *
 */

//Main Class
public class connectgame {
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		/**
		 *  Welcome menu part
		 *  Options: Play, Rules, Exit
		 *  Create functions/class for Play, rules.
		 */
		
		System.out.println("Welcome to ConnectK game!");
		int option;
		do
		{
			System.out.println("Select Option, Press 1-Play Game, 2-Rules, 3-Exit");
			
			//Handle invalid user inputs
			try
			{
				option = sc.nextInt();
			}
			catch(InputMismatchException e)
			{
				option = 0;
				sc.nextLine();
			}
			
			switch(option)
			{
				case 1: 
					connectK game = new connectK(); //Initialize game
					game.startGame(); //start game
					break;
					
				case 2:
					new gameRules();//Show rules to user
					break;
					
				case 3:
					break;
					
				default:
					System.out.println("Invalid Input, Enter a number between 1-3, Try Again...\n");
			}
			
		}while(option != 3);
		
		System.out.println("\nThank you for playing :) \n");
		sc.close();
	}

}