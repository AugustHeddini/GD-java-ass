import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.text.html.StyleSheet.ListPainter;

public class Venue {

    private ArrayList<Band> bands;

    /**
     * Constructor for the Venue class
     */
    public Venue() {
        bands = new ArrayList<Band>();
    }

    /**
     * Initialize the described scenario
     */
    public void init() {
        bands.add(new Band("Spoke 'n hub"));
        bands.get(0).addMember(new Musician("Liza Baar", new Instrument("Bender")));
        bands.get(0).addMember(new Musician("Null Beat", new Instrument("McFaren")));
        bands.get(0).addMember(new Musician("Void", new Instrument("Lorg")));

        bands.add(new Band("Berats"));
        bands.get(1).addMember(new Musician("Stringsteen", new Instrument("Gibson")));
        bands.get(1).addMember(new Musician("Xindea", new Instrument("Toyota")));
        bands.get(1).addMember(new Musician("Captor", new Instrument("Suzuki")));
    }

    /**
     * The manage loop
     */
    public void manage() {

        System.out.println("A new venue has opened up!");
        System.out.println("Please welcome our current bands:\n----------------");
        for (Band b : bands) {
            System.out.println(b);
        }
        System.out.println("----------------");
        printHelp();

        // Read from command line and act
        Scanner clin = new Scanner(System.in);
        String[] currentIn;

        System.out.print("\n> ");                                     // Print prompt
        while (clin.hasNext()) {
            currentIn = clin.nextLine().toLowerCase().split(" ");
            switch (currentIn[0]) {
                case "h":
                case "help":
                    printHelp();
                    break;
                case "l":
                case "list":
                    listInfo();
                    break;
                case "play":
                    // If the number of nights to play is specified, parse it
                    // else default one
                    if (currentIn.length > 1) {
                        if (currentIn[1].equals("one")) {
                            playNight();
                            break;
                        }
                        System.out.println("You have chosen to play " + currentIn[1] + " nights!");
                        // TODO play nights
                    }
                    playNight();
                    break;
                case "q":
                case "quit":
                case "exit":
                    System.out.println("Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid command! For more info use \"help\".");
                    break;
            }
            System.out.print("\n> ");                                 // Print prompt
        }

    }

    /**
     * Plays one night and executes the following logic:
     * One member will randomly leave each Band.
     * Each Band will then recruit a new Musician
     */
    private void playNight() {
        //TODO
    }

    /**
     * Lists all info about the current configuration of Bands and their Musicians
     */
    private void listInfo() {
        System.out.println("Our bands:");
        System.out.println("----------------");
        for (Band b : bands) {
            System.out.println(b);
            System.out.println("Featuring:");
            // Print musician info
            for (Musician m : b.getMembers()) {
                System.out.println("    " + m);
            }
            // Newline for all except last
            if (!(b == bands.get(bands.size()-1))) {
                System.out.println();
            }
        }
        System.out.println("----------------");
    }

    /**
     * Prints help info for the CLI
     */
    private void printHelp() {
        System.out.println("Valid commands:");
        System.out.println("List - Lists the name of all bands, their members and the properties of their instruments");
        System.out.println("Play one night - Plays one night of Venue logic");
        System.out.println("Exit or Quit - Exits the program");
    }

}