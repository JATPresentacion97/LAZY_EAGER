package mbtc.ux40.lazyeager.util;

import mbtc.ux40.lazyeager.domain.Author;
import mbtc.ux40.lazyeager.domain.Book;
import mbtc.ux40.lazyeager.dto.AuthorDto;
import mbtc.ux40.lazyeager.dto.BookDto;
import java.util.stream.Collectors;

public final class Mapping {
    private Mapping() {}

    public static AuthorDto toDto(Author a) {
        return new AuthorDto(
                a.getId(),
                a.getName(),
                a.getBooks().stream().map(Mapping::toDto).collect(Collectors.toList())
        );
    }

    public static BookDto toDto(Book b) {
        return new BookDto(b.getId(), b.getTitle());
    }
}
