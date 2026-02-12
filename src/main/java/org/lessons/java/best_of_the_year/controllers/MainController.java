package org.lessons.java.best_of_the_year.controllers;

import java.util.ArrayList;
import java.util.List;

import org.lessons.java.best_of_the_year.classes.Movie;
import org.lessons.java.best_of_the_year.classes.Song;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequestMapping("/")
public class MainController {

    @GetMapping("/")
    public String getHome(Model model) {
        model.addAttribute("name", "Andrea");
        return "index";
    }

    @GetMapping("/movies")
    public String getMovies(Model model) {
        model.addAttribute("movies", getBestMovies());
        return "movies";
    }

    @GetMapping("/movies/{id}")
    public String getMovieById(@PathVariable("id") String movieId, Model model) {
        Movie movie = null;

        for (Movie m : getBestMovies()) {
            if (m.getId() == Integer.parseInt(movieId)) {
                movie = m;
            }
        }

        model.addAttribute("movie", movie);
        return "movie_detail";
    }

    @GetMapping("/songs")
    public String getSongs(Model model) {
        model.addAttribute("songs", getBestSongs());
        return "songs";
    }

    @GetMapping("/songs/{id}")
    public String getSongById(@PathVariable("id") String songId, Model model) {
        Song song = null;

        for (Song s : getBestSongs()) {
            if (s.getId() == Integer.parseInt(songId)) {
                song = s;
            }
        }

        model.addAttribute("song", song);
        return "song_detail";
    }

    private ArrayList<Movie> getBestMovies() {
        return new ArrayList<>(
                List.of(new Movie(123, "La Vita è bella"), new Movie(1233, "Il Gigante di Ferro"),
                        new Movie(1234, "Pirati dei Caraibi")));
    }

    private ArrayList<Song> getBestSongs() {
        return new ArrayList<>(List.of(new Song(15353, "Song 1"), new Song(12, "Song 2"), new Song(3414, "Song 3")));
    }

}
