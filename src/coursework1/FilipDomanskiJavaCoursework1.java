package coursework1;

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
        System.out.println("combined number from two dice thrown: " + combined);

        // return the combined value of rolled numbers
        return combined;
    }

    // function asking to enter t to throw dice and validateing if t was entered
    private static void tToThrow() {
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
                if(choosePlace <= 1 || choosePlace > 12){
                    System.out.println("pick a number form 2-12");
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
    
    // function that generates and updates table
    private static void generateTable(int[] playerOne, int[] playerTwo,int[] playerThree, int[] score){
        // for every collumn check which number is bigger increment score and turn the other to 20
        for(int j = 0; j < playerOne.length; j++){
            //ignore values 20 and 0 because they are used to format the looks of the table
            if (playerOne[j] != 0 && playerTwo[j] != 0 && playerThree[j] != 0 &&
            playerOne[j] != 20 && playerTwo[j] != 20 && playerThree[j] != 20) {
                int max = Integer.MIN_VALUE;
                // Check if player one is max if so save it as max
                if (playerOne[j] != 20) {
                    max = Math.max(max, playerOne[j]);
                }

                // Check if player two is max if so save it as max
                if (playerTwo[j] != 20) {
                    max = Math.max(max, playerTwo[j]);
                }

                // Check if player three is max if so save it as max
                if (playerThree[j] != 20) {
                    max = Math.max(max, playerThree[j]);
                }

                // Now set any non-maximum values to 20 and increment score if its a maximum number
                if (playerOne[j] != 20 && playerOne[j] != max) {
                    playerOne[j] = 20;
                }else{
                     score[0] += j+2;
                }

                if (playerTwo[j] != 20 && playerTwo[j] != max) {
                    playerTwo[j] = 20;
                }else{
                     score[1] += j+2;
                }

                if (playerThree[j] != 20 && playerThree[j] != max) {
                    playerThree[j] = 20;
                }else{
                    score[2] += j+2;
                }
            }
        }
        // generate table
        System.out.println("--------------------------------------------------------------------------------------------");
        System.out.println("|          |  2  |  3  |  4  |  5  |  6  |  7  |  8  |  9  |  10  |  11  |  12  |  Scores  |");
        System.out.println("--------------------------------------------------------------------------------------------");
        System.out.println("| Player 1 | " + format(playerOne[0]) + " | " + format(playerOne[1]) + " | " + format(playerOne[2]) + " | " + format(playerOne[3]) + " | " + format(playerOne[4]) + " | " + format(playerOne[5]) + " | " + format(playerOne[6]) + " | " + format(playerOne[7]) + " | " + format(playerOne[8]) + "  | " + format(playerOne[9]) + "  | " + format(playerOne[10]) + "  |   " + format(score[0]) + "    |");
        System.out.println("--------------------------------------------------------------------------------------------");
        System.out.println("| Player 2 | " + format(playerTwo[0]) + " | " + format(playerTwo[1]) + " | " + format(playerTwo[2]) + " | " + format(playerTwo[3]) + " | " + format(playerTwo[4]) + " | " + format(playerTwo[5]) + " | " + format(playerTwo[6]) + " | " + format(playerTwo[7]) + " | " + format(playerTwo[8]) + "  | " + format(playerTwo[9]) + "  | " + format(playerTwo[10]) + "  |   " + format(score[1]) + "    |");
        System.out.println("--------------------------------------------------------------------------------------------");
        System.out.println("| Player 3 | " + format(playerThree[0]) + " | " + format(playerThree[1]) + " | " + format(playerThree[2]) + " | " + format(playerThree[3]) + " | " + format(playerThree[4]) + " | " + format(playerThree[5]) + " | " + format(playerThree[6]) + " | " + format(playerThree[7]) + " | " + format(playerThree[8]) + "  | " + format(playerThree[9]) + "  | " + format(playerThree[10]) + "  |   " + format(score[2]) + "    |");
        System.out.println("--------------------------------------------------------------------------------------------");
    }

    // Helper method to format the numbers
    private static String format(int number) {
        String value = String.valueOf(number);
        if(number == 0){
            value = "   ";
        }
        if(number > 0 && number < 10){
            value = " " + number + " ";
        }
        if(number == 20){
            value = " * ";
        }
        return value;
    }
    
    // at the end of the game compare scores and display the winner
    private static void victory(int[] score){
        int max = Integer.MIN_VALUE;
        
        // find the biggest score
        for(int j = 0; j < score.length; j++){
            max = Math.max(max, score[j]);
        }
        
        // proclameing winners/ties
        if(max == score[0]){
            System.out.println("player one won!");
        }
        if(max == score[1]){
            System.out.println("player two won!");
        }
        if(max == score[2]){
            System.out.println("player three won!");
        }
        if(max == score[0] && max == score[1]){
            System.out.println("player one and two tied!");
        }
        if(max == score[0] && max == score[2]){
            System.out.println("player one and three tied!");
        }
        if(max == score[1] && max == score[2]){
            System.out.println("player two and three tied!");
        }
    }    
    
    public static void main(String[] args) {
        //defining arrays
        int[] playerOne = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] playerTwo = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] playerThree = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] score = {0, 0, 0};
        
        // define choosePlace for each player and assign default value
        int choosePlace, choosePlace1, choosePlace2;
        choosePlace = 0;
        choosePlace1 = 0;
        choosePlace2 = 0;
        
        // print initial text
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

            generateTable(playerOne, playerTwo, playerThree, score);

            System.out.println("PLayer 1 to throw");

            // t to throw
            tToThrow();

            // throw two dice and save combined numbert
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
            generateTable(playerOne, playerTwo, playerThree, score);

            System.out.println("PLayer 2 to throw");

            // t to throw
            tToThrow();

            // throw two dice and save combined number
            int diceThrow1 = diceThrow();

            // if its the first round check if the collumns picked by players are the same and prompt to pick a different collumn 
            if(i == 1){
                do{
                  // pick a number to be saved as the place you want your score to be placed in
                  System.out.println(" dureing round one you have to pick different collumn than other players");
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
            generateTable(playerOne, playerTwo, playerThree, score);

            System.out.println("PLayer 3 to throw");

            // t to throw
            tToThrow();

            // throw two dice and save combined number
            int diceThrow2 = diceThrow();

            // if its the first round check if the collumns picked by players are the same and prompt to pick a different collumn 
            if(i == 1){
                do{
                // pick a number to be saved as the place you want your score to be placed in
                System.out.println(" dureing round one you have to pick different collumn than other players");
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
            generateTable(playerOne, playerTwo, playerThree, score);
        }
        
        // end game and display the winners
        victory(score);
        System.out.println("game finished");
    }
}
