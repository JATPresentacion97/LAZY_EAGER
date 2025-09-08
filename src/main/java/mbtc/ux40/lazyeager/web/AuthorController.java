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
        return authors.findAll().stream().map(Mapping::toDto).collect(Collectors.toList());
    }

    @GetMapping("/lazy-no-nplus")
    public Object lazyNoNPlus() {
        return authors.findAllWithBooksFetched().stream().map(Mapping::toDto).collect(Collectors.toList());
    }

    @GetMapping("/eager")
    public Object eagerViaEntityGraph() {
        return authors.findByNameContainingIgnoreCase("").stream().map(Mapping::toDto).collect(Collectors.toList());
    }
}
