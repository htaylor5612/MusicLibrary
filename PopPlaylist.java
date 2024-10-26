import java.util.ArrayList;
import java.util.List;

public class PopPlaylist {
    private List<String> popPlaylist;
//Names of all the songs in the playlist. 
    public PopPlaylist() {
        popPlaylist = new ArrayList<>();
        popPlaylist.add("Shape of You");
        popPlaylist.add("Blinding Lights");
        popPlaylist.add("Dance Monkey");
    }

    public List<String> getPopPlaylist() {
        return popPlaylist;
    }

//Shuffle Play??? 
    public String getRandomSong() {
        if (popPlaylist.isEmpty()) {
            return null;
        }
        int randomIndex = (int) (Math.random() * popPlaylist.size());
        return popPlaylist.get(randomIndex);
    }

public static void main(String[] args) {
    PopPlaylist library = new PopPlaylist();
    System.out.println("Pop Playlist: " + library.getPopPlaylist());
    System.out.println("Random Song: " + library.getRandomSong());
    
}




}