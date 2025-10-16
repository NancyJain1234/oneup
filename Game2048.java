/**
* @Filename - Main.java
* @Description - this will contain list of operations of 2048 Game
* @Author - Nancy Jain
*/


import java.util.Scanner;

public class Game2048 {
    public static final int WINNING_TILE = 2048;

    public static void main(String[] args) {
        Operations operation = new Operations(WINNING_TILE);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the 2048 Game!");
        System.out.println("Use 'w' (up), 'a' (left), 's' (down), 'd' (right) to move.");
        System.out.println("Try to reach " + WINNING_TILE + " to win!\n");

        operation.initializeBoard();
        operation.printBoard();

        while (!operation.isGameOver()) {
            System.out.print("Your Move (w/a/s/d): ");
            char move = scanner.nextLine().toLowerCase().charAt(0);
            boolean moved = false;

            switch (move) {
                case 'w': moved = operation.moveUp(); break;
                case 's': moved = operation.moveDown(); break;
                case 'a': moved = operation.moveLeft(); break;
                case 'd': moved = operation.moveRight(); break;
                default:
                    System.out.println("Invalid input! Use w/a/s/d.");
                    continue;
            }

            if (moved) {
                operation.generateNewTile();
                operation.printBoard();
                if (operation.checkForWin()) {
                    System.out.println("Congratulations! You reached 2048!");
                    break;
                }
                if (operation.isGameOver()) {
                    System.out.println("Game Over! No valid moves left.");
                    break;
                }
            } else {
                System.out.println("Move not possible. Try another direction.");
            }
        }
        System.out.println("Final Score: " + operation.getScore());
        scanner.close();
    }
}
