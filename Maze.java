/*import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Arrays;
public class Maze{
  public static void main(String[] args) throws FileNotFoundException {
    File text = new File("Maze1.txt");
    Scanner s = new Scanner(text);
    while(s.hasNextLine()){
      String line = s.nextLine();
      System.out.println(line);
    }
    char[] ary = new char[315];
    while(s.hasNextLine()){
      String x = s.nextLine();
      int a = 0;
      for(int i = 0; i < x.length(); i++){
        ary[a] = x.charAt(i);
        a++;
      }
      a++;
    }
    for(int c = 0; c < ary.length; c++)
    System.out.print(ary[c]);
  }
}*/
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
        while(s.hasNextLine()){
          String line = s.nextLine();
          System.out.println(line);
        }
        //save maze as an array
        


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
