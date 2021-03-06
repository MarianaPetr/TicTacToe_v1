/*
 * This Java source file was generated by the Gradle 'init' task.
 */
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import static org.testng.Assert.*;

import org.testng.Assert;

public class AppTest {
    @Test public void checkBoardAfterSomeMoves() {
        Board board = new Board();
        Player player1 = new Player("Test", Signs.X);
        Player player2 = new Player("Test", Signs.O);
        SoftAssert sa = new SoftAssert();
        player1.SetMove(board, 1);
        player2.SetMove(board, 5);
        char[][] expectedBoard= { { 'X', ' ', ' ' }, { ' ', 'O', ' ' }, { ' ', ' ', ' ' } };
        for(int i = 0; i < 3; i++)
        	 for(int j = 0; j < 3; j++)
        		 sa.assertEquals(board.board[i][j], expectedBoard[i][j]);
        sa.assertAll();
    }
    
    @Test public void checkFreeSpaceExistsOnTheBoard() {
        Board board = new Board();
        Player player1 = new Player("Test", Signs.X);
        for(int i=1; i<8;i++){
        	player1.SetMove(board, i);
        board.printBoard();
        assertEquals(board.isNextMove, true );
        }
    }
    
    @Test public void checkFreeSpaceNotExistsOnTheBoard() {
        Board board = new Board();
        Player player1 = new Player("Test", Signs.X);
        for(int i=1; i<=9;i++)
        	player1.SetMove(board, i);
        board.printBoard();
        assertEquals(board.isNextMove, false );
    }
    
    @Test public void checkProperSignAssigned2ndUser(){
    	Board board = new Board();
    	Player player1 = new Player("X", Signs.O);
    	Player player2 = new Player("O", new InputHandler().assignSignThatIsLeft(player1.sign));
    	assertEquals(player2.sign, Signs.X);
    			
    }
    
    @DataProvider(name="winCombinaions")
    public Object[][] winCombinaions(){
    	return new Object[][]{
    		{1,2,3},
    		{4,5,6},
    		{7,8,9},
    		{1,4,7},
    		{2,5,8},
    		{3,6,9},
    		{1,5,9},
    		{3,5,7}
    		
    	};
    }
    		
    /*This test is not working yet...*/
    @Test//(dataProvider="winCombinaions")
    public void checkWinCombinations(){
    	Board board = new Board();
    	Game game = new Game();
    	Player player1 = new Player("Test", Signs.X);
    	Player player2 = new Player("Test", Signs.O);
    	player1.SetMove(board, 1);	
    	player1.SetMove(board, 2);	
    	player1.SetMove(board, 4);	
    	Assert.assertTrue(game.checkWin(board, player1.sign));
    }
}
