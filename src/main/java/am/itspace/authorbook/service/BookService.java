package am.itspace.authorbook.service;

import am.itspace.authorbook.entity.Book;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface BookService {

    List<Book> findAll();

    Book save(Book book, MultipartFile multipartFile);

}
