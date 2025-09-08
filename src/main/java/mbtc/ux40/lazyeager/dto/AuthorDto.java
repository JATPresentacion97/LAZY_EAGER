package mbtc.ux40.lazyeager.dto;

import java.util.List;

public record AuthorDto(Long id, String name, List<BookDto> books) {}
