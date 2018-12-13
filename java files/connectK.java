import java.util.Scanner;

public class connectK {
	
	Scanner sc = new Scanner(System.in);
	
	//Game parameters
	int k;
	int grid_length;
	int grid_height;
	char player_1;
	char player_2;
	gameGrid grid;
	
	public connectK() //Initializing game
	{	
		
		//setting up grid parameters, handle invalid input
		System.out.println("\nInitializing grid:");
		
		System.out.print("Enter Grid Length (number of columns, Recommended between 7 - 10):");
		grid_length = sc.nextInt();
		
		System.out.print("Enter Grid Height (number of rows, Recommended between 7 - 10):");
		grid_height = sc.nextInt();
		
		System.out.println();
		grid = new gameGrid(grid_length, grid_height);
		
		//Draw initial grid
		grid.drawGrid();
		
		//setting up value of K, handle large K values which would lead to draw
		int wish=0; 
		do 
		{
			System.out.println("Enter value of K less than or equal to " + Math.max(grid_length, grid_height) + ":");
			k = sc.nextInt();
			
			if(k > Math.max(grid_length, grid_height))
			{
				System.out.println("Setting the value of K bigger than "+Math.max(grid_length, grid_height)+ " will result in a draw");
				System.out.println("Do you wish to continue anyway? 1-No 2-Yes");
				wish = sc.nextInt();
			}
			else
			{
				break;
			}
		}while(wish != 2);
	}
	
	public void startGame()
	{
		//Random user selection to start first
		String first_move = "Red";
		player_1 = 'R';
		String second_move = "Black";
		player_2 = 'B';
		int random = (int)(Math.random() * 2);
		
		switch(random)
		{	
			case 1:
				first_move = "Black";
				player_1 = 'B';
				second_move = "Red";
				player_2 = 'R';
				break;
		}
		System.out.println("\n"+first_move+" plays first!\n");
		
		int first_move_chip_column;
		int second_move_chip_column;
		
		//Game begins, each player plays the turn
		do
		{
			//Player 1 move
			do
			{
				System.out.println("Player "+first_move+": Select column to drop your chip");
				first_move_chip_column = sc.nextInt();
			}while(grid.insertMove(player_1, first_move_chip_column-1) != true);	
			
			//Checking if 'K' chips are in a row
			int result = gameChecker.check(grid,first_move_chip_column-1, k, player_1);
			
			//Game Winner
			if(result == 1)
			{
				System.out.println("Player "+first_move + " wins!!!\n");
				break;
			}
			
			//Game Draw
			if(result == 0)
			{
				System.out.println("\nGame Draw: Grid is full!\n");
				break;
			}
			grid.drawGrid();
			
			//Player 2 move
			do
			{
				System.out.println("Player "+second_move+": Select column to drop your chip");
				second_move_chip_column = sc.nextInt();
			}while(grid.insertMove(player_2, second_move_chip_column-1) != true);
			
			//Checking if 'K' chips are in a row
			result = gameChecker.check(grid,second_move_chip_column-1, k, player_2);
			
			//Game Winner
			if(result == 1)
			{
				System.out.println("Player "+second_move + " wins!!!\n");
				break;
			}
			
			//Game draw
			if(result == 0)
			{
				System.out.println("Game Draw: Grid is full!\n");
				break;
			}
			grid.drawGrid();
			
		}while(true);
	}
}