package mbtc.ux40.lazyeager.repo;

import mbtc.ux40.lazyeager.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> { }
