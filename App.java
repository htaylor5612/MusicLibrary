import java.util.List;
import java.util.Scanner;
import java.util.Collections;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class App { // Main class for the music player application
    private static int currentSongIndex = 0; // Keep track of the current song's index in the playlist
    private static int currentDuration = 0; // Keep track of the current song's playing duration
    private static final int MAX_DURATION = 15; // Maximum duration for each song (15 seconds for proof of concept)
    private static ScheduledExecutorService scheduler; // Scheduler for managing song playback

    public static void main(String[] args) { // Main method, entry point of the application
        Scanner scanner = new Scanner(System.in); // Create a Scanner object for user input
        
        RapPlaylist rapPlaylist = new RapPlaylist(); // Create a RapPlaylist object
        RockPlaylist rockPlaylist = new RockPlaylist(); // Create a RockPlaylist object
        PopPlaylist popPlaylist = new PopPlaylist(); // Create a PopPlaylist object
        
        System.out.println("Select a playlist:"); // Prompt user to select a playlist
        System.out.println("1. Rap"); // Option 1: Rap playlist
        System.out.println("2. Rock"); // Option 2: Rock playlist
        System.out.println("3. Pop"); // Option 3: Pop playlist
        
        int playlistChoice = scanner.nextInt(); // Read user's playlist choice
        List<String> selectedPlaylist = null; // Initialize selectedPlaylist variable
        
        switch (playlistChoice) { // Switch statement to handle playlist selection
            case 1:
                selectedPlaylist = rapPlaylist.getRapPlaylist(); // Set selectedPlaylist to Rap playlist
                break;
            case 2:
                selectedPlaylist = rockPlaylist.getRockPlaylist(); // Set selectedPlaylist to Rock playlist
                break;
            case 3:
                selectedPlaylist = popPlaylist.getPopPlaylist(); // Set selectedPlaylist to Pop playlist
                break;
            default:
                System.out.println("Invalid choice. Exiting."); // Handle invalid input
                System.exit(1); // Exit the program
        }
        
        scheduler = Executors.newScheduledThreadPool(1); // Initialize scheduler with a single thread
        
        boolean running = true; // Control variable for the main loop
        while (running) { // Main program loop
            System.out.println("\nChoose an option:"); // Display menu options
            System.out.println("1. Play a specific song");
            System.out.println("2. Shuffle play");
            System.out.println("3. Add a song");
            System.out.println("4. Remove a song");
            System.out.println("5. Display playlist");
            System.out.println("6. Skip to next song");
            System.out.println("7. Go to previous song");
            System.out.println("8. Stop Listening");
            
            int option = scanner.nextInt(); // Read user's menu choice
            scanner.nextLine(); // Consume newline left by nextInt()
            
            switch (option) { // Switch statement to handle menu options
                case 1: // Play a specific song
                    System.out.println("\nEnter the number of the song you want to play:");
                    int songChoice = scanner.nextInt(); // Read user's song choice
                    
                    if (songChoice > 0 && songChoice <= selectedPlaylist.size()) { // Check if song choice is valid
                        String selectedSong = selectedPlaylist.get(songChoice - 1); // Get the selected song
                        playSong(selectedSong); // Play the selected song
                    } else {
                        System.out.println("Invalid song choice."); // Handle invalid song choice
                    }
                    break;
                case 2: // Shuffle play
                    Collections.shuffle(selectedPlaylist); // Shuffle the playlist
                    System.out.println("Shuffled playlist:");
                    playSong(selectedPlaylist.get(0)); // Play the first song in the shuffled playlist
                    break;
                case 3: // Add a song
                    System.out.println("Enter the name of the song to add:");
                    String newSong = scanner.nextLine(); // Read the name of the new song
                    selectedPlaylist.add(newSong); // Add the new song to the playlist
                    System.out.println("Song added: " + newSong);
                    break;
                case 4: // Remove a song
                    System.out.println("Enter the number of the song to remove:");
                    displayPlaylist(selectedPlaylist); // Display the current playlist
                    int removeIndex = scanner.nextInt() - 1; // Read the index of the song to remove
                    if (removeIndex >= 0 && removeIndex < selectedPlaylist.size()) { // Check if the index is valid
                        String removedSong = selectedPlaylist.remove(removeIndex); // Remove the song
                        System.out.println("Song removed: " + removedSong);
                    } else {
                        System.out.println("Invalid song number."); // Handle invalid song number
                    }
                    break;
                case 5: // Display playlist
                    displayPlaylist(selectedPlaylist); // Call method to display the playlist
                    break;
                case 6: // Skip to next song
                    skipToNextSong(selectedPlaylist); // Call method to skip to the next song
                    break;
                case 7: // Go to previous song
                    goToPreviousSong(selectedPlaylist); // Call method to go to the previous song
                    break;
                case 8: // Stop listening
                    running = false; // Set running to false to exit the main loop
                    System.out.println("Exiting. Goodbye!");
                    scheduler.shutdown(); // Shutdown the scheduler
                    break;
                default:
                    System.out.println("Invalid option. Please try again."); // Handle invalid menu option
                    break;
            }
        }
        
        scanner.close(); // Close the scanner
    }
    
    private static void displayPlaylist(List<String> playlist) { // Method to display the playlist
        System.out.println("\nCurrent Playlist:");
        for (int i = 0; i < playlist.size(); i++) { // Iterate through the playlist
            System.out.println((i + 1) + ". " + playlist.get(i)); // Print each song with its number
        }
    }

    private static void playSong(String song) { // Method to play a song
        currentDuration = 0; // Reset the current duration
        System.out.println("Now playing: " + song); // Display the currently playing song
        scheduler.scheduleAtFixedRate(() -> { // Schedule a task to run every second
            System.out.print("\rDuration: " + currentDuration + " seconds"); // Print the current duration
            currentDuration++; // Increment the duration
            if (currentDuration > MAX_DURATION) { // Check if the song has finished
                scheduler.shutdown(); // Shutdown the scheduler
                System.out.println("\nSong finished.");
            }
        }, 0, 1, TimeUnit.SECONDS); // Run the task every second
    }

    private static void skipToNextSong(List<String> playlist) { // Method to skip to the next song
        if (playlist.isEmpty()) { // Check if the playlist is empty
            System.out.println("The playlist is empty.");
            return;
        }
        currentSongIndex = (currentSongIndex + 1) % playlist.size(); // Update the current song index
        playSong(playlist.get(currentSongIndex)); // Play the next song
    }

    private static void goToPreviousSong(List<String> playlist) { // Method to go to the previous song
        if (playlist.isEmpty()) { // Check if the playlist is empty
            System.out.println("The playlist is empty.");
            return;
        }
        currentSongIndex = (currentSongIndex - 1 + playlist.size()) % playlist.size(); // Update the current song index
        playSong(playlist.get(currentSongIndex)); // Play the previous song
    }
}
