package mbtc.ux40.lazyeager.repo;

import mbtc.ux40.lazyeager.domain.Author;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    @EntityGraph(attributePaths = {"books"})
    List<Author> findByNameContainingIgnoreCase(String name);

    @Query("select distinct a from Author a left join fetch a.books")
    List<Author> findAllWithBooksFetched();
}
