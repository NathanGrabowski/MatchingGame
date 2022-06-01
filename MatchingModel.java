/** ***************************************************************************
 *
 * FILE:           MatchingModel.java
 * DATE:           Feb 14, 2022
 * AUTHOR:         Nathan Grabowski
 * VERSION:        1.0
 * PURPOSE:
 *
 ***************************************************************************** */

public class MatchingModel {

    int[][] grid = new int[4][4];
    boolean[][] faceup = new boolean[4][4];

    public MatchingModel(int size) {
        grid = new int[size][size];
    }

    public boolean getFaceUp( int row, int column) {
        return faceup[row][column];
    }

    public void display() {         //displays the grid
        System.out.println("\t1\t2\t3\t4");
        System.out.println("\t-------------------------");
        for (int r = 0; r < 4; r++) {
            System.out.print(r + 1 + "\t|");
            for (int c = 0; c < 4; c++) {
                if (faceup[r][c] == false) { //prints a * when facedown
                    System.out.print("*\t");
                } else {
                    System.out.print(grid[r][c] + "\t"); //prints the number when faceup
                }
            }
            System.out.println("");
        }
    }

    public void initialize() {      //gives all parts of grid a number (2 per number)
        grid[0][0] = grid[0][1] = 1;
        grid[0][2] = grid[0][3] = 2;
        grid[1][0] = grid[1][1] = 3;
        grid[1][2] = grid[1][3] = 4;
        grid[2][0] = grid[2][1] = 5;
        grid[2][2] = grid[2][3] = 6;
        grid[3][0] = grid[3][1] = 7;
        grid[3][2] = grid[3][3] = 8;
    }

    public void shuffle() {
        int x = 0, y = 0, a = 0, b = 0;

        for (int i = 0; i < 1000; i++) {    //randomizes the numbers on each grid
            x = (int) (Math.random() * 4);
            y = (int) (Math.random() * 4);
            a = (int) (Math.random() * 4);
            b = (int) (Math.random() * 4);
            int temp = grid[x][y];
            grid[x][y] = grid[a][b];
            grid[a][b] = temp;
        }

    }

}