import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.text.html.StyleSheet.ListPainter;

public class Venue {

    private ArrayList<Band> bands;

    /**
     * Constructor
     */
    public Venue() {
        bands = new ArrayList<Band>();
    }

    /**
     * Initialize class fields
     */
    public void init() {
        bands.add(new Band("Spoke 'n hub"));
        bands.add(new Band("Berats"));
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
        System.out.print("> ");
        while (clin.hasNext()) {

            switch (clin.nextLine().toLowerCase()) {
                case "help":
                    printHelp();
                    break;
                case "h":
                    printHelp();
                    break;
                case "list":
                    listInfo();
                    break;
                case "exit":
                    System.out.println("Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid command! For more info use \"help\".");
                    break;
            }
            System.out.print("> ");
        }

    }

    private void listInfo() {
        System.out.println("----------------");
        for (Band b : bands) {
            System.out.print("BAND - ");
            System.out.println(b);
            // TODO print musician info
        }
        System.out.println("----------------");
    }

    /**
     * Prints help info for the CLI
     */
    private void printHelp() {
        System.out.println("Valid commands:");
        System.out.println("List - Lists the name of all bands, their members and the properties of their instruments");
        System.out.println("Play one night - Plays one night of Venus logic");
        System.out.println("Exit - Exits the program");
        System.out.println();
    }

}