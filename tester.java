/** ***************************************************************************
 *
 * FILE:           tester.java
 * DATE:           Mar 7, 2022
 * AUTHOR:         Nathan Grabowski
 * VERSION:        1.0
 * PURPOSE:
 *
 ***************************************************************************** */
import java.util.Scanner;

public class tester {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        MatchingModel m = new MatchingModel(4);
        m.initialize();
        m.shuffle();
        m.getFaceUp(3, 3);
        int score = 0;
        int numCorrect = 0;
        System.out.println("Welcome to the Matching Game!");
        System.out.println("You will recieve five points for a correct guess, and lose one point for an incorrect guess.");
        while (true) {//loops through as long as the game is still going
            m.display();
            System.out.println("");
            System.out.println("Enter the row of your  guess(1-4)");
            int r1 = input.nextInt() - 1;
            System.out.println("Enter the collum of your  guess(1-4)");
            int c1 = input.nextInt() - 1;
            m.faceup[r1][c1] = true;
            m.display();

            System.out.println("Enter the row of your  guess(1-4)");
            int r2 = input.nextInt() - 1;
            System.out.println("Enter the collum of your  guess(1-4)");
            int c2 = input.nextInt() - 1;
            m.faceup[r2][c2] = true;
            m.display();

            if (m.grid[r1][c1] == m.grid[r2][c2]) {
                score = score + 5; //if it is correct 5 points are added 
                numCorrect = numCorrect + 1;
                System.out.println("Congratulations, you got a match!");
                System.out.println("Your score is now: " + score);
            } else {
                score = score - 1; //if it is incorrrect 1 point is removed
                System.out.println("The two tiles did not match");
                System.out.println("Your score is now: " + score);
                m.faceup[r1][c1] = false;
                m.faceup[r2][c2] = false;
            }
            if (numCorrect >= 8) {
                System.out.println("Your final score was: " + score);
                break;
            }
        }
    }
}