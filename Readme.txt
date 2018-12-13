1) Running the program
	- Double Click the RUN.bat file to run the program on Windows.

Note: Please use numbers as input. Bad and illegal inputs have been handled in the program.

2) The java files have been provided in "java files" folder
	- 1)The connectgame.java is the Main class, from where the program starts.
		- It contains the Game menu having "game start", "game rules" and "exit".

	- 2)connectK.java contains the logic where players take turns and play the game.
		- Game initialization such as setting up grid values, value of K, which player should play first
		  has been handled by this class.
	
	- 3)gameGrid.java deals with setting up the main grid, inserting player chip, and drawing the grid after a chip 
	    has been inserted.
	
	- 4)gameChecker.java handles the logical part of the game. with every chip inserted in the grid, 
	    game checker checks for a 'K' chip row in the surroundings of the inserted chip.

	- 5) gameRules.java provides the user with the rules and condition of the game.