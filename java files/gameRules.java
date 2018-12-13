
public class gameRules {
	
	public gameRules() {
		
		/**
		 * There are two players (Red vs Black) and one player goes at a time.
		 * A player selects a column number to drop a chip into (they can not select a column that is already full of chips)
		 * The chip falls to the first open slot in the selected column.
		 * The first player to get k chips in a row (horizontal, vertical, or diagonal) wins the game
		 * If no player does this before the board is full the game ends in a draw.
		 * users should be able to specify the value of k
		 */
		
		System.out.println("\nRules/How to Play:\n"
				+ "1) There are two players (Red vs Black) and one player goes at a time.\n"
				+ "2) A player selects a column number to drop a chip into if the column is already not full\n"
				+ "3) The chip falls to the first open slot in the selected column.\n"
				+ "4) The user will specify the value of K\n"
				+ "5) The first player to get K chips in a row (horizontal, vertical, or diagonal) wins the game\n"
				+ "6) If no player does this before the board is full the game ends in a draw.\n");
	}
}
