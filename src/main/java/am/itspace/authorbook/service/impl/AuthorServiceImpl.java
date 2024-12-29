package am.itspace.authorbook.service.impl;

import am.itspace.authorbook.entity.Author;
import am.itspace.authorbook.repository.AuthorRepository;
import am.itspace.authorbook.service.AuthorService;
import am.itspace.authorbook.specification.AuthorSpecification;
import am.itspace.authorbook.specification.SearchCriteria;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Primary
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;


    @Override
    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    @Override
    public Page<Author> findAll(Pageable pageable) {
        return authorRepository.findAll(pageable);
    }

    @Override
    public Author save(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public void deleteById(int id) {
        authorRepository.deleteById(id);
    }

    @Override
    public Author findById(int id) {
        return authorRepository
                .findById(id)
                .orElse(null);
    }

    @Override
    public List<Author> search(String keyword) {
        return authorRepository.findAllByNameContainingOrSurnameContaining(keyword, keyword);
    }

    @Override
    public List<Author> filter(SearchCriteria searchCriteria) {
        AuthorSpecification authorSpecification = new AuthorSpecification(searchCriteria);
        List<Author> result = authorRepository.findAll(authorSpecification);
        return result;
    }
}
