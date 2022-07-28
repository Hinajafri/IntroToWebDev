/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coms.sg.foundations.milestone1;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author hinas
 */
public class RockPaperScissors {

    public static void main(String[] args) {
        //initiating the program with all the required variables
        int userChoice;
        int compChoice;
        int ties = 0;
        int userWins = 0;
        int compWins = 0;
        int invalidUserInput = 0;
        String playAgain;
        int playCount;
        final int maxCompChoice = 3;
        final int minCompChoice = 1;
        boolean startOver = true;
        //Initiating Scanner and Random Class
        Scanner input = new Scanner(System.in);
        Random rdm = new Random();
        while (startOver) {
            System.out.println("How many rounds you would like to play : Max=10, Min=1");
            playCount = input.nextInt();
            //taking the input from user for game

            if (playCount < 1 || playCount > 10) {
                System.out.println("Invalid choice of rounds");
                System.exit(0);
            }

            //Running the loop for playing the game
            for (int i = 1; i <= playCount; i++) {
                System.out.println("User - Please enter your choice - Rock=1, Paper=2, Scissors=3 ");
                userChoice = input.nextInt();
                compChoice = minCompChoice + rdm.nextInt(maxCompChoice);
                System.out.println("Computer - What is your choice? Rock=1, Paper=2, Scissors=3 " + compChoice);
                if (userChoice == compChoice) {
                    System.out.println("It is a TIE");
                    ties++;
                } else if (((userChoice == 1) && (compChoice == 3)) || ((userChoice == 2) && (compChoice == 1)) || ((userChoice == 3) && (compChoice == 2))) {
                    System.out.println("User Wins");
                    userWins++;
                } else if (((compChoice == 1) && (userChoice == 3)) || ((compChoice == 2) && (userChoice == 1)) || ((compChoice == 3) && (userChoice == 2))) {
                    System.out.println("Computer Wins");
                    compWins++;
                } else {
                    System.out.println("Invalid User Input");
                    invalidUserInput++;
                }

            }
            System.out.println("Ties= " + ties);
            System.out.println("User Wins= " + userWins);
            System.out.println("Comp Wins= " + compWins);
            System.out.println("Invalid User Input= " + invalidUserInput);
            //when user win more than computer
            if (userWins > compWins) {
                System.out.println("User is the Winner");
            //when computer wins more than user
            } else if (userWins < compWins) {
                System.out.println("Computer is the Winner");
            //when there is tie betweeen user and computer    
            } else if (userWins > 0 && compWins > 0 && userWins == compWins) {
                System.out.println("The Game is Tied " + ties + " time(s)");
            //when user enter all invalid entries
            } else if (invalidUserInput == playCount) {
                System.out.println("All User Inputs are Invalid");
            }
            //Taking the input from user for playing the game again or not
            Scanner plAg = new Scanner(System.in);
            System.out.println("Do you want to play this game again - Yes or No");
            playAgain = plAg.nextLine();
            System.out.println("You chose " + playAgain);
            //If user choose not to play the game
            if (playAgain.equalsIgnoreCase("No")) {
                System.out.println("Thanks for playing");
                startOver = false;
            //if user chose to play the game    
            } else if (playAgain.equalsIgnoreCase("Yes")){
                startOver = true;
                // resetting the win counts for user and computer
                userWins = 0;
                compWins = 0;
                invalidUserInput = 0;
            } 
            //if user put invalid choice
            else {
                System.out.println("Invalid User Input - Have a great day!");
                startOver = false;
            }
        }

    }
}
