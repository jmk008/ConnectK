public class gameChecker {
	 
	static String[][] result;
	
	//Initialize final result
	public static void initialize()
	{
		for(int i=0; i<result.length; i++)
		{
			for(int j=0; j<result[i].length; j++)
			{
				result[i][j] = "|";
			}
		}
	}
	
	//Show final result with highlighted elements
	public static void showResult(gameGrid game, int row, int column, int k, char chip)
	{
		for(int i=0; i<result.length; i++)
		{
			for(int j=0; j<result[i].length; j++)
			{
				if(result[i][j] == "|")
				{
					result[i][j] = Character.toString(game.grid[i][j]);
				}
			}
		}
		
		System.out.println();
		for(int i=0; i<result.length; i++)
		{
			for(int j=0; j<result[i].length; j++)
			{
				System.out.print(result[i][j] + "\t");
			}
			System.out.println();
		}
		for(int i=1; i<=result[0].length; i++)
		{
			System.out.print(i+"\t");
		}
		System.out.println("\n");
	}
	
	//check if 'K' chips are in a row
	public static int check(gameGrid game, int column, int k, char chip)
	{
		result = new String[game.grid.length][game.grid[0].length];
		initialize();
		
		int win=1,draw=0;
		int row = game.getRow(column);
		
		if(checkSouth(game, row, column, k, chip))
		{
			showResult(game, row, column, k ,chip);
			return win;
		}
		if(checkEast(game, row, column, k, chip))
		{
			showResult(game, row, column, k ,chip);
			return win;
		}
		if(checkWest(game, row, column, k, chip))
		{
			showResult(game, row, column, k ,chip);
			return win;
		}
		if(checkNorthEast(game, row, column, k, chip))
		{
			showResult(game, row, column, k ,chip);
			return win;
		}
		if(checkNorthWest(game, row, column, k, chip))
		{
			showResult(game, row, column, k ,chip);
			return win;
		}
		if(checkSouthEast(game, row, column, k, chip))
		{
			showResult(game, row, column, k ,chip);
			return win;
		}
		if(checkSouthWest(game, row, column, k, chip))
		{
			showResult(game, row, column, k ,chip);
			return win;
		}
		
		if(gridFull(game))
		{
			return draw;
		}
		return -1;
	}
	
	//checks if 'K' chips align below the last inserted chip
	static boolean checkSouth(gameGrid game, int row, int column, int k, char chip)
	{
		int i=0;
		for(; i<k; i++)
		{
			if(row + i < game.grid.length)
			{
				if(game.grid[row+i][column] == chip)
				{
					result[row+i][column] = "["+chip+"]";
					continue;
				}
				else
				{
					initialize();
					break;
				}
			}
			else
			{
				initialize();
				break;
			}
		}
		if(i == k)
		{
			return true;
		}
		return false;
	}
	
	//checks if 'K' chips align to right of the last inserted chip
	static boolean checkEast(gameGrid game, int row, int column, int k, char chip)
	{
		int i=0;
		for(; i<k; i++)
		{
			if(column + i < game.grid[row].length)
			{
				if(game.grid[row][column+i] == chip)
				{
					result[row][column+i] = "["+chip+"]";
					continue;
				}
				else
				{
					initialize();
					break;
				}
			}
			else
			{
				initialize();
				break;
			}
		}
		
		if(i == k)
		{
			return true;
		}
		return false;
	}
	
	//checks if 'K' chips align to left of the last inserted chip
	static boolean checkWest(gameGrid game, int row, int column, int k, char chip)
	{
		int i=0;
		for(; i<k; i++)
		{
			if(column - i >= 0)
			{
				if(game.grid[row][column-i] == chip)
				{
					result[row][column-i] = "["+chip+"]";
					continue;
				}
				else
				{
					initialize();
					break;
				}
			}
			else
			{
				initialize();
				break;
			}
		}
		
		if(i == k)
		{
			return true;
		}
		return false;
	}
	
	//checks if 'K' chips align diagonally in north-east of the last inserted chip
	static boolean checkNorthEast(gameGrid game, int row, int column, int k, char chip)
	{
		int i=0;
		for(; i<k; i++)
		{
			if(row - i >=0 && column + i < game.grid[row].length)
			{
				if(game.grid[row-i][column+i] == chip)
				{
					result[row-i][column+i] = "["+chip+"]";
					continue;
				}
				else
				{
					initialize();
					break;
				}
			}
			else
			{
				initialize();
				break;
			}
		}
		if(i == k)
		{
			return true;
		}
		return false;
	}
	
	//checks if 'K' chips align diagonally in north-west of the last inserted chip
	static boolean checkNorthWest(gameGrid game, int row, int column, int k, char chip)
	{
		int i=0;
		for(; i<k; i++)
		{
			if(row - i >=0 && column - i >=0)
			{
				if(game.grid[row-i][column-i] == chip)
				{
					result[row-i][column-i] = "["+chip+"]";
					continue;
				}
				else
				{
					initialize();
					break;
				}
			}
			else
			{
				initialize();
				break;
			}
		}
		if(i == k)
		{
			return true;
		}
		return false;
	}
	
	//checks if 'K' chips align diagonally in south-east of the last inserted chip
	static boolean checkSouthEast(gameGrid game, int row, int column, int k, char chip)
	{
		int i=0;
		for(; i<k; i++)
		{
			if(row + i < game.grid.length && column + i < game.grid[row].length)
			{
				if(game.grid[row+i][column+i] == chip)
				{
					result[row+i][column+i] = "["+chip+"]";
					continue;
				}
				else
				{
					initialize();
					break;
				}
			}
			else
			{
				initialize();
				break;
			}
		}
		if(i == k)
		{
			return true;
		}
		return false;
	}
	
	//checks if 'K' chips align diagonally in south-west of the last inserted chip
	static boolean checkSouthWest(gameGrid game, int row, int column, int k, char chip)
	{
		int i=0;
		for(; i<k; i++)
		{
			if(row + i < game.grid.length && column - i >= 0)
			{
				if(game.grid[row+i][column-i] == chip)
				{
					result[row+i][column-i] = "["+chip+"]";
					continue;
				}
				else
				{
					initialize();
					break;
				}
			}
			else
			{
				initialize();
				break;
			}
		}
		if(i == k)
		{
			return true;
		}
		return false;
	}
	
	//Check if grid is full which would result in a draw
	static boolean gridFull(gameGrid game)
	{
		int i=0;
		for(; i<game.grid[0].length;i++)
		{
			if(game.grid[0][i] != '|')
			{
				continue;
			}
			else
			{
				break;
			}
		}
		if(i == game.grid[0].length)
		{
			return true;
		}
		return false;
	}
}