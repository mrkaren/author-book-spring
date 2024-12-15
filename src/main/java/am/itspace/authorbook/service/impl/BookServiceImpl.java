package am.itspace.authorbook.service.impl;

import am.itspace.authorbook.entity.Book;
import am.itspace.authorbook.repository.BookRepository;
import am.itspace.authorbook.service.BookService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Value("${author.book.upload.path}")
    private String uploadPath;

    @SneakyThrows
    @Override
    public Book save(Book book, MultipartFile multipartFile) {
        String fileName;
        if (!multipartFile.isEmpty()) {
            fileName = System.currentTimeMillis() + "_" + multipartFile.getOriginalFilename();
            File file = new File(uploadPath, fileName);
            multipartFile.transferTo(file);
            book.setImageName(fileName);
        }
        book.setCreatedAt(new Date());
        return bookRepository.save(book);
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }
}
