package am.itspace.authorbook.service.impl;

import am.itspace.authorbook.entity.Author;
import am.itspace.authorbook.repository.AuthorRepository;
import am.itspace.authorbook.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
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
}
