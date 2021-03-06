package Console;
import Model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// This allows users to play a text based version of the game that has the positions on the board as numbers
public class ConsoleShip {
    private Scanner scanner;
    private Boat b;
    private Board board1, board2;

    public ConsoleShip() {
        scanner = new Scanner(System.in);
        String input = null;
        board1 = new Board();
        board2 = new Board();

        while (true) {
            displayMenu();
            input = scanner.next();
            input = input.toLowerCase();

            if (input.equals("q")) {
                break;
            } else if (input.equals("start")) {
                setupGame(board1);
                setupGame(board2);
                playGame();
            } else {
                System.out.println("Selection not valid...");
            }
        }

    }

    private void playGame() {
        boolean game = true;
        while (game) {
            System.out.println("player one goes");
            System.out.println("guess:");
            scanner.nextLine();
            int pos1 = (int) scanner.nextLong();
            if (board2.hit(pos1)) {
                System.out.println("player two got hit at " + pos1);
                if (board2.done()) {
                    System.out.println("player one wins!");
                    break;
                }
            } else {
                System.out.println("nothing but water here!");
            }

            System.out.println("player two goes");
            System.out.println("guess:");
            scanner.nextLine();
            int pos2 = (int) scanner.nextLong();
            if (board1.hit(pos2)) {
                System.out.println("player one got hit at " + pos2);
                if (board1.done()) {
                    System.out.println("player two wins!");
                    break;
                }
            } else {
                System.out.println("nothing but water here!");
            }
        }

    }

    public void setupGame(Board board) {
        List<String> allboats = new ArrayList<>();
        while (allboats.size() != 5) {
            System.out.println("Which boat do your want to add?");
            System.out.println("car -> carrier(5)");
            System.out.println("b -> battleship(4)");
            System.out.println("cru -> cruiser(3)");
            System.out.println("s -> submarine(3)");
            System.out.println("d -> destroyer(2)");
            scanner.nextLine();
            String boattype = scanner.nextLine();

            switch (boattype) {
                case "car":
                    b = new Boat(Boattype.CARRIER);
                    allboats.add("Carreier"); break;
                case "b":
                    b = new Boat(Boattype.BATTLESHIP);
                    allboats.add("Battleship"); break;
                case "cru":
                    b = new Boat(Boattype.CRUISER);
                    allboats.add("Cruiser"); break;
                case "s":
                    b = new Boat(Boattype.SUBMARINE);
                    allboats.add("Submarine"); break;
                case "d":
                    b = new Boat(Boattype.DESTROYER);
                    allboats.add("Desstroyer"); break;
            }

            for (int i = 0; i < b.size; i++) {
                System.out.println("what position will ur ship be in?");
                scanner.nextLine();
                long position = scanner.nextLong();
                Square s = new Square((int) position);
                s.changeState(State.OCCUPIED);
                b.addSquare(s);
                System.out.println(position);
            }
            board.addBoat(b);
            System.out.println(allboats);
        }
    }

    private void displayMenu() {
        System.out.println("\nWELCOME TO CONSOLESHIP");
        System.out.println("\ttype 'start' to begin!");
        System.out.println("\tq -> quit");
    }

}
