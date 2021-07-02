package Console;
import model.Boat;
import model.Board;
import model.Boattype;
import model.Square;

import java.util.Scanner;

public class ConsoleShip {
    private Scanner scanner;
    private Boat b;
    //private boolean stop = false;

    public ConsoleShip() {
        scanner = new Scanner(System.in);
        String input = null;

        while (true) {
            displayMenu();
            input = scanner.next();
            input = input.toLowerCase();

            if (input.equals("q")) {
                break;
            } else if (input.equals("start")) {
                setupGame();
            } else {
                System.out.println("Selection not valid...");
            }
        }

    }

    public void setupGame() {
        System.out.println("Which boat do your want to add first?");
        System.out.println("car -> carrier(5)");
        System.out.println("b -> battleship(4)");
        System.out.println("cru -> cruiser(3)");
        System.out.println("s -> submarine(3)");
        System.out.println("d -> destroyer(2)");
        scanner.nextLine();
        String boattype = scanner.nextLine();
        switch (boattype) {
            case "car": b = new Boat(Boattype.CARRIER);
            case "b": b = new Boat(Boattype.BATTLESHIP);
            case "cru": b = new Boat(Boattype.CRUISER);
            case "s": b = new Boat(Boattype.SUBMARINE);
            case "d": b = new Boat(Boattype.DESTROYER);
        }
        



    }

    private void displayMenu() {
        System.out.println("\nWELCOME TO CONSOLESHIP");
        System.out.println("\ttype 'start' to begin!");
        System.out.println("\tq -> quit");
    }

}
