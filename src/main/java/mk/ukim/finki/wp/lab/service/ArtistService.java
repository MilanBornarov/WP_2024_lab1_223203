package mk.ukim.finki.wp.lab.service;

import mk.ukim.finki.wp.lab.model.Artist;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ArtistService{
    List<Artist> listArtists();
    void ArtistfindById(Long id);
}