import java.util.Scanner;

public class FilipDomanskiJavaCoursework1 {

    // function responsible for throwing two dice
    private static int diceThrow(){
       // declaration of variables
       double diceThrow1, diceThrow2;
       int dice1, dice2, combined;
       
       // dice function
       diceThrow1 = ((Math.random() * 6) + 1);
       dice1 = (int)diceThrow1; // conversion form double to int without changeing the initial number

       diceThrow2 = ((Math.random() * 6) + 1);
       dice2 = (int)diceThrow2; // conversion form double to int without changeing the initial number
        
       // display rolled numbers
       System.out.print("[" + dice1 + "]");
       System.out.println("[" + dice2 + "]");
        
       // adding rolled numbers together
       combined = dice1 + dice2;
       System.out.print("combined number from two dice thrown: " + combined);
        
       // return the combined value of rolled numbers
       return combined;
    }
    
     // function asking to enter t to throw dice and validateing if t was entered
    public static void tToThrow() {
        Scanner input = new Scanner(System.in);
        boolean result;
        do{
            System.out.print("Enter 't' to throw > ");
            String data = input.nextLine();
            
          result = data.equalsIgnoreCase("t"); // check if data is equal to 't' noncase sensitive if yes result = true
        }while(!result);
    }

    //function allowing to choose the place you want the score to be saved in
    private static int choosePlace(){
        // declaration of variables
        int validationFlag = 0, choosePlace = 0;

        // while loop responsible for validation of inputed data
        do{
            System.out.println("Enter the column in which you wish to insert your score (2 to 12) > ");
            Scanner input = new Scanner(System.in);
            // check if inputted value is an integer
            if(input.hasNextInt()){ 
                choosePlace = input.nextInt();
                // check if inputed integer is between 2-12 if yes update the validationFlag to end the loop
                if(choosePlace < 1 || choosePlace > 12){
                    System.out.print("pick a number form 2-12 >");
                }else{
                    validationFlag++;
                }
            }else{ // if inputted value is not an integer print please pick a number
                System.out.println("please pick a number >");
            }
        }while(validationFlag == 0); // if the validationFlag value changes from 0 to a different number the loop ends

        // return the validated integer picked by the player
        return choosePlace;
    }
    
    // function that generates and updates table useing combined number got form a throw, choosen place to put the number and playerFlag to distinguish between players
    public static void generateTable(int[] playerOne, int[] playerTwo,int[] playerThree){
         System.out.println("--------------------------------------------------------------------");
        System.out.println("|          | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 | 10 | 11 | 12 | Scores |");
        System.out.println("| Player 1 | " + format(playerOne[0]) + " | " + format(playerOne[1]) + " | " + format(playerOne[2]) + " | " + format(playerOne[3]) + " | " + format(playerOne[4]) + " | " + format(playerOne[5]) + " | " + format(playerOne[6]) + " | " + format(playerOne[7]) + " | " + format(playerOne[8]) + "  | " + format(playerOne[9]) + "  | " + format(playerOne[10]) + "  |        |");
        System.out.println("| Player 2 | " + format(playerTwo[0]) + " | " + format(playerTwo[1]) + " | " + format(playerTwo[2]) + " | " + format(playerTwo[3]) + " | " + format(playerTwo[4]) + " | " + format(playerTwo[5]) + " | " + format(playerTwo[6]) + " | " + format(playerTwo[7]) + " | " + format(playerTwo[8]) + "  | " + format(playerTwo[9]) + "  | " + format(playerTwo[10]) + "  |        |");
        System.out.println("| Player 3 | " + format(playerThree[0]) + " | " + format(playerThree[1]) + " | " + format(playerThree[2]) + " | " + format(playerThree[3]) + " | " + format(playerThree[4]) + " | " + format(playerThree[5]) + " | " + format(playerThree[6]) + " | " + format(playerThree[7]) + " | " + format(playerThree[8]) + "  | " + format(playerThree[9]) + "  | " + format(playerThree[10]) + "  |        |");
        System.out.println("--------------------------------------------------------------------");
    }

    // Helper method to format the numbers
    public static String format(int number) {
        return number == 0 ? " " : String.valueOf(number);
    }
    
    public static void main(String[] args) {
        //defining arrays
        int[] playerOne = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] playerTwo = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] playerThree = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        
        // define choosePlace for each player and assign default value
        int choosePlace, choosePlace1, choosePlace2, previousPlace, previousPlace1, previousPlace2;
        choosePlace = 0;
        choosePlace1 = 0;
        choosePlace2 = 0;
        
        System.out.println("***************************");
        System.out.println("*** Strategic Dice Game ***");
        System.out.println("***************************");
        
        
        System.out.println("Welcome to a simple dice game!");
        
        System.out.println("Three players take turn throwing two dice over 11 rounds");
        System.out.println("This is simulated at the console, with all players simply");
        System.out.println("takeing turns at the keyboard. The game simply involves");
        System.out.println("throwing two dice in each round and selecting a column");
        System.out.println("or position in the score table, but it is quite strategic");
        System.out.println("in oder to optimise scores. Note that for the first roud");
        System.out.println("players must select different columns ... let's play");
         
         // for loop running for 11 rounds
          for(int i = 1; i < 12; i++){
            // display what round it is
              System.out.println("---------------");
              System.out.println("*** Round: " + i + "***");
              System.out.println("---------------");
              
              generateTable(playerOne, playerTwo, playerThree);
              
              System.out.println("PLayer 1 to throw");
              
              // t to throw
              tToThrow();
              
            // throw two dice and save combined number
              int diceThrow = diceThrow();
              
            // from the second round onwards check if the same collumn is choosen again if so repeat
            if(i == 1){
                // pick a number to be saved as the place you want your score to be placed in
                choosePlace = choosePlace() - 2;
            }else{
                do{
                    choosePlace = choosePlace() - 2;
                }while(playerOne[choosePlace] != 0);
            }     
           
              
            // update array
            playerOne[choosePlace] = diceThrow;
                
            // generate updated table
            generateTable(playerOne, playerTwo, playerThree);
              
               System.out.println("PLayer 2 to throw");
              
              // t to throw
              tToThrow();
              
            // throw two dice and save combined number
              int diceThrow1 = diceThrow();
              
            // if its the first round check if the collumns picked by players are the same and prompt to pick a different collumn 
            if(i == 1){
              do{
                  // pick a number to be saved as the place you want your score to be placed in
                   System.out.println(" dureing round one you have to pick different collumn than player 1 or 2");
                   choosePlace1 = choosePlace() - 2;
              }while( choosePlace == choosePlace1);
            }else{
                do{
                    choosePlace1 = choosePlace() - 2;
                }while(playerTwo[choosePlace1] != 0);
            }     
             
             
            // update array
            playerTwo[choosePlace1] = diceThrow1;
                 
             
            // generate updated table 
             generateTable(playerOne, playerTwo, playerThree);
             
             
               System.out.println("PLayer 3 to throw");
              
              // t to throw
              tToThrow();
              
            // throw two dice and save combined number
              int diceThrow2 = diceThrow();
             
            // if its the first round check if the collumns picked by players are the same and prompt to pick a different collumn 
            if(i == 1){
               do{
                   // pick a number to be saved as the place you want your score to be placed in
                    System.out.println(" dureing round one you have to pick different collumn than player 1 or 2");
                    choosePlace2 = choosePlace() - 2;
               }while( choosePlace == choosePlace2 || choosePlace1 == choosePlace2);
            }else{
                  do{
                    choosePlace2 = choosePlace() - 2;
                }while(playerThree[choosePlace2] != 0);
             }
             
             
             
             // update array
            playerThree[choosePlace2] = diceThrow2;
                
             
            // generate updated table 
             generateTable(playerOne, playerTwo, playerThree);
             
             }

    }
    
}
