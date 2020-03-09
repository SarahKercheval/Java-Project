import java.util.Scanner;
import javax.swing.JOptionPane;
import java.io.*;
import java.util.Random;

public class DiceRoll{//aka rolls and secret methods lol

   //method for prompting dice roll
      public static int randomDiceRollPrompt(){
         
         JOptionPane.showMessageDialog(null, "Please press 'Ok' for a your dice roll.");
              
         int diceOutcome;
         diceOutcome = randomDiceRoll();            
         //JOptionPane.showMessageDialog(null, diceOutcome);
         return diceOutcome; 
      }
      //method for random dice outcome 
      public static int randomDiceRoll(){
              
               Random diceRoll = new Random();
               int diceOutcome;
            
               int rollOutput = diceRoll.nextInt(20)+1;
               if(rollOutput == 1){
                  diceOutcome = 1;
               }else if(rollOutput < 10 && rollOutput > 1){
                  diceOutcome = 2;
               }else if(rollOutput >= 10 && rollOutput < 20){
                  diceOutcome = 3;
               }else 
                  diceOutcome = 4;
                  
                return diceOutcome;
      }






}