import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;
import instruments.*;

public class Venue {

    private Random rnd;
    private ArrayList<Band> bands;
    private ArrayList<Musician> unemployed;

    /**
     * Constructor for the Venue class
     */
    public Venue() {
        rnd = new Random(System.currentTimeMillis());   // Seed random function
        bands = new ArrayList<Band>();
        unemployed = new ArrayList<Musician>();
    }

    /**
     * Initialize the described scenario
     */
    public void init() {
        // Add first band and musicians
        bands.add(new Band("Spoke 'n hub"));
        bands.get(0).addMember(new Musician("Liza Baar", new Guitar("Bender", 5, 0.4)));
        bands.get(0).addMember(new Musician("Null Beat", new Piano("McFaren", 51, true)));
        bands.get(0).addMember(new Musician("Void", new Synthesizer("Lorg", 47, true)));

        // Add second band and musicians
        bands.add(new Band("Berats"));
        bands.get(1).addMember(new Musician("Stringsteen", new Banjo("Gibson", 4, 8)));
        bands.get(1).addMember(new Musician("Xindea", new Drums("Toyota", true)));
        bands.get(1).addMember(new Musician("Captor", new Synthesizer("Suzuki", 72, false)));

        // Add musicians without bands
        unemployed.add(new Musician("Slam Itur", new Guitar("TweEntiOan", 5, 0.2)));
    }

    /**
     * The manage loop
     */
    public void manage() {

        // Print greeting
        System.out.println("A new venue has opened up!");
        System.out.println("Please welcome our current bands:\n----------------");
        for (Band b : bands) {
            System.out.println(b);
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

    }

    /**
     * Plays one night and executes the following logic:
     * One member will randomly leave each Band.
     * Each Band will then recruit a new Musician
     */
    private void playNight() {
        
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
        for (int i = 0; i < n; i++) {
            System.out.println("Night " + (i+1));
            playNight();
            System.out.println();
        }
    }

    /**
     * Lists all info about the current configuration of Bands and their Musicians
     */
    private void listInfo() {
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
        System.out.println("----------------");
        System.out.println("Musicians currently looking for bands:");
        System.out.println("----------------");
        for (Musician m : unemployed) {
            System.out.println(m);
        }
        System.out.println("----------------");
    }

    /**
     * Prints help info for the CLI
     */
    private void printHelp() {
        System.out.println("Valid commands:");
        System.out.println("List - Lists the name of all bands, their members and the properties of their instruments, as well as Musicians currently not in any Band");
        System.out.println("Play one night - Plays one night of Venue logic");
        System.out.println("Play X nights - Plays several nights of Venue logic");
        System.out.println("Exit or Quit - Exits the program");
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