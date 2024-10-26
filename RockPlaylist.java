
import java.util.ArrayList;
import java.util.List;
public class RockPlaylist {

    private List<String> rockPlaylist;
    
    public RockPlaylist() {
        rockPlaylist = new ArrayList<>();
        rockPlaylist.add("Enter Sandman");
        rockPlaylist.add("My Own Summer (Shove It)");
        rockPlaylist.add("Coming Undone");
    }

    public List<String> getRockPlaylist() {
        return rockPlaylist;
    }

    public String getRandomSong() {
        if (rockPlaylist.isEmpty()) {
            return null;
        }
        int randomIndex = (int) (Math.random() * rockPlaylist.size());
        return rockPlaylist.get(randomIndex);
    }
//Return Random Song. 
    public static void main(String[] args) {
        RockPlaylist library = new RockPlaylist();
        System.out.println("Rock Playlist: " + library.getRockPlaylist());
        System.out.println("Now Playing " + library.getRandomSong());
    }

}