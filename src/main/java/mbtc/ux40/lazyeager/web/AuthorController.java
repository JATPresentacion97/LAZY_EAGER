package mbtc.ux40.lazyeager.web;

import mbtc.ux40.lazyeager.repo.AuthorRepository;
import mbtc.ux40.lazyeager.util.Mapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/authors")
public class AuthorController {
    private final AuthorRepository authors;

    public AuthorController(AuthorRepository authors) {
        this.authors = authors;
    }

    @GetMapping("/lazy")
    public Object lazy() {
        long start = System.currentTimeMillis();
        var result = authors.findAll().stream()
                .map(Mapping::toDto)
                .toList();
        long end = System.currentTimeMillis();
        System.out.println("🔥 Lazy took: " + (end - start) + " ms");
        return result;
    }

    @GetMapping("/lazy-no-nplus")
    public Object lazyNoNPlus() {
        long start = System.currentTimeMillis();
        var result = authors.findAllWithBooksFetched().stream()
                .map(Mapping::toDto)
                .toList();
        long end = System.currentTimeMillis();
        System.out.println("🚀 Lazy (no N+1) took: " + (end - start) + " ms");
        return result;
    }

    @GetMapping("/eager")
    public Object eager() {
        long start = System.currentTimeMillis();
        var result = authors.findAll().stream()
                .map(Mapping::toDto)
                .toList();
        long end = System.currentTimeMillis();
        System.out.println("⚡ Eager took: " + (end - start) + " ms");
        return result;
    }
}
