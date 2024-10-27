
import java.util.*;

public class PopPlaylist {
    private List<Song> popPlaylist; // Correct variable name
    private Random randomsong; // Random object
    private Menu printmenu;

    public PopPlaylist() {
        popPlaylist = new ArrayList<>(); // Initialize the list
        randomsong = new Random(); // Initialize the Random object
        printmenu = new Menu(); 

        // Add songs to the playlist
        popPlaylist.add(new Song("Say It Right", "Nelly Furtado", "Loose", 342));
        popPlaylist.add(new Song("Own It", "Stormzy, Burna Boy, Ed Sheeran", "Heavy Is The Head", 336));
    }

    public List<Song> getPopPlaylist() {
        return popPlaylist; // Return the list of Song objects
    }

    public String shuffleplay() { // I've only created a shuffle play method, you need to create all the other ones like add song remove song.., just 
        //look at the options menu on what else u need to do, u need to change each playlist so that they alll have the methods in them.
        
        if (popPlaylist.isEmpty()) {
            return "No songs available to shuffle"; // Return a message if empty
        }
        Song randomSong = popPlaylist.get(randomsong.nextInt(popPlaylist.size()));
        return randomSong.toString(); // Use the toString() method
    }
     public void menuselection() {
       
        Scanner menuchoice = new Scanner(System.in);
        int choice = 0; // Initialize choice

        // Continue until the user chooses to stop listening
        while (choice != 8) {
            printmenu.displayMenu(); // Display the menu
            choice = menuchoice.nextInt(); // Get user choice

            if (choice == 1) {
                System.out.println("Playing a specific song..."); //once youve created a choose a song method u can add it in the output e.g. specificsong() 
                //if thats what you've called the method 
            } else if (choice == 2) {
                System.out.println("Random Song: " + shuffleplay());
            } else if (choice == 3) {
                System.out.println("Adding a song...");
            } else if (choice == 4) {
                System.out.println("Removing a song...");
            } else if (choice == 5) {
                System.out.println("Current Playlist:");
                for (Song song : getPopPlaylist()) {
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
        PopPlaylist library = new PopPlaylist();
        System.out.println("Pop Playlist: ");
        for (Song song : library.getPopPlaylist()) {
            System.out.println(song); // Print each song's details
        }
        System.out.println("Random Song: " + library.shuffleplay());
        library.menuselection(); 
    }



}


    
