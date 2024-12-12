package am.itspace.authorbook.repository;

import am.itspace.authorbook.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Integer> {

}
