package online.spraydxd.movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/reviews")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;

    @PostMapping
    @CrossOrigin(origins = "https://movie-ui-eight.vercel.app/")
    public ResponseEntity<Reviews> createReview(@RequestBody Map<String, String> payload){
      return new ResponseEntity<Reviews>(reviewService.createReview(payload.get("reviewBody"), payload.get("imdbId")), HttpStatusCode.valueOf(200));
    }
}
