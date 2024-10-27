
import java.io.*;
import java.util.*;

public class App {
    
    public static void main(String[] args) throws Exception {
    
        //Creating instances of playlist classes
        RapPlaylist Rapplaylist = new RapPlaylist();
        PopPlaylist popPlaylist = new PopPlaylist();
        ChillPlaylist Chillplaylist = new ChillPlaylist();
       
//creating a userinput scanner to allow user to choose what playlist they want to listen to
        Scanner userinput = new Scanner(System.in);
        
  System.out.println("Select a playlist: ");
  System.out.println("1. Rap");
  System.out.println("2. Chill");
  System.out.println("3. Pop");
  String playlist = userinput.nextLine();
  System.out.println("You chose: " + playlist);


  List<Song> selectedPlaylist = null;

  if (playlist.equalsIgnoreCase("Rap")) {
    System.out.println("Rap Playlist  -------");
    selectedPlaylist = Rapplaylist.getRapPlaylist();
    Rapplaylist.menuselection();
} else if (playlist.equalsIgnoreCase("Pop")) {
    System.out.println("Pop Playlist  -------");
    selectedPlaylist = popPlaylist.getPopPlaylist();
    popPlaylist.menuselection(); 
} else if (playlist.equalsIgnoreCase("Chill")) {
    System.out.println("Chill Playlist  -------");
    selectedPlaylist = Chillplaylist.getChillPlaylist();
    Chillplaylist.menuselection();
} else {
    System.out.println("Invalid choice.");
}

if (selectedPlaylist != null) {
    for (Song song : selectedPlaylist) {
        System.out.println(song); // This will call the toString() method
        
    }
} 


userinput.close();

    }
    }
