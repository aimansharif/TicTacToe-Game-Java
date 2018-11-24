/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Scanner;
/**
 *
 * @author Md Aiman Sharif
 */

/**
 * A class representing the game play of TicTacToe.
 * Declares variables needed for the TicTacToe game. 
 * @author Md Aiman Sharif
 */
public class TicTacToe {
   private int nRows; //the number of rows in the grid
   private int nColumns; //the number of columns in the grid
   private int numToWin; //needs 3 in a row to win
   private char grid[][]; //holds the characters 'x' or 'o'
   private char turn; //Alternates between 'x' and 'o'
   private TicTacToeEnum gameState; //store the progress of the game
   private int nMarks; //used to detect whether the game is draw or not.
   
   /**
    * Default constructor initializing a new 3 by 3 grid and nMarks to 0;
    * @param initialTurn stores the initial turn of the game. 
    */
   public TicTacToe(char initialTurn){
      this.turn = initialTurn;
      this.nMarks = 0;
      this.grid = new char[3][3];
      reset(initialTurn);
   }
   
   /**
    * overloaded constructor initializing the variables.
    * @param nRows number of the rows in the array 
    * @param nColumns number of columns in the array
    * @param numToWin number required in a row to win the game 
    * @param initialTurn initial turn in the game
    */
   public TicTacToe(int nRows, int nColumns, int numToWin, char initialTurn){
      this.nRows = 3;
      this.nColumns = 3;
      this.numToWin = 3; 
      this.grid = new char[nRows][nColumns];

      reset(initialTurn);
      
      if(nRows < 0 || nColumns < 0 || numToWin < 0)
         throw new IllegalArgumentException ("Parameters cannot be negative values.");
   }
   
   /**
    * Converts 'x' or 'o' into the corresponding value in the ENUM.
    * @param player player's turn to make a move.
    * @return IN_PROGRESS progress of the game
    */
   private TicTacToeEnum charToEnum(char player){
      TicTacToeEnum IN_PROGRESS = TicTacToeEnum.IN_PROGRESS;
      return IN_PROGRESS;
   }

   /**
    * checks each grid horizontally and vertically to see if the values are the same
    * @return ENUM O_WON or O_WON or DRAW depending on who won the game.
    */
   private TicTacToeEnum findWinner(){
      if(grid[0][0] == 'X' && grid[0][1] == 'X' && grid[0][2] == 'X'){
         TicTacToeEnum X_WON = TicTacToeEnum.X_WON;
      }
      else if(grid[0][0] == 'O' && grid[0][1] == 'O' && grid[0][2] == 'O'){
         TicTacToeEnum O_WON = TicTacToeEnum.O_WON;
      }
         
      if(grid[1][0] == 'X' && grid[1][1] == 'X' && grid[1][2] == 'X'){
         TicTacToeEnum X_WON = TicTacToeEnum.X_WON;
      }
      else if(grid[1][0] == 'O' && grid[1][1] == 'O' && grid[1][2] == 'O'){
         TicTacToeEnum O_WON = TicTacToeEnum.O_WON;
      }
      
      if(grid[2][0] == 'X' && grid[2][1] == 'X' && grid[2][2] == 'X'){
         TicTacToeEnum X_WON = TicTacToeEnum.X_WON;
      }
      else if(grid[2][0] == 'O' && grid[2][1] == 'O' && grid[2][2] == 'O'){
         TicTacToeEnum O_WON = TicTacToeEnum.O_WON;
      }
         
      if(grid[0][0] == 'X' && grid[1][0] == 'X' && grid[2][0] == 'X'){
         TicTacToeEnum X_WON = TicTacToeEnum.X_WON;
      }
      else if(grid[0][0] == 'O' && grid[1][0] == 'O' && grid[2][0] == 'O'){
         TicTacToeEnum O_WONN = TicTacToeEnum.O_WON;   
      }
         
      if(grid[0][1] == 'X' && grid[1][1] == 'X' && grid[2][1] == 'X'){
         TicTacToeEnum X_WON = TicTacToeEnum.X_WON;
      }
      else if(grid[0][1] == 'O' && grid[1][1] == 'O' && grid[2][1] == 'O'){
         TicTacToeEnum O_WONN = TicTacToeEnum.O_WON; 
      }
      
     if(grid[0][2] == 'X' && grid[1][2] == 'X' && grid[2][2] == 'X'){
         TicTacToeEnum X_WON = TicTacToeEnum.X_WON;
      }
      else if(grid[0][2] == 'O' && grid[1][2] == 'O' && grid[2][2] == 'O'){
         TicTacToeEnum O_WON = TicTacToeEnum.O_WON;   
         return O_WON;
      }
     return TicTacToeEnum.DRAW;
   }
  
   /**
    * Resets the game on being called.
    * sets each grid to an empty character to start the game again.
    * @param initialTurn initial turn of the player to make a move
    */
   public void reset(char initialTurn){
      for(int i = 0; i < grid.length; i++){
         for(int j = 0; j < grid.length; j++){
            grid[i][j] = ' ';
         }
      }
      this.turn = initialTurn;
   }
   
   /**
    * gets the turn of the player to make the next move.
    * @return turn the turn of the player to make a move.
    */
   public int getTurn(){
      return turn;
   }
   
   /**
    * gets the game state
    * @return IN_PROGRESS progress of the game so far.
    */
   public TicTacToeEnum getGameState(){
      TicTacToeEnum IN_PROGRESS = TicTacToeEnum.IN_PROGRESS;
      return IN_PROGRESS;
   }
   
   /**
    * alternates the player's turns and sets the grid to the value assigned by the player
    * @param row the row at which the value will be set
    * @param column the column at which the value will be set.
    * @return findWinner checks to see in each turn whether a winner has been found or not.
    */
   public TicTacToeEnum takeTurn(int row, int column){
      grid[row][column] = turn; //assigns 'x' or 'o' in the grid column and row.
      if(turn == 'X'){
         turn = 'O';
      }
      else{
         turn = 'X';
      }
      return findWinner();
   }
   
   /**
    * outputs the default grid of the game and puts 'x' or 'o' according to the turn of player. 
    * @return 
    */
   public String toString(){
      String board = "";
      for(int i = 0; i < grid.length; i++){
         for(int j = 0; j < grid.length; j++){
            board += grid[i][j];
            board += " | ";
         }
         board += "\n";
      }
      return board;
   }
  
   public static void main(String args[]) {
        TicTacToe game = new TicTacToe('X');
        Scanner scanner = new Scanner(System.in);
        
        do { 
            System.out.println(game.toString());
            System.out.println(game.getTurn() + 
                ": Where do you want to mark? Enter row column");
            int row = scanner.nextInt();
            int column = scanner.nextInt();
            scanner.nextLine();
            game.takeTurn(row, column);
            
        } while (game.getGameState() == TicTacToeEnum.IN_PROGRESS);
        System.out.println( game.getGameState());

    }
}

