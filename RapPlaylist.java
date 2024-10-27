
import java.io.*;
import java.util.*;


public class RapPlaylist {
    List<Song> Rapplaylist;
    private Random randomsong;
    private Menu printmenu;


public RapPlaylist() {
    Rapplaylist = new ArrayList<>();
    randomsong = new Random();
    printmenu = new Menu();

    Rapplaylist.add(new Song("I Got 5 On It", "Luniz, Michael Marshall", "Operation Stackola", 352));
    Rapplaylist.add(new Song("Respectfully", "JAY1", "LocalMvp", 156));
}
public List <Song> getRapPlaylist() {
    return Rapplaylist; // Return the list of Song objects
}

public String shuffleplay() {
    if (Rapplaylist.isEmpty()) {
        return "No songs available to shuffle"; // Return a message if empty
    }
    Song randomSong =  Rapplaylist.get(randomsong.nextInt(Rapplaylist.size()));
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
            for (Song song : getRapPlaylist()) {
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


public static void main(String[] args) {
    RapPlaylist library = new RapPlaylist();
    System.out.println("Rap Playlist: ");
    for (Song song : library.getRapPlaylist()) {
        System.out.println(song); // Print each song's details
    }
    System.out.println("Random Song: " + library.shuffleplay());
}
}
