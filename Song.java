import java.io.*;
import java.util.*;

public class Song {
    String name;
    String artist;
    String album;
    int duration;


public Song (String name, String artist, String album, int duration){
this.name = name;
this.artist = artist;
this.album = album;
this.duration = duration;
}

public String toString() {
    return "Title: " + name + "\n" +
           "Artist: " + artist + "\n" +
           "Album: " + album + "\n" +
           "Duration: " + duration + " seconds\n";
}
}
