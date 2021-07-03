package Console;
import model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleShip {
    private Scanner scanner;
    private Boat b;
    private Board board1, board2;
    //private boolean stop = false;

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
            //System.out.println(scanner.nextLine());
            switch (boattype) {
                case "car":
                    b = new Boat(Boattype.CARRIER);
                    allboats.add("Carreier");
                    break;
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
