import java.util.Scanner;
import javax.swing.JOptionPane;
import java.io.*;
import java.util.Random;

public class FLOORS{//aka floors and charactersetup

   public boolean WentUp;

  

   //fields, mostly boolean for the sake of it being only true or false, keeps things simple
   public boolean GoDownstairs;
   public boolean firstStairs;
   public boolean secondStairs;
   public boolean thirdStairs;
   public boolean ExitMain;
   public boolean InFirstFloor;
   public boolean InSecondFloor;
   public boolean OnThirdFloor;
   public boolean InAttic;
   public boolean InDungeon;

   

   ROOMS callRoom = new ROOMS();
   DiceRoll randomdice = new DiceRoll();
   int rollDice = randomdice.randomDiceRollPrompt();
   
   //method for calling boolean GoDownstairsto determine if main should recall a diff floor
   public boolean GoDownstairs(){
      return GoDownstairs;     
   }
   //method for calling if firstStairs boolean is true
   public boolean getFirstStairs(){
      return firstStairs;
   }   
   //method for calling if secondStairs boolean is true or false
   public boolean getSecondStairs(){
      return secondStairs;
   }
   //method for calling if thirdStairs boolean is true or false
   public boolean getThirdStairs(){
      return thirdStairs;
   }
   //method for calling the boolean to exit the main part of the house
   public boolean getExitMain(){
      return ExitMain;
   }
   //return what floor the player is o
   public boolean getFirstFloor(){
      return InFirstFloor;
   }
   public boolean getInSecondFloor(){
      return InSecondFloor;
   }
   public boolean getInAttic(){
      return InAttic;
   }
   public boolean getThirdFloor(){
      return OnThirdFloor;
   }
   public boolean getInDungeon(){
      return InDungeon;
   }   
   
//STAIRS (or transitions)

   public void FirstStairs(){
   
      firstStairs = true;
      secondStairs = false;
      thirdStairs = false;
      
         while(firstStairs){
            //Floor One ends by going up the stairs   
            JOptionPane.showMessageDialog(null, "Walking up the stairs, you come across a landing onto the second floor of the house.");
            //Ask if want to go to third floor or stay on second
            String StairsFF = JOptionPane.showInputDialog(null, "Would you like to continue upwards or explore the second floor?" + "\n" + "1. Explore the second floor" + "\n" + "2. Continue upwards");
            int stairsFF = Integer.parseInt(StairsFF);
            //if loop for going to floor three or staying on second floor
            if(stairsFF == 1){//second floor
               firstStairs = false;
               secondStairs = true;
               thirdStairs = false;
      
            }else if(stairsFF == 2){//third floor
               JOptionPane.showMessageDialog(null, "Ascending the top of the stairs, you come to a dusty balcony looking over the stairs, with a suit of black plate armor standing against one wall, draped in cobwebs.");
               JOptionPane.showMessageDialog(null, "You can see that there’s two seperate doors in front of you, another door to the left of you near the suit of armor, " + "\n" + "and a set of double doors with dusty glass panes on the wall to your right."); 
               firstStairs = false;
               secondStairs = false;
               thirdStairs = true;
 
            }//end if loop
         }//end while firstStairs
   }
   
   public void SecondStairs(){
      
      secondStairs = true;
      firstStairs = false;
      thirdStairs = false;
      
         while(secondStairs){
            //Floor Two ends by choosing to go up or down the stairs
            String StairsSS = JOptionPane.showInputDialog(null, "Would you like to ascend the stairs or go down to the first floor?" + "\n" + "1. Ascend the stairs" + "\n" + "2. Go to the first floor");
            int stairsSS = Integer.parseInt(StairsSS);
            //if loop to go up the stairs or down the stairs
               if(stairsSS == 1){//go upstairs
                  JOptionPane.showMessageDialog(null, "Ascending the top of the stairs, you come to a dusty balcony looking over the stairs, with a suit of black plate armor standing against one wall, draped in cobwebs.");
                  JOptionPane.showMessageDialog(null, "You can see that there’s two seperate doors in front of you, another door to the left of you near the suit of armor, " + "\n" + "and a set of double doors with dusty glass panes on the wall to your right.");
                  secondStairs = false;
                  firstStairs = false;
                  thirdStairs = true;
                  
               }else if(stairsSS == 2){//go downstairs
                  JOptionPane.showMessageDialog(null, "You walk back downstairs, finding yourself in the main hall again.");
                  secondStairs = false;
                  thirdStairs = false;
                  firstStairs = true;
             
               }
            
         }//end while secondStairs
   
   }
   
   public void ThirdStairs(){
   
      thirdStairs = true;
      secondStairs = false;
      firstStairs = false;
      
         while(thirdStairs){
            //the choice to go downstairs from the third floor
            if(GoDownstairs = true){
               String GODownstairs = JOptionPane.showInputDialog(null, "Which floor would you like to go to?" + "\n" + "1. First floor"+ "\n" + "2. Second floor");
               int goDownstairs = Integer.parseInt(GODownstairs);
               //if loop for going downstairs
               if(goDownstairs == 1){//go to the first floor
                  JOptionPane.showMessageDialog(null, "You walk back down to the first floor, and find yourself in the main hall again.");
                  firstStairs = true;
                  secondStairs = false;
                  thirdStairs = false;
               }else if(goDownstairs == 2){//go the the second floor
                  JOptionPane.showMessageDialog(null, "Walking back down the stairs, you make you way to the second floor landing.");
                  firstStairs = false;
                  secondStairs = true;
                  thirdStairs = false;
               }
            }

            
         }//end while thirdStairs
   }   
   
   public void OutsideHouse(){
      //talk with the children
      //loop options forcing the player to go inside the house
      boolean whileOutside = true;
      
      JOptionPane.showMessageDialog(null,  "You are traveling along a gravel road, thick mist surrounding you on all sides. ");
      JOptionPane.showMessageDialog(null, "A soft whimpering draws your eye toward a pair of children standing in the middle of an otherwise lifeless street.");
      while(whileOutside){
         boolean Starting = true;//loop that forces player to talk to the children to continue game
            while(Starting){
               String Start = JOptionPane.showInputDialog(null, "Seeing the children, do you approach or call out to them?" +"\n" + "1. Yes" + "\n" + "2. No");
               int start = Integer.parseInt(Start);
               //if loop for talking with the children
                  if(start == 1){//yes talk w children
                     boolean TalkChildren;
                     JOptionPane.showMessageDialog(null, "Approaching, you can see that the children appear to be a girl and her younger brother." + "\n" + "Seeing you approach, the girl shushes her brother, then turns to you and says, " +"\n" + "''There’s a monster in our house!''");
                     JOptionPane.showMessageDialog(null, "She points to a tall brick row house that " + "has seen better days. Its windows are dark."+"\n" +"It has a gated portico on the ground floor, and the rusty gate is slightly ajar. The houses on either side are abandoned, " + "their windows and doors boarded up.");
                     Starting = false;
                  }else if(start == 2){//no don't talk with children
                     JOptionPane.showMessageDialog(null, "You turn around and try to find a way around the children. After traveling along this gravel road for some time, a familiar scene greets you");
                  }
            }//end while Starting
         
         boolean TalkChildren = true;
            while(TalkChildren){
               String Talk = JOptionPane.showInputDialog(null, "What would you like to do?" + "\n" + "1. Question the children further" + "\n" + "2. Investigate the outside of the house" + "\n" + "3. Investigate the inside of the house" + "\n" + "4. Try to leave");
               int talk = Integer.parseInt(Talk);
               //if loop for what to do while contemplating the house and chidren
               
                  if(talk == 1){//question the children further
                  boolean activelyTalking = true;//loop for actively talking to the children
                     while(activelyTalking){
                        String Question = JOptionPane.showInputDialog(null, "What would you like to ask the children?" + "\n" + "1. What type of monster?" +"\n" + "2. Where are your parents?" + "\n" + "3. Are you okay?");
                        int question = Integer.parseInt(Question);
                        //if loop for what question to ask the children
                        
                           if(question == 1){//what type of moster
                               JOptionPane.showMessageDialog(null, "“We don’t know, our parents said that there was a monster in the basement. We can hear it howling every night. Please help us get rid of it.“");
                               String Response = JOptionPane.showInputDialog(null, "How do you respond?" + "\n" + "1. I’ll help." + "\n" + "2. I need more information first." +  "\n" + "3. I won’t help.");  
                               int response = Integer.parseInt(Response);
                               //if loop for how to respond
                               
                                 if(response == 1){//I'll help
                                    activelyTalking = false;//exit specific children questioning
                                 }else if(response == 2){//i need more info
                                    //just keep the questions going
                                 }else if(response == 3){//I won't help
                                     activelyTalking = false;//exit specific children questioning
                                 }
                           }else if(question == 2){//where are your parents
                              JOptionPane.showMessageDialog(null,"“We don’t know, they went into the basement a while ago and haven’t come out. Our baby brother is still in the house, they didn’t take him with them. Please help our baby brother.“");
                           }else if(question == 3){//are you okay
                              JOptionPane.showMessageDialog(null, "The children look at each other and the girl offers you a wobbly smile. ”Yes, I think so”. " + "\n" + "She frowns, ”But our brother, and our parents, please we don’t know what’s happened to them, please help with this monster.” ");
                           }
                      }//end while activelyTalking 
                          
                  }else if(talk == 2){//investigate the outside of the house
                     JOptionPane.showMessageDialog(null, "Looking at the house, you can see that it’s four stories high with a balcony jutting out of the third floor." + "\n" +"A wrought-Iron gate with hinges on one side and a lock on the other fills the archway of a stone portico. " + "\n" + "Oil lamps hang down from the portico ceiling by chains.");
                     String Enter = JOptionPane.showInputDialog(null, "What would you like to do?" + "\n"+ "1. Look around more of the outside of the house"+ "\n" + "2. Try to enter the house" ); 
                     int enter = Integer.parseInt(Enter);
                     //if loop for going in the house or not
                     
                        if(enter == 1){//look around some more
                           JOptionPane.showMessageDialog(null, "You walk around the house. The third floor has a balcony on the back of the house, but otherwise nothing seems different about it from other angles." + "\n" + "The mist feels like it’s getting thicker as you walk back around to the entrance. The road is barely visible. ");
                        }else if(enter == 2){//try to enter house
                           String EnterHouse = JOptionPane.showInputDialog(null, "You approach the entrance. The gate is unlocked, it’s rusted hinges shriek as you open it. " + "\n"  + "Past this, there’s a set of oaken doors. Would you like to continue forward?" + "\n" + "1. Yes" + "\n" + "2. No");
                           int enterHouse = Integer.parseInt(EnterHouse);
                           //if loop for actually entering the house
                              if(enterHouse == 1){// continue on
                                 JOptionPane.showMessageDialog(null, "You step forward and push open the doors of the entrance.");
                                 TalkChildren = false;
                                 whileOutside = false;
                              }else if(enterHouse == 2){//dont' want to continue on
                                 JOptionPane.showMessageDialog(null, "You walk away from the house. It's so misty you can barely see your feet." + "\n" + "You find yourself once again in front of the children.");
                              }
                        } 
                  }else if(talk == 3){//investigate the inside of the house
                     String InvestigateHouse = JOptionPane.showInputDialog(null, "You approach the entrance. The gate is unlocked, it’s rusted hinges shriek as you open it. " + "\n" + "Past this, there’s a set of oaken doors. Would you like to continue forward?" + "\n" + "1. Yes" + "\n" + "2. No");
                     int investigateHouse = Integer.parseInt(InvestigateHouse);
                     //if loop for entering the house or not
                        if(investigateHouse == 1){//yes continue
                           JOptionPane.showMessageDialog(null, "You step forward and push open the doors of the entrance.");
                           TalkChildren = false;
                           whileOutside = false;
                        }else if(investigateHouse == 2){//no don't continue
                           JOptionPane.showMessageDialog(null, "You walk away from the house. It's so misty you can barely see your feet." + "\n" + "You find yourself once again in front of the children.");
                        }   
                        
                  }else if(talk == 4){//try to leave again
                     JOptionPane.showMessageDialog(null, "You turn around and try to find a way past the house and the children. You find the road, and after traveling along it for some time, a familiar scene greets you");
                     TalkChildren = false;
                  }
 
            }//end while TalkChildren
        }//end while loop whileOutside    
   }//end outside
   
//FLOOOOORS
   
  //ENTRANCE
   public void getEntrance(){
      JOptionPane.showMessageDialog(null, "As you open the set of oaken doors, you step into the grand foyer. " + "\n" + "You see another set of doors, mahogany doors set with stained glass." + "\n"  + "On the left wall is a brilliant shield emblazoned with a coat-of-arms, flanked by framed portraits of stony-faced aristocrats.");
      callRoom.Entrance();
   }
//FLOOR ONE    
   public void FloorOne()throws IOException{
      //calling on all the rooms in the first floor. Will display MainHall options in this floor method, with a while loop. 
      //if player chooses to go up the stairs, will exit the while loop to exit the method and go to Main file for the stairs options.
      //will do this throughout all the floor methods
      
      
      InFirstFloor = true;
         while(InFirstFloor){
            String MainHall = JOptionPane.showInputDialog(null, "What would you like to do in the main hall?" + "\n" + "1. Look closer at the fireplace"+ "\n" + "2. Approach the door across from the main entrance"+ "\n" + "3. Enter the door to the right of the main entrance"+ "\n" + "4. Approach the stairs" + "\n" + "5. Try to leave the house");
            int mainHall = Integer.parseInt(MainHall);
            //if loop to go to the correct room corresponding with the number the player typed in
            
            if(mainHall == 1){//Look closer at the fireplace
               callRoom.MainHallFireplace();
            }else if(mainHall == 2){//Approach the door across
               callRoom.DiningRoomAndKitchen();//includes dumbwaiter method
            }else if(mainHall == 3){//Enter the door to the right
               callRoom.DenOfWolves();
            }else if(mainHall == 4){//Approach the stairs
               JOptionPane.showMessageDialog(null, "Heading towards the main staircase, you can see that it's a massive spiral staircase with red velvet carpeting running the length of it.");
               String FirstFloorStairs = JOptionPane.showInputDialog(null," Would you like to ascend?" + "\n" + "1. Yes" + "\n" + "2. No");
               int firstFloorStairs = Integer.parseInt(FirstFloorStairs);
               //if loop for going up the stairs or not
               if(firstFloorStairs == 1){//go up the stairs
                  firstStairs = true;//for going up the stairs
                  InFirstFloor = false;
               }else if(firstFloorStairs == 2){
                  JOptionPane.showMessageDialog(null, "You turn back to survey the main hall");
               }  
            }else if(mainHall == 5){
               JOptionPane.showMessageDialog(null, "You turn towards the entrance and try to open the doors. They won't budge." + "\n" + "You can't seem to leave the house.");
            }//end mainHall if loop
            
            
         }//end while InFirstFloor
   
     
   }//end FloorOne method
   
//FLOOR TWO   
   public void FloorTwo()throws IOException{
      JOptionPane.showMessageDialog(null, "The landing of the second floor opens up into a hall.");
      JOptionPane.showMessageDialog(null, "Unlit oil lamps hang on the walls, and standing suits of armor flank wooden doors carved with dancing youths in walls to your left and right. " + "\n" + "Each suit of armor clutches a spear and has a visored helm shaped like a wolf’s head. " + "\n" + "There’s a fireplace directly across from the landing, with a labeled portrait of a family hanging above it." + "\n" + "The staircase behind you continues upwards, a cold draft coming down the steps.");
      InSecondFloor = true;
         while(InSecondFloor){
         
            String SecondFloor = JOptionPane.showInputDialog(null, "What would you like to do on the second floor?" + "\n" + "1. Look closer at the family portrait above the fireplace" + "\n" + "2. Enter the door on the wall to the left" + "\n" + "3. Approach the door on the wall the right" + "\n" + "4. Go back to the stairs" );
            int secondFloor = Integer.parseInt(SecondFloor);
            //if loop for which room to go to, or continue up
            
            if(secondFloor == 1){//Look closer at the family portrait
               callRoom.UpperHallFireplace();
            }else if(secondFloor == 2){//Enter the door on the wall to the left
               callRoom.Conservatory();
            }else if(secondFloor == 3){//Approach the door on the wall the right
               callRoom.Library();
            }else if(secondFloor == 4){//Go back to the stairs
               JOptionPane.showMessageDialog(null, "You walk back to the stairs.");
               secondStairs = true;
               InSecondFloor = false;
            }
            
         }//end while InSecondFloor
      
   }//end FloorTwo method
   
//FLOOR THREE   
   public void FloorThree()throws IOException{
      
      boolean GoDownstairs = false;
      OnThirdFloor = true;
      
         while(OnThirdFloor){
         
            //RANDOM CHANCE HERE
            DiceRoll SECRET = new DiceRoll();
            int secret = SECRET.randomDiceRollPrompt();
                  
            if(secret > 1){//if random chance to find the secret door to the attic in the main third floor balcony
               JOptionPane.showMessageDialog(null, "As you start to look around the third floor, you notice that next to the door on the left wall, a slight gap in the walls widens slightly." + "\n" + "A hidden door slightly creaks open from the wall as you watch.");
               String GoToAttic = JOptionPane.showInputDialog(null, "Would you like to investigate the hidden door?" + "\n" + "1. Yes" + "\n" + "2. No");
               int goToAttic = Integer.parseInt(GoToAttic);
                   if(goToAttic == 1){
                       JOptionPane.showMessageDialog(null, "The secret door swings open as you near it, revealing a staircase going up. As you step inside the door to get a closer look at the stairs, the door slams behind you, trapping you!");
                       JOptionPane.showMessageDialog(null,  "You see no way out except up.");
                       JOptionPane.showMessageDialog(null, "GAME OVER");
                       System.exit(0);
                       OnThirdFloor = false;  
                   }else{
                       JOptionPane.showMessageDialog(null, "Turning back to what you were doing, you decide to investigate the hidden door later.");
                   }
            }//end RANDOM CHANCE to find the hidden door
            
            
            String ThirdFloorHall = JOptionPane.showInputDialog(null, "What would you like to do?" + "\n" + "1. Enter the double doors to your right"+ "\n" + "2. Approach one of the doors in front of you"+ "\n" + "3. Approach the door on the wall to your left"+ "\n" + "4. Go back to the stairs");
            int thirdFloorHall = Integer.parseInt(ThirdFloorHall);
            //if loop for third floor rooms
            if(thirdFloorHall == 1){//Enter the double doors to your right
               callRoom.MasterSuite();
            }else if(thirdFloorHall == 2){//Approach one of the doors in front of you
               //CHANCE FOR COMBAT HERE
               String CombatOne = JOptionPane.showInputDialog(null, "Would you like to enter the door slightly to the left or the door slightly to the right?" + "\n" + "1. The door slightly to the right" + " \n" + "2. The door slightly to the left" + "\n" + "3. Neither");
               int combatOne = Integer.parseInt(CombatOne);
               //if loop for which door to go into. The door slightly to te left initiates combat one
               if(combatOne == 1){//to the right, the bathroom
                  callRoom.Bathroom();
               }else if(combatOne == 2){//to the left, StorageCloset(), combat one starts
                  callRoom.StorageCloset();
               }else if(combatOne == 3){
                  JOptionPane.showMessageDialog(null, "Deciding to open neither door, you turn around back to the third floor landing");
               }
            }else if(thirdFloorHall == 3){//Approach the door on the wall to your left
               //suit of armor blocks the door
               JOptionPane.showMessageDialog(null, "As you start walking towards the door on the left, the suit of armor near to it turns and moves in front of the door, pulling its sword out. " + "\n" + "Then it stops moving.");
               String CombatTwo = JOptionPane.showInputDialog(null, "Would you like to attempt to get past the suit of armor, or turn back?" + "\n" + "1. Turn back"+ "\n" + "2. Attempt to get past the suit of armor");
               int combatTwo = Integer.parseInt(CombatTwo);
                  
               //if loop to either try to get past the armor, or turn back to the third floor main
               if(combatTwo == 2){//attempt to get past the armor
                  JOptionPane.showMessageDialog(null, "You attempt to get past the suit of armor.");
                  //if loop for calling on random and getting past the suit of armor.
                  //if get more than one, can get past the armor and into the nursemaids suite, if not, initiate combat two
                  if(rollDice == 1){//COMBAT TWO
       //              attack.combatTwo();
                     JOptionPane.showMessageDialog(null, "You try to walk past the suit of armor, but can't manage to get past. " + "\n" + "As you turn around to go back to the main part of the floor, you could swear it sticks it foot out to trip you. " + "\n" + "You manage to not fall, and go back to surveying the third floor landing.");
                  }else{//enter the nursemaids suite
                     JOptionPane.showMessageDialog(null, "You carefully scoot past the armor and into the room past it. The rusted armor gives off a loud creak and falls to the floor in pieces.");
                     //JOptionPane.showMessageDialog(null, "Peering around the room, you see cobwebs elegantly draped around this bedroom." + "\n" + "In front of you is a simple bed, covered in dust. To your left sits a vanity with a small mirror, and on the wall to your right are two doors." + "\n" + "You can see that one of the two doors is glass, looking outside. The other door is shut.");
                     JOptionPane.showMessageDialog(null, "Looking around the room you've entered, it's in a horrid state." + "\n" + "It seems like there was a fire here and no one fixed anything. " + "\n" + "You can see remnants of the room and balcony, jutting out of the house, along with two collapsed rooms to the right of you.");
                     JOptionPane.showMessageDialog(null, "To your right, there seems to be an entryway into some dark hallway, with an off kilter vanity partially covering it.");
                     callRoom.NurseMaidsSuite();
                  }
               }
            }else if(thirdFloorHall == 4){//Go back to the stairs
               thirdStairs = true;
               GoDownstairs = true;
               OnThirdFloor = false;
            }
         
         }//end while OnThirdFloor

   }

/* 
//ATTIC     
   public void FloorAttic()throws IOException{
   
      callRoom.AtticHall();
      callRoom.UpperStorageRoom();
      callRoom.ChildrensRoom();
      callRoom.SecretStairs();
   
   }
   
//DUNGEON   
   public void FloorDungeon()throws IOException{
   
      callRoom.DungeonLevelAccess();
      callRoom.FamilyCrypts();
      callRoom.CultInitiatesQuarters();
      callRoom.WellAndCultQuarters();
      callRoom.HiddenSpikedPit();
      callRoom.DiningHall();
      callRoom.Larder();
      callRoom.GhoulishEncounter();
      callRoom.StairsDown();
      callRoom.DarklordShrine();
      callRoom.HiddenTrapdoor();
      callRoom.CultLeadersDen();
      callRoom.Reliquary();
      callRoom.Prison();
      callRoom.Portcullis();
      callRoom.RitualChamber();
   
   }


*/

}