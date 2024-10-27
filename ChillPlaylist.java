import java.io.*;
import java.util.*;

public class ChillPlaylist {

    List <Song> Chillplaylist;
    private Random randomsong;
    private Menu printmenu;

public ChillPlaylist() {
    Chillplaylist = new ArrayList<>();
    randomsong = new Random();
    printmenu = new Menu(); 

//chill Playlist creation
    Chillplaylist.add(new Song("Borderline", "Tame Impala", "The Slow Rush", 353));
    Chillplaylist.add(new Song("Like An Animal", "RUFUS DU SOL", "Bloom", 400));
}

public List <Song> getChillPlaylist() {
    return Chillplaylist; // Return the list of Song objects
}

public String shuffleplay() {
    if (Chillplaylist.isEmpty()) {
        return "No songs available to shuffle"; // Return a message if empty
    }
    Song randomSong =  Chillplaylist.get(randomsong.nextInt(Chillplaylist.size()));
    return randomSong.toString(); // Use the toString() method
}

public void menuselection() { //creating a method to select different menu options
       
    Scanner menuchoice = new Scanner(System.in);
    int choice = 0; // Initialize choice

    // Continue until the user chooses to stop listening
    while (choice != 8) {
        printmenu.displayMenu(); // Display the menu
        choice = menuchoice.nextInt(); // Get user choice

        if (choice == 1) {
            System.out.println("Playing a specific song...");
        } else if (choice == 2) {
            System.out.println("Random Song: " + shuffleplay());
        } else if (choice == 3) {
            System.out.println("Adding a song...");
        } else if (choice == 4) {
            System.out.println("Removing a song...");
        } else if (choice == 5) {
            System.out.println("Current Playlist:");
            for (Song song : getChillPlaylist()) {
                System.out.println(song);
            }
        } else if (choice == 6) {
            System.out.println("Skipping to next song...");
        } else if (choice == 7) {
            System.out.println("Going to previous song...");
        } else if (choice != 8) {
            System.out.println("Invalid choice. Please try again.");
        }
    }

    menuchoice.close();
    System.out.println("Ending session...");
}
}


