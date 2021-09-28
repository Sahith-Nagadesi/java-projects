import java.util.Scanner;

class Main {
    public static char[][] row = {{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};
    public static int i;
    public static int j;
    public static Scanner input = new Scanner(System.in);
    public static char result;
    public static int temp = 0;


    public static void main(String[] args) {
        System.out.println("---------");
        System.out.println("| " + " " + " " + " " + " " + " " + " |");
        System.out.println("| " + " " + " " + " " + " " + " " + " |");
        System.out.println("| " + " " + " " + " " + " " + " " + " |");
        System.out.println("---------");

        Call();
    }

    public static void Call() {
        System.out.print("Enter the coordinates: ");
        try {
            i = input.nextInt();
            j = input.nextInt();
            if (i > 3 || i < 1 || j > 3 || j < 1) {
                System.out.println("Coordinates should be from 1 to 3!");
                Call();
            } else {
                if (row[i - 1][j - 1] != 'X' && row[i - 1][j - 1] != 'O') {
                    temp = temp + 1;
                    if (temp % 2 !=0) {
                        row[i - 1][j - 1] = 'X';
                    } else {
                        row[i - 1][j - 1] = 'O';
                    }
                    System.out.println("---------");
                    System.out.println("| " + row[0][0] + " " + row[0][1] + " " + row[0][2] + " |");
                    System.out.println("| " + row[1][0] + " " + row[1][1] + " " + row[1][2] + " |");
                    System.out.println("| " + row[2][0] + " " + row[2][1] + " " + row[2][2] + " |");
                    System.out.println("---------");
                    result = matchResult(row);
                    if (result == 'C') {
                        Call();
                    }
                } else {
                    System.out.println("This cell is occupied! Choose another one!");
                    Call();
                }
            }
        } catch (Exception e) {
            System.out.println("You should enter numbers!");
        }
    }

    public static char matchResult(char[][] row) {
        int numberOfX = 0;
        int numberOfO = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (row[i][j] == 'X') {
                    numberOfX++;
                } else if (row[i][j] == 'O') {
                    numberOfO++;
                }
            }
        }

        int sumRow1 = row[0][0] + row[0][1] + row[0][2];
        int sumRow2 = row[1][0] + row[1][1] + row[1][2];
        int sumRow3 = row[2][0] + row[2][1] + row[2][2];
        int sumCol1 = row[0][0] + row[1][0] + row[2][0];
        int sumCol2 = row[0][1] + row[1][1] + row[2][1];
        int sumCol3 = row[0][2] + row[1][2] + row[2][2];

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
            result = 'C';
        }

        return result;
    }
}