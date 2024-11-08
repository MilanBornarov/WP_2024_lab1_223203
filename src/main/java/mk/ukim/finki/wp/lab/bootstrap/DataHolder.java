package mk.ukim.finki.wp.lab.bootstrap;

import jakarta.annotation.PostConstruct;
import mk.ukim.finki.wp.lab.model.Artist;
import mk.ukim.finki.wp.lab.model.Song;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {

    public static List<Artist> artistList = new ArrayList<>();
    public static List<Song> songList = new ArrayList<>();


    @PostConstruct
    public void init(){
        artistList.add(new Artist(1, "Adele", "Adkins", "A British singer-songwriter known for her soulful voice and emotional ballads, with hits like 'Someone Like You' and 'Rolling in the Deep'."));
        artistList.add(new Artist(2, "Bob", "Dylan", "An American singer-songwriter and Nobel laureate known for his influential lyrics and songs like 'Like a Rolling Stone' and 'Blowin' in the Wind'."));
        artistList.add(new Artist(3, "Madonna", "Ciccone", "An American pop icon known as the 'Queen of Pop,' famous for her versatility and hits like 'Like a Virgin' and 'Vogue'."));
        artistList.add(new Artist(4, "Stevie", "Wonder", "An American musician and singer known for his contributions to Motown and hits like 'Superstition' and 'Isn't She Lovely'."));
        artistList.add(new Artist(5, "Prince", "Nelson", "An American singer, songwriter, and multi-instrumentalist known for his flamboyant stage presence and hits like 'Purple Rain' and 'When Doves Cry'."));

        songList.add(new Song("S006", "Rolling in the Deep", "Pop/Soul", 2010));
        songList.add(new Song("S007", "Like a Rolling Stone", "Folk Rock", 1965));
        songList.add(new Song("S008", "Like a Virgin", "Pop", 1984));
        songList.add(new Song("S009", "Superstition", "Funk/Soul", 1972));
        songList.add(new Song("S010", "Purple Rain", "Rock", 1984));
    }
}
