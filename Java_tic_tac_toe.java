import java.util.Scanner;

class Main {
    public static char[][] row = {{'-', '-', '-'}, {'-', '-', '-'}, {'-', '-', '-'}}; //ARRAY- Tic-Tac-Toe grid
    public static Scanner input = new Scanner(System.in);
    public static char result;
    public static int temp = 0; //Temporary variable used for changing turns of X and O


    public static void main(String[] args) {
        // Tic-Tac-Toe layout
        System.out.println("-----------");
        System.out.println("* " + "| " + "1" + " " + "2" + " " + "3" + " |");
        System.out.println("-----------");
        System.out.println("1 " + "| " + "-" + " " + "-" + " " + "-" + " |");
        System.out.println("2 " + "| " + "-" + " " + "-" + " " + "-" + " |");
        System.out.println("3 " + "| " + "-" + " " + "-" + " " + "-" + " |");
        System.out.println("-----------");

        Call(); //Function for taking inputs of gameplay
    }

    public static void Call() {
        System.out.print("Enter the coordinates: ");
        int i, j; //Row and Column respectively
        try {
            i = input.nextInt();
            j = input.nextInt();

            // Checking whether both inputs given are between 1 and 3
            if (i > 3 || i < 1 || j > 3 || j < 1) {
                System.out.println("Coordinates should be from 1 to 3!");
                Call();
            } else {
                // Checking if the cell is empty or not
                if (row[i - 1][j - 1] != 'X' && row[i - 1][j - 1] != 'O') {
                    temp = temp + 1;

                    //Changing turns after cell is filled by one player
                    if (temp % 2 !=0) {
                        row[i - 1][j - 1] = 'X';
                    } else {
                        row[i - 1][j - 1] = 'O';
                    }

                    //Updating the cells
                    System.out.println("-----------");
                    System.out.println("* " + "| " + "1" + " " + "2" + " " + "3" + " |");
                    System.out.println("-----------");
                    System.out.println("1 " + "| " + row[0][0] + " " + row[0][1] + " " + row[0][2] + " |");
                    System.out.println("2 " + "| " + row[1][0] + " " + row[1][1] + " " + row[1][2] + " |");
                    System.out.println("3 " + "| " + row[2][0] + " " + row[2][1] + " " + row[2][2] + " |");
                    System.out.println("-----------");

                    result = matchResult(row); // Calling Result function to get the status of the game
                    if (result == 'C') {
                        Call(); //Continuing the play if no conclusion is reached yet
                    }
                } else {
                    System.out.println("This cell is occupied! Choose another one!");
                    Call();
                }
            }
        } catch (Exception e) {
            System.out.println("You should enter numbers!"); //Exception when inputs other than numbers are given
        }
    }

    public static char matchResult(char[][] row) {
        int numberOfX = 0;
        int numberOfO = 0;

        //Calculating the number of Xs and Os
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (row[i][j] == 'X') {
                    numberOfX++;
                } else if (row[i][j] == 'O') {
                    numberOfO++;
                }
            }
        }

        /*Sum of all rows and columns (X and O are converted to ASCII values and calculated)
          ASCII value of X = 88, ASCII value of O = 79
         */
        int sumRow1 = row[0][0] + row[0][1] + row[0][2];
        int sumRow2 = row[1][0] + row[1][1] + row[1][2];
        int sumRow3 = row[2][0] + row[2][1] + row[2][2];
        int sumCol1 = row[0][0] + row[1][0] + row[2][0];
        int sumCol2 = row[0][1] + row[1][1] + row[2][1];
        int sumCol3 = row[0][2] + row[1][2] + row[2][2];

        /* Impossible cases
            1. When the grid has three X’s in a row as well as three O’s in a row
            2. There are a lot more X's than O's or vice versa (the difference should be 1 or 0;
                if the difference is 2 or more, then the game state is impossible)
         */

        /* Win cases
            1. X wins - when the grid has three X’s in a row
            2. O wins - when the grid has three O’s in a row
         */

        /* Draw case
            When no side has a three in a row and the grid has no empty cells
         */
        if (Math.abs(numberOfX - numberOfO) > 1) {
            System.out.println("Impossible");
            result = 'I';
        } else if ((sumRow1 == 264 && sumRow2 == 237) || (sumRow1 == 264 && sumRow3 == 237)) {
            System.out.println("Impossible");
            result = 'I';
        } else if ((sumRow2 == 264 && sumRow1 == 237) || (sumRow2 == 264 && sumRow3 == 237)) {
            System.out.println("Impossible");
            result = 'I';
        } else if ((sumRow3 == 264 && sumRow1 == 237) || (sumRow3 == 264 && sumRow2 == 237)) {
            System.out.println("Impossible");
            result = 'I';
        } else if ((sumRow1 == 237 && sumRow2 == 264) || (sumRow1 == 237 && sumRow3 == 264)) {
            System.out.println("Impossible");
            result = 'I';
        } else if ((sumRow2 == 237 && sumRow1 == 264) || (sumRow2 == 237 && sumRow3 == 264)) {
            System.out.println("Impossible");
            result = 'I';
        } else if ((sumRow3 == 237 && sumRow1 == 264) || (sumRow3 == 237 && sumRow2 == 264)) {
            System.out.println("Impossible");
            result = 'I';
        } else if ((sumCol1 == 264 && sumCol2 == 237) || (sumCol1 == 264 && sumCol3 == 237)) {
            System.out.println("Impossible");
            result = 'I';
        } else if ((sumCol2 == 264 && sumCol1 == 237) || (sumCol2 == 264 && sumCol3 == 237)) {
            System.out.println("Impossible");
            result = 'I';
        } else if ((sumCol3 == 264 && sumCol1 == 237) || (sumCol3 == 264 && sumCol2 == 237)) {
            System.out.println("Impossible");
            result = 'I';
        } else if ((sumCol1 == 237 && sumCol2 == 264) || (sumCol1 == 237 && sumCol3 == 264)) {
            System.out.println("Impossible");
            result = 'I';
        } else if ((sumCol2 == 237 && sumCol1 == 264) || (sumCol2 == 237 && sumCol3 == 264)) {
            System.out.println("Impossible");
            result = 'I';
        } else if ((sumCol3 == 237 && sumCol1 == 264) || (sumCol3 == 237 && sumCol2 == 264)) {
            System.out.println("Impossible");
            result = 'I';
        } else if (row[0][0] +row[0][1] +  row[0][2] == 264) {
            System.out.println("X wins");
            result = 'W';
        } else if (row[1][0] +  row[1][1] +  row[1][2] == 264) {
            System.out.println("X wins");
            result = 'W';
        } else if (row[2][0] +  row[2][1] +  row[2][2] == 264) {
            System.out.println("X wins");
            result = 'W';
        } else if (row[0][0] +  row[1][0] +  row[2][0] == 264) {
            System.out.println("X wins");
            result = 'W';
        } else if (row[0][1] +  row[1][1] +  row[2][1] == 264) {
            System.out.println("X wins");
            result = 'W';
        } else if (row[0][2] +  row[1][2] +  row[2][2] == 264) {
            System.out.println("X wins");
            result = 'W';
        } else if (row[0][0] +  row[1][1] +  row[2][2] == 264) {
            System.out.println("X wins");
            result = 'W';
        } else if (row[0][2] +  row[1][1] +  row[2][0] == 264) {
            System.out.println("X wins");
            result = 'W';
        } else if (row[0][0] +  row[0][1] +  row[0][2] == 237) {
            System.out.println("O wins");
            result = 'W';
        } else if (row[1][0] +  row[1][1] +  row[1][2] == 237) {
            System.out.println("O wins");
            result = 'W';
        } else if (row[2][0] +  row[2][1] +  row[2][2] == 237) {
            System.out.println("O wins");
            result = 'W';
        } else if (row[0][0] +  row[1][0] +  row[2][0] == 237) {
            System.out.println("O wins");
            result = 'W';
        } else if (row[0][1] +  row[1][1] +  row[2][1] == 237) {
            System.out.println("O wins");
            result = 'W';
        } else if (row[0][2] +  row[1][2] +  row[2][2] == 237) {
            System.out.println("O wins");
            result = 'W';
        } else if (row[0][0] +  row[1][1] +  row[2][2] == 237) {
            System.out.println("O wins");
            result = 'W';
        } else if (row[0][2] +  row[1][1] +  row[2][0] == 237) {
            System.out.println("O wins");
            result = 'W';
        } else if (numberOfX + numberOfO == 9) {
            System.out.println("Draw");
            result = 'D';
        } else {
            result = 'C'; //Game continues
        }

        return result;
    }
}
