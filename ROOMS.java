import java.util.Scanner;
import javax.swing.JOptionPane;
import java.io.*;
import java.util.Random;
import java.util.ArrayList;

public class ROOMS{//aka rooms

   DiceRoll diceRoll = new DiceRoll();
   CharacterSetup player1 = new CharacterSetup();
   //COMBAT attack = new COMBAT();
   public boolean WentUp;
   public int whichCombat;
   public static String CharType;
   public static String haveCrossbow;
   
    public void CharacterSetupInMain() throws IOException{
      //CharacterSetup
      String NAME = JOptionPane.showInputDialog(null, "Please enter your name: ");
      player1.setName(NAME);//setting the name of player1
      JOptionPane.showMessageDialog(null, "Instructions: For each option please enter the number associated with it");
      String CharacterClass = JOptionPane.showInputDialog(null, "What type of character would you like to be?" + "\n" + "1. Warrior "+"\n" + "2. Sorcerer" + "\n" + "3. Rogue");
      int characterClass = Integer.parseInt(CharacterClass);//changing player input to integer
      //if loop to assign the integer with a specific class
         if(characterClass == 1){
            player1.setCharacterClass("Warrior");
            player1.setPlayerHP(25);
         }else if(characterClass == 2){
            player1.setCharacterClass("Sorcerer");
            player1.setPlayerHP(15);
         }else if(characterClass == 3){
            player1.setCharacterClass("Rogue");
            player1.setPlayerHP(20);
         }//end if loop
      
      //writing character info to a text file CharacterStats.txt
      PrintWriter Write = new PrintWriter("CharacterStats.txt");
      Write.write(player1.getName()+ "\n");
      Write.write(player1.getCharacterClass()+ "\n"); 
      Write.write(player1.getPlayerHP()+ "\n");  
      Write.close();
      
      JOptionPane.showMessageDialog(null, "Welcome " + player1.getCharacterClass() +" " + player1.getName() + ". You have " + player1.getPlayerHP() + " hitpoints.");
      //reset inventory
      PrintWriter write = new PrintWriter("Inventory.txt");
      write.write("Inventory");
      write.close();
  }//end character setup
   
   public void Entrance(){//ENTRANCE 
      boolean InEntrance = true;
         while(InEntrance){
            String Entrance = JOptionPane.showInputDialog(null, "What would you like to do?" + "\n" + "1. Look closer at the portraits" + "\n" + "2. Look closer at the shield" + "\n" + "3. Try to take the shield"+ "\n" + "4. Approach the doors");
            int entrance = Integer.parseInt(Entrance);
            //if loop for entrance choices
               if(entrance == 1){//look closer at the portraits
                  JOptionPane.showMessageDialog(null, "Looking closer at the portraits, you assume these to be the people who live in the house. " + "\n" + "You can see the children from outside along with a couple of adults in one of the portraits, a family painting." + "\n" + "The other is of just the two adults, whom you assume to be the parents of the children outside and the owners of the house.");
               }else if(entrance == 2){//look closer at the shield
                  JOptionPane.showMessageDialog(null, "Looking closer at the shield, you see a stylized golden windmill on a red field. It looks expensive.");
               }else if(entrance == 3){//try to take the shield
                  JOptionPane.showMessageDialog(null, "Nothing happens. This shield appears to be bolted to the wall.");
               }else if(entrance == 4){//Approach the doors
                  JOptionPane.showMessageDialog(null, "Approaching the doors, you try to peer through the stained glass. You see a vague layout of the room that’s past, but no movement. ");
                  String Foyer = JOptionPane.showInputDialog(null, "What would you like to do in the foyer?" + "\n" + "1. Turn around and look at something else" + "\n" + "2. Close your eyes and concentrate to see if you can hear anything through the doors" + "\n" + "3. Open the doors ");
                  int foyer  = Integer.parseInt(Foyer);
                  //if loop for approaching the door
                     if(foyer == 1){//turn around and look at something else
                        JOptionPane.showMessageDialog(null, "You turn around and look back at the room.");
                     }else if(foyer == 2){//close eyes and concentrate
                        int entranceRoll = diceRoll.randomDiceRollPrompt();
                        //if loop for entrance
                           if(entranceRoll == 1){
                              JOptionPane.showMessageDialog(null, "You hear your heartbeat raising as you stress yourself out by straining to hear something. Take one hitpoint damage.");
                              player1.changePlayerHPOne();
                              JOptionPane.showMessageDialog(null, "Your hitpoint total is now " + player1.getPlayerHP() + ".");
                                 if(player1.getPlayerHP() <= 0){
                                    JOptionPane.showMessageDialog(null, "You have died." + "\n" + "GAME OVER ");
                                    System.exit(0);
                                 }
                           }else if(entranceRoll == 2){
                              JOptionPane.showMessageDialog(null, "You don’t hear anything remarkable, you guess there’s probably nothing alive in the room.");
                           }else if(entranceRoll == 3){
                              JOptionPane.showMessageDialog(null, "There seems to be a faint sound of a party drifting under the door. Some conversation and tinkling of glasses.");
                           }else if(entranceRoll == 4){
                              JOptionPane.showMessageDialog(null, "You can hear a party going on. The sound isn’t coming from the room through this door, but it’s drifting through from somewhere.");
                           }
                     }else if(foyer == 3){//open the doors
                        InEntrance = false;
                     }                                                
               }
      }//end while InEntrance
      //dialog box for describing the main hall
      }
   public void MainHallFireplace(){
      
      JOptionPane.showMessageDialog(null, "You walk closer to the fireplace.");
      int MainFireplace = diceRoll.randomDiceRollPrompt();
      //if loop for firplace in main hall
         if(MainFireplace == 1){
            JOptionPane.showMessageDialog(null, "You trip and bang your head against the mantle, take 1 hitpoint damage");
            player1.changePlayerHPOne();
            JOptionPane.showMessageDialog(null, "Your hitpoint total is now " + player1.getPlayerHP() + ".");
               if(player1.getPlayerHP() <= 0){
                  JOptionPane.showMessageDialog(null, "You have died." + "\n" + "GAME OVER ");
                  System.exit(0);
               }
         }else if(MainFireplace == 2){
            JOptionPane.showMessageDialog(null, "Looking at the fireplace, you see that the walls and mantle around the fireplace are ornately sculpted with images of vines, flowers, nymphs, and satyrs. " + "\n" + "You follow the sculpting with your eyes, seeing it goes all the way to, and up, the stairs.");
         }else if(MainFireplace == 3){
            JOptionPane.showMessageDialog(null, "Looking at the fireplace, you see that the walls and mantle around the fireplace are ornately sculpted with images of vines, flowers, nymphs, and satyrs." + "\n" + "But peering closer still, the images are interlaced with inconspicuous skulls and serpents. " + "\n" + "You follow the engravings with your eyes, seeing it goes all the way to, and up, the stairs.");
   
         }else if(MainFireplace == 4){
            JOptionPane.showMessageDialog(null, "The fireplace and the walls surrounding it give you an eerie feeling, they seem to have ornate, pleasant engravings at first," + "\n" + "but the longer you look at them, the more imagery you see of death and disease within.");
         }
      
   }
   public void DenOfWolves()throws IOException{
      JOptionPane.showMessageDialog(null, "This room appears to be a hunters den. There's taxidermied animal heads and three large taxideremed wolves around the room." + "\n" + "You see two padded chairs draped in animal furs facing the hearth, with a small oak table between them." + "\n" + "An ornate cabinet is on the wall to your left. It looks locked.");
      boolean InHuntersDen = true;//boolean for the while loop of this room
         while(InHuntersDen){

            String huntersDEN = JOptionPane.showInputDialog(null, "What would you like to do in this hunters den? " + "\n" + "1. Investigate the cabinets"+ "\n" + "2. Look closer at the wolves"+ "\n" + "3. See what's on the small oak table"+ "\n" + "4. Leave the room" );
            int huntersDen = Integer.parseInt(huntersDEN);
            //if loop for choices
            if(huntersDen == 1){//investigate the cabinets
              String Unlock = JOptionPane.showInputDialog(null, "Looking at the cabinet, you can clearly see it’s locked. Would you like to try to unlock it?" + "\n" + "1. Yes" + "\n" + "2. No");
              int unlock = Integer.parseInt(Unlock);
              //if loop for unlocking the cabinets
               if(unlock == 1){//want to unlock
                  if(player1.getCharacterClass().equals("Rogue")){//if rogue, unlocks right away
                     JOptionPane.showMessageDialog(null, "You unlock it with relative ease, opening to find inside a hand crossbow and some cross bolts along with some playing cards. ");
                     String Take = JOptionPane.showInputDialog(null, "Would you like to take the contents?" + "\n" + "1. Yes" + "\n" + "2. No");
                     int take = Integer.parseInt(Take);
                     //if loop for taking the contents
                        if(take == 1){//yes
                           JOptionPane.showMessageDialog(null, "You take the contents and put them in your bag.");
                           String inventory = "Inventory.txt";//create a file inventory
                           FileWriter Write = new FileWriter("Inventory.txt");
                           Write.write("\n" + "Hand Crossbow" + "\n" + "Cross bolts" + "\n" + "Playing Cards");//write down the inventory items
                                 
                           Write.close();//close the writer
                           
                        }else{//no
                           JOptionPane.showMessageDialog(null, "Nothing looks interesting, you step away from the cabinet.");
                        }
                  }else{
                     int huntersDenCabinet = diceRoll.randomDiceRollPrompt();
                     //if loop for chance of unlocking
                        if(huntersDenCabinet == 1){
                           JOptionPane.showMessageDialog(null, "Attempting to unlock the cabinet, the lock pick shatters in the lock and your hand. Take one hitpoint damage");
                           player1.changePlayerHPOne();
                           JOptionPane.showMessageDialog(null, "Your total hitpoints is now " + player1.getPlayerHP());
                           //if loop for if player HP is lower than 0 or 0
                              if(player1.getPlayerHP() <= 0){
                                 JOptionPane.showMessageDialog(null, "You have died. "+ "\n" + " GAME OVER ");
                                 System.exit(0);
                              }   
                        }else if(huntersDenCabinet == 2){
                           JOptionPane.showMessageDialog(null, "You attempt to unlock the cabinet but the lock pick breaks in the lock." + "\n" + "The lock is broken now, and the cabinet is not able to be opened.");
                        }else{
                           JOptionPane.showMessageDialog(null, "You jiggle the pick around and manage to click the lock open.");
                           JOptionPane.showMessageDialog(null, "You unlock it with relative ease, opening to find inside a hand crossbow and some cross bolts along with some playing cards. ");
                           String Take = JOptionPane.showInputDialog(null, "Would you like to take the contents?" + "\n" + "1. Yes" + "\n" + "2. No");
                           int take = Integer.parseInt(Take);
                           //if loop for taking the contents
                              if(take == 1){//yes
                                 String inventory = "Inventory.txt";//create a file inventory
                                 FileWriter Write = new FileWriter("Inventory.txt");
                                 Write.write("\n" + "Hand Crossbow" + "\n" + "Cross bolts" + "\n" + "Playing Cards");//write down the inventory items
                                       
                                 Write.close();//close the writer
                              }else{//no
                                 JOptionPane.showMessageDialog(null, "Nothing looks interesting, You step away from the cabinet.");
                              }
                        }
                  }
               }else{//don't want to try to unlock the cabinet
                  JOptionPane.showMessageDialog(null, "You turn away from the cabinet, looking back around the room.");
               }   
            }else if(huntersDen == 2){//look closer at the wolves 
               JOptionPane.showMessageDialog(null, "You look closer at the wolves. These were definitely alive at one point.");
               int huntersDice = diceRoll.randomDiceRollPrompt();//calling on random dice roll
               //if loop for dice roll
                  if(huntersDice == 1){
                     JOptionPane.showMessageDialog(null, "You poke at the wolf, clumsily clipping your hand on its teeth. Take one hp damage.");
                     player1.changePlayerHPMore(1);
                     JOptionPane.showMessageDialog(null, "Your total hitpoints is now " + player1.getPlayerHP());
                     //if loop for if player HP is lower than 0 or 0
                        if(player1.getPlayerHP() <= 0){
                           JOptionPane.showMessageDialog(null, "You have died. "+ "\n" + " GAME OVER ");
                           System.exit(0);
                        }   
                  }else if(huntersDice == 2){
                     JOptionPane.showMessageDialog(null, "These wolves were well preserved, they almost have a lifelike sheen to their eyes.");
                  }else if(huntersDice == 3){
                     JOptionPane.showMessageDialog(null, "While looking at one wolf you could swear you see one of the other wolves blink. Must be a trick of the eye.");
                  }else if(huntersDice == 4){
                     JOptionPane.showMessageDialog(null, "You peer into the eyes of one of the wolves. You get the feeling that these wolfs might come alive and attack you. " + "\n" + "But that’s not possible, they’re dead. Right?");
                  }
            }else if(huntersDen == 3){//see what's on the small oak table
               JOptionPane.showMessageDialog(null, "You approach the small oak table in front of the hearth. There’s some old wine goblets on it as well as what looks like an ashtray. Nothing noteworthy.");
            }else if(huntersDen == 4){//leave the room
               JOptionPane.showMessageDialog(null, "Leaving the room, you re-enter the main hall");
               InHuntersDen = false;
            } 
          
         }//end while InHuntersDen
   
   }//end DenOfWolves Method
   
   public void DiningRoomAndKitchen()throws IOException{
      JOptionPane.showMessageDialog(null, "Walking across the room, you approach the door.");
      int diningDice = diceRoll.randomDiceRollPrompt();
         if(diningDice == 1){//if loop for dice roll
            JOptionPane.showMessageDialog(null, "You trip on a small dip in the floor and hit your head agaist the door handle. Take 1 hp damage.");
            player1.changePlayerHPOne();
            JOptionPane.showMessageDialog(null, "Your hitpoint total is now " + player1.getPlayerHP() + ".");
               if(player1.getPlayerHP() <= 0){//simple if for if healthpoints are gone
                  JOptionPane.showMessageDialog(null, "You have died." + "\n" + "GAME OVER ");
                  System.exit(0);
               }
          }else if(diningDice == 2){
             JOptionPane.showMessageDialog(null, "Approaching the door, you see nothing remarkable about it.");
          }else if(diningDice == 3){
            JOptionPane.showMessageDialog(null, "Approaching the door, you can hear faint laughter and tinkling of glasses." + "\n" + "It sounds like there’s a small party happening on the other side of the door.");
          }else if(diningDice == 4){
            JOptionPane.showMessageDialog(null, "As you approach the door you can hear the sounds of a gathering on the other side." + "\n" + "It sounds like a merry gathering with laughter and alcohol");
          }
      String DiningRoom = JOptionPane.showInputDialog(null, "What would you like to do?" + "\n" + "1. Open the door" + "\n" + "2. Do something else");
      int diningRoom = Integer.parseInt(DiningRoom);  
      //if loop to go in or not go in the dining room
      if(diningRoom == 1){
         JOptionPane.showMessageDialog(null, "You open the door into a dining room.");
         JOptionPane.showMessageDialog(null, "The centerpiece of this wood-paneled dining room is a carved mahogany table surrounded by eight highbacked chairs with sculpted armrests and cushioned seats. " + "\n" + "Mounted above the marble fireplace is a mahogany-framed painting of an alpine vale. " + "\n" + "Red silk drapes cover the windows, and a tapestry depicting hunting dogs" + " and horse-mounted aristocrats chasing after a wolf hangs from an iron rod bolted to the south wall." + "\n" + "To the right you can see another door on the wall.");     
         boolean InDiningRoom = true;
         while(InDiningRoom){
            String DiningRoomChoices = JOptionPane.showInputDialog(null, "What would you like to do in the dining room?" + "\n" + "1. Look closer at the painting and tapestry" + "\n" + "2. Look outside the window "
                                                                           + "\n" + "3. Go to the door on the right"+ "\n" + "4. Leave the room");
            int diningRoomChoices = Integer.parseInt(DiningRoomChoices);
            //if loop for what to do in the dining room
               if(diningRoomChoices == 1){//look closer at the painting and tapestry
                  int diceDiningRoom = diceRoll.randomDiceRollPrompt();
                  //if loop for dice roll
                     if(diceDiningRoom == 1){//if loop for looking at the artwork
                        JOptionPane.showMessageDialog(null, "Moving closer to the painting, a rat scurries past your feet, tripping you. Flailing, your nails catch on the painting and tear through it." + "\n" + "You have an awful hangnail, take one hp damage");
                        player1.changePlayerHPOne();
                        JOptionPane.showMessageDialog(null, "Your hitpoint total is now " + player1.getPlayerHP() + ".");
                           if(player1.getPlayerHP() <= 0){//simple if for if healthpoints are gone
                              JOptionPane.showMessageDialog(null, "You have died." + "\n" + "GAME OVER ");
                              System.exit(0);
                           }
                     }else if(diceDiningRoom == 2){
                        JOptionPane.showMessageDialog(null, "Looking closer at the painting and tapestry, you notice that they look the same up close as they did from further away");
                     }else if(diceDiningRoom == 3){
                        JOptionPane.showMessageDialog(null, "As you approach the artwork, you peer into the alpine vale of the painting and subsequently the tapestry, " + "\n" + "and see twisted faces carved into the tree trunks, and wolves staring back at you through the trees.");
                     }else if(diceDiningRoom == 4){
                         JOptionPane.showMessageDialog(null, "Looking closer at the art, you see twisted faces carved into the tree trunks and wolves lurking amid the carved foliage." + "\n" + "An ominous feeling creeps up your spine at the sight of these.");
                     }
               }else if(diningRoomChoices == 2){//look outside the window
                  JOptionPane.showMessageDialog(null, "You look outside the window, and can’t see very far. The mist has gotten very thick around the house.");
               }else if(diningRoomChoices == 3){//go to the door on the right
                  String EnterKitchen = JOptionPane.showInputDialog(null, "Going to the door, you don’t hear anything on the other side. Do you open it?" + "\n" + "1. Yes" + "\n" + "2. No");
                  int enterKitchen = Integer.parseInt(EnterKitchen);
                  //if loop for entering the kitchen
                     if(enterKitchen == 1){//enter kitchen
                        JOptionPane.showMessageDialog(null, "As the door creaks open, you see a disheveled kitchen behind it. There seems to be a dumbwaiter " + "\n" + "in the corner near an open door, which you assume leads to the pantry.");   
                        boolean InKitchen = true;
                           while(InKitchen){
                              String KitchenChoices = JOptionPane.showInputDialog(null, "What would you like to do in the kitchen?" + "\n" + "1. Investigate the pantry" + "\n" + "2. Look closer at the dumbwaiter" + "\n" + "3. Leave and go back to the dining room");
                              int kitchenChoices = Integer.parseInt(KitchenChoices);
                              //if loop for kitchen choices
                                 if(kitchenChoices == 1){//investigate the pantry
                                    JOptionPane.showMessageDialog(null, "You enter the pantry, seeing some preserved jars of food and a couple bundles of garlic.");
                                    String TakeFood = JOptionPane.showInputDialog(null, "Would you like to take the food?" + "\n" + "1. Yes" + "\n" + "2. No");
                                    int takeFood = Integer.parseInt(TakeFood);
                                    //if loop for taking the food
                                       if(takeFood == 1){
                                          JOptionPane.showMessageDialog(null, "You take the food and garlic, then leave the room as there’s nothing else here.");
                                          FileWriter writeFood = new FileWriter("Inventory.txt", true);
                                          writeFood.write("\n" + "Jars of food" + "\n" + "Garlic");
                                          writeFood.close();
                                       }else{
                                          JOptionPane.showMessageDialog(null, "You leave the pantry, dissapointed by the lack of spoils.");
                                       }
                                 }else if(kitchenChoices == 2){//look closer at the dumbwaiter
                                    JOptionPane.showMessageDialog(null, "Looking closer at the dumbwaiter, it seems perfectly funcitonal." + "\n" + "There’s a couple of ropes that appear to control which direction it goes. You feel like you might be able to fit in here if you wanted to.");
                                    String DumbwaiterChoice = JOptionPane.showInputDialog(null, "Would you like to try and get in the dumbwaiter?" + "\n" + "1. Yes" + "\n" + "2. No");
                                    int dumbwaiterChoice = Integer.parseInt(DumbwaiterChoice);
                                    //if loop for getting in or not getting in the dumbwaiter
                                       if(dumbwaiterChoice == 1){//do get in dumbwaiter
                                          Dumbwaiter();
                                          if(WentUp){
                                             JOptionPane.showMessageDialog(null, "You pull on one of the ropes within reach, raising the dumbwaiter up through a dark tunnel.");
                                             //if loop for if the player survives lol
                                             int dumbIdeaRoll = diceRoll.randomDiceRollPrompt();
                                                if(dumbIdeaRoll == 1 || dumbIdeaRoll == 2){//player dies
                                                   JOptionPane.showMessageDialog(null, "As you continue pulling on the ropes you hear an awful unraveling noise followed by a snap! As the ropes holding this dumbwaiter up break." + "\n" + "You are conscious for just long enough to regret getting in this dumbwaiter before crashing to the ground, crushed.");
                                                   JOptionPane.showMessageDialog(null, "You have died." + "\n" + " GAME OVER ");
                                                   System.exit(0);
                                                }else if(dumbIdeaRoll == 3 || dumbIdeaRoll == 4){//player lives and tumbles out of dumbwaiter
                                                   JOptionPane.showMessageDialog(null, "As you continue to pull on the dumbwaiter ropes, you feel the ropes starting to snap that are holding the dumbwaiter up! " + "\n" + "Falling several feet, the dumbwaiter screeches to a halt back where it started, thoroughly stuck in the dumbwaiter shaft." + "\n" + "You manage to crawl out and back into the kitchen, thinking yourself very lucky for surviving this ordeal.");
                                                }
                                          }else if(!WentUp){
                                             JOptionPane.showMessageDialog(null, "You manage to extract yourself from the dumbwaiter, wondering what you were thinking in the first place going in there.");
                                             System.out.println("In kitchen dumB");
                                          }
                                       }else{//don't get in dumbwaiter
                                          JOptionPane.showMessageDialog(null, "You decide it might be a good idea to not attempt to get into the ancient dumbwaiter.");
                                       }
                                 
                                 }else if(kitchenChoices == 3){//leave and go back to the dining room
                                    JOptionPane.showMessageDialog(null, "You leave the kitchen and go back to the dining room");
                                    InKitchen = false;
                                 }
                     
                           }//end while InKitchen
                     }else{//don't enter kitchen 
                        JOptionPane.showMessageDialog(null, "You choose not to open the door and turn back to the dining room.");
                     }

               }else if(diningRoomChoices == 4){//leave the room
                  JOptionPane.showMessageDialog(null, "You leave the room and go back to the main hall.");
                  InDiningRoom = false;
               }
         
         }//end while InDiningRoom
      }else if(diningRoom == 2){
         JOptionPane.showMessageDialog(null, "You turn back to the main hall.");
      }  
      
   }
   public boolean Dumbwaiter(){//this method only called in the kitchen and third floor. Can't go back down probs, we'll see
      JOptionPane.showMessageDialog(null, "You attempt to get in the dumbwaiter.");
      boolean InDumbwaiter = true;
         while(InDumbwaiter){
            int dumbRoll = diceRoll.randomDiceRollPrompt();
            //if loop for getting into the dumbwaiter
               if(dumbRoll == 1){
                  JOptionPane.showMessageDialog(null, "You trip attempting to get in the dumbwaiter, your foot getting caught on something. " + "\n" + "Falling backwards, your head smacks into a counter near the dumbwaiter. Take two hp damage.");
                  player1.changePlayerHPMore(2);
                  JOptionPane.showMessageDialog(null, "Your hitpoint total is now " + player1.getPlayerHP() + ".");
                  InDumbwaiter = false;
                     if(player1.getPlayerHP() <= 0){//simple if for if healthpoints are gone
                        JOptionPane.showMessageDialog(null, "You have died." + "\n" + "GAME OVER ");
                        System.exit(0);
                     }                                
               }else if(dumbRoll == 2){
                  JOptionPane.showMessageDialog(null, "You manage to shove yourself into the dumbwaiter, wondering why you had this idea in the first place." + "\n" +  "Your leg is cramping and you fall out of the dumbwaiter. Take one hp damage.");
                  player1.changePlayerHPOne();    
                  JOptionPane.showMessageDialog(null, "Your hitpoint total is now " + player1.getPlayerHP() + ".");
                  InDumbwaiter = false;
                     if(player1.getPlayerHP() <= 0){//simple if for if healthpoints are gone
                        JOptionPane.showMessageDialog(null, "You have died." + "\n" + "GAME OVER ");
                        System.exit(0);
                     }                         
               }else if(dumbRoll == 3 || dumbRoll == 4){
                  JOptionPane.showMessageDialog(null, "Squishing yourself into the dumbwaiter, you wonder about the intelligence of this idea.");
                  String DumbIdea =  JOptionPane.showInputDialog(null, "What would you like to do now?" + "\n" + "1. Exit the dumbwaiter" + "\n" +"2. Attempt to use the dumbwaiter to go further up into the house");
                  int dumbIdea = Integer.parseInt(DumbIdea);
                  //if loop for what to do in the dumbwaiter
                     if(dumbIdea == 1){
                        JOptionPane.showMessageDialog(null, "You manage to extract yourself from the dumbwaiter, wondering what you were thinking in the first place going in there."); 
                        InDumbwaiter = false;
                     }else if(dumbIdea == 2){
                        WentUp = true;
                        InDumbwaiter = false;    
                     }
               }
 
         
         }//end while InDumbwaiter
      return WentUp;      
   }
//THESE ARE SECOND FLOOR ROOMS   
   public void UpperHallFireplace(){
      JOptionPane.showMessageDialog(null, "Stepping closer to the family portrait, you can make out the names etched into the plaque next to it.");
      JOptionPane.showMessageDialog(null, "The family portraited appears to be the owners of the house; Gustav and Elisabeth Durst with their two smiling children, Rose and Thorn." + "\n" + "Cradled in the father’s arms is a swaddled baby, which Elisabeth seems to regard with a hint of scorn.");
   }         
  
   public void Library()throws IOException{
      JOptionPane.showMessageDialog(null, "Approaching the door on the wall to the right, you notice that the carvings on this door are a little newer than the ones on the other door.");
      int doorCarvings = diceRoll.randomDiceRollPrompt();
      //if loop for looking at the door      
         if(doorCarvings == 1){//if loop for looking at the door
               JOptionPane.showMessageDialog(null, "Leaning foward to get a closer look at the carvings, a mysterious gust of wind blows the door into your face. Take one hp damage.");
               player1.changePlayerHPOne();
               JOptionPane.showMessageDialog(null, "Your hitpoint total is now " + player1.getPlayerHP() + ".");
                 if(player1.getPlayerHP() <= 0){//if player hp is 0 or less, the game ends
                     JOptionPane.showMessageDialog(null, "You have died." + "\n" + "GAME OVER ");
                     System.exit(0);
                 }
               }else if(doorCarvings == 2){
                  JOptionPane.showMessageDialog(null, "Leaning closer to the door, you see youths dancing. It’s an exquisite carving.");

               }else
                  JOptionPane.showMessageDialog(null, "Looking closer at the carvings reveals that the youths aren’t really dancing but are actually fighting off swarms of bats.");
               //end if loop for looking at the door   
                  
      JOptionPane.showMessageDialog(null, "The door opens, revealing a library."); 
      JOptionPane.showMessageDialog(null, "Red velvet drapes cover the windows of this library. An exquisite mahogany desk and a matching high-back chair face the entrance and the fireplace, " + "\n" + "above which hangs a framed picture of a windmill perched atop a rocky crag." + "\n" + "Situated in corners of the room are two overstuffed chairs." + "\n" + "Floor-to-ceiling bookshelves line the south wall and a rolling wooden ladder allows one to more easily reach the high shelves.");
      boolean InLibrary = true;
         while(InLibrary){
            String Library = JOptionPane.showInputDialog(null, "What would you like to do in the library?" + "\n" + "1. Leave the room" + "\n" + "2. Look closer at the desk" + "\n" + "3. Explore the bookshelves" + "\n" + "4. Look outside the windows");
            int library = Integer.parseInt(Library);
            //if loop for library choices
               if(library == 1){//leave the room
                  JOptionPane.showMessageDialog(null, "You leave the room, going back to the second floor landing");
                  InLibrary = false;
               }else if(library == 2){//look closer at the desk
                  JOptionPane.showMessageDialog(null, "There appears to be a few items on the desk, mostly writing tools. There’s two desk drawers, and opening them you can see that one is empty and the other contains a key.");
                  String takeKEY = JOptionPane.showInputDialog(null, "Would you like to take the key?" + "\n" + "1. Yes" + "\n" + "2. No");
                  int takeKey = Integer.parseInt(takeKEY);
                     if(takeKey == 1){//yes
                        JOptionPane.showMessageDialog(null, "You take the key, putting it in your bag.");
                        FileWriter inventory = new FileWriter("Inventory.txt", true);
                        inventory.write("\n" + "Key");//writing key to inventory
                        inventory.close();//closing the writer
                     }else{
                        JOptionPane.showMessageDialog(null, "You decide not to take the key, and turn back to the library.");
                     }
               }else if(library == 3){//explore the bookshelves
                  JOptionPane.showMessageDialog(null, "Exploring the bookshelves, you can see that they hold hundreds of tomes covering a range of topics including history, warfare, and alchemy.");
                  int Secret = diceRoll.randomDiceRollPrompt();
                     if(Secret == 1 || Secret == 2){
                        JOptionPane.showMessageDialog(null, "None of these seem very useful, you go back to the main library area.");
                     }else if(Secret == 3){
                        JOptionPane.showMessageDialog(null, "One of these bookshelves seems to hold quite a few books that won’t come out of the shelf." + "\n" +  "After poking around for a couple minutes, something clicks and the door opens, revealing a secret room.");
                        SecretRoom();                                                                 
                     }else if(Secret == 4){
                        JOptionPane.showMessageDialog(null, "You notice that one of the bookshelves is sticking out slightly more than the others. " + "\n"  + "Inspecting it closer, it appears to be a hidden door. Opening it, a secret room is revealed to you.");
                        SecretRoom();                                                                       
                     }
               }else if(library == 4){//look outside the windows
                  JOptionPane.showMessageDialog(null, "Pushing aside the curtains, you look out the windows. Dense white fog meets your eye. You can’t see anything past the ledge of the window.");
               }
         
         
         }//end while InLibrary
   }//end library method
   
   public void SecretRoom()throws IOException{
      boolean SecretRoom = true;
      JOptionPane.showMessageDialog(null, "There’s more bookshelves in this secret room you've found, and they're packed with books. " + "\n" + "A heavy wooden chest with clawed iron feet stands against the wall opposite you, its lid half-closed.");
         while(SecretRoom){
                        
            String secretROOM = JOptionPane.showInputDialog(null, "What would you like to do?" + "\n" + "1. Leave the room"+ "\n" + "2. Look closer at the books"+ "\n" + "3. Inspect the chest");
            int secretRoom = Integer.parseInt(secretROOM);
            //if loop for secret room choices
             if(secretRoom == 1){//leave the room
               JOptionPane.showMessageDialog(null, "You leave the secret room and go back into the library");
               SecretRoom = false;//leave the SecretRoom loop
             }else if(secretRoom == 2){//look closer at the books
               JOptionPane.showMessageDialog(null, "These bookshelves are packed with tomes describing fiend-summoning rituals and the necromantic rituals of a cult called the Priests of Osybus.");
               String BOOKS = JOptionPane.showInputDialog(null, "Would you like to take a moment to read them?" + "\n" + "1. Yes" + "\n" + "2. No");
               int books = Integer.parseInt(BOOKS);
               //if loop to read the books
                  if(books == 1){//Yes
                     JOptionPane.showMessageDialog(null, "Skimming through them, they seem like complete bogus. A charlatan made a lot of money selling these to the owner.");
                  }else if(books == 2){// No
                     JOptionPane.showMessageDialog(null, "You put down the books and turn back to the room.");
                  }
                           
             }else if(secretRoom == 3){//inspect the chest
               JOptionPane.showMessageDialog(null, "Sticking out of the chest is a skeleton in leather armor. Three darts are stuck in the dead adventurer’s armor and ribcage." + "\n"  +  "Luckily for you, the dart-firing mechanism inside the chest no longer functions. The skeleton appears to have a note in his hand.");
               String SecretChest = JOptionPane.showInputDialog(null, "What would you like to do?" + "\n" + "1. Take the note" + "\n" + "2. Root around the chest to try and find anything else useful" + "\n" + "3. Turn around and survey the room again" );
               int secretChest = Integer.parseInt(SecretChest);
               //if loop for the chest in the secret room
                  if(secretChest == 1){//take the note
                                 JOptionPane.showMessageDialog(null, "You pick up the note, trying to read it. As you grab it, it turns to dust.");
                                 continue;
                  }else if(secretChest == 2){//root around the chest to try and find anything useful
                     JOptionPane.showMessageDialog(null, "Pushing the skeleton aside, you find a couple of blank books and what seems like the deed to the house, signed by Gustav and Elisabeth Durst.");
                     String takeSecretChestStuff = JOptionPane.showInputDialog(null, "What would you like to do?" + "\n" + "1.Take the books and deed"+ "\n" + "2. Leave the chest alone");
                     int TakeSecretChestStuff = Integer.parseInt(takeSecretChestStuff);
                     //if loop to take the contents of the chest
                        if(TakeSecretChestStuff == 1){//yes take the stuff
                           JOptionPane.showMessageDialog(null, "You take the books and deed, turning around and surveying the room again");
                           FileWriter stuffInChest = new FileWriter("Inventory.txt", true);
                           stuffInChest.write("\n" + "A couple of blank books" + "\n" + "Deed to the House");
                           stuffInChest.close();
                        }else if(TakeSecretChestStuff == 2){//no don't take the stuff
                           JOptionPane.showMessageDialog(null, "Deciding not to take the items in the chest, you turn around to survey the room again");
                        }
                  }else if(secretChest == 3){//turn around and survey the room again
                     JOptionPane.showMessageDialog(null, "You turn around and look at the room again.");
                  }
                           
             }//end of if loop secretRoom
                                   
         }//end while InSecretRoom
   }//end secret room method
   
   public void Conservatory(){
      JOptionPane.showMessageDialog(null, "Entering the door on the left wall, it opens up to a conservatory.");
      JOptionPane.showMessageDialog(null, "Upholstered chairs line the walls, and stained-glass wall hangings depict beautiful men, women, and children singing and playing instruments."+ "\n" + "A harpsichord with a bench rests in the northwest corner and near the fireplace on the leftmost wall is a large standing harp." + "\n" + "Alabaster figurines of well-dressed dancers adorn the mantelpiece.");
      boolean InConservatory = true;
         while(InConservatory){
            String MusicRoom = JOptionPane.showInputDialog(null, "What would you like to do in the conservatory?" + "\n" + "1. Leave the room "+ "\n" + "2. Look closer at the wall hangings "+ "\n" + "3. Play some notes on the harpsichord "+ "\n" + "4. Pluck at the harp ");
            int musicRoom = Integer.parseInt(MusicRoom);
            //if loop for music room choices
               
               if(musicRoom == 1){//leave the room
                  JOptionPane.showMessageDialog(null, "You leave the room, going back to the second floor landing");
                  InConservatory = false;
               }else if(musicRoom == 2){//look closer at the wall hangings
                  JOptionPane.showMessageDialog(null, "The stained glass wall hangings look very cheerful at first glance. ");
                  int conservatory = diceRoll.randomDiceRollPrompt();
                  //if loop for random chance of wall hangings being wack
                     if(conservatory == 1){
                        JOptionPane.showMessageDialog(null, "Taking a closer look at the stained glass, your foot gets caught the rug and you fall flat on your face. Take one hp damage.");
                        player1.changePlayerHPOne();
                        JOptionPane.showMessageDialog(null, "Your hitpoint total is now " + player1.getPlayerHP() + ".");
                           if(player1.getPlayerHP() <= 0){//simple if for if healthpoints are gone
                              JOptionPane.showMessageDialog(null, "You have died." + "\n" + "GAME OVER ");
                              System.exit(0);
                           } 
                     }else if(conservatory == 2){
                        JOptionPane.showMessageDialog(null, "These stained glass wall hangings seem like a good source of inspiration for music playing. Nothing otherwise noteworthy about them.");
                     }else{
                        JOptionPane.showMessageDialog(null, "Looking closer at the stained glass wall hangings, you can see that a few of the gentlemen are well dressed skeletons. This room just became a lot more sinister.");
                     }
               }else if(musicRoom == 3) {//player some notes on the harpsichord
                  JOptionPane.showMessageDialog(null, "The harpsichord is covered in dust, it looks like no one has played this instrument for quite a while. " + "\n" + "You sit on the bench and reach towards the keys to push a note.");
                  int playHarpsichord = diceRoll.randomDiceRollPrompt();
                  //if loop for random harpsichord
                     if(playHarpsichord == 1){
                        JOptionPane.showMessageDialog(null, "You push one of the keys down and it gives an awful twang as the internal mechanism plucks a string and it snaps, striking your face. Take one hp damage.");
                        player1.changePlayerHPOne();
                        JOptionPane.showMessageDialog(null, "Your hitpoint total is now " + player1.getPlayerHP() + ".");
                           if(player1.getPlayerHP() <= 0){//simple if for if healthpoints are gone
                              JOptionPane.showMessageDialog(null, "You have died." + "\n" + "GAME OVER ");
                              System.exit(0);
                           } 
                     }else if(playHarpsichord == 2){
                        JOptionPane.showMessageDialog(null, "You push one of the keys down and nothing happens. Looking inside the harpsichord, you can see that a few of the strings are broken.");
                     }else if(playHarpsichord == 3){
                        JOptionPane.showMessageDialog(null, "Pushing on a couple of the keys, it makes an out of tune plucking noise. This is a very old harpsichord.");
                     }else if(playHarpsichord == 4){
                        JOptionPane.showMessageDialog(null, "Pushing a few of the keys, a beautiful chord rings out. " + "\n" + "Looking inside the harpsichord, you realize that there’s only a few strings intact, you just hit the right ones.");
                     }       
               }else if(musicRoom == 4){//pluck at the harp
                  JOptionPane.showMessageDialog(null, "This harp looks like it was once well loved, there’s still hints of shine where it used to be polished, and the strings are worn in places." + "\n" + "You reach out to pluck at one of the strings.");
                  int playHarp = diceRoll.randomDiceRollPrompt();
                  //if loop for random harp
                     if(playHarp == 1){
                        JOptionPane.showMessageDialog(null, "You pluck at one of the strings, and it snaps under your hand, wacking you in the face. Take one hp damage.");
                        player1.changePlayerHPOne();
                        JOptionPane.showMessageDialog(null, "Your hitpoint total is now " + player1.getPlayerHP() + ".");
                           if(player1.getPlayerHP() <= 0){//simple if for if healthpoints are gone
                              JOptionPane.showMessageDialog(null, "You have died." + "\n" + "GAME OVER ");
                              System.exit(0);
                           } 
                    }else if(playHarp == 2){
                        JOptionPane.showMessageDialog(null, "You pluck at one of the strings and it gives a hollow thunk sound. This harp is very old.");
                    }else if(playHarp == 3){
                        JOptionPane.showMessageDialog(null, "You pluck at the harp and the string rings out. It’s very out of tune.");
                    }else if(playHarp == 4){
                        JOptionPane.showMessageDialog(null, "You pluck a few notes on the harp and a beautiful chord rings out. Nothing else happens.");
                    }       
               }//end if loop for InConservatory
         
         }//end while InConservatory
   }
//THESE ARE THIRD FLOOR ROOMS   
   public void MasterSuite()throws IOException{
      boolean InMasterSuite = true;
      //boolean jewelryBox = true;
      JOptionPane.showMessageDialog(null, "The double doors open to reveal a dusty, cobweb-filled master bedroom.");
      JOptionPane.showMessageDialog(null, "In this bedroom there is a four-poster bed with embroidered curtains and tattered gossamer veils, and a matching pair of empty wardrobes on adjacent walls." + "\n" +  "There's a vanity with a wood-framed mirror and a shiny jewelry box; a padded chair sits in front of it."  + "\n" +  "A tiger-skin rug lies on the floor in front of the fireplace, which has a dust-covered portrait of Gustav and Elisabeth Durst hanging above it." + "\n" +  "You also notice a dumbwaiter in the far corner of the room.");
         while(InMasterSuite){                                    
            String BedroomChoices = JOptionPane.showInputDialog(null, "What would you like to do in the bedroom?" + "\n" +  "1. Investigate the vanity" + "\n" +  "2. Look closer at the tiger-skin rug" + "\n" +  "3. See if there's anything in the wardrobes" + "\n" +  "4. Look closer at the dumbwaiter" + "\n" +  "5. Leave the room");       
            int bedroomChoices = Integer.parseInt(BedroomChoices);
            //if loop for bedroom choices
                  if(bedroomChoices == 1){// Investigate the vanity
                     JOptionPane.showMessageDialog(null, "Getting a closer look at the vanity, you can see that the jewelry box sitting on it is quite ornate." + "\n" + "Otherwise, the vanity doesn’t seem like anything special.");
                     /*//need to check inventory here
                     //if player already has the jewerly in the inventory, will not show jewelry options, if the don't then will show jewelry options
                     FileReader jewelCheck = new FileReader("Inventory.txt");
                     BufferedReader CheckForJewels = new BufferedReader(jewelCheck);
                     for(int z = 0; CheckForJewels.readLine() != null; z++){
                        if(CheckForJewels.readLine().equals("Plantinum necklace with a Topaz Pendant")){//if this is in inventory, won't display the option to look at the vanity again
                           jewelryBox = false;
                        }else{
                           jewelryBox = true; 
                        }     
  
                     }//end for loop
                     //if player doesn't have jewelry in inventory, will do this loop                                    
                     while(jewelryBox){  //while loop for looking at the vanity and taking the jewels                                  
                        String JBox = JOptionPane.showInputDialog(null, "What would you like to do at the vanity?" + "\n" + "1. Look inside the jewelry box"+ "\n" + "2. Take the jewelry box contents"
                                                                        + "\n" + "3. Survey the room again");
                        int jBox = Integer.parseInt(JBox);   
                           if(jBox == 1){//look at the jewelry box
                           
                           }else if(jBox == 2){//take the contents of the jewelry box
                              JOptionPane.showMessageDialog(null, "You take the jewelry in the box.");
                              //add jewelry to inventory
                              FileWriter jewelry = new FileWriter("Inventory.txt", true);
                              jewelry.write("Three gold rings" + "\n");
                              jewelry.write("Plantinum necklace with a Topaz Pendant");
                              jewelry.close();
                              jewelryBox = false;
                           }else if(jBox == 3){// survey the room again
                             JOptionPane.showMessageDialog(null, "You turn around and look around the bedroom again.");
                             jewelryBox = false;
                           }                                 
                                                         
                      }//end jewelryBox while loop    */   //commenting this out for the sake of time lol                            
                                                         
                  }else if(bedroomChoices == 2){//Look closer at the tiger-skin rug
                     JOptionPane.showMessageDialog(null, "You crouch down to look at the tiger skin rug.");
                     int tigerSkin = diceRoll.randomDiceRollPrompt();
                        if(tigerSkin == 1){//if loop for tiger skin rug observation
                           JOptionPane.showMessageDialog(null, "This rug looks… old. And kind of gross. Nothing otherwise noteworthy about it.");
                        }else if(tigerSkin == 2){
                           JOptionPane.showMessageDialog(null, "This rug was not properly preserved, a rotting smell is emanating from it.");
                        }else if(tigerSkin == 3){
                           JOptionPane.showMessageDialog(null, "You notice an awful smell radiating from this rug, and see rotting flesh inside the open mouth of the tigers head. This rug is disgusting.");
                        }else if(tigerSkin == 4){
                           JOptionPane.showMessageDialog(null, "As you look closer, you notice blood starting to pool out from underneath the rug. " + "\n" + "Kicking it out of the way to see what’s under it, you find that there was nothing besides itself under it. " 
                                                               + "\n" + "The rug flips and blood and viscera squelch out. The smell of rotting flesh penetrates your nose. You wonder how this could have happened.");
                        }   
                  }else if(bedroomChoices == 3){//See if there's anything in the wardrobes
                     JOptionPane.showMessageDialog(null, "Rummaging through the wardrobes, you find nothing except some old dresses.");
                  }else if(bedroomChoices == 4){//Look closer at the dumbwaiter
                     JOptionPane.showMessageDialog(null, "Looking closer at the dumbwaiter, it seems like the dumbwaiter was funcitonal at one point, but the ropes seem a little too frayed for it to be trustworthy");
                  }else if(bedroomChoices == 5){//Leave the room
                     JOptionPane.showMessageDialog(null, "You walk back out to the third floor landing");
                     InMasterSuite = false;
                  }       
                  
            }//end while InMasterSuite                                                                                     

   }
   
   public void Bathroom(){
      JOptionPane.showMessageDialog(null, "The door opens to a dingy bathroom. There’s an old wooden clawed tub in the far corner, and you can see a rusty pipe coming down from the cieling." + "\n" +  "A small iron stove with a kettle sits near it.");
      JOptionPane.showMessageDialog(null, "There's nothing of noteworthy in this room and the smell is getting to you. You leave the bathroom.");
   }
   public void StorageCloset()throws IOException{
      JOptionPane.showMessageDialog(null, "The door opens into a small dusty closet. ");
      JOptionPane.showMessageDialog(null, "You only have a moment to register what’s in the room before a seemingly inconspicuos broom leaning against the wall tries to wack you!");
      CombatOne();
   }
   public void NurseMaidsSuite(){
      boolean InNurseMaidsSuite = true;
         while(InNurseMaidsSuite){ 
            String tempLast = JOptionPane.showInputDialog(null, "What would you like to do?" + "\n" + "1. Leave the room" + "\n" + "2. Investigate the dark hallway");
            int lastRoom = Integer.parseInt(tempLast);
            //if loop for last choice for now
               if(lastRoom == 1){//leave the room
                  JOptionPane.showMessageDialog(null, "You turn back to the door you entered through and discover that there is no longer a door there." + "\n" + "Very confused, you look around the room again to try and figure out what's happening.");
               }else if(lastRoom == 2){//investigate the dark hallway
                  JOptionPane.showMessageDialog(null, "As you step inside the dark hallway to get a closer look at the stairs, the vanity slams into the open doorway behind you, trapping you!");
                  JOptionPane.showMessageDialog(null,  "You see no way out except up.");
                  JOptionPane.showMessageDialog(null, "GAME OVER");
                  System.exit(0);
               }
                       
   
         
         }//end while InNurseMaidsSuite    
   }
   
   public void CombatOne() throws IOException{
      
      String haveCrossbow = "Maybe";
      String CharType = "IDK";
      //create an array list for enemy hp
      ArrayList<Integer> enemyHP = new ArrayList<Integer>();
      enemyHP.add(17);
      enemyHP.add(33);
      enemyHP.add(22);
      enemyHP.add(36);
      enemyHP.add(22);
      enemyHP.add(27);
      enemyHP.add(22);
      enemyHP.add(16);
      enemyHP.add(100);
      enemyHP.add(24);
      enemyHP.add(5); 
  
      //multidimensional array for enemy attacke damage
      int[][] enemyAttackDamage = {{2, 3, 1},
                                  {4, 1, 5},
                                  {2, 1, 3},
                                  {2, 3, 1},
                                  {3, 2, 1},
                                  {5, 2, 0},
                                  {2, 3, 7},
                                  {3, 1, 2},
                                  {1, 7, 2},
                                  {2, 3, 1}};
                                  
     //multidimensional array for enemy name in first slot and attack types in others                             
     String[][] enemyAttackType = {{"Push Broom", "smack", "wack", "trip"},                             
                                  {"Old Armor", "swing spear", "backhand", "thrust spear"},
                                  {"Spectre", "life drain", "telekinetic thrust", "Possess"},
                                  {"Ghast", "bite", "claw", "stench"},
                                  {"Ghoul", "claw", "bite", "stench"},
                                  {"Grick", "beak", "tentacle", "camoflauge"},
                                  {"Swarm of Insects", "swarm", "bite", "devour"},
                                  {"Cult Shadows", "possess", "strength drain", "life drain"},
                                  {"Shambling Mound", "engulf", "devour", "grab"},
                                  {"Swarm of Rats", "swarm", "bite", "scratch"},
                                  {"Walter"}}; 

   
     //First need to read the inventory and put it into a string array
    FileReader file = new FileReader("Inventory.txt");//instance of file reader
    BufferedReader read = new BufferedReader(file);//instance of bufferedreader
      
      String reading;
      int i = 0;
      ArrayList<String> inventory = new ArrayList<String>();
      
      while((reading = read.readLine()) != null){//while buffered reader doesn't return null
         
         for(i = 0; i<25; i++){
            inventory.add(reading);
         }
   
      }//end while loop for reading the file Inventory.txt
      
      //for loop to check if the crossbow is in the inventory
      for(i = 0; i<inventory.size(); i++){
        if(inventory.get(i).equals("Hand Crossbow")){
         haveCrossbow = "Yes";
        }else if(inventory.get(i) == null){
         haveCrossbow = "No";
        }
        
      }//end for loop

       
       int Combat1Choices;
       
       //while loop START for combat1
       boolean InCombatOne = true;
       while(InCombatOne){
       String combat1Choices = "Choice"; 
          //if loop for dialog options depending on what the character has in their inventory 
          if(haveCrossbow.equals("Yes") && CharType.equals("Sorcerer")){
            combat1Choices = JOptionPane.showInputDialog(null,"What do you do?" + "\n" + "1. Attack with your dagger" + "\n" +"2. Attack with your crossbow" + "\n" + "3. Attack with a spell" + "\n" + "4. Run away");
            Combat1Choices = Integer.parseInt(combat1Choices);
               //if loop assigning a string to each of the ints
               if(Combat1Choices == 1){
                  combat1Choices = "Attack with your dagger";
               }else if(Combat1Choices == 2){
                  combat1Choices = "Attack with your crossbow";
               }else if(Combat1Choices == 3){
                  combat1Choices = "Attack with a spell";
               }else if(Combat1Choices == 4){
                  combat1Choices = "Run away";
               }   
          
          }else if(haveCrossbow.equals("Yes") && !CharType.equals("Sorcerer")){
            combat1Choices = JOptionPane.showInputDialog(null,"What do you do?" + "\n" + "1. Attack with your dagger" + "\n" +"2. Attack with your crossbow" +"\n" + "3. Run away");
            Combat1Choices = Integer.parseInt(combat1Choices);
               //if loop assigning a string to each of the ints
               if(Combat1Choices == 1){
                  combat1Choices = "Attack with your dagger";
               }else if(Combat1Choices == 2){
                  combat1Choices = "Attack with your crossbow";
               }else if(Combat1Choices == 3){
                  combat1Choices = "Run away";
               } 
            
          }else if(!haveCrossbow.equals("Yes") && CharType.equals("Sorcerer")){
            combat1Choices = JOptionPane.showInputDialog(null,"What do you do?" + "\n" + "1. Attack with your dagger" + "\n"  + "2. Attack with a spell" + "\n" + "3. Run away");
            Combat1Choices = Integer.parseInt(combat1Choices);
               if(Combat1Choices == 1){
                  combat1Choices = "Attack with your dagger";
               }else if(Combat1Choices == 2){
                  combat1Choices = "Attack with a spell";
               }else if(Combat1Choices == 3){
                  combat1Choices = "Run away";
               } 
          
          }else if(!haveCrossbow.equals("Yes") && !CharType.equals("Sorcerer")){
            combat1Choices = JOptionPane.showInputDialog(null,"What do you do?" + "\n" + "1. Attack with your dagger" + "\n" + "2. Run away");
            Combat1Choices = Integer.parseInt(combat1Choices);
               if(Combat1Choices == 1){
                  combat1Choices = "Attack with your dagger";
               }else if(Combat1Choices == 2){
                  combat1Choices = "Run away";
               } 
          
          }//end if for dialog option
   
         switch(combat1Choices){
          
            case "Attack with your dagger":
               
               JOptionPane.showMessageDialog(null, "You rush the broom, swiping at it with your dagger.");
               int combatDice = diceRoll.randomDiceRollPrompt();
               //if loop for how much damage player does to the enemy
               if(combatDice == 1){
                  JOptionPane.showMessageDialog(null, "Swiping down with your dagger towards the broom, you miss!"  + "\n" + "Tripping over the bottom of the broom, you tumble over the banister and down the stairs. You sit at the bottom of the stairs, stunned. " + "\n" + "The broom does not follow, but you hear a door slam. Take 5 damage to your hp.");
                  player1.changePlayerHPMore(5);
                  JOptionPane.showMessageDialog(null, "Your total hitpoints is now " + player1.getPlayerHP());
                  //if loop for if the players HP is below 0, aka dead.
                  if(player1.getPlayerHP() <= 0){
                     JOptionPane.showMessageDialog(null, "You have died." + "\n" + "GAME OVER ");
                     System.exit(0);
                  }//end if loop for if player is dead
                  
               }else if(combatDice == 2){
                  JOptionPane.showMessageDialog(null,"Slashing at the broom with your dagger, it moves out of the way just in the knick of time. You miss."); 
                  JOptionPane.showMessageDialog(null,"Stepping back from the broom, you center yourself and prepare to strike again.");
                  
               }else if(combatDice == 3){
                  JOptionPane.showMessageDialog(null,"Whacking the broom with your dagger, you hit it in the handle, causing a small chunk to break off of it.");
                  JOptionPane.showMessageDialog(null,"You prepare to strike again.");
                  //enemy1HP.takeDamage(5);
                  
               }else if(combatDice == 4){
                  JOptionPane.showMessageDialog(null,"Your dagger strikes true, hitting the handle of the broom and shattering it.");
                  //enemy1.setHP(0);
                  InCombatOne = false;
               }
            
            break;
            
            case "Attack with your crossbow":
            
               JOptionPane.showMessageDialog(null,"You pull out your crossbow, drawing it back and firing off a shot");
               JOptionPane.showMessageDialog(null,"It's a thin broom, you miss.");
            
            break;
            
            case"Attack with a spell":
               
               JOptionPane.showMessageDialog(null,"Concentrating on welling up your magic, you draw up a beam of energy that hits the broom and shatters it.");
               InCombatOne = false;
               //enemy1.setHP(0);
            
            break;
            
            case"Run away":
            
               JOptionPane.showMessageDialog(null,"You run away, tripping down the stairs and tumbling back a few stairs. Take 3 hitpoints damage.");
               player1.changePlayerHPMore(3);
               JOptionPane.showMessageDialog(null, "Your total hitpoints is now " + player1.getPlayerHP());
               JOptionPane.showMessageDialog(null, "As you start to climb back up the stairs, you hear a door slam. You suspect it's the broom somehow going back into the room it came out of and closing the door somehow.");
               InCombatOne = false;
                  //if loop for if the players HP is below 0, aka dead.
                  if(player1.getPlayerHP() <= 0){
                     JOptionPane.showMessageDialog(null, "You have died." + "\n" + "GAME OVER ");
                     System.exit(0);
                  }//end if loop for if player is dead
            
            break;
          
          }//end switch loop
          
   if(InCombatOne){
      JOptionPane.showMessageDialog(null, "The " + enemyAttackType[0][0] + " reels back, looking surprisingly menacing!");
          //if loop for enemyattack  
            int combatDice = diceRoll.randomDiceRollPrompt();
            if(combatDice == 1){
               JOptionPane.showMessageDialog(null, "It tries to "+ enemyAttackType[0][3] + " you, but it misses!");
               
            }else if(combatDice == 2){
               JOptionPane.showMessageDialog(null, "It tries to " + enemyAttackType[0][2] + " you, but it misses!");
            }else if(combatDice == 3){
               JOptionPane.showMessageDialog(null, "It rushes foward and " + enemyAttackType[0][1] + "s" + " you, dealing " + enemyAttackDamage[0][1] + " damage!");
               player1.changePlayerHPMore(2);
               JOptionPane.showMessageDialog(null, "You total hitpoints is now " + player1.getPlayerHP());
               if(player1.getPlayerHP() <= 0){//if loop for if you die
                  JOptionPane.showMessageDialog(null, "You have died." + "\n" + "GAME OVER ");
                  System.exit(0);
               }
            }else if(combatDice == 4){
               JOptionPane.showMessageDialog(null, "It swings out wide, and " + enemyAttackType[0][2] + "dealing " + enemyAttackType[0][2] + " hp damage!");
               player1.changePlayerHPMore(3);
               JOptionPane.showMessageDialog(null, "You total hitpoints is now " + player1.getPlayerHP());
               if(player1.getPlayerHP() <= 0){//if loop for if you die
                  JOptionPane.showMessageDialog(null, "You have died." + "\n" + "GAME OVER ");
                  System.exit(0);
               }
            }
      }
      
      }//end while loop
  }  //end combatone  
   
  
   /*
   public void AtticHall(){
      JOptionPane.showMessageDialog(null, "AtticHall");
   }  
   /*public void SpareBedroom(){
      System.out.println("SpareBedroom");
   }
   public void UpperStorageRoom(){
      JOptionPane.showMessageDialog(null, "UpperStorageROom");
   }
   public void ChildrensRoom(){
      JOptionPane.showMessageDialog(null, "ChildrensRoom");
   }
   //Dungeon starts here lol big house
   public void SecretStairs(){
      JOptionPane.showMessageDialog(null, "SecretStairs");
   }
   public void DungeonLevelAccess(){
      JOptionPane.showMessageDialog(null, "DungeonENTER");
   }
   public void FamilyCrypts(){
      JOptionPane.showMessageDialog(null, "Crypts");
   }
   public void CultInitiatesQuarters(){
      JOptionPane.showMessageDialog(null, "InitiateQuarters");
   }
   public void WellAndCultQuarters(){
      JOptionPane.showMessageDialog(null, "CultQuarters");
   }
   public void HiddenSpikedPit(){
      JOptionPane.showMessageDialog(null, "PIT");
   }
   public void DiningHall(){
      JOptionPane.showMessageDialog(null, "DiningHall");
   }
   public void Larder(){
      JOptionPane.showMessageDialog(null, "Larder");
   }
   public void GhoulishEncounter(){
      JOptionPane.showMessageDialog(null, "ENOUNTER");
   }
   public void StairsDown(){
      JOptionPane.showMessageDialog(null, "StairsDown");
   }
   public void DarklordShrine(){
      JOptionPane.showMessageDialog(null, "Darklord Shrine");
   }
   public void HiddenTrapdoor(){
      JOptionPane.showMessageDialog(null, "Hidden Trapdoor");
   }
   public void CultLeadersDen(){
      JOptionPane.showMessageDialog(null, "CultDen");
   }
   public void Reliquary(){
      JOptionPane.showMessageDialog(null, "Reliquary");
   }
   public void Prison(){
      JOptionPane.showMessageDialog(null, "Prison");
   }
   public void Portcullis(){
      JOptionPane.showMessageDialog(null, "Portcullis");
   }
   public void RitualChamber(){
      JOptionPane.showMessageDialog(null, "Ritual Chamber");
   }*/
   


}


