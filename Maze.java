import java.util.*;
import java.io.*;
public class Maze{
    private char[][]maze;
    private boolean animate;//false by default
    private int rowOfS, colOfS ;
    private int[][] directions ;

     public Maze(String filename) throws FileNotFoundException {
    animate = false ;
    int[][] moves = { {0, -1}, {-1, 0}, {0, 1}, {1, 0} } ;
    directions = moves ;
    int len = 0, width = 0 ;
    File f = new File(filename) ;
    Scanner s = new Scanner(f) ;
    String line = "" ;
    while (s.hasNextLine()) {
      line = s.nextLine() ;
      len++ ;
    }
    width = line.length() ;
    maze = new char[len][width] ;
    Scanner adding = new Scanner(f) ;
    int row = 0, numberOfStarts = 0, numberOfEnds = 0 ;
    rowOfS = -1 ;
    colOfS = -1 ;
    while (adding.hasNextLine() && row < maze.length) {
      line = adding.nextLine() ;
      for (int i = 0 ; i < line.length() ; i++) {
        maze[row][i] = line.charAt(i) ;
        if (line.charAt(i) == 'S') {
          rowOfS = row ;
          colOfS = i ;
          numberOfStarts+= 1 ;
        }
        if (line.charAt(i) == 'E') numberOfEnds+= 1 ;
      }
      row++ ;
    }
    if (rowOfS == -1 || numberOfStarts != 1 || numberOfEnds != 1) {
      throw new IllegalStateException("The start and end are either missing, or there's more than one of each!") ;
    }
  }


    private void wait(int millis){
     try {
         Thread.sleep(millis);
     }
     catch (InterruptedException e) {
     }
   }


    public void setAnimate(boolean b){
    animate = b;
  }


  public void clearTerminal(){
    //erase terminal, go to top left of screen
    System.out.println("\033[2J\033[1;1H");
  }


  public String toString(){
    String ans = "";
    for(int r = 0; r < maze.length; r++){
      for(int c = 0; c < maze[0].length; c++){
        ans += maze[r][c];
      }
        ans += "\n" ;
    }
    return ans;
  }

    public int solve() {
        maze[rowOfS][colOfS] = '@' ;
        return solveH(rowOfS, colOfS,0) ;
  }
    private int solveH(int row, int col, int lengthOfSolution) {
    if (animate) {
      clearTerminal() ;
      System.out.println(this) ;
      wait(20) ;
    }
    if (maze[row][col] == 'E') {
      setAnimate(false) ;
      System.out.println(lengthOfSolution) ;
      return lengthOfSolution ;
    }
    int tempR, tempC ;
    for (int i = 0 ; i < 4 ; i++) {
      tempR = row + directions[i][0] ;
      tempC = col + directions[i][1] ;
      if (tempR >= 0 && tempR <= maze.length - 1 && tempC >= 0
      && tempC <= maze[0].length - 1 && maze[tempR][tempC] == ' ') {
        maze[tempR][tempC] = '@' ;
        solveH(tempR, tempC, lengthOfSolution + 1) ;
      }
    }
    for (int a = 0 ; a < 4 ; a++) {
      tempR = row + directions[a][0] ;
      tempC = col + directions[a][1] ;
      if (maze[tempR][tempC] == 'E') solveH(tempR, tempC, lengthOfSolution) ;
    }
    maze[row][col] = '•' ;
    lengthOfSolution-- ;
    return -1 ;
  }

}
