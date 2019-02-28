import java.util.*;
import java.io.*;
public class Maze{
    private char[][]maze;
    private boolean animate;//false by default

    public Maze(String filename) throws FileNotFoundException{
        //COMPLETE CONSTRUCTOR
        animate = false;
        File text = new File(filename);
        Scanner s = new Scanner(text);
        String line = "";
        while(s.hasNextLine()){
          line += s.nextLine();
          line += "\n";

        }
        int row = 0;
        int col = 0;
        for(int i = 0; i < line.length(); i++){
          if(line.charAt(i) == '\n'){//to get number of rows
            row++;
          }
        }
        col = line.length() / row;//to calculate number of cols
        maze = new char[row][col];
        int index = 0;//to keep track of the index of line 
        //save the maze into an array
        for(int r = 0;r <maze.length; r++){
          for(int c = 0; c < maze[0].length; c++){
            maze[r][c]= line.charAt(index);
            index++; 
          }
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

}
