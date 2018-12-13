public class gameGrid {
	char grid[][];
	
	//Constructor
	public gameGrid(int columns, int rows) 
	{
		//initialize grid variable
		grid = new char[rows][columns];
		initializeGrid();
	}
	
	private void initializeGrid()
	{
		for(int i=0; i<grid.length; i++)
		{
			for(int j=0;j<grid[i].length;j++)
			{
				grid[i][j] = '|';
			}
		}
	}
	
	//Inserting chip
	public boolean insertMove(char chip, int column)
	{
		boolean inserted = false;
		
		//Handling a value greater than number of columns
		if(column >= grid[0].length)
		{
			System.out.println("Your input exceeds the maximum column number, try again");
			return inserted;
		}
		for(int i=grid.length-1; i>=0; i--)
		{
			if(grid[i][column] == '|')
			{
				grid[i][column] = chip;
				inserted = true;
				break;
			}
		}
		//Handling if a column is full
		if(inserted == false)
		{
			System.out.println("Cannot place chip as no empty slots remain, please try another column");
		}
		return inserted;
	}
	
	//get row number for last inserted chip
	public int getRow(int column)
	{
		int i;
		for(i=grid.length-1; i>=0; i--)
		{
			if(grid[i][column] == '|')
			{
				i += 1;
				break;
			}
		}
		if(i < 0)
		{
			return 0;
		}
		return i;
	}
	
	//draws the grid with updated elements
	public void drawGrid()
	{
		System.out.println();
		for(int i=0; i<grid.length; i++)
		{
			for(int j=0; j<grid[i].length; j++)
			{
				System.out.print(grid[i][j] + "\t");
			}
			System.out.println();
		}
		for(int i=1; i<=grid[0].length; i++)
		{
			System.out.print(i + "\t");
		}
		System.out.println("\n");
	}
}