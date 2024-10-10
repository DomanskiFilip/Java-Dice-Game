/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */


import java.util.Scanner;

/**
 *
 * @author Strateg
 */
public class FilipDomanskiJavaCoursework1 {

    // function responsible for throwing two dice
    static int diceThrow(){
       // declaration of variables
       double diceThrow1, diceThrow2;
       int dice1, dice2, combined;
       // dice function
       do{
           diceThrow1 = Math.random() * 7;
           dice1 = (int)diceThrow1; // conversion form double to int without changeing the initial number
       }while(dice1 == 0);
       
       do{
           diceThrow2 = Math.random() * 7;
           dice2 = (int)diceThrow2; // conversion form double to int without changeing the initial number
       }while(dice2 == 0);
       // display rolled numbers
        System.out.println("first dice: " + dice1);
        System.out.println("second dice: " + dice2);
       // adding rolled numbers together
       combined = dice1 + dice2;
       System.out.println("combined number from two dice thrown: " + combined);
       // return the combined value of rolled numbers
       return combined;
    }
    
    //function allowing to choose the place you want the score to be saved in
    static int choosePlace(){
            // declaration of variables
            int validationFlag = 0, choosePlace = 0;
            // while loop responsible for validation of inputed data
            do{
                Scanner input = new Scanner(System.in);
                // check if inputted value is an integer
                if(input.hasNextInt()){ 
                    choosePlace = input.nextInt();
                    // check if inputed integer is between 1-11 if yes update the validationFlag to end the loop
                    if(choosePlace < 0 || choosePlace > 11){
                        System.out.println("pick a number form 1-11");
                    }else{
                        System.out.println("picked: " + choosePlace);
                        validationFlag++;
                    }
                }else{ // if inputted value is not an integer print please pick a number
                    System.out.println("please pick a number");
                }
            }while(validationFlag == 0); // if the validationFlag value changes from 0 to a different number the loop ends
        // return the validated integer picked by the player
        return choosePlace;
    }
    
    public static void main(String[] args) {
        // for loop running for 11 rounds
        for(int i = 1; i < 12; i++){
            // display what round it is
            System.out.println("round: " + i);
            // throw two dice and save combined number
            int score = diceThrow();
            // pick a number to be saved as the place you want your score to be placed in
            int ChoosenPlace = choosePlace();
        }
    }
    
}
