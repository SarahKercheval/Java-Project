import java.util.Random;
import java.io.*;
import javax.swing.JOptionPane;
import java.util.Scanner;

public class MAIN{
      
   public static void main(String[] args)throws IOException{
   
      Scanner scan = new Scanner(System.in);
      System.out.println("Please read the read me before playing");
      System.out.println("Type a word to start the game!");
      System.out.println(scan.nextLine());
      JOptionPane.showMessageDialog(null, "Welcome to the Death House");
      
      FLOORS call = new FLOORS();
      ROOMS calling = new ROOMS();
        
        calling.CharacterSetupInMain();
      
      boolean inMainHouse = true;  
          
         call.OutsideHouse();

         call.getEntrance();
         
      //describe the opening into the first floors
      JOptionPane.showMessageDialog(null, "You open the doors, they swing open into a wide hall that runs the width of the house.");
      JOptionPane.showMessageDialog(null, "There’s a black marble fireplace on the leftmost wall with a sword mounted above it, and a sweeping, red marble staircase on the other wall." + "\n" +  "Across from you is a door, and to your right another one.");
         //calling floor one
         call.FloorOne();
      
      
      //while loop to determine what floor the character is on
      while(inMainHouse){
      
         if(!call.getThirdFloor() && call.getInAttic()){//if the character has chosen to leave the third floor and go into the attic, this loop will exit
            inMainHouse = false;
         }
         //if loop to determine which floor the character is on/going to
         if(call.getFirstStairs() && !call.getSecondStairs() && !call.getThirdStairs()){
            call.FirstStairs();
         }else if(call.getSecondStairs() && !call.getFirstStairs() && !call.getThirdStairs()){
            call.SecondStairs();
         }else if(call.getThirdStairs() && !call.getSecondStairs() && !call.getFirstStairs()){
            call.ThirdStairs();
         }
         
         //if loop to call on the floor the character is on based on the previous if loop
            if(call.getFirstStairs() && !call.getSecondStairs() && !call.getThirdStairs()){
               call.FloorOne();
            }else if(call.getSecondStairs() && !call.getFirstStairs() && !call.getThirdStairs()){
               call.FloorTwo();
            }else if(call.getThirdStairs() && !call.getSecondStairs() && !call.getFirstStairs()){
               call.FloorThree();
            }
       
      }//end while inMainHouse   
      
        
           
      
      /*
      
      
      call.FloorAttic();
      
      call.FloorDungeon();
      */

   }//end of main method

}//end of class