package am.itspace.authorbook.controller;

import am.itspace.authorbook.entity.Author;
import am.itspace.authorbook.entity.Book;
import am.itspace.authorbook.service.AuthorService;
import am.itspace.authorbook.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;
    private final AuthorService authorService;

    @GetMapping
    public String bookPage(ModelMap modelMap) {
        List<Book> books = bookService.findAll();
        modelMap.put("books", books);
        return "book/books";
    }

    @GetMapping("/add")
    public String addBookPage(ModelMap modelMap) {
        List<Author> authors = authorService.findAll();
        modelMap.put("authors", authors);
        return "book/addBook";
    }

    @PostMapping("/add")
    public String addBook(@ModelAttribute Book book,
                          @RequestParam("image") MultipartFile multipartFile) {

        bookService.save(book, multipartFile);
        return "redirect:/books";
    }

}
