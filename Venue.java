import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class Venue {

    private Random rnd;
    private ArrayList<Band> bands;
    private ArrayList<Musician> unemployed;

    /**
     * Constructor for the Venue class
     */
    public Venue() {
        rnd = new Random(System.currentTimeMillis());                   // Seed random function
        bands = new ArrayList<Band>();
        unemployed = new ArrayList<Musician>();
    }

    /**
     * The manage loop
     */
    public void manage() {

        // Print greeting
        System.out.println("A new venue has opened up!");
        if (bands.size() > 0) {                                         // Show Band info if there are any
            System.out.println("Please welcome our current bands:\n----------------");
            for (Band b : bands) {
                System.out.println(b);
            }
        }
        System.out.println("----------------");
        printHelp();                                                    // Print initial usage info

        // Read from command line and act
        Scanner clin = new Scanner(System.in);
        String[] currentIn;

        System.out.print("\n> ");                                       // Print prompt
        while (clin.hasNext()) {
            currentIn = clin.nextLine().toLowerCase().split(" ");       // Tokenize
            if (currentIn.length == 0) { continue; }                    // Handles empty input line          
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
                        if (isNumber(currentIn[1])) {                   // Ensures that the number of nights input is valid
                            System.out.println("You have chosen to play " + currentIn[1] + " nights!");
                            playNights(Integer.parseInt(currentIn[1]));
                            break;
                        } else {
                            System.out.println("Invalid number of nights. If you wish to play more than one night, please enter the number in digits.");
                            break;
                        }
                    }
                    playNight();                                        // If number of nights is not specified, play one night
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
            System.out.print("\n> ");                                   // Print prompt
        }
        clin.close();                                                   // Close input Scanner
    }

    /**
     * Adds an external Band to the bands list
     * @param b The Band to be added
     */
    public void addBand(Band b) {
        bands.add(b);
    }

    /**
     * Adds a Musician without Band to the unemployed list
     * @param m The Musician to be added
     */
    public void addFreeMusician(Musician m) {
        unemployed.add(m);
    }

    /**
     * Plays one night and executes the following logic:
     * One member will randomly leave each Band.
     * Each Band will then recruit a new Musician
     */
    private void playNight() {
        if (bands.size() < 1) {                                         // Handle playing a night without Bands
            System.out.println("The night is silent as no Bands play...");
            return;
        }
        
        // Kicking band members
        ArrayList<Musician> kicked = new ArrayList<>(bands.size());
        for (Band b : bands) {                                          // Kick a random member from every (nonempty) band
            if (!b.getMembers().isEmpty()) {
                kicked.add(b.removeMember(rnd.nextInt(b.getMembers().size())));
                System.out.println("Musician " + kicked.get(kicked.size()-1).getName() + " left " + b);
            }
        }

        // Unemployed Musicians attempt to join a random band
        for (int i = 0; i < unemployed.size(); i++) {                   // For-each loop unavailable here as we may remove m
            Band tryingToJoin = bands.get(rnd.nextInt(bands.size()));
            Musician m = unemployed.get(i);

            if (tryingToJoin.addMember(m)) {                            // Will return true if add was successful
                unemployed.remove(m);
                System.out.println("Musician " + m.getName() + " joined " + tryingToJoin);
            }
        }

        // Add those freshly kicked to the unemployed list
        unemployed.addAll(kicked);
    }

    /**
     * Plays several nights in a row
     * @param n The number of nights to be played
     */
    private void playNights(int n) {
        if (bands.size() < 1) {                                         // Handle playing many nights without Bands
            System.out.println("Each night is as silent as the last without Bands...");
            return;
        }
        for (int i = 0; i < n; i++) {                                   // Play several nights
            System.out.println("Night " + (i+1));
            playNight();
            if (i < n-1) { System.out.println(); }                      // Spacing for all but final night
        }
    }

    /**
     * Lists all info about the current configuration of Bands and their Musicians
     */
    private void listInfo() {
        // List Band info
        if (bands.size() > 0) {
            System.out.println("Our bands:");
            System.out.println("----------------");
            for (Band b : bands) {
                System.out.println("- " + b + " -");
                System.out.println("Featuring:");
                // Print musician info
                for (Musician m : b.getMembers()) {
                    System.out.println(m);
                }
                // Newline for all except last
                if (!(b == bands.get(bands.size()-1))) {
                    System.out.println();
                }
            }
        } else {
            System.out.println("There are currently no Bands playing at this Venue!");
        }

        System.out.println("----------------");                         // Spacer

        // List free Musician info
        if (unemployed.size() > 0) {
            System.out.println("Musicians currently looking for bands:");
            System.out.println("----------------");
            for (Musician m : unemployed) {
                System.out.println(m);
            }
            System.out.println("----------------");
        } else {
            System.out.println("There are currently no Musicians looking for Bands!");
        }
    }

    /**
     * Prints help info for the CLI
     */
    private void printHelp() {
        System.out.println("Valid commands:");
        System.out.println("Help, h - Displays this help information");
        System.out.println("List, l - Lists the name of all bands, their members and the properties of their instruments, as well as Musicians currently not in any Band");
        System.out.println("Play one night, Play - Plays one night of Venue logic");
        System.out.println("Play X nights - Plays several nights of Venue logic");
        System.out.println("Exit, Quit, q - Exits the program");
    }

    /**
     * Check if String is parsable int
     * @param input String to be checked
     * @return Boolean for is the input parsable
     */
    private boolean isNumber(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}