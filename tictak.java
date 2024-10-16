import java.util.*;

public class tictak {

    // Player symbols
    public static char player1 = 'X';
    public static char player2 = 'O';

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[][] arr = {
            {' ', ' ', ' '},
            {' ', ' ', ' '},
            {' ', ' ', ' '}
        };

        System.out.println("Let's start the toss...");
        System.out.print("Player1, choose Head or Tails: ");
        String player1Choice = sc.next();
        
        while (!player1Choice.equalsIgnoreCase("Head") && !player1Choice.equalsIgnoreCase("Tails")) {
            System.out.print("Invalid choice. Please choose Head or Tails: ");
            player1Choice = sc.next();
        }

        String player2Choice = player1Choice.equalsIgnoreCase("Head") ? "Tails" : "Head";
        
        System.out.println("Player2 gets: " + player2Choice);
        
        String result = toss();
        
        char currentPlayer;  // To track whose turn it is
        if (result.equalsIgnoreCase(player1Choice)) {
            System.out.println("Player1 won the toss! Choose X or O:");
            player1 = sc.next().toUpperCase().charAt(0);
            player2 = (player1 == 'X') ? 'O' : 'X';
            currentPlayer = player1;  // Player1 starts
        } else {
            System.out.println("Player2 won the toss! Choose X or O:");
            player2 = sc.next().toUpperCase().charAt(0);
            player1 = (player2 == 'X') ? 'O' : 'X';
            currentPlayer = player2;  // Player2 starts
        }
        
        System.out.println("Player1 is: " + player1 + ", Player2 is: " + player2);

        boolean gameOn = true;
        while (gameOn) {
            drawGrid(arr);
            System.out.println("Current player: " + currentPlayer);
            System.out.print("Enter row (0-2): ");
            int row = sc.nextInt();
            System.out.print("Enter column (0-2): ");
            int col = sc.nextInt();

           
            if (isValidMove(arr, row, col)) {
                arr[row][col] = currentPlayer;
                
                if (checkWinner(arr, currentPlayer)) {
                    drawGrid(arr);
                    System.out.println("Player " + currentPlayer + " wins!");
                    gameOn = false;
                } else if (isDraw(arr)) {
                    drawGrid(arr);
                    System.out.println("It's a draw!");
                    gameOn = false;
                } else {
                    currentPlayer = (currentPlayer == player1) ? player2 : player1;  // Switch turn
                }
            } else {
                System.out.println("Invalid move. Try again.");
            }
        }
    }

    // Toss function to return Head or Tails
    public static String toss() {
        Random x = new Random();
        return x.nextBoolean() ? "Head" : "Tails";
    }

    // Draw the current state of the grid
    public static void drawGrid(char[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(" " + arr[i][j] + " ");
                if (j + 1 < arr.length) {
                    System.out.print("|");
                }
            }
            System.out.println();
            if (i + 1 < arr.length) {
                System.out.println("-----------");
            }
        }
    }

    // Check if a move is valid (i.e., if the spot is empty)
    public static boolean isValidMove(char[][] arr, int row, int col) {
        return arr[row][col] == ' ';
    }

    // Check if the current player has won
    public static boolean checkWinner(char[][] arr, char currentPlayer) {
        // Check rows and columns
        for (int i = 0; i < 3; i++) {
            if (arr[i][0] == currentPlayer && arr[i][1] == currentPlayer && arr[i][2] == currentPlayer) {
                return true;
            }
            if (arr[0][i] == currentPlayer && arr[1][i] == currentPlayer && arr[2][i] == currentPlayer) {
                return true;
            }
        }
        // Check diagonals
        if (arr[0][0] == currentPlayer && arr[1][1] == currentPlayer && arr[2][2] == currentPlayer) {
            return true;
        }
        if (arr[0][2] == currentPlayer && arr[1][1] == currentPlayer && arr[2][0] == currentPlayer) {
            return true;
        }
        return false;
    }

    // Check if the game is a draw (i.e., if all spots are filled)
    public static boolean isDraw(char[][] arr) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (arr[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
}
