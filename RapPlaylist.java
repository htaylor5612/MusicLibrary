import java.util.ArrayList;
import java.util.List;

    
public class RapPlaylist {
List<String> rapPlaylist;
    
    public RapPlaylist() {
        rapPlaylist = new ArrayList<>();
        rapPlaylist.add("Still D.R.E.");
        rapPlaylist.add("It Was a Good Day");
        rapPlaylist.add("Shook Ones Part II");
    }

    public List<String> getRapPlaylist() {
        return rapPlaylist;
    }

    public String getRandomSong() {
        if (rapPlaylist.isEmpty()) {
            return null;
        }
        int randomIndex = (int) (Math.random() * rapPlaylist.size());
        return rapPlaylist.get(randomIndex);
    }

    public static void main(String[] args) {
        RapPlaylist library = new RapPlaylist();
        System.out.println("Rap Playlist: " + library.getRapPlaylist());
        System.out.println("Random Song: " + library.getRandomSong());
    }
}