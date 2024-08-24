package online.spraydxd.movies;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/movies")
public class MovieController {
    @Autowired
    private MovieService movieService;

    @GetMapping
    @CrossOrigin(origins = "https://movie-ui-eight.vercel.app")
    public ResponseEntity<List> getAllMovies() {
        return new ResponseEntity<List>(movieService.allMovies(), HttpStatusCode.valueOf(200));
    }

    @GetMapping("/{imdbId}")
    public ResponseEntity<Optional<Movie>> getSingleMovie(@PathVariable String imdbId) {
           return new ResponseEntity<Optional<Movie>>(movieService.singleMovie(imdbId),HttpStatusCode.valueOf(200));

    }
}
