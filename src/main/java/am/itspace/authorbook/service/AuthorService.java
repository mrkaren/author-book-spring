package am.itspace.authorbook.service;


import am.itspace.authorbook.entity.Author;
import am.itspace.authorbook.specification.SearchCriteria;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface AuthorService {

    List<Author> findAll();

    Page<Author> findAll(Pageable pageable);

    Author save(Author author);

    void deleteById(int id);

    Author findById(int id);

    List<Author> search(String keyword);

    List<Author> filter(SearchCriteria searchCriteria);
}
